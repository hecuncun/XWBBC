package com.cvnchina.xingwanban.ui.fragment

import android.content.Intent
import android.graphics.Color
import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.PersonalInfoBean
import com.cvnchina.xingwanban.bean.ShareBean
import com.cvnchina.xingwanban.event.RefreshPersonalInfoEvent
import com.cvnchina.xingwanban.glide.GlideUtils
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.ui.activity.*
import com.cvnchina.xingwanban.utils.CommonUtil
import com.cvnchina.xingwanban.widget.ShareDialog
import com.flyco.dialog.widget.ActionSheetDialog
import com.lhzw.bluetooth.base.BaseFragment
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import kotlinx.android.synthetic.main.fragment_mine.*
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * Created by heCunCun on 2020/4/29
 */
class MineFragment : BaseFragment() {
    override fun useEventBus() = true
    private var moreDialog: ActionSheetDialog? = null
    private var shareDialog: ShareDialog? = null

    companion object {
        fun getInstance(): MineFragment = MineFragment()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fragment_mine
    }

    override fun onDestroyView() {
        super.onDestroyView()
        moreDialog?.dismiss()
    }

    override fun initView(view: View) {
        toolbar_title.text = "个人中心"
        toolbar_right_img.setImageResource(R.mipmap.icon_more)
        toolbar_right_img.visibility = View.VISIBLE
        moreDialog = ActionSheetDialog(activity!!, arrayOf("设置", "分享"), null)
        moreDialog?.run {
            isTitleShow(false)
                .lvBgColor(Color.parseColor("#FFFFFF"))
            itemTextColor(resources.getColor(R.color.color_primary_bar))
            cancelText(resources.getColor(R.color.color_primary_bar))
        }
        shareDialog = ShareDialog(activity!!, false)
    }

    override fun initListener() {
        iv_head_photo.setOnClickListener {
            val intent = Intent(activity, PersonInfoActivity::class.java)
            intent.putExtra("personalInfoBean", personalInfoBean)
            startActivity(intent)
        }
        ll_person_info.setOnClickListener {
            startActivity(Intent(activity, InfoEditActivity::class.java))
        }
        tv_info_des.setOnClickListener {
            val intent = Intent(activity, InfoEditActivity::class.java)
            intent.putExtra("personalInfoBean", personalInfoBean)
            startActivity(intent)
        }
        tv_about.setOnClickListener {
            //startActivity(Intent(activity, AboutUsActivity::class.java))
            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra("type", 4)
            startActivity(intent)
        }
        tv_agreement.setOnClickListener {
            startActivity(Intent(activity, AgreementActivity::class.java))
        }
        tv_good_evaluate.setOnClickListener {
            //给个好评
            CommonUtil.toMarket(activity!!, "com.cvnchina.xingwanban", null)
            //CommonUtil.toMarket(activity!!,"com.tencent.mm",null)
        }
        tv_contact.setOnClickListener {
            //联系我们
            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra("type", 1)
            startActivity(intent)
        }
        toolbar_right_img.setOnClickListener {
            //更多
                moreDialog?.show()
                moreDialog?.setOnOperItemClickL { parent, view, position, id ->
                    moreDialog!!.dismiss()
                    if (position == 0) {
                        //设置
                        startActivity(Intent(activity, SettingActivity::class.java))
                    } else {
                        shareDialog?.setOnChoseListener(object : ShareDialog.OnChoseListener {
                            override fun select(resId: Int) {
                                when (resId) {
                                    R.id.ll_wx -> {
                                        requestShare(1, 1)
                                    }
                                    R.id.ll_wx_c -> {
                                        requestShare(2, 1)
                                    }
                                    R.id.ll_wb -> {
                                        requestShare(3, 1)
                                    }
                                    R.id.ll_qq -> {
                                        requestShare(4, 1)
                                    }
                                    R.id.ll_qq_c -> {
                                        requestShare(5, 1)
                                    }

                                }

                                shareDialog?.dismiss()
                            }
                        })

                        shareDialog?.show()
                    }
                }


        }

    }

    private fun requestShare(platform: Int, type: Int) {
        //分享到平台1-微信；2-朋友圈；3-微博；4-QQ好友；5.QQ空间  1-app分享 2-视频分享
        val shareVideoCall = SLMRetrofit.instance.api.shareAppCall(
            platform,
            type
        )
        shareVideoCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackListObserver<ShareBean>() {
                override fun onSucceed(t: ShareBean?) {
                    val web = UMWeb(t?.url)
                    web.title = "星顽半" //标题
                    var thumb = UMImage(activity, R.mipmap.logo)
                    web.setThumb(thumb) //缩略图

                    web.description = "@$nickname 我的新视界，想要与你一起分享~" //描述
                    when (platform) {
                        1 -> {
                            ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN).withMedia(web)
                                .setCallback(umShareListener).share()
                        }
                        2 -> {
                            ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                                .withMedia(web).setCallback(umShareListener).share()
                        }
                        3 -> {
                            ShareAction(activity).setPlatform(SHARE_MEDIA.SINA).withMedia(web)
                                .setCallback(umShareListener).share()
                        }
                        4 -> {
                            ShareAction(activity).setPlatform(SHARE_MEDIA.QQ).withMedia(web)
                                .setCallback(umShareListener).share()
                        }
                        5 -> {
                            ShareAction(activity).setPlatform(SHARE_MEDIA.QZONE).withMedia(web)
                                .setCallback(umShareListener).share()
                        }

                    }

                }

                override fun onFailed() {

                }
            })
    }

    private var umShareListener = object : UMShareListener {
        /**
         * @descrption 分享开始的回调
         */
        override fun onResult(p0: SHARE_MEDIA?) {//成功

        }

        override fun onCancel(p0: SHARE_MEDIA?) {

        }

        override fun onError(p0: SHARE_MEDIA?, p1: Throwable?) {

        }

        override fun onStart(p0: SHARE_MEDIA?) {

        }
    }

    override fun lazyLoad() {
        initPersonalInfo()
    }

    private fun initPersonalInfo() {
        //请求个人信息
        val personalInfoCall = SLMRetrofit.instance.api.personalInfoCall()
        personalInfoCall.compose(ThreadSwitchTransformer()).subscribe(object :
            CallbackObserver<PersonalInfoBean>() {
            override fun onSucceed(t: PersonalInfoBean, desc: String) {
                //初始化个人信息
                initPersonalInfo(t)
            }

            override fun onFailed() {
            }
        })
    }


    /**
     * 设置个人信息
     */
    private var personalInfoBean: PersonalInfoBean? = null

    private fun initPersonalInfo(t: PersonalInfoBean) {
        personalInfoBean = t
        GlideUtils.showCircle(iv_head_photo, t.headPic, R.mipmap.icon_def_head)
        tv_nick_name.text = t.nickName
        nickname = t.nickName
        tv_id.text = t.id
        tv_sex.text = t.sex
        tv_age.text = t.age
        tv_star.text = t.constellation
        tv_city.text = t.location
        if (t.signature.isEmpty()) {
            ll_person_info.visibility = View.VISIBLE
            tv_info_des.visibility = View.GONE
        } else {
            ll_person_info.visibility = View.GONE
            tv_info_des.visibility = View.VISIBLE
            tv_info_des.text = t.signature
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun refreshPersonalInfo(event: RefreshPersonalInfoEvent) {
        initPersonalInfo()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(activity).onActivityResult(requestCode, resultCode, data)
    }


}