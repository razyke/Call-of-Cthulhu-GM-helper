package ru.orbot90.com.coc.gmhelper.core

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.http.*
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.orbot90.com.coc.gmhelper.core.dice.DiceRoller
import ru.orbot90.com.coc.gmhelper.core.dice.DiceRollerImpl
import ru.orbot90.com.coc.gmhelper.core.model.RollRequest
import ru.orbot90.com.coc.gmhelper.core.model.TestRequest
import ru.orbot90.com.coc.gmhelper.core.test.SkillTestPerformer
import ru.orbot90.com.coc.gmhelper.core.test.SkillTestPerformerImpl

fun Application.module(){
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation){
      jackson {
          configure(SerializationFeature.INDENT_OUTPUT, true)
      }
    }
    install(Routing){
        get("/"){
            call.respondText("""Some API info:<br><br>
                |1) Use /diceroll with POST method. Body should be like this<br>
                |{diceCount: 4, diceFacesCount: 6} for example.<br><br>
                |2) Use /performtest with POST method. Body should be like this<br>
                |{i don't know =)}<br>
            """.trimMargin(), ContentType.Text.Html)
        }

        val dice = DiceRollerImpl() // for now.. we need KO-IN

        diceRollController(dice)
        performTestController(SkillTestPerformerImpl(dice))
    }
}

fun Route.diceRollController(diceRoller: DiceRoller){
    route("/diceroll"){
        post("/"){
            val request = call.receive<RollRequest>()
            call.respond(diceRoller.rollDice(request.diceCount,request.diceFacesCount))
        }
    }
}

fun Route.performTestController(skillTestPerformer: SkillTestPerformer){
    post("/performtest"){
        val request = call.receive<TestRequest>()
        val testResult = skillTestPerformer.performSkillTest(request.skillValue, request.bonusDice,
                request.penaltyDice).name
        call.respond("{\"testResult\": \"$testResult\"}")
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080, module = Application::module).start()
}