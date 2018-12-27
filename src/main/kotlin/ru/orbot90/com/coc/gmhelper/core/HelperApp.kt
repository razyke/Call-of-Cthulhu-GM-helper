package ru.orbot90.com.coc.gmhelper.core

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.http.*
import io.ktor.jackson.jackson
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.ext.inject
import org.koin.standalone.StandAloneContext.startKoin
import ru.orbot90.com.coc.gmhelper.core.controller.diceRollController
import ru.orbot90.com.coc.gmhelper.core.controller.performTestController
import ru.orbot90.com.coc.gmhelper.core.dice.DiceRoller
import ru.orbot90.com.coc.gmhelper.core.test.SkillTestPerformer

fun Application.module(){
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation){
      jackson {
          configure(SerializationFeature.INDENT_OUTPUT, true)
      }
    }
    install(CORS) {
        anyHost()
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

        val diceRoller by inject<DiceRoller>()
        val skillTestPerform by inject<SkillTestPerformer>()

        diceRollController(diceRoller)
        performTestController(skillTestPerform)
    }
}

fun main(args: Array<String>) {
    startKoin(listOf(HelperGmModule))
    embeddedServer(Netty, 8080, module = Application::module).start()
}