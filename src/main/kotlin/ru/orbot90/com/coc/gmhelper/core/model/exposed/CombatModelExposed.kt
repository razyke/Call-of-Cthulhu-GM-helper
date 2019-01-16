package ru.orbot90.com.coc.gmhelper.core.model.exposed

import ru.orbot90.com.coc.gmhelper.core.model.Combat
import ru.orbot90.com.coc.gmhelper.core.model.Damage
import ru.orbot90.com.coc.gmhelper.core.model.Dice
import ru.orbot90.com.coc.gmhelper.core.model.Weapon

data class CombatExpImpl(override var damageBonus: Int, override var build: Int) : Combat

data class WeaponExpImpl(override val name: String, override val damage: Damage, override val range: Int, override val impales: Boolean,
                         override val attacks: Int, override val ammo: Int, override val malf: Int, override val skill: Set<String>) : Weapon

data class DamageExpImpl(override val basicDamage: Int, override val dices: List<Dice>) : Damage {
    override fun calculate(): Int {
        var totalDamage = basicDamage
        for (d in dices) {
            totalDamage = d + totalDamage
        }
        return totalDamage
    }
}
