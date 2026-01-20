package gg.forgeone.hytaleStats.entities

import java.util.*

class PlayerStat(uuid1: UUID) {
    private var uuid: String = ""

    val damages = PlayerStatDamages()
    val kills = PlayerStatKills()
    val distances = PlayerStatDistances()
    val harvests = PlayerStatHarvests()

    init {
        uuid = uuid1.toString()
    }

    // Vous pouvez ajouter des méthodes globales ici si nécessaire
    fun resetAll() {
        // Logique de reset
    }
}