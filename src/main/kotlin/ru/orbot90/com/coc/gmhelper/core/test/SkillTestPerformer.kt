package ru.orbot90.com.coc.gmhelper.core.test

interface SkillTestPerformer {

    fun performSkillTest(skillValue: Int,
                         bonusDiceCount: Int = 0, penaltyDiceCount: Int = 0): TestResultType
}