package ru.orbot90.com.coc.gmhelper.core.model


data class Character(val info: Info, val bar: Bar, val characteristics: Characteristics,
                val backStory: BackStory, val cashAndAssets: CashAndAssets,
                val weapons: List<Weapon>, val combat: Combat)

data class Characteristics(val STR: Int, val DEX: Int, val POW: Int,
                      val CON: Int, val APP: Int, val EDU: Int,
                      val SIZ: Int, val INT: Int, val moveRate: Any)

data class Info(val name: String, val player: String, val occupation: Any,
                val age: Int, val sex: Sex, val residence: Any, val birthplace: String)

data class Bar(var HP: Int, var MP: Int, var Sanity: Int, var Luck: Int){
    init {
        if(HP !in 0..20) throw IllegalArgumentException("HP must be in range 0..20")
        if(MP !in 0..24) throw IllegalArgumentException("MP must be in range 0..24")
        if(Sanity !in 1..99) throw IllegalArgumentException("Sanity must be in range 1..99")
        if(Luck !in 1..99) throw IllegalArgumentException("Luck must be in range 1..99")
    }
}

data class Combat(var damageBonus: Int, var build: Any, var dodge: Any)

enum class Sex {
    MALE,
    FEMALE
}

data class Weapon(val name: String, val regular: Any, val hard: Any, val extreme: Any,
             val damage: Any, val range: Int, val attacks: Int, val ammo: Any, val malf: Any)

data class BackStory(val personalDescription: String, val ideologyOrBeliefs: String,
                val significantPeople: String, val meaningfulLocations: String,
                val treasuredProcessions: String, val traits: String,
                val injuriesAndScars: String, val phobiasAndManias: String,
                val arcaneTomesOrSpellsAndArtifacts: String, val encountersWithStrangeEntities: String)

data class CashAndAssets(val spendingLevel: Any, val cash: Long, val assets: Any)

//TODO: Cear And Processions ? What should be in this class? Or it will be String field in Character