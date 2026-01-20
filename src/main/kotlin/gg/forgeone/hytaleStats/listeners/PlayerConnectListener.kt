package gg.forgeone.hytaleStats.listeners

import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent
import gg.forgeone.hytaleStats.entities.PlayerStat

class PlayerConnectListener {
    fun onPlayerConnect(event: PlayerConnectEvent): PlayerStat {
        val playerRef = event.playerRef

        return PlayerStat(playerRef.uuid)
    }
}