package ru.orbot90.com.coc.gmhelper.core

import org.koin.dsl.module.module
import ru.orbot90.com.coc.gmhelper.core.dice.DiceRoller
import ru.orbot90.com.coc.gmhelper.core.dice.DiceRollerImpl
import ru.orbot90.com.coc.gmhelper.core.test.SkillTestPerformer
import ru.orbot90.com.coc.gmhelper.core.test.SkillTestPerformerImpl

val HelperGmModule = module {
    single<DiceRoller> { DiceRollerImpl() }
    single<SkillTestPerformer> { SkillTestPerformerImpl(get()) }
}