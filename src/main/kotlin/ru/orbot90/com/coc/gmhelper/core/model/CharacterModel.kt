package ru.orbot90.com.coc.gmhelper.core.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id

data class Character(val info: Info, val bar: Bar, val characteristics: Characteristics, val backStory: BackStory,
                     val cashAndAssets: CashAndAssets, val weapons: List<Weapon>, val combat: Combat,
                     val cearAndPossessions: Set<String>, val skills: Map<String, Double>)

data class Characteristics(val STR: Int, val DEX: Int, val POW: Int,
                           val CON: Int, val APP: Int, val EDU: Int,
                           val SIZ: Int, val INT: Int, val moveRate: Int)

data class Info(val name: String, val player: String, val occupation: String,
                val age: Int, val sex: Sex, val residence: String, val birthplace: String)

data class Bar(var HP: Int, var MP: Int, var sanity: Int, var luck: Int) {
    init {
        if (HP !in 0..20) throw IllegalArgumentException("HP must be in range 0..20")
        if (MP !in 0..24) throw IllegalArgumentException("MP must be in range 0..24")
        if (sanity !in 1..99) throw IllegalArgumentException("Sanity must be in range 1..99")
        if (luck !in 1..99) throw IllegalArgumentException("Luck must be in range 1..99")
    }
}


enum class Sex {
    MALE,
    FEMALE
}

data class BackStory(val personalDescription: String, val ideologyOrBeliefs: String,
                     val significantPeople: String, val meaningfulLocations: String,
                     val treasuredProcessions: String, val traits: String,
                     val injuriesAndScars: String, val phobiasAndManias: String,
                     val arcaneTomesOrSpellsAndArtifacts: String, val encountersWithStrangeEntities: String)

data class CashAndAssets(val spendingLevel: Double, val cash: BigDecimal, val assets: BigDecimal)

@Entity
data class Cat(@Id var id: Long, val name: String, val age: Int)