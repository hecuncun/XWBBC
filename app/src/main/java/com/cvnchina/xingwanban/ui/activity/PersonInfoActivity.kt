package com.cvnchina.xingwanban.ui.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.view.View
import cn.qqtheme.framework.picker.DatePicker
import cn.qqtheme.framework.picker.DatePicker.OnYearMonthDayPickListener
import cn.qqtheme.framework.picker.OptionPicker
import cn.qqtheme.framework.picker.OptionPicker.OnOptionPickListener
import cn.qqtheme.framework.util.ConvertUtils
import cn.qqtheme.framework.widget.WheelView.DividerConfig
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.CityCodeBean
import com.cvnchina.xingwanban.bean.DefaultHeadPhotoBean
import com.cvnchina.xingwanban.bean.NewPhotoBean
import com.cvnchina.xingwanban.bean.PersonalInfoBean
import com.cvnchina.xingwanban.event.RefreshPersonalInfoEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.glide.GlideUtils
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.widget.EditNickNameDialog
import com.cvnchina.xingwanban.widget.SelectHeadPhotoDialog
import com.lljjcoder.Interface.OnCityItemClickListener
import com.lljjcoder.bean.CityBean
import com.lljjcoder.bean.DistrictBean
import com.lljjcoder.bean.ProvinceBean
import com.lljjcoder.citywheel.CityConfig
import com.lljjcoder.style.citypickerview.CityPickerView
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_person_info.*
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.greenrobot.eventbus.EventBus
import java.io.File

/**
 * Created by hecuncun on 2020-5-2
 */
class PersonInfoActivity : BaseActivity() {
    private val PERMISS_REQUEST_CODE = 0x100

    private var selectHeadPhotoDialog: SelectHeadPhotoDialog? = null
    private var editNickNameDialog: EditNickNameDialog? = null
    private var pickerStart: OptionPicker? = null
    private var pickerSex: OptionPicker? = null
    private var datePicker: DatePicker? = null
    private var map = mutableMapOf<String, String>()
    private var sexCode = 1
    private val cityPickerView by lazy {
        CityPickerView()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.activity_person_info
    }

    override fun initData() {
        if (checkPermissions(
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            )
        ) {

        } else {
            requestPermission(
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ), PERMISS_REQUEST_CODE
            )
        }

