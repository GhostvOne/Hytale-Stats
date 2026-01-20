package gg.forgeone.hytaleStats

import com.hypixel.hytale.logger.HytaleLogger
import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import gg.forgeone.hytaleStats.commands.HelloCommand
import gg.forgeone.hytaleStats.entities.PlayerStat
import gg.forgeone.hytaleStats.listeners.PlayerDeathListener
import gg.forgeone.hytaleStats.services.PlayerDeathService
import javax.annotation.Nonnull

class Main(@Nonnull init: JavaPluginInit) : JavaPlugin(init) {

    private val playersStats = mutableMapOf<String, PlayerStat>()
    //     private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    override fun start() {
        super.start()

        registerListeners()

        commandRegistry.registerCommand(HelloCommand())
    }

    override fun setup() {
        HytaleLogger.forEnclosingClass().atInfo()
    }

    fun registerListeners() {
        val deathService = PlayerDeathService()

        PlayerDeathListener(deathService).register(entityStoreRegistry)
    }
}