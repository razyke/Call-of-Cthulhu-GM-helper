package ru.orbot90.com.coc.gmhelper.core.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.orbot90.com.coc.gmhelper.core.model.TestRequest
import ru.orbot90.com.coc.gmhelper.core.test.SkillTestPerformer

@RestController
@RequestMapping("/performtest")
class PerformTestController {

    @Autowired
    lateinit var skillTestPerformer: SkillTestPerformer

    @PostMapping
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    fun performTest(@RequestBody testRequest: TestRequest) : String {
        return skillTestPerformer.performSkillTest(testRequest.skillValue, testRequest.bonusDice, testRequest.penaltyDice).name
    }


}