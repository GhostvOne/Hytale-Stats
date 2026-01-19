package org.example

import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import com.hypixel.hytale.logger.HytaleLogger
import javax.annotation.Nonnull

// Assurez-vous d'importer la classe JavaPlugin correcte depuis votre dépendance
// Par exemple pour Spigot : import org.bukkit.plugin.java.JavaPlugin
// Ou pour Hytale (selon l'API) : import com.hypixel.hytale.JavaPlugin

class Main(@Nonnull init: JavaPluginInit) : JavaPlugin(init) {

    //     private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    override fun setup() {
        HytaleLogger.forEnclosingClass().atInfo()
    }
}