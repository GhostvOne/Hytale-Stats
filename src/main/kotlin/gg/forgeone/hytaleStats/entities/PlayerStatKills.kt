package gg.forgeone.hytaleStats.entities

class PlayerStatKills {
    private var _kills: Int = 0

    fun addKill() {
        _kills++
    }

    fun getKills(): Int {
        return _kills
    }
}