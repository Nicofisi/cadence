package ovh.natproview.cadence

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import java.io.File

object CadenceListener : ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val msg = event.message
        val author = event.author
        val channel = event.channel
        val raw = msg.contentRaw
        val lower = raw.toLowerCase()

        if (lower.equals("turn off")) {
            File("leave.txt").writeText(channel.id)
            channel.sendMessage("Turning off...").queue()
            event.jda.shutdown()
        }
        // algorytm warunkowy = operacja wykona się, jesli warunek po if  zostanie spełniony
        // lower = weź wiadomość
        // equals = ta wiadomosc musi byc dokladnie taka jak to, co jest w nawiasie
        // pomiędzy {} znajduje się kod, który wykonuje się, jeżeli warunek equals jest spełniony
        // tzn. jesli wzięta wiadomość jest taka sama jak tekst w nawiasie, warunek się wykona
        if (lower.equals("hello world")) { // jeżeli zostanie spełniony warunek, że wysłana wiadomość to "hello world"
            // channel = weź kanał
            // sendMessage(x) = wyślij wiadomość o treści x
            // .queue() - musi zostać dopisane, aby kod mógł zrobić coś związanego wiadomościami
            channel.sendMessage("oh hi there").queue()
        }

        if (lower.startsWith("say ")) { // jeżeli wiadomość zaczyna się z "say "
            val text = lower // tekst wiadomości zapisywany jest do zmiennej text
            // od zmiennej text zabieramy 4 pierwsze znaki i tworzymy z niej zmienną textToSend
            val textToSend = lower.substring(4)
            channel.sendMessage(textToSend).queue() // wysłana zostaje nasza wiadomośc bez "say "
            msg.delete().queue() // nasza oryginalna wiadomosc zostaje usunięta i zostaje tylko ta wyslana przez bota
        }

        if (lower.contains("google")) { // jeżeli w tej wiadomości występuje słowo "google"
            channel.sendFile(File("google.png")).queue() // wyślij na ten kanał plik (logo googla jako obraz)
        }
    }
}