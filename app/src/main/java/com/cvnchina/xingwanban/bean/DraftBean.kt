package com.cvnchina.xingwanban.bean

import org.litepal.crud.LitePalSupport

/**
 * Created by hecuncun on 2020-5-18
 */
data class DraftBean(val path:String,val title:String,val tags:String,val thumbnailPath:String):LitePalSupport() {
    val id:Long =1
}