package com.cvnchina.xingwanban.ui.activity

import android.app.Activity
import android.content.Intent
import android.text.Html
import com.aliyun.apsara.alivclittlevideo.constants.LittleVideoParamConfig
import com.aliyun.qupai.editor.AliyunIComposeCallBack
import com.aliyun.qupai.editor.impl.AliyunComposeFactory
import com.aliyun.svideo.base.Constants
import com.aliyun.svideo.common.utils.image.ImageLoaderImpl
import com.aliyun.svideo.common.utils.image.ImageLoaderOptions
import com.aliyun.svideo.editor.publish.CoverEditActivity
import com.aliyun.svideo.sdk.external.struct.common.AliyunVideoParam
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.base.BaseNoDataBean
import com.cvnchina.xingwanban.bean.DraftBean
import com.cvnchina.xingwanban.bean.LocationBean
import com.cvnchina.xingwanban.bean.UploadVideoBean
import com.cvnchina.xingwanban.event.*
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.ProgressRequestBody
import com.cvnchina.xingwanban.net.ProgressRequestBody.UploadCallbacks
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.FileUtils
import com.cvnchina.xingwanban.widget.ProgressDialog
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_publish.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.litepal.LitePal
import java.io.File

/**
 * Created by hecuncun on 2020-5-9
 */
class PublishActivity : BaseActivity() {
    private val KEY_PARAM_VIDEO_PARAM = "videoParam"
    private val KEY_PARAM_VIDEO_RATIO = "key_param_video_ratio"
    private val KEY_PARAM_CONFIG = "project_json_path"
    private val KEY_PARAM_THUMBNAIL = "svideo_thumbnail"
    /**
     * 配置文件地址
     */
    private var mConfigPath: String? = null
    /**
     * 封面图片地址
     */
    private var mThumbnailPath: String? = null
    private var videoRatio = 0f
    private var mVideoPram: AliyunVideoParam? = null


    override fun useEventBus() = true
    override fun attachLayoutRes(): Int {
        return R.layout.activity_publish
    }

    private var mDraftBean: DraftBean? = null
    override fun initData() {
        val intent = intent
        val draftBean = intent.getSerializableExtra("draftBean")
        if (draftBean != null) {
            //初始化数据
            mDraftBean = draftBean as DraftBean
            initDraftData(draftBean as DraftBean)
        }
        mConfigPath = intent.getStringExtra(KEY_PARAM_CONFIG)//配置文件
        mThumbnailPath = intent.getStringExtra(KEY_PARAM_THUMBNAIL)//封面路径
        Logger.e("传的封面地址==$mThumbnailPath")
        videoRatio = intent.getFloatExtra(KEY_PARAM_VIDEO_RATIO, 0f)
        mVideoPram = intent.getSerializableExtra(KEY_PARAM_VIDEO_PARAM) as AliyunVideoParam
        ImageLoaderImpl().loadImage(
            this,
            mThumbnailPath!!,
            ImageLoaderOptions.Builder().skipMemoryCache().skipDiskCacheCache().build()
        )
            .into(iv_cover)
        startComposeF()
    }

    /**
     * 初始化填写数据
     */
    private fun initDraftData(draftBean: DraftBean) {
        title = draftBean.title//视频标题
        description = draftBean.title
        et_title.textString = title
        columns = draftBean.columns
        tv_content_sort.text = draftBean.colName
        tv_content_sort.setTextColor(resources.getColor(R.color.color_primary_yellow))
        tags = draftBean.tags
        talk_name.text = tags
        talk_name.setTextColor(resources.getColor(R.color.color_primary_yellow))
        tv_location.text = draftBean.address
        city = draftBean.city
        lat = draftBean.lat
        lng = draftBean.lng
        isVisible = draftBean.isVisible
        tv_visiable.text = if (isVisible == "0") "公开" else "秘密"

        address = draftBean.address
        tv_location.text = draftBean.addName


    }

