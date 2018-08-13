package ru.orbot90.com.coc.gmhelper.core.dice

interface DiceRoller {

    /**
     * Roll dice
     *
     * @param diceCount - number of rolled dice
     * @param diceFacesCount - number of faces of the rolled dice
     *
     * @return array of the results of roll
     */
    fun rollDice(diceCount: Int, diceFacesCount: Int): IntArray
}