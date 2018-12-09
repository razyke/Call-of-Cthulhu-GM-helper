package ru.orbot90.com.coc.gmhelper.core.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.orbot90.com.coc.gmhelper.core.dice.DiceRoller

@RestController
@RequestMapping("/diceroll")
class DiceRollController {

    @Autowired
    lateinit var diceRoller: DiceRoller

    @PostMapping
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    fun rollDice(@RequestBody request: RollRequest): IntArray {
        val requestString = request.rollRequest
        val requestParts: List<String> = requestString.split('x')
        val diceCount : Int = Integer.parseInt(requestParts[0])
        val facesCount : Int = Integer.parseInt(requestParts[1].substringAfter('d'))
        val rollResult = this.diceRoller.rollDice(diceCount, facesCount)
        return rollResult
    }
}