package gg.forgeone.hytaleStats

import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import gg.forgeone.hytaleStats.commands.HelloCommand
import gg.forgeone.hytaleStats.entities.PlayerStat
import gg.forgeone.hytaleStats.system.PlayerDeathListener
import gg.forgeone.hytaleStats.utils.LogUtils
import javax.annotation.Nonnull

class Main(@Nonnull init: JavaPluginInit) : JavaPlugin(init) {

    private val playersStats = mutableMapOf<String, PlayerStat>()

    override fun start() {
        super.start()

        LogUtils.info("Le mods vient de start.")

        entityStoreRegistry.registerSystem(
            PlayerDeathListener()
        )

        commandRegistry.registerCommand(HelloCommand())
    }

    override fun setup() {
        LogUtils.info("Le mods vient de ce setup.")
    }
}