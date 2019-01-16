package ru.orbot90.com.coc.gmhelper.core.model

import java.util.*

data class Dice(val diceCount: Int, val diceFacesCount: Int) {

    private val random: Random = Random()

    fun throwDice(): Int{
        var sum = 0
        for (i in 0 until diceCount) {
            sum += this.random.nextInt(diceFacesCount) + 1
        }
        return sum
    }

    operator fun plus(dice: Dice): Int = throwDice() + dice.throwDice()

    operator fun plus(num: Int): Int = throwDice() + num

}