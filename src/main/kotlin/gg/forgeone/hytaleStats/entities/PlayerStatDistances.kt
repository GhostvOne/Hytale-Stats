package gg.forgeone.hytaleStats.entities

class PlayerStatDistances {

    private var _distanceTraveled: Int = 0

    fun addDistance(distance: Int) {
        _distanceTraveled += distance
    }

    fun getDistance(): Int {
        return _distanceTraveled
    }

    fun reset() {
        _distanceTraveled = 0
    }
}