    /**
     * 先合成目标视频文件
     */
    private fun startCompose(upload: Boolean) {
        progressDialog?.show()
        if (upload) {
            progressDialog?.setText("合成中...")
        } else {
            progressDialog?.setText("存草稿中...")
        }

        createAliyunCompose.compose(mConfigPath, videoPath, object : AliyunIComposeCallBack {
            override fun onComposeProgress(p0: Int) {
                //合成进度
                if (upload){
                    progressDialog?.setProgress(p0/2)
                }else{
                    progressDialog?.setProgress(p0)
                }

                Logger.e("合成进度$p0")
            }

            override fun onComposeCompleted() {
                //合成完成，上传接口
                runOnUiThread {
                    val file = File(videoPath)
                    Logger.e("视频地址==$videoPath")
                    if (upload) {
                        progressDialog?.setText("上传中...")

                  val  requestFile =ProgressRequestBody(file, "video/mp4",object :UploadCallbacks{
                            override fun onFinish() {

                            }

                            override fun onProgressUpdate(percentage: Int) {
                                progressDialog?.setProgress(percentage/2+50)
                            }

                            override fun onError() {
                                showToast("上传视频失败")
                            }
                        })


//                        val requestFile: RequestBody =
//                            RequestBody.create(MediaType.parse("multipart/form-data"), file)
                        //retrofit 上传文件api加上 @Multipart注解,然后下面这是个重点 参数1：上传文件的key，参数2：上传的文件名，参数3 请求头
                        val body: MultipartBody.Part =
                            MultipartBody.Part.createFormData("video-file", file.name, requestFile)
                        val uploadVideoCall = SLMRetrofit.instance.api.uploadVideoCall(body)
                        uploadVideoCall.compose(ThreadSwitchTransformer())
                            .subscribe(object : CallbackListObserver<UploadVideoBean>() {
                                override fun onSucceed(t: UploadVideoBean) {
                                    //上传成功后再真个和接口上传视频
                                    //  Logger.e("视频上传成功")

                                    if (t.msg != "1") {
                                        showToast(t.msgCondition)
                                        return
                                    }
                                    val file2 = File(mThumbnailPath)
                                    val request: RequestBody =
                                        RequestBody.create(
                                            MediaType.parse("multipart/form-data"),
                                            file2
                                        )
                                    val body2: MultipartBody.Part =
                                        MultipartBody.Part.createFormData(
                                            "image-file",
                                            file2.name,
                                            request
                                        )
                                    val saveVideoCall = SLMRetrofit.instance.api.saveVideoCall(
                                        t.videoId,
                                        body2,
                                        title,
                                        description,
                                        columns,
                                        tags,
                                        city,
                                        lat,
                                        lng,
                                        isVisible,
                                        address
                                    )
                                    saveVideoCall.compose(ThreadSwitchTransformer())
                                        .subscribe(object : CallbackListObserver<BaseNoDataBean>() {
                                            override fun onSucceed(t: BaseNoDataBean) {
                                                showToast(t.msgCondition)
                                                if (mDraftBean!=null){
                                                    val delete = LitePal.delete(
                                                        DraftBean::class.java,
                                                        mDraftBean!!.id
                                                    )
                                                    EventBus.getDefault().post(RefreshDraftEvent())
                                                    Logger.e("草稿存在,删除$delete")
                                                }else{
                                                    Logger.e("草稿不存在")
                                                }

                                                if (saveLoc){
                                                    showToast("视频保存在$videoPath")
                                                }else{
                                                    FileUtils.DeleteFolder(videoPath)
                                                }

                                                progressDialog?.dismiss()
                                                EventBus.getDefault().post(RefreshWorksEvent())
                                                EventBus.getDefault().post(ChangeEvent())
                                                startActivity(
                                                    Intent(
                                                        this@PublishActivity,
                                                        MainActivity::class.java
                                                    )
                                                )


                                            }

                                            override fun onFailed() {
                                                progressDialog?.dismiss()
                                            }
                                        })
                                }

                                override fun onFailed() {
                                    progressDialog?.dismiss()
                                }
                            })
                    } else {
                            progressDialog?.setText("存储成功")
                            Logger.e("存储的封面地址==$mThumbnailPath")
                            if (mDraftBean!=null){
                                LitePal.delete(DraftBean::class.java, mDraftBean!!.id)
                            }

                            DraftBean(
                                videoPath,
                                title,
                                tags,
                                mThumbnailPath!!,
                                columns,
                                colName,
                                city,
                                lat,
                                lng,
                                address,
                                isVisible,
                                addName
                            ).save()
                            progressDialog?.dismiss()
                            EventBus.getDefault().post(RefreshDraftEvent())
                            EventBus.getDefault().post(ChangeEvent())
                            startActivity(Intent(this@PublishActivity, MainActivity::class.java))

                        }

                }


            }

            override fun onComposeError(p0: Int) {
                progressDialog?.dismiss()
                showToast("视频合成失败")
            }
        })
    }

    /**
     * 先合成目标视频文件
     */
    private fun startComposeF() {
        createAliyunCompose.compose(mConfigPath, videoPath, object : AliyunIComposeCallBack {
            override fun onComposeProgress(p0: Int) {
            }

            override fun onComposeCompleted() {
                Logger.e("线程==${Thread.currentThread().name}")
                Logger.e("按钮可用")
                runOnUiThread {
                    tv_choose.isEnabled = true
                    tv_save.isEnabled = true
                    tv_publish.isEnabled = true
                }

            }

            override fun onComposeError(p0: Int) {
            }
        })
    }


