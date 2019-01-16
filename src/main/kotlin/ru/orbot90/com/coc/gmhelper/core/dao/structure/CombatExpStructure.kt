package ru.orbot90.com.coc.gmhelper.core.dao.structure

import org.jetbrains.exposed.dao.LongIdTable

object CombatTable : LongIdTable() {
    var damageBonus = integer("damage_bonus")
    var build = integer("build")
}

object WeaponTable : LongIdTable() {
    val name = varchar("name", 50)
    //val damage: Damage
    val range = integer("range")
    val impales = bool("impales")
    val attacks = integer("attacks")
    val ammo = integer("ammo")
    val malf = integer("malf")
    //val skill: Set<String>
    //val skills = reference("skills", )
}

object SkillsTable : LongIdTable() {
    val skill = varchar("skill",100)
}