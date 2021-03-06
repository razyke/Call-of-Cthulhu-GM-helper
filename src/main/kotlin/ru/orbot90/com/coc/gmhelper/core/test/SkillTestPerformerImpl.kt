package ru.orbot90.com.coc.gmhelper.core.test

import ru.orbot90.com.coc.gmhelper.core.dice.DiceRoller

class SkillTestPerformerImpl constructor(private val diceRoller: DiceRoller) : SkillTestPerformer {

    override fun performSkillTest(skillValue: Int,
                         bonusDiceCount: Int, penaltyDiceCount: Int): TestResultType {
        val rollResult = when {
            bonusDiceCount == 0 && penaltyDiceCount == 0 -> this.diceRoller.rollDice(1, 100)[0]
            bonusDiceCount > penaltyDiceCount -> this.rollWithBonusDice(bonusDiceCount - penaltyDiceCount)
            else -> this.rollWithPenaltyDice(penaltyDiceCount - bonusDiceCount)
        }

        val fumbleRange: IntRange = if (skillValue < 50) 96..100 else 100..100

        return when {
            rollResult in fumbleRange -> TestResultType.FUMBLE
            rollResult == 1 -> TestResultType.CRITICAL_SUCCESS
            rollResult <= skillValue/5 -> TestResultType.EXTREME_SUCCESS
            rollResult <= skillValue/2 -> TestResultType.HARD_SUCCESS
            rollResult <= skillValue -> TestResultType.SUCCESS
            else -> TestResultType.FAILURE
        }
    }

    private fun rollWithPenaltyDice(penaltyDiceCount: Int): Int {
        val units = this.diceRoller.rollDice(1, 10)[0]
        val tens = this.diceRoller.rollDice(1 + penaltyDiceCount, 10)
        val worstTen: Int = {
            var biggestTen = 0
            for (ten in tens) {
                if (ten > biggestTen) {
                    biggestTen = ten
                }
            }
            biggestTen
        }()

        return 10 * worstTen + units
    }

    private fun rollWithBonusDice(bonusDiceCount: Int): Int {
        val units = this.diceRoller.rollDice(1, 10)[0]
        val tens = this.diceRoller.rollDice(1 + bonusDiceCount, 10)
        val bestTen: Int = {
            var leastTen = 10
            for (ten in tens) {
                if (ten < leastTen) {
                    leastTen = ten
                }
            }
            leastTen
        }()

        return 10 * bestTen + units
    }

}