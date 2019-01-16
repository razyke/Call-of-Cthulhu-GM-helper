package ru.orbot90.com.coc.gmhelper.core.dao

import ru.orbot90.com.coc.gmhelper.core.model.Bar

interface BarDao{

    fun createOrUpdateBar(bar: Bar): Bar

    fun getBar(id: Long): Bar

    fun deleteBar(id: Long)
}