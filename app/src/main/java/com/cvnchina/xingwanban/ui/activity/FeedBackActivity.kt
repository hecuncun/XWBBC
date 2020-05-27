package com.cvnchina.xingwanban.ui.activity

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import android.support.v7.widget.GridLayoutManager
import android.view.MotionEvent
import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.ComImageAdapter
import com.cvnchina.xingwanban.adapter.ComImageAdapter.onAddPicClickListener
import com.cvnchina.xingwanban.adapter.FullyGridLayoutManager
import com.cvnchina.xingwanban.application.App
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.base.BaseNoDataBean
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.glide.GlideUtils
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.FileUtils
import com.lqr.audio.AudioRecordManager
import com.lqr.audio.IAudioRecordListener
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_feedback.*
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File


class FeedBackActivity : BaseActivity() {

    private var imageAdapter: ComImageAdapter? = null
    private var selectPhotoList = mutableListOf<LocalMedia>() //已选的照片集合
    private var mediaPlayer: MediaPlayer? = null
    override fun attachLayoutRes(): Int {
        return R.layout.activity_feedback
    }

    override fun initData() {

    }

    override fun initView() {
        toolbar_title.text = "用户反馈"
        //检查权限
        if (checkPermissions(
                arrayOf(
                    android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WAKE_LOCK



                )
            )
        ) {

        } else {
            requestPermission(
                arrayOf(
                    android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WAKE_LOCK
                ), 0x55
            )
        }

        initRvPhoto()
          file=File(Environment.getExternalStorageDirectory(),"XWB")
        if (!file!!.exists()){
            file!!.mkdirs()
        }
        AudioRecordManager.getInstance(App.context).setAudioSavePath(file!!.absolutePath)
        AudioRecordManager.getInstance(App.context).audioRecordListener=object :IAudioRecordListener{
            override fun initTipView() {

            }

            override fun setRecordingTipView() {

            }

            override fun setAudioShortTipView() {

            }

            override fun onFinish(audioPath: Uri, duration: Int) {
              Logger.e("audioPath=$audioPath,duration=$duration")
                voicePath=audioPath.path
                tv_voice_time.text =duration.toString()+ "''"
            }

            override fun setCancelTipView() {
            }

            override fun setTimeoutTipView(counter: Int) {
            }

            override fun onStartRecord() {
            }

            override fun destroyTipView() {
            }

            override fun onAudioDBChanged(db: Int) {
            }
        }
        //初始化音频播放器
        mediaPlayer = MediaPlayer()
    }

    private var voicePath = ""//录音文件
    private var file:File?=null

