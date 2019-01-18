package ru.orbot90.com.coc.gmhelper.core.dao

import ru.orbot90.com.coc.gmhelper.core.model.Cat

interface CatDao {

    fun getAllCats(): List<Cat>

    fun getCat(id: Long): Cat

    fun createUpdateCat(cat: Cat): Cat

    fun deleteCat(id: Long)

}