package ru.orbot90.com.coc.gmhelper.core.model

interface Combat {
    var damageBonus: Int
    var build: Int
}

interface Weapon {
    val name: String
    val damage: Damage
    val range: Int
    val impales: Boolean
    val attacks: Int
    val ammo: Int
    val malf: Int
    val skill: Set<String>
}

interface Damage {
    val basicDamage: Int
    val dices: List<Dice>
    fun calculate(): Int
}
