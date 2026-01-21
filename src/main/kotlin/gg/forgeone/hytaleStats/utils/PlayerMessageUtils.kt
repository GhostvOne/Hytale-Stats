package gg.forgeone.hytaleStats.utils

import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.entity.entities.Player
import com.hypixel.hytale.server.core.universe.Universe

object PlayerMessageUtils {
    /**
     * Message global (chat serveur)
     */
    fun broadcast(text: String) {
        Universe.get().sendMessage(
            Message.raw(text)
        )
    }

    /**
     * Message privé à un joueur
     */
    fun send(player: Player, text: String) {
        player.sendMessage(
            Message.raw(text)
        )
    }

    /**
     * Message formaté (préfixe plugin)
     */
    fun broadcastPrefixed(prefix: String, text: String) {
        broadcast("§6[$prefix] §f$text")
    }

    fun sendPrefixed(prefix: String, player: Player, text: String) {
        send(player, "§6[$prefix] §f$text")
    }
}
