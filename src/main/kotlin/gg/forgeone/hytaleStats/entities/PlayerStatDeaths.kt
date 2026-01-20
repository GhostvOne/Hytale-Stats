package gg.forgeone.hytaleStats.entities

import kotlin.time.Instant

class PlayerStatDeaths {
    private var _deaths: Int = 0
    private var _lastDeath: Instant? = null
    private var _lastCauseOfDeath: String? = null

    fun initWithDeath(cause: String? = null) {
        val time = Instant.now()
        _deaths = 1
        _lastDeath = Instant.now()
        _lastCauseOfDeath = cause
    }

    fun addDeath(cause: String? = null) {
        _deaths++
        _lastDeath = Instant.now()
        _lastCauseOfDeath = cause
    }

    fun reset() {
        _deaths = 0
        _lastDeath = 0
        _lastCauseOfDeath = null
    }
}
