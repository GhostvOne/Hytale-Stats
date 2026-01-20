package gg.forgeone.hytaleStats.listeners

import com.hypixel.hytale.component.CommandBuffer
import com.hypixel.hytale.component.ComponentRegistryProxy
import com.hypixel.hytale.component.Ref
import com.hypixel.hytale.component.Store
import com.hypixel.hytale.server.core.modules.entity.damage.DeathComponent
import com.hypixel.hytale.server.core.modules.entity.damage.DeathSystems
import com.hypixel.hytale.server.core.universe.PlayerRef
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore
import gg.forgeone.hytaleStats.Main
import gg.forgeone.hytaleStats.services.PlayerDeathService

// https://hytalemodding.dev/en/docs/guides/plugin/player-death-event
class PlayerDeathListener(
    private val service: PlayerDeathService
) {

    fun register(registry: ComponentRegistryProxy<EntityStore>) {
        registry.registerSystem(PlayerDeathSystem())
    }

    private inner class PlayerDeathSystem : DeathSystems.OnDeathSystem() {

        override fun getQuery() =
            PlayerRef.getComponentType()

        override fun onComponentAdded(
            ref: Ref<EntityStore>,
            component: DeathComponent,
            store: Store<EntityStore>,
            commandBuffer: CommandBuffer<EntityStore>
        ) {
            val playerRef =
                store.getComponent(ref, PlayerRef.getComponentType())
                    ?: return

            service.handleDeath(playerRef, component, store)
        }
    }
}
