package gg.forgeone.hytaleStats.entities

class PlayerStatHarvests {
    private var _harvest: Int = 0

    fun addHarvest() {
        _harvest++
    }

    fun getHarvest(): Int {
        return _harvest
    }
}