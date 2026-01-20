package gg.forgeone.hytaleStats.entities

import java.util.UUID
import kotlin.time.Instant

data class PlayerDeathContext(
    val playerUuid: UUID,
    val playerName: String,
    val worldName: String,
    val cause: String?,
    val killer: KillerInfo?
)

sealed class KillerInfo {
    data class Player(val uuid: UUID, val name: String) : KillerInfo()
    data class Npc(val typeId: String) : KillerInfo()
}
