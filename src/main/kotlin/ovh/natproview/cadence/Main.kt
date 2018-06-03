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

    val leaveFile = File("leave.txt")
    if (leaveFile.exists()) {
        val leaveChannelId = leaveFile.readText().trim()
        jda.getTextChannelById(leaveChannelId).sendMessage("I'm back on!").queue()
    }
}