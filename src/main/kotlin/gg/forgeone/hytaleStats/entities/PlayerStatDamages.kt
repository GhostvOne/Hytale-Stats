package gg.forgeone.hytaleStats.entities

class PlayerStatDamages {
    private var _receivedDamages: Long = 0
    private var _sentDamages: Long = 0

    fun addDamage(damage: Long) {
        _receivedDamages += damage
    }

    fun addSentDamage(damage: Long) {
        _sentDamages += damage
    }

    fun getReceivedDamages(): Long {
        return _receivedDamages
    }


}