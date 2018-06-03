package ovh.natproview.cadence

import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder
import java.io.File

fun main(args: Array<String>) {
    val token = File("token.txt").readText().trim()

    val jda = JDABuilder(AccountType.BOT)
            .setToken(token)
            .addEventListener(CadenceListener)
            .buildBlocking()
    jda.getTextChannelById(File("leave.txt").readText().trim()).sendMessage("I'm back on!").queue()

}