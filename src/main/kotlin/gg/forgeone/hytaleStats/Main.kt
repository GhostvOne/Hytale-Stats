package gg.forgeone.hytaleStats

import com.hypixel.hytale.logger.HytaleLogger
import com.hypixel.hytale.server.core.modules.entity.damage.DeathSystems
import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import gg.forgeone.hytaleStats.commands.HelloCommand
import gg.forgeone.hytaleStats.system.PlayerDeathSystem
import javax.annotation.Nonnull

class Main(@Nonnull init: JavaPluginInit) : JavaPlugin(init) {

    //     private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    override fun start() {
        super.start()

        this.entityStoreRegistry.registerSystem(PlayerDeathSystem())
        this.commandRegistry.registerCommand(HelloCommand())
    }



    override fun setup() {
        HytaleLogger.forEnclosingClass().atInfo()
    }
}