package ru.orbot90.com.coc.gmhelper.core.dice

import java.util.*

class DiceRollerImpl: DiceRoller {

    private val random: Random = Random()

    override fun rollDice(diceCount: Int, diceFacesCount: Int): IntArray {
        val result = IntArray(diceCount)
        for (i in 0 until diceCount) {
            result[i] = this.random.nextInt(diceFacesCount) + 1
        }
        return result
    }
}