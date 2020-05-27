package com.cvnchina.xingwanban.adapter

import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.aliyun.svideo.common.baseAdapter.BaseViewHolder
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.LocationBean

/**
 * Created by hecuncun on 2020-5-14
 */
class LocationAdapter:BaseQuickAdapter<LocationBean.DataBean,BaseViewHolder>(R.layout.item_location_list) {
    override fun convert(helper: BaseViewHolder, item: LocationBean.DataBean?) {
       helper.setText(R.id.tv_city,item?.city)
            .setText(R.id.tv_address,item?.address)
    }
}