    override fun initListener() {
        iv_start_record.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        AudioRecordManager.getInstance(App.context).startRecord()
                        ll_recording.visibility = View.VISIBLE
                        GlideUtils.loadGif(iv_wave,R.drawable.icon_wave)
                        ll_recorded.visibility = View.GONE
                        tv_delete.visibility = View.GONE
                    }
                    MotionEvent.ACTION_UP -> {
                        AudioRecordManager.getInstance(App.context).stopRecord()
                        AudioRecordManager.getInstance(App.context).destroyRecord();
                        ll_recording.visibility = View.GONE
                        ll_recorded.visibility = View.VISIBLE
                        tv_delete.visibility = View.VISIBLE
                    }
                }
                return true
            }
        })

        ll_recorded.setOnClickListener {
            play()
        }

        tv_delete.setOnClickListener {
            val del = FileUtils.DeleteFolder(voicePath)
            if (del) {
                tv_delete.visibility = View.GONE
                voicePath = ""
                ll_recorded.visibility = View.GONE
                ll_recording.visibility = View.GONE
                showToast("删除成功")
            }

        }
        tv_confirm.setOnClickListener {
            val content = et_content.textString
            val phone = et_phone.text.toString().trim()
            if (content.isNotEmpty() && phone.isNotEmpty()) {
                if (voicePath.isNotEmpty()) {
                    val file = File(voicePath)
                    val requestFile: RequestBody =
                        RequestBody.create(MediaType.parse("multipart/form-data"), file)
                    //retrofit 上传文件api加上 @Multipart注解,然后下面这是个重点 参数1：上传文件的key，参数2：上传的文件名，参数3 请求头
                    body = MultipartBody.Part.createFormData("record-file", file.name, requestFile)
                }
                if (selectPhotoList.isNotEmpty()) {
                    for (item in selectPhotoList) {
                        val file = File(item.compressPath)
                        val requestFile: RequestBody =
                            RequestBody.create(MediaType.parse("multipart/form-data"), file)
                        val bodyIv =
                            MultipartBody.Part.createFormData("image-file", file.name, requestFile)
                        bodyList.add(bodyIv)
                    }
                }

                val feedbackCall =
                    SLMRetrofit.instance.api.feedbackCall(content, body, bodyList, phone)
                feedbackCall.compose(ThreadSwitchTransformer())
                    .subscribe(object : CallbackListObserver<BaseNoDataBean>() {
                        override fun onSucceed(t: BaseNoDataBean) {
                            if (t.msg == "1") {
                                showToast(t.msgCondition)
                                finish()
                            }
                        }

                        override fun onFailed() {

                        }
                    })
            } else {
                showToast("请填写完整")
            }
        }
    }

    private var body: MultipartBody.Part? = null//文件
    private var bodyList = mutableListOf<MultipartBody.Part>()
    private var map = mutableMapOf<String, RequestBody>()//多图上传
    private fun play() {
        val file = File(voicePath) //确认音乐文件的存在
        if (!file.exists()) return
        try {
            mediaPlayer!!.reset()
            mediaPlayer!!.setDataSource(voicePath)
            mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
            mediaPlayer!!.prepareAsync() //异步的方式加载音乐文件
            mediaPlayer!!.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
                override fun onPrepared(mp: MediaPlayer?) {
                    mediaPlayer!!.start() //准备好之后才能start
                    ll_recorded.isEnabled = false
                }

            })
            mediaPlayer!!.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
                override fun onCompletion(mp: MediaPlayer?) {
                    ll_recorded.isEnabled = true //播放完成后btn_play可用
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun pause() {
        if (mediaPlayer != null && !mediaPlayer!!.isPlaying) {
            mediaPlayer!!.start()
            return
        }
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        }
    }

    private fun stop() {
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }


    private fun initRvPhoto() {
        val themeId = R.style.picture_default_style//相册的默认样式
        rv_photo.layoutManager =
            FullyGridLayoutManager(this@FeedBackActivity, 3, GridLayoutManager.VERTICAL, false)
        imageAdapter = ComImageAdapter(
            this@FeedBackActivity, onAddPicClickListener
        )
        imageAdapter!!.setList(selectPhotoList)
        imageAdapter!!.setSelectMax(3)
        rv_photo.adapter = imageAdapter!!
        imageAdapter!!.setOnItemClickListener { position, v ->
            if (selectPhotoList.size > 0) {
                val media = selectPhotoList.get(position)
                val pictureType = media.getPictureType()
                val mediaType = PictureMimeType.pictureToVideo(pictureType)
                when (mediaType) {
                    1 ->
                        // 预览图片 可自定长按保存路径
                        //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                        PictureSelector.create(this@FeedBackActivity).themeStyle(themeId).openExternalPreview(
                            position,
                            selectPhotoList
                        )
                    2 ->
                        // 预览视频
                        PictureSelector.create(this@FeedBackActivity).externalPictureVideo(media.getPath())
                    3 ->
                        // 预览音频
                        PictureSelector.create(this@FeedBackActivity).externalPictureAudio(media.getPath())
                }
            }


        }
    }

    private val onAddPicClickListener = onAddPicClickListener {
        // 进入相册 以下是例子：不需要的api可以不写
        PictureSelector.create(this@FeedBackActivity)
            .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
            .maxSelectNum(3)// 最大图片选择数量
            .minSelectNum(1)// 最小选择数量
            .imageSpanCount(3)// 每行显示个数
            .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
            .previewImage(true)// 是否可预览图片
            .isCamera(true)// 是否显示拍照按钮
            .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
            .enableCrop(false)// 是否裁剪
            .compress(true)// 是否压缩
            .synOrAsy(true)//同步true或异步false 压缩 默认同步
            .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
            .withAspectRatio(3, 2)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
            .openClickSound(false)// 是否开启点击声音
            .selectionMedia(selectPhotoList)// 是否传入已选图片
            .minimumCompressSize(100)// 小于100kb的图片不压缩
            .forResult(PictureConfig.CHOOSE_REQUEST)//结果回调onActivityResult code
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                PictureConfig.CHOOSE_REQUEST -> {
                    // 图片选择结果回调
                    selectPhotoList = PictureSelector.obtainMultipleResult(data)
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    if (selectPhotoList.size > 0) {
                        //val loadingView = LoadingView(this@FeedBackActivity)
                        // loadingView.setLoadingTitle("上传中...")
                        // loadingView.show()
                        //                       val sb  =   StringBuilder()
                        //                       var successNum = 0
//                        for (i in selectPhotoList.indices){
//                            //上传文件
//                            val file = File(selectPhotoList[0].compressPath)
//                            Logger.e("图片地址==${selectPhotoList[0].compressPath}")
//                            val requestFile: RequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
//                            //retrofit 上传文件api加上 @Multipart注解,然后下面这是个重点 参数1：上传文件的key，参数2：上传的文件名，参数3 请求头
//                            val body: MultipartBody.Part = MultipartBody.Part.createFormData("upload", file.name, requestFile)
//                            val uploadCall = SLMRetrofit.getInstance().api.uploadCall(body)
//                            uploadCall.compose(ThreadSwitchTransformer()).subscribe(object: CallbackObserver<ImgBean>(){
//                                override fun onSucceed(t: ImgBean?, desc: String?) {
//                                    Logger.e("成功")
//                                    Logger.e("网络图片地址==${t?.fileUrl}")
//                                    sb.append(t?.fileUrl)
//                                    sb.append(",")
//                                    successNum++
//                                    if (successNum==selectPhotoList.size){
//                                        loadingView.dismiss()
//                                        //进行拼接
//                                        showToast("所有图片上传成功")
//                                        pic= sb.toString().substring(0,sb.toString().length-1)
//                                    }
//                                }
//
//                                override fun onFailed() {
//                                    loadingView.dismiss()
//                                    showToast("图片上传失败")
//                                }
//                            } )
//                        }

                    } else {
                        showToast("图片出现问题")
                    }
                    imageAdapter!!.setList(selectPhotoList)
                    imageAdapter!!.notifyDataSetChanged()
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
}
