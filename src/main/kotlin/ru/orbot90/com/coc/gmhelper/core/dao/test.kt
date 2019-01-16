package ru.orbot90.com.coc.gmhelper.core.dao

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")

    val superCat = transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Cats)
        SchemaUtils.create(Bowls)


        val cat2 = Cat.new {
            name = "Super Kot"
            age = 777
        }

        val bowl = Bowl.new {
            type = "food"
            cat = cat2
        }
        val bowl2 = Bowl.new {
            type = "water"
            cat = cat2
        }
        cat2
    }

    var bowls = mutableListOf<Bowl>()
    //var l = {x: SizedIterable<Bowl> -> bowls.  }

    val getCat = transaction {
        val findById = Cat.findById(1)

        findById!!.bowls.forEach {
            println(it.type)
        }
        //findById
    }

    val okCat = transaction {
        addLogger(StdOutSqlLogger)
        Cat.new {
            name = "Normalnu Kot"
            age = 7
        }
    }


    print(superCat)
    print(okCat)

}

object Cats : LongIdTable() {
    val name = varchar("name", 20)
    val age = integer("age")
}

object Bowls : LongIdTable() {
    val type = varchar("bowl", 40)
    val cat = reference("cat", Cats)
}

class Bowl(id : EntityID<Long>): LongEntity(id) {
    companion object : LongEntityClass<Bowl>(Bowls)

    var type by Bowls.type
    var cat by Cat referencedOn Bowls.cat
}
class Cat(id: EntityID<Long>) : LongEntity(id) {

    companion object : LongEntityClass<Cat>(Cats)
    var name by Cats.name
    var age by Cats.age
    val bowls by Bowl referrersOn Bowls.cat

    override fun toString(): String {
        return "Cat: id = $id name = $name, age = $age"
    }

}

object Users: IntIdTable() {
    val name = varchar("name", 50)
}

class User(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
}


object UserRatings: IntIdTable() {
    val value = long("value")
    val user = reference("user", Users)
}

class UserRating(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<UserRating>(UserRatings)

    var value by UserRatings.value
    var user by User referencedOn UserRatings.user
}

