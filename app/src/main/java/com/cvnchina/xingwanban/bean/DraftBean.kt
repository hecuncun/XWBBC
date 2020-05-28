package com.cvnchina.xingwanban.bean

import org.litepal.crud.LitePalSupport
import java.io.Serializable

/**
 * Created by hecuncun on 2020-5-18
 */
data class DraftBean(
    val path: String,
    val title: String,
    val tags: String,
    val thumbnailPath: String,
    val columns: String,
    val colName: String,
    val city: String,
    val lat: String,
    val lng: String,
    val address: String,
    val isVisible: String,
    val addName: String
) : LitePalSupport(), Serializable {
    val id: Long = 1
}