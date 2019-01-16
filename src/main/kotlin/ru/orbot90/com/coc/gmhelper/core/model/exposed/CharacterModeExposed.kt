package ru.orbot90.com.coc.gmhelper.core.model.exposed

import ru.orbot90.com.coc.gmhelper.core.model.*
import java.math.BigDecimal

data class CharacterExpImpl(override val info: Info, override val bar: Bar, override val characteristics: Characteristics,
                            override val backStory: BackStory, override val cashAndAssets: CashAndAssets,
                            override val weapons: List<Weapon>, override val combat: Combat, override val cearAndPossessions: Set<String>,
                            override val skills: Map<String, Double>): Character

data class CharacteristicsExpImpl(val STR: Int, val DEX: Int, val POW: Int,
                           val CON: Int, val APP: Int, val EDU: Int,
                           val SIZ: Int, val INT: Int, val moveRate: Int)

data class InfoExpImpl(val name: String, val player: String, val occupation: String,
                val age: Int, val sex: Sex, val residence: String, val birthplace: String)

data class BarExpImpl(var HP: Int, var MP: Int, var sanity: Int, var luck: Int) {
    init {
        if (HP !in 0..20) throw IllegalArgumentException("HP must be in range 0..20")
        if (MP !in 0..24) throw IllegalArgumentException("MP must be in range 0..24")
        if (sanity !in 1..99) throw IllegalArgumentException("sanity must be in range 1..99")
        if (luck !in 1..99) throw IllegalArgumentException("luck must be in range 1..99")
    }
}

data class BackStoryExpImpl(val personalDescription: String, val ideologyOrBeliefs: String,
                     val significantPeople: String, val meaningfulLocations: String,
                     val treasuredProcessions: String, val traits: String,
                     val injuriesAndScars: String, val phobiasAndManias: String,
                     val arcaneTomesOrSpellsAndArtifacts: String, val encountersWithStrangeEntities: String)

data class CashAndAssetsExpImpl(val spendingLevel: Double, val cash: BigDecimal, val assets: BigDecimal)