    private val createAliyunCompose = AliyunComposeFactory.createAliyunCompose()
    private var progressDialog: ProgressDialog? = null
    override fun initView() {
        tv_choose.isEnabled = false
        tv_save.isEnabled = false
        tv_publish.isEnabled = false
        Logger.e("按钮不可用")
//利用SDK提供的合成核心类AliyunIVodCompose，通过传入接收到的配置文件路径，调用其compose方法对编辑的视频进行合成。
        createAliyunCompose.init(this)
        initPath()
        progressDialog = ProgressDialog(this)
        var talk= "<font>参与话题</font><font color=\'#999999\'><small>    \t发布时必填</small></font>"
        talk_name.text=Html.fromHtml(talk)
        var content= "<font>内容分类</font><font color=\'#999999\'><small>    \t发布时必填</small></font>"
        tv_content_sort.text=Html.fromHtml(content)
    }

    /**
     * 初始化文件路径videoPath
     */
    private var videoPath = ""
    private var videoName = ""
    fun initPath() {
        videoName = System.currentTimeMillis().toString() + "_output_compose_video.mp4"
        videoPath =
            Constants.SDCardConstants.getDir(this) + LittleVideoParamConfig.DIR_COMPOSE + videoName
    }
private var saveLoc=false
    override fun initListener() {
        iv_save.setOnClickListener {
            saveLoc=!saveLoc
            iv_save.setImageResource(if (saveLoc) R.mipmap.icon_save else R.mipmap.icon_unsave)
        }
        iv_back.setOnClickListener {
            finish()
        }
        tv_publish.setOnClickListener {
            //1.发布上传 先检查填写的条件完整
            title = et_title.textString
            description = et_title.textString
            if (title.isNotEmpty() && columns.isNotEmpty() && tags.isNotEmpty() && city.isNotEmpty() && lat.isNotEmpty() && lng.isNotEmpty() && isVisible.isNotEmpty() && address.isNotEmpty()) {
                //2.根据mConfigPath合成文件
                startCompose(true)
                //3.上传视频文件
                //4.创建视频
            } else {
                showToast("请把信息填写完成")
            }


        }
        tv_choose.setOnClickListener {
            val intent = Intent(this, CoverEditActivity::class.java)
            intent.putExtra(CoverEditActivity.KEY_PARAM_VIDEO, videoPath)
            startActivityForResult(intent, 0)
        }
        tv_save.setOnClickListener {
            //1.发布上传 先检查填写的条件完整
            title = et_title.textString
            description = et_title.textString
            startCompose(false)
//            if (title.isNotEmpty() && columns.isNotEmpty() && tags.isNotEmpty() && city.isNotEmpty() && lat.isNotEmpty() && lng.isNotEmpty() && isVisible.isNotEmpty() && address.isNotEmpty()) {
//                //2.根据mConfigPath合成文件
//
//                //3.上传视频文件
//                //4.创建视频
//            } else {
//                showToast("请把信息填写完成")
//            }

        }

        ll_talk.setOnClickListener {
            startActivity(Intent(this, TalkActivity::class.java))
        }
        ll_sort.setOnClickListener {
            startActivity(Intent(this, SortActivity::class.java))
        }
        ll_location.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }
        ll_permission.setOnClickListener {
            startActivity(Intent(this, CanShowActivity::class.java))
        }
    }

    private var title = ""//视频标题
    private var description = ""
    private var columns = ""
    private var colName = ""
    private var tags = ""
    private var city = ""
    private var lat = ""
    private var lng = ""
    private var isVisible = "0"
    private var address = ""
    private var addName = ""//大地址


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getTalkEvent(event: TalkEvent) {
        talk_name.text = event.name
        tags = event.name
        talk_name.setTextColor(resources.getColor(R.color.color_primary_yellow))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getSortEvent(event: SortEvent) {
        columns = event.columnId
        colName = event.name
        tv_content_sort.text = event.name
        tv_content_sort.setTextColor(resources.getColor(R.color.color_primary_yellow))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getLocationEvent(event: LocationBean.DataBean) {
        addName = event.name
        tv_location.text = event.name
        city = event.city
        lat = event.lat
        lng = event.lng
        address = event.address
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getVisiableEvent(event: VisiableEvent) {
        tv_visiable.text = if (event.visiable) "公开" else "秘密"
        isVisible = if (event.visiable) "0" else "1"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            mThumbnailPath = data!!.getStringExtra(CoverEditActivity.KEY_PARAM_RESULT)
            Logger.e("新封面==$mThumbnailPath")
            ImageLoaderImpl().loadImage(
                this,
                mThumbnailPath!!,
                ImageLoaderOptions.Builder().skipMemoryCache().skipDiskCacheCache().build()
            )
                .into(iv_cover)
        }
    }
}