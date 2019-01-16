package ru.orbot90.com.coc.gmhelper.core.model

import java.math.BigDecimal

interface Character {
    val info: Info
    val bar: Bar
    val characteristics: Characteristics
    val backStory: BackStory
    val cashAndAssets: CashAndAssets
    val weapons: List<Weapon>
    val combat: Combat
    val cearAndPossessions: Set<String>
    val skills: Map<String, Double>
}

interface Characteristics {
    val STR: Int
    val DEX: Int
    val POW: Int
    val CON: Int
    val APP: Int
    val EDU: Int
    val SIZ: Int
    val INT: Int
    val moveRate: Int
}

interface Bar {
    var HP: Int
    var MP: Int
    var sanity: Int
    var luck: Int
}

interface Info {
    val name: String
    val player: String
    val occupation: String
    val age: Int
    val sex: Sex
    val residence: String
    val birthplace: String
}

enum class Sex {
    MALE,
    FEMALE
}

interface BackStory {
    val personalDescription: String
    val ideologyOrBeliefs: String
    val significantPeople: String
    val meaningfulLocations: String
    val treasuredProcessions: String
    val traits: String
    val injuriesAndScars: String
    val phobiasAndManias: String
    val arcaneTomesOrSpellsAndArtifacts: String
    val encountersWithStrangeEntities: String
}

interface CashAndAssets {
    val spendingLevel: Double
    val cash: BigDecimal
    val assets: BigDecimal
}
