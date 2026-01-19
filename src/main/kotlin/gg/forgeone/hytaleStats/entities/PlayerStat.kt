package gg.forgeone.hytaleStats.entities

class PlayerStat {
    var kills: Int = 0
    var deaths: Int = 0
    var receivedDamages: Long = 0
    var sentDamages: Long = 0
    var harvest: Int = 0
    var distanceTraveled: Int = 0

    fun addDamage(damage: Long) {
        receivedDamages += damage
    }

    fun addDistance(distance: Int) {
        distanceTraveled += distance
    }

    fun addKill() {
        kills++
    }

    fun addDeath() {
        deaths++
    }

    fun addHarvest() {
        harvest++
    }

    fun reset() {
        kills = 0
        deaths = 0
        receivedDamages = 0
        sentDamages = 0
        harvest = 0
        distanceTraveled = 0
    }
}