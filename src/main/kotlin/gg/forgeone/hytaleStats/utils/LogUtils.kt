package gg.forgeone.hytaleStats.utils

import com.hypixel.hytale.logger.HytaleLogger

object LogUtils {
    private const val name = "[Hytale-Stats] "
    private val LOGGER: HytaleLogger =
        HytaleLogger.forEnclosingClass()

    fun info(message: String) {
        LOGGER.atInfo().log(name + message)
    }

    fun warn(message: String) {
        LOGGER.atWarning().log(name + message)
    }

    fun error(message: String, throwable: Throwable? = null) {
        if (throwable != null) {
            LOGGER.atSevere().withCause(throwable).log(name + message)
        } else {
            LOGGER.atSevere().log(name + message)
        }
    }

    fun debug(message: String) {
        LOGGER.atFine().log(name + message)
    }
}
