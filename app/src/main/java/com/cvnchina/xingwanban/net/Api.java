package com.cvnchina.xingwanban.net;

import com.cvnchina.xingwanban.base.BaseBean;
import com.cvnchina.xingwanban.base.BaseNoDataBean;
import com.cvnchina.xingwanban.base.OtherLoginBean;
import com.cvnchina.xingwanban.bean.AgreementBean;
import com.cvnchina.xingwanban.bean.BindPhoneBean;
import com.cvnchina.xingwanban.bean.CityCodeBean;
import com.cvnchina.xingwanban.bean.ContentSortBean;
import com.cvnchina.xingwanban.bean.DefaultHeadPhotoBean;
import com.cvnchina.xingwanban.bean.DemoWorksBean;
import com.cvnchina.xingwanban.bean.EvaluateListBean;
import com.cvnchina.xingwanban.bean.LocationBean;
import com.cvnchina.xingwanban.bean.MsgBean;
import com.cvnchina.xingwanban.bean.MsgCountBean;
import com.cvnchina.xingwanban.bean.NewPhotoBean;
import com.cvnchina.xingwanban.bean.PersonalInfoBean;
import com.cvnchina.xingwanban.bean.QABean;
import com.cvnchina.xingwanban.bean.ScanLoginBean;
import com.cvnchina.xingwanban.bean.TalksBean;
import com.cvnchina.xingwanban.bean.TokenBean;
import com.cvnchina.xingwanban.bean.UpdateAppBean;
import com.cvnchina.xingwanban.bean.UploadVideoBean;
import com.cvnchina.xingwanban.bean.WorksBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by hecuncun on 2019/5/13
 */
public interface Api {

    /**
     * app更新  启动页图片
     */
    @POST("vms/appapi/sysMgr/init")
    Observable<BaseBean<UpdateAppBean>> updateAppCall();


    /**
     * 获取手机验证码
     *
     * @param phone
     * @param
     * @return
     */
    @POST("vms/appapi/sysMgr/getCode")
    Observable<BaseNoDataBean> phoneCodeCall(@Query("phone") String phone);

    /**
     * 登录
     *
     * @param phone
     * @param code
     * @return
     */
    @POST("vms/appapi/sysMgr/phoneLogin")
    Observable<TokenBean> loginCall(@Query("phone") String phone, @Query("code") String code);

    /**
     * 获取未读消息数
     *
     * @return
     */
    @POST("vms/appapi/sysMgr/getUnReadMsgCount")
    Observable<MsgCountBean> msgCountCall();

    /**
     * 获取个人信息
     *
     * @return
     */
    @POST("vms/appapi/account/get")
    Observable<BaseBean<PersonalInfoBean>> personalInfoCall();

    /**
     * 修改头像id接口
     */
    @POST("vms/appapi/account/editPic")
    Observable<BaseBean<NewPhotoBean>> changeDefaultHeadPhotoCall(@Query("id") int id);

    /**
     * 修改自定义头像接口
     */
    @POST("vms/appapi/account/editPic")
    @Multipart
    Observable<BaseBean<NewPhotoBean>> changeHeadPhotoCall(@Part MultipartBody.Part file);

    /**
     * 获取默认头像
     */
    @POST("vms/appapi/account/getDefaultHeadPic")
    Observable<DefaultHeadPhotoBean> defaultHeadPhotoCall();

    /**
     * 修改个人信息
     */
    @POST("vms/appapi/account/edit")
    Observable<BaseBean<PersonalInfoBean>> editPersonalInfoCall(@QueryMap Map<String, String> map, @Query("sex") int sex);

