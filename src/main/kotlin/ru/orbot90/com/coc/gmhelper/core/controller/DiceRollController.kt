package ru.orbot90.com.coc.gmhelper.core.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.orbot90.com.coc.gmhelper.core.dice.DiceRoller
import ru.orbot90.com.coc.gmhelper.core.model.RollRequest

@RestController
@RequestMapping("/diceroll")
class DiceRollController {

    @Autowired
    lateinit var diceRoller: DiceRoller

    @PostMapping
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    fun rollDice(@RequestBody request: RollRequest): IntArray {
        return this.diceRoller.rollDice(request.diceCount, request.diceFacesCount)
    }
}