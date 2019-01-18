package ru.orbot90.com.coc.gmhelper.core.model

data class Combat(var damageBonus: Int, var build: Int)

data class Weapon(val name: String, val damage: Damage, val impales: Boolean, val range: Int,
                  val attacks: Int, val ammo: Int, val malf: Int, val skills: Set<String>)

data class Damage(val basicDamage: Int, val dices: List<Dice>) {
    fun calculate(): Int {
        var totalDamage = basicDamage
        for (d in dices) {
            totalDamage = d + totalDamage
        }
        return totalDamage
    }
}