    /**
     * 获取常见问题
     */
    @POST("vms/appapi/qa/page")
    Observable<BaseBean<QABean>> commonProblemCall(@Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 获取省市code
     */
    @POST("vms/appapi/account/getProvinceAndCity")
    Observable<CityCodeBean> cityCodeCall();

    /**
     * 获取相关协议文本  协议类型 1-联系我们 2-用户协议 3-隐私协议 4-关于我们
     */
    @POST("vms/appapi/sysMgr/getAgreement")
    Observable<BaseBean<AgreementBean>> agreementCall(@Query("type") String type);

    /**
     * 一键反馈
     */
    @POST("vms/appapi/sysMgr/feedback")
    @Multipart
    Observable<BaseNoDataBean> feedbackCall(@Query("content") String content, @Part MultipartBody.Part file, @Part List<MultipartBody.Part> list, @Query("phone") String phone);

    /**
     * 消息列表
     */
    @POST("vms/appapi/sysMgr/msgList")
    Observable<BaseBean<MsgBean>> msgListCall(@Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 获取推荐标签话题
     */
    @POST("vms/appapi/video/getRecommendTags")
    Observable<TalksBean> talksCall(@Query("name") String name);

    /**
     * 获取内容分类
     */
    @POST("vms/appapi/video/getColumnTree")
    Observable<ContentSortBean> contentSortCall();

    /**
     * 获取位置
     */
    @POST("vms/appapi/video/addressSearch")
    Observable<LocationBean> locationCall(@Query("address") String address);

    /**
     * 获取我的作品列表
     */
    @POST("vms/appapi/video/getSelfVideo")
    Observable<BaseBean<WorksBean>> worksCall(@Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 上传视频
     */
    @POST("vms/appapi/video/uploadVideo")
    @Multipart
    Observable<UploadVideoBean> uploadVideoCall(@Part MultipartBody.Part file);

    /**
     * 保存视频
     */
    @POST("vms/appapi/video/videoSave")
    @Multipart
    Observable<BaseNoDataBean> saveVideoCall(@Query("videoId") int videoId, @Part MultipartBody.Part file,
                                             @Query("title") String title, @Query("description") String description,
                                             @Query("columns") String columns, @Query("tags") String tags,
                                             @Query("city") String city, @Query("lat") String lat,
                                             @Query("lng") String lng, @Query("isVisible") String isVisible,
                                             @Query("address") String address);

    /**
     * 获取示例视频
     */
    @POST("vms/appapi/video/getExampleVideo")
    Observable<DemoWorksBean> demoWorksCall();

    /**
     * 移除视频
     */
    @POST("vms/appapi/video/remove")
    Observable<BaseNoDataBean> removeVideoCall(@Query("videoId") int videoId);

    /**
     * 删除视频
     */
    @POST("vms/appapi/video/delete")
    Observable<BaseNoDataBean> deleteVideoCall(@Query("ids") String ids);

    /**
     * 三方登录
     */
    @POST("vms/appapi/sysMgr/otherLogin")
    Observable<OtherLoginBean> otherLoginCall(@Query("type") int type, @Query("openId") String openId);

    /**
     * 绑定手机号
     */
    @POST("vms/appapi/sysMgr/bindPhone")
    Observable<BindPhoneBean> bindPhoneCall(@Query("phone") String phone, @Query("code") String code);

    /**
     * 根据视频id获取评论
     */
    @POST("vms/appapi/video/getCommentsByVideoId")
    Observable<EvaluateListBean> evaluateListCall(@Query("videoId") int videoId, @Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 回复评论
     */
    @POST("vms/appapi/video/replyComment")
    Observable<BaseNoDataBean> replayCall(@Query("commentId") int commentId, @Query("content") String content);

    /**
     * 扫码登录
     */
    @POST("vms/appapi/sysMgr/scanLogin")
    Observable<ScanLoginBean> scanLoginCall(@Query("imei") String imei, @Query("isSyn") int isSyn); /**
     * 扫码登录
     */
    @POST("vms/appapi/sysMgr/scanLogin")
    Observable<ScanLoginBean> scanLoginCall2(@Query("imei") String imei);
//
//    /**
//     * 用户注册
//     *
//     * @param phone
//     * @param code
//     * @param pwd
//     * @return
//     */
//    @POST("appUserBase/insertSelective")
//    Observable<BaseBean<UserInfoBean>> registerCall(@Query("phone") String phone, @Query("code") String code, @Query("pwd") String pwd);
//

//
//    /**
//     * 重置密码
//     *
//     * @param phone
//     * @param code
//     * @param pwd
//     * @return
//     */
//    @POST("appUserBase/resetPwd")
//    Observable<BaseNoDataBean> resetPwdCall(@Query("phone") String phone, @Query("code") String code, @Query("pwd") String pwd);
//
//    /**
//     * 首页轮播图
//     *
//     * @return
//     */
//    @POST("appTcmnCarouselPicture/searchAll")
//    Observable<BannerInfoBean> homeBannerCall();
//
//    /**
//     * 首页好物
//     *
//     * @return
//     */
//    @POST("appGoodsInfo/selectHomeExquisiteGoods")
//    Observable<GoodListBean> goodListCall();
//
//    /**
//     * 大牌
//     *
//     * @return
//     */
//    @POST("appGoodsInfo/searchBigClassList")
//    Observable<FamousListBean> famousListCall();
//
//    /**
//     * 更多推荐
//     *
//     * @param page 当前页码，从1开始
//     * @param type 1:综合排序，2：销量升降序，3：价格降序，4：价格升序，5：价格筛选
//     * @return
//     */
//    @POST("appGoodsInfo/searchForPage")
//    Observable<GoodsMoreListBean> goodsMoreListCall(@Query("page") int page, @Query("type") int type);
//
//    /**
//     * 更好好物
//     *
//     * @param page
//     * @return
//     */
//
//    @POST("appGoodsInfo/selectExquisiteGoods")
//    Observable<GoodMoreListBean> goodMoreListCall(@Query("page") int page);
//
//    /**
//     * @param page       当前页码，从1开始
//     * @param bigClassId 大牌id
//     * @param type       1:综合排序，2：销量升降序，3：价格降序，4：价格升序，5：价格筛选
//     * @return
//     */
//    @POST("appGoodsInfo/searchForPage")
//    Observable<GoodsMoreListBean> famousMoreListCall(@Query("page") int page, @Query("bigClassId") String bigClassId, @Query("type") int type);
//
//    /**
//     * 未读消息数
//     *
//     * @param uid
//     * @return
//     */
//    @POST("appActiveMessage/searchCount")
//    Observable<BaseNoDataBean> unReadMsgCall(@Query("uid") String uid);
//
//    /**
//     * 消息列表
//     *
//     * @param page
//     * @param uid
//     * @return
//     */
//    @POST("appActiveMessage/searchForPage")
//    Observable<MsgListBean> msgListCall(@Query("page") int page, @Query("uid") String uid);
//
//    /**
//     * 更新消息状态
//     *
//     * @param uid
//     * @param mid
//     * @return
//     */
//    @POST("appActiveMessage/updateById")
//    Observable<BaseNoDataBean> updateMsgStateCall(@Query("uid") String uid, @Query("mid") String mid);
//
//    /**
//     * 热门搜索
//     */
//    @POST("appGoodsHot/searchAll")
//    Observable<HotTagListBean> hotTagCall();
//
//
//    /**
//     * 搜索页多条件搜索
//     *
//     * @param page       当前页码，从1开始
//     * @param cid        二级商品id
//     * @param type       1:综合排序，2：销量升降序，3：价格降序，4：价格升序，5：价格筛选
//     * @return
//     */
//    @POST("appGoodsInfo/searchForPage")
//    Observable<GoodsMoreListBean> searchListCall(@Query("page") int page, @Query("name") String name, @Query("cid") String cid, @Query("type") int type, @Query("max") Double max, @Query("min") Double min);
//
//    /**
//     * 积分列表
//     *
//     * @param page
//     * @param uid
//     * @return
//     */
//    @POST("appUserIntegral/searchForPage")
//    Observable<ScoreListBean> scoreListCall(@Query("page") int page, @Query("uid") String uid);
//
//    /**
//     * 反馈
//     * @param uid
//     * @param content
//     * @return
//     */
//    @POST("appTcmnFeedback/insertSelective")
//    Observable<BaseNoDataBean> feedBackCall(@Query("uid") String uid, @Query("content") String content);
//
//    /**
//     * 优惠券
//     * @param uid
//     * @param type 类型：1：所有，2：未使用
//     * @return
//     */
//    @POST("appUserCardUse/searchAll")
//    Observable<CouponListBean> couponListCall(@Query("uid") String uid, @Query("type") int type);
//
//    /**
//     * 上传图片
//     * @param file
//     * @return
//     */
//    @POST("appimg/upload")
//    @Multipart
//    Observable<BaseBean<ImgBean>> uploadCall(@Part MultipartBody.Part file);
//
//    /**
//     * 修改用户信息
//     * @param uid
//     * @param nickName
//     * @param picture
//     * @return
//     */
//    @POST("appUserBase/updateById")
//    Observable<BaseNoDataBean> updateInfoCall(@Query("uid") String uid, @Query("nickName") String nickName, @Query("picture") String picture);
//
//    /**
//     * 我的收藏
//     * @param uid
//     * @return
//     */
//    @POST("appGoodsInfo/selectCollectGoods")
//    Observable<MyCollectionListBean> myCollectionListCall(@Query("uid") String uid);
//
//    /**
//     * 批量取消收藏
//     * @param gids
//     * @param uid
//     * @return
//     */
//    @POST("appGoodsInfo/batchCancellCollectGoods")
//    Observable<BaseNoDataBean> deleteCollection(@Query("gids") String gids, @Query("uid") String uid);
//
//    /**
//     * 商品详情
//     * @param gid
//     * @return
//     */
//    @POST("appGoodsInfo/selectDetail")
//    Observable<GoodsDetailBean> goodsDetailCall(@Query("gid") String gid, @Query("uid") String uid);
//
//    /**
//     *详情评价列表
//     */
//    @POST("appGoodsEvaluate/searchForPage")
//    Observable<EvaluateListBean> evaluateListCall(@Query("page") int page, @Query("gid") String gid);
//
//    /**
//     * 收藏/取消收藏
//     * @param gid
//     * @param uid
//     * @param type 类型：1收藏，2取消收藏
//     * @return
//     */
//    @POST("appGoodsInfo/insertCollectGoods")
//    Observable<BaseNoDataBean> collectionEnsureCall(@Query("gid") String gid, @Query("uid") String uid, @Query("type") int type);
//
//    /**
//     * 分类列表
//     * 父分类 id（0：查一级分类，查子分类时传一级分类id）
//     */
//    @POST("appGoodsClassification/searchAll")
//    Observable<SortListBean> sortListCall(@Query("pid") String pid);
//
//    /**
//     * 全部订单列表
//     * @param page
//     * @param uid
//     * @return
//     */
//    @POST("appOrderInfo/searchForPage")
//    Observable<OrderListBean> orderListCall(@Query("page") int page, @Query("uid") String uid);
//
//    /**
//     * 订单详情
//     * @param oid
//     * @return
//     */
//    @POST("appOrderInfo/selectDetail")
//    Observable<OrderDetailBean> orderDetailCall(@Query("oid") String oid);
//
//    /**
//     * 新增地址
//     * @param uid
//     * @param name
//     * @param phone
//     * @param card
//     * @param area 所在地区（省-市-区用‘-’分割）
//     * @param cardPhotoZ
//     * @param cardPhotoF
//     * @param areaDetail
//     * @return
//     */
//    @POST("appUserAddress/insertSelective")
//    Observable<BaseNoDataBean> addAddressCall(@Query("uid") String uid, @Query("name") String name, @Query("phone") String phone, @Query("card") String card, @Query("area") String area, @Query("cardPhotoZ") String cardPhotoZ, @Query("cardPhotoF") String cardPhotoF, @Query("areaDetail") String areaDetail);
//
//    /**
//     * 地址列表
//     * @param uid
//     * @return
//     */
//    @POST("appUserAddress/searchAll")
//    Observable<AddressListBean> addressListCall(@Query("uid") String uid);
//
//    /**
//     * 设为默认地址
//     * @param aid
//     * @param uid
//     * @return
//     */
//    @POST("appUserAddress/updateDefault")
//    Observable<BaseNoDataBean>  addressDefaultCall(@Query("aid") String aid, @Query("uid") String uid);
//
//    /**
//     * 删除地址
//     * @param aid
//     * @return
//     */
//    @POST("appUserAddress/deleteById")
//    Observable<BaseNoDataBean>  addressDeleteCall(@Query("aid") String aid);
//
//    /**
//     * 修改地址
//     */
//    @POST("appUserAddress/updateById")
//    Observable<BaseNoDataBean> addressUpdateCall(@Query("aid") String aid, @Query("name") String name, @Query("phone") String phone, @Query("card") String card, @Query("area") String area, @Query("cardPhotoZ") String cardPhotoZ, @Query("cardPhotoF") String cardPhotoF, @Query("areaDetail") String areaDetail);
//
//    /**
//     * 新增订单
//     * @param uid
//     * @param addressId
//     * @param cardId
//     * @param integralNum
//     * @param goodsInfoJsonStr
//     * @return
//     */
//    @FormUrlEncoded//str有中文必须加上此注解  防止乱码
//    @POST("appOrderInfo/insertSelective")
//    Observable<AddOrderBean> addOrderCall(@Query("uid") String uid, @Query("addressId") String addressId, @Query("cardId") String cardId, @Query("integralNum") int integralNum, @Field("goodsInfoJsonStr") String goodsInfoJsonStr);
//
//    /**
//     *wx App支付签名(统一下单),已完成二次签名,直接调用支付即可
//     * @param uid
//     * @param oid
//     * @param way
//     * @return
//     */
//
//    @POST("apppay/appsign")
//    Observable<WxPaySignBean> wxPaySignCall(@Query("uid") String uid, @Query("oid") String oid, @Query("way") int way);
//
//    /**
//     *支付宝 App支付签名(统一下单),已完成二次签名,直接调用支付即可
//     * @param uid
//     * @param oid
//     * @param way
//     * @return
//     */
//    @POST("apppay/appsign")
//    Observable<AliPaySignBean> aliPaySignCall(@Query("uid") String uid, @Query("oid") String oid, @Query("way") int way);
//
//    /**
//     * 取消订单
//     * @param uid
//     * @param oid
//     * @return
//     */
//    @POST("appOrderInfo/updateCancelOrder")
//    Observable<BaseNoDataBean> cancelOrderCall(@Query("uid") String uid, @Query("oid") String oid);
//    /**
//     * 删除订单
//     * @param uid
//     * @param oid
//     * @return
//     */
//    @POST("appOrderInfo/deleteById")
//    Observable<BaseNoDataBean> deleteOrderCall(@Query("uid") String uid, @Query("oid") String oid);
//
//    /**
//     * 新增评价
//     * @param uid
//     * @param orderId
//     * @param content
//     * @return
//     */
//    @POST("appGoodsEvaluate/insertSelective")
//    Observable<BaseNoDataBean> addEvaluateCall(@Query("uid") String uid, @Query("orderId") String orderId, @Query("content") String content);
//
//    /**
//     * 确认收货
//     * @param uid
//     * @param oid
//     * @return
//     */
//    @POST("appOrderInfo/confirmOrder")
//    Observable<BaseNoDataBean> confirmOrderCall(@Query("uid") String uid, @Query("oid") String oid);
//
//    /**
//     * 退换货
//     * @param uid
//     * @param oid
//     * @param type
//     * @param reason
//     * @param picture
//     * @return
//     */
//
//    @POST("appOrderInfo/returnOrder")
//    Observable<BaseNoDataBean> returnOrderCall(@Query("uid") String uid, @Query("oid") String oid, @Query("type") int type, @Query("reason") String reason, @Query("picture") String picture);
//
//    /**
//     * 首页4个须知链接
//     * @param type
//     * @return
//     */
//    @POST("appTcmnSet/selectIndexText")
//    Observable<BaseNoDataBean> homeLinkCall(@Query("type") int type);
//
//    /**
//     * 订单数
//     * @param uid
//     * @return
//     */
//
//    @POST("appUserBase/selectDetail")
//    Observable<BaseBean<UserDetailBean>>  mineOrderNumCall(@Query("uid") String uid);
//    /**
//     * 获取全员信息e
//     * @return
//     */
//    @GET("security/user")
//    Observable<AllPersonInfoBean> getAllPersonCall();
//
//    /**
//     * 手持机与手表绑定接口
//     *
//     * @param mac         手持机mac号
//     * @param childNumber 手表的固话注册码
//     * @return
//     */
//    @POST("handsets/binding/{handsetNumber}-{childNumber}")
//    Observable<BaseBean> canBinding(@Path("handsetNumber") String mac, @Path("childNumber") String childNumber);
//
//    /**
//     * 手持机与手表解绑接口
//     *
//     * @param mac         手持机的mac号
//     * @param childNumber 手表的固话注册码   如果是多个之间用,隔开
//     * @return
//     */
//    @DELETE("handsets/binding/{handsetNumber}-{childNumber}")
//    Observable<BaseBean> deleteBinding(@Path("handsetNumber") String mac, @Path("childNumber") String childNumber);
//
//    /**
//     * 获取所有的北斗信息
//     *
//     * @return
//     */
//    @GET("bds")
//    Observable<AllBDInfosBean> getAllBDInfos();
//
//    /**
//     * 4g 通信接口
//     */
//
//    @POST("remoteapi/bd")
//    Observable<NetResponseBean> uploadInfo(@Body RequestBody requestBody);
//
//    /**
//     * 根据手持机的mac号  查询绑定的手表
//     */
//    @GET("handsets/binding/{handsetNumber}/watch")
//    Observable<BindingWatchBean> getBindingWatch(@Path("handsetNumber") String mac);
//
//    /**
//     * mac与北斗上传绑定关系的接口
//     */
//
//    @PUT("handsets/binding/bd/{handsetNumber}-{bdNumber}")
//    Observable<BaseBean> uploadMacAndBdNum(@Path("handsetNumber") String mac, @Path("bdNumber") String bdNumber);
}