        val personalInfoBean = intent.getParcelableExtra<PersonalInfoBean>("personalInfoBean")
        if (personalInfoBean != null) {
            initPersonalInfo(personalInfoBean)
        }
        //获取省市的code码
        getCityCode()

    }

    private var cityList = mutableListOf<CityCodeBean.DataBean.ChildAreaBean>()
    private fun getCityCode() {
        val cityCodeCall = SLMRetrofit.instance.api.cityCodeCall()
        cityCodeCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackListObserver<CityCodeBean>() {
                override fun onSucceed(t: CityCodeBean) {
                    if (t.msg == "1") {
                        for (p in t.data) {
                            cityList.addAll(p.childArea)
                        }
                    } else {
                        showToast(t.msgCondition)
                    }
                }

                override fun onFailed() {

                }
            })
    }

    private fun initPersonalInfo(t: PersonalInfoBean) {
        GlideUtils.showCircle(iv_head_photo, t.headPic, R.mipmap.icon_def_head)
        tv_nick_name.text = t.nickName
        tv_id.text = "用户ID: ${t.accountId}"
        tv_sex.text = t.sex ?: "未知"
        iv_sex.setImageResource(if (t.sex == "男") R.mipmap.icon_man else R.mipmap.icon_women)
        sexCode = if ((t.sex == "男")) 1 else 2
        tv_age.text = t.age ?: "未知"
        tv_star.text = t.constellation ?: "未知"
        tv_city.text = t.location ?: "未知"

    }

    override fun initView() {
        toolbar_title.text = "个人资料"
        toolbar_right_tv.text = "保存"
        toolbar_right_tv.visibility = View.VISIBLE
        toolbar_right_tv.setTextColor(resources.getColor(R.color.color_primary_yellow))
        getDefaultHeadPhoto()
        selectHeadPhotoDialog = SelectHeadPhotoDialog(this)
        editNickNameDialog = EditNickNameDialog(this)
        cityPickerView.init(this)

        //初始化星座选择器
        pickerStart = OptionPicker(
            this, mutableListOf(
                "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座",
                "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"
            )
        )
        pickerStart?.run {
            setCycleDisable(false)//禁用循环
            setBackgroundColor(resources.getColor(R.color.white))
            setTopHeight(45)
            setTopLineColor(resources.getColor(R.color.white))
            setTopLineHeight(1)
            setTitleText("星座")
            setTitleTextColor(resources.getColor(R.color.color_gray_333333))
            setTitleTextSize(15)
            setCancelTextColor(resources.getColor(R.color.color_gray_999999))
            setCancelText("X")
            setCancelTextSize(15)
            setSubmitTextColor(resources.getColor(R.color.color_gray_333333))
            setSubmitText("  确认  ")
            setSubmitTextSize(15)
            setTextColor(
                resources.getColor(R.color.color_gray_303234),
                resources.getColor(R.color.color_gray_979899)
            )
            val config = DividerConfig()
            config.setColor(resources.getColor(R.color.white)) //线颜色

            config.setAlpha(140) //线透明度

            config.setRatio((1.0 / 8.0).toFloat()) //线比率
            setDividerVisible(false)
            setDividerConfig(config)
            setBackgroundColor(-0x1e1e1f)
            setSelectedIndex(7)
            setCanceledOnTouchOutside(true)
            setOnOptionPickListener(object : OnOptionPickListener() {
                override fun onOptionPicked(index: Int, item: String) {
                //    showToast("index=$index, item=$item")
                    tv_star.text = item
                    map["constellation"] = item
                }
            })
        }

        //初始化性别选择器
        pickerSex = OptionPicker(
            this, mutableListOf(
                "男", "女"
            )
        )
        pickerSex?.run {
            setCycleDisable(true)//禁用循环
            setBackgroundColor(resources.getColor(R.color.white))
            setTopHeight(45)
            setTopLineColor(resources.getColor(R.color.white))
            setTopLineHeight(1)
            setTitleText("性别")
            setTitleTextColor(resources.getColor(R.color.color_gray_333333))
            setTitleTextSize(15)
            setCancelTextColor(resources.getColor(R.color.color_gray_999999))
            setCancelText("X")
            setCancelTextSize(15)
            setSubmitTextColor(resources.getColor(R.color.color_gray_333333))
            setSubmitText("  确认  ")
            setSubmitTextSize(15)
            setTextColor(
                resources.getColor(R.color.color_gray_303234),
                resources.getColor(R.color.color_gray_979899)
            )
            val config = DividerConfig()
            config.setColor(resources.getColor(R.color.white)) //线颜色

            config.setAlpha(140) //线透明度

            config.setRatio((1.0 / 8.0).toFloat()) //线比率
            setDividerVisible(false)
            setDividerConfig(config)
            setBackgroundColor(-0x1e1e1f)
            setSelectedIndex(1)
            setCanceledOnTouchOutside(true)
            setOnOptionPickListener(object : OnOptionPickListener() {
                override fun onOptionPicked(index: Int, item: String) {
                    //   showToast("index=$index, item=$item")
                    tv_sex.text = item
                    iv_sex.setImageResource(if (index == 0) R.mipmap.icon_man else R.mipmap.icon_women)
                    sexCode = if (index == 0) 1 else 2
                }
            })
        }

        //初始化日期选择
        datePicker = DatePicker(this)
        datePicker?.run {
            setBackgroundColor(resources.getColor(R.color.white))
            setTopHeight(45)
            setTopLineColor(resources.getColor(R.color.white))
            setTopLineHeight(1)
            setTitleText("生日")
            setTitleTextColor(resources.getColor(R.color.color_gray_333333))
            setTitleTextSize(15)
            setCancelTextColor(resources.getColor(R.color.color_gray_999999))
            setCancelText(" X ")
            setCancelTextSize(15)
            setSubmitTextColor(resources.getColor(R.color.color_gray_333333))
            setSubmitText("  确认  ")
            setSubmitTextSize(15)
            setTextColor(
                resources.getColor(R.color.color_gray_303234),
                resources.getColor(R.color.color_gray_979899)
            )
            val config = DividerConfig()
            config.setColor(resources.getColor(R.color.white)) //线颜色

            config.setAlpha(140) //线透明度

            config.setRatio((1.0 / 8.0).toFloat()) //线比率
            setDividerVisible(false)
            setDividerConfig(config)


            setCanceledOnTouchOutside(true)
            setUseWeight(true)
            setTopPadding(ConvertUtils.toPx(this@PersonInfoActivity, 10f))
            setRangeEnd(2100, 1, 1)
            setRangeStart(1950, 1, 1)
            setSelectedItem(2000, 1, 1)
            setResetWhileWheel(false)
            setOnDatePickListener(OnYearMonthDayPickListener { year, month, day ->
              //  showToast("$year-$month-$day")
                map["birthday"] = "$year-$month-$day"
                var gen = ""
                if (year[0] == '1') {
                    gen = year[2].toString() + "0"
                } else {
                    if (year[2] == '0') {
                        gen = year[2].toString() + "0"
                    } else {
                        gen = "10"
                    }
                }
                tv_age.text = "$gen 后"
//                this@PersonInfoActivity.startActivity(
//                    Intent(
//                        this@PersonInfoActivity,
//                        AgeDescriptionActivity::class.java
//                    )
//                )
//            })
//            setOnWheelListener(object : DatePicker.OnWheelListener {
//                override fun onYearWheeled(index: Int, year: String) {
//                    setTitleText(year + "-" + selectedMonth + "-" + selectedDay)
//                }
//
//                override fun onMonthWheeled(index: Int, month: String) {
//                  setTitleText(selectedYear + "-" + month + "-" + selectedDay)
//                }
//
//                override fun onDayWheeled(index: Int, day: String) {
//                   setTitleText(selectedYear + "-" + selectedMonth + "-" + day)
//                }
            })
        }

    }

    /**
     * 服务器获取默认头像并显示
     */

    private var list = mutableListOf<DefaultHeadPhotoBean.DataBean>()

    private fun getDefaultHeadPhoto() {
        val defaultHeadPhotoCall = SLMRetrofit.instance.api.defaultHeadPhotoCall()
        defaultHeadPhotoCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackListObserver<DefaultHeadPhotoBean>() {
                override fun onSucceed(t: DefaultHeadPhotoBean) {
                    if (t.msg == "1") {
                        Logger.e("默认头像size==${t.data.size}")
                        list = t.data
                    } else {
                        showToast(t.msgCondition)
                    }
                }

                override fun onFailed() {

                }
            })
    }

    override fun initListener() {
        toolbar_right_tv.setOnClickListener {
            //保存修改
            val editPersonalInfoCall = SLMRetrofit.instance.api.editPersonalInfoCall(map, sexCode)
            editPersonalInfoCall.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackObserver<PersonalInfoBean>() {
                    override fun onSucceed(t: PersonalInfoBean?, desc: String?) {
                        EventBus.getDefault().post(RefreshPersonalInfoEvent())
                        showToast("保存成功")
                        finish()
                    }

                    override fun onFailed() {

                    }
                })


        }
        selectHeadPhotoDialog?.setOnChoseListener(object : SelectHeadPhotoDialog.OnChoseListener {
            override fun select(resId: Int) {
                when (resId) {
                    R.id.tv_album -> {
                        //打开相册
                        selectImage(1)
                    }
                    R.id.tv_take_photo -> {
                        //拍照
                        selectImage(0)
                    }
                    R.id.iv_def1 -> {
                        if (list.size<4){
                            showToast("服务器默认头像未配置")
                            return
                        }
                      GlideUtils.showCircle(iv_head_photo,list[0].headPic,R.mipmap.head1)
                        val changeDefaultHeadPhotoCall =
                            SLMRetrofit.instance.api.changeDefaultHeadPhotoCall(list[0].id.toInt())
                        changeDefaultHeadPhotoCall.compose(ThreadSwitchTransformer())
                            .subscribe(object : CallbackObserver<NewPhotoBean>() {
                                override fun onSucceed(t: NewPhotoBean?, desc: String?) {
                                    EventBus.getDefault().post(RefreshPersonalInfoEvent())

                                }

                                override fun onFailed() {

                                }
                            })
                    }
                    R.id.iv_def2 -> {
                        if (list.size<4){
                            showToast("服务器默认头像未配置")
                            return
                        }
                        GlideUtils.showCircle(iv_head_photo,list[1].headPic,R.mipmap.head1)
                        val changeDefaultHeadPhotoCall =
                            SLMRetrofit.instance.api.changeDefaultHeadPhotoCall(list[1].id.toInt())
                        changeDefaultHeadPhotoCall.compose(ThreadSwitchTransformer())
                            .subscribe(object : CallbackObserver<NewPhotoBean>() {
                                override fun onSucceed(t: NewPhotoBean?, desc: String?) {

                                    EventBus.getDefault().post(RefreshPersonalInfoEvent())
                                }

                                override fun onFailed() {

                                }
                            })
                    }
                    R.id.iv_def3 -> {
                        if (list.size<4){
                            showToast("服务器默认头像未配置")
                            return
                        }
                        GlideUtils.showCircle(iv_head_photo,list[2].headPic,R.mipmap.head1)
                        val changeDefaultHeadPhotoCall =
                            SLMRetrofit.instance.api.changeDefaultHeadPhotoCall(list[2].id.toInt())
                        changeDefaultHeadPhotoCall.compose(ThreadSwitchTransformer())
                            .subscribe(object : CallbackObserver<NewPhotoBean>() {
                                override fun onSucceed(t: NewPhotoBean?, desc: String?) {
                                    EventBus.getDefault().post(RefreshPersonalInfoEvent())

                                }

                                override fun onFailed() {

                                }
                            })
                    }
                    R.id.iv_def4 -> {
                        if (list.size<4){
                            showToast("服务器默认头像未配置")
                            return
                        }
                        GlideUtils.showCircle(iv_head_photo,list[3].headPic,R.mipmap.head1)
                        val changeDefaultHeadPhotoCall =
                            SLMRetrofit.instance.api.changeDefaultHeadPhotoCall(list[3].id.toInt())
                        changeDefaultHeadPhotoCall.compose(ThreadSwitchTransformer())
                            .subscribe(object : CallbackObserver<NewPhotoBean>() {
                                override fun onSucceed(t: NewPhotoBean?, desc: String?) {
                                    EventBus.getDefault().post(RefreshPersonalInfoEvent())

                                }

                                override fun onFailed() {

                                }
                            })
                    }
                    R.id.iv_close -> {

                    }
                }
                selectHeadPhotoDialog?.dismiss()
            }

        })

        editNickNameDialog?.setOnChoseListener(object : EditNickNameDialog.OnChoseListener {
            override fun select(resId: Int, str: String) {
                when (resId) {
                    R.id.tv_confirm -> {
                        tv_nick_name.text = str
                        map["nickName"] = str
                    }
                    R.id.iv_close -> {

                    }
                }
                editNickNameDialog?.dismiss()
            }

        })
        iv_head_photo.setOnClickListener {
            //底部弹出选择框
            selectHeadPhotoDialog?.setImageData(list)
            selectHeadPhotoDialog?.show()
        }

        tv_nick_name.setOnClickListener {
            editNickNameDialog?.show()
        }

        ll_city.setOnClickListener {
            //城市选择
            //三级城市选择器
            wheel()
        }
        //星座选择
        ll_star.setOnClickListener {
           // pickerStart?.show()
        }
        //性别选择
        ll_sex.setOnClickListener {
            pickerSex?.show()
        }
        //生日选择
        ll_age.setOnClickListener {
            datePicker?.show()
        }

    }

    private fun wheel() {
        val cityConfig = CityConfig.Builder()
            .title("选择城市")
            .confirmText("确认")
            .confirTextColor("#333333")
            .cancelText("x")
            .cancelTextColor("#999999")
            .visibleItemsCount(5)//显示个数
            .province("北京市")//省
            .city("北京市")//市
            .district("昌平区")//区
            .provinceCyclic(true)//循环显示
            .cityCyclic(false)//循环显示
            .districtCyclic(true)//循环显示
            .setCityWheelType(CityConfig.WheelType.PRO_CITY)
            // * 显示省市区三级联动的显示状态
            //* PRO:只显示省份的一级选择器
            // * PRO_CITY:显示省份和城市二级联动的选择器
            // * PRO_CITY_DIS:显示省份和城市和县区三级联动的选择器
            .setCustomItemLayout(R.layout.item_city)//自定义item的布局
            .setCustomItemTextViewId(R.id.item_city_name_tv)
            .setShowGAT(true)//显示港澳台数据
            .build()

        cityPickerView.setConfig(cityConfig)
        cityPickerView.setOnCityItemClickListener(object : OnCityItemClickListener() {
            override fun onSelected(
                province: ProvinceBean?,
                city: CityBean?,
                district: DistrictBean?
            ) {
                val sb = StringBuilder()
                // sb.append("选择的结果：\n")
                if (province != null) {
                    sb.append(province.name + "-")
                }

                if (city != null) {
                    sb.append(city.name + "-")
                    tv_city.text = city.name
                }

                if (district != null) {
                    sb.append(district.name)
                }
                for (c in cityList) {
                    if (c.name == city!!.name) {
                        map["cityCode"] = c.code
                   //     showToast(c.code)
                        Logger.e("所选城市的名称${city!!.name}===${c.code}")
                        return
                    }
                }

                    showToast("当前城市不可选择")
                    tv_city.text=""

                // tv_city.text = (sb.toString())

            }

            override fun onCancel() {
                // ToastUtils.showLongToast(this@CitypickerWheelActivity, "已取消")
            }
        })
        cityPickerView.showCityPicker()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                tag -> {
                    val selectList = PictureSelector.obtainMultipleResult(data)
                    if (selectList.size > 0) {
                        GlideUtils.showCircle(
                            iv_head_photo,
                            selectList[0].compressPath,
                            R.mipmap.icon_def_head
                        )
//                        //上传文件
                        val file = File(selectList[0].compressPath)
                        Logger.e("图片地址==${selectList[0].compressPath}")
                        val requestFile: RequestBody =
                            RequestBody.create(MediaType.parse("multipart/form-data"), file)
                        //retrofit 上传文件api加上 @Multipart注解,然后下面这是个重点 参数1：上传文件的key，参数2：上传的文件名，参数3 请求头
                        val body: MultipartBody.Part =
                            MultipartBody.Part.createFormData("headPic", file.name, requestFile)
                        val changeHeadPhotoCall = SLMRetrofit.instance.api.changeHeadPhotoCall(body)
                        changeHeadPhotoCall.compose(ThreadSwitchTransformer())
                            .subscribe(object : CallbackObserver<NewPhotoBean>() {
                                override fun onSucceed(t: NewPhotoBean, desc: String) {
                                    Logger.e("${t.headPic}")
                                    showToast(desc)
                                    EventBus.getDefault().post(RefreshPersonalInfoEvent())
                                }

                                override fun onFailed() {

                                }
                            })
//                        val uploadCall = SLMRetrofit.getInstance().api.uploadCall(body)
//                        uploadCall.compose(ThreadSwitchTransformer()).subscribe(object : CallbackObserver<ImgBean>() {
//                            override fun onSucceed(t: ImgBean?, desc: String?) {
//                                Logger.e("成功")
//                                Logger.e("网络图片地址==${t?.fileUrl}")
//                                if (tag == REQUEST_FRONT) {
//                                    cardPhotoZ = t?.fileUrl
//                                } else {
//                                    cardPhotoF = t?.fileUrl
//                                }
//
//                            }
//
//                            override fun onFailed() {
//                                Logger.e("失败")
//                            }
//                        })

                    } else {
                        showToast("图片出现问题")
                    }
                }
            }
        }
    }


    //选择图片方式
    private var tag = 0x333

    private fun selectImage(i: Int) {
        if (i == 0) {
            PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .enableCrop(true)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(true)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .minimumCompressSize(200)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .isDragFrame(false)// 是否可拖动裁剪框(固定)
                .forResult(tag)
        } else {
            PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage()) //全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(1)// 最大图片选择数量 int
                .imageSpanCount(3)
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .enableCrop(true)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(true)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .minimumCompressSize(200)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true).// 裁剪是否可放大缩小图片 true or false
                    isDragFrame(false).// 是否可拖动裁剪框(固定)
                    forResult(tag)
        }
    }
}