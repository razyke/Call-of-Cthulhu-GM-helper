package ru.orbot90.com.coc.gmhelper.core.dao.structure

import org.jetbrains.exposed.dao.LongIdTable
import ru.orbot90.com.coc.gmhelper.core.model.Sex

object Characters : LongIdTable() {
    val bar = reference("bar", BarTable)
    val info = reference("info", InfoTable)
    val characteristics = reference("characteristics", CharacteristicsTable)
    val backStory = reference("back_story", BackStoryTable)
    val cashAndAssets = reference("cash_and_assets", CashAndAssetsTable )
    //val weapons: List<Weapon>
    //val combat: Combat
    //val cearAndPossessions: Set<String>
    //val skills: Map<String, Double>
}

object CharacteristicsTable : LongIdTable() {
    val STR = integer("str")
    val DEX = integer("mp")
    val POW = integer("pow")
    val CON = integer("con")
    val APP = integer("app")
    val EDU = integer("edu")
    val SIZ = integer("siz")
    val INT = integer("int")
    val moveRate = integer("move_rate")
}

object BarTable : LongIdTable() {
    val HP = integer("hp")
    val MP = integer("mp")
    val sanity = integer("sanity")
    val luck = integer("luck")
}

object InfoTable : LongIdTable() {
    val name = varchar("name", 50)
    val player = varchar("player", 70)
    val occupation = varchar("occupation", 40)
    val age = integer("age")
    val sex = enumeration("sex", Sex::class)
    val residence = varchar("residence", 40)
    val birthplace = varchar("birthplace", 40)
}

object BackStoryTable : LongIdTable() {
    val personalDescription = varchar("personalDescription", 400)
    val ideologyOrBeliefs = varchar("ideologyOrBeliefs", 200)
    val significantPeople = varchar("significantPeople", 300)
    val meaningfulLocations = varchar("meaningfulLocations", 300)
    val treasuredProcessions = varchar("treasuredProcessions", 500)
    val traits = varchar("traits", 300)
    val injuriesAndScars = varchar("injuriesAndScars", 200)
    val phobiasAndManias = varchar("phobiasAndManias", 600)
    val arcaneTomesOrSpellsAndArtifacts = varchar("arcaneTomesOrSpellsAndArtifacts", 1000)
    val encountersWithStrangeEntities = varchar("encountersWithStrangeEntities", 600)
}

object CashAndAssetsTable : LongIdTable() {
    val spendingLevel = double("spendingLevel")
    val cash = decimal("cash", 12, 2)
    val assets = decimal("assets", 12, 2)
}
