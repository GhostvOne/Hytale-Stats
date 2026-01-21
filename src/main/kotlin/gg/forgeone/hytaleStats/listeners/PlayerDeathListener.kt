package gg.forgeone.hytaleStats.system

import com.hypixel.hytale.component.CommandBuffer
import com.hypixel.hytale.component.Ref
import com.hypixel.hytale.component.Store
import com.hypixel.hytale.component.query.Query
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.entity.entities.Player
import com.hypixel.hytale.server.core.modules.entity.damage.DeathComponent
import com.hypixel.hytale.server.core.modules.entity.damage.DeathSystems
import com.hypixel.hytale.server.core.universe.Universe
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore
import gg.forgeone.hytaleStats.utils.LogUtils
import gg.forgeone.hytaleStats.utils.PlayerMessageUtils

open class PlayerDeathListener : DeathSystems.OnDeathSystem() {

    override fun getQuery(): Query<EntityStore> {
        // On ne traite que les entités qui sont des joueurs
        return Query.and(Player.getComponentType())
    }

    override fun onComponentAdded(
        ref: Ref<EntityStore>,
        deathComponent: DeathComponent,
        store: Store<EntityStore>,
        commandBuffer: CommandBuffer<EntityStore>
    ) {
        // Ici c'est le vrai point d'entrée ECS
        onDeath(ref, store, commandBuffer, deathComponent)
    }

    protected fun onDeath(
        ref: Ref<EntityStore>,
        store: Store<EntityStore>,
        commandBuffer: CommandBuffer<EntityStore>,
        deathComponent: DeathComponent
    ) {
        val player = store.getComponent(ref, Player.getComponentType())
            ?: return

        PlayerMessageUtils.broadcast("${player.displayName} est mort")

        deathComponent.deathCause.let { deathCause ->
            LogUtils.debug("$deathCause")
            PlayerMessageUtils.broadcast("${player.displayName} mort à cause de $deathCause")
        }
        deathComponent.deathInfo?.let { damage ->
            PlayerMessageUtils.broadcast("Cause : ${damage.amount} dégâts")
        }
    }
}
