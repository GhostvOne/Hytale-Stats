package gg.forgeone.hytaleStats.services

import com.hypixel.hytale.component.Store
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.modules.entity.damage.Damage
import com.hypixel.hytale.server.core.modules.entity.damage.DeathComponent
import com.hypixel.hytale.server.core.universe.PlayerRef
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore
import gg.forgeone.hytaleStats.entities.KillerInfo

class PlayerDeathService {
    fun handleDeath(
        playerRef: PlayerRef,
        component: DeathComponent,
        store: Store<EntityStore>
    ): KillerInfo? {
        val world = store.externalData.world.name
        val cause = component.deathCause?.id

        val source = component.deathInfo?.source as? Damage.EntitySource ?: return null

        val ref = source.ref.takeIf { it.isValid } ?: return null

        store.getComponent(ref, PlayerRef.getComponentType())?.let {
            return KillerInfo.Player(it.uuid, it.username)
        }

        playerRef.sendMessage(Message.raw("Player ${playerRef.username} died in $world (cause=$cause)"))

        println(
            "Player ${playerRef.username} died in $world (cause=$cause)"
        )

        return null
    }
}
