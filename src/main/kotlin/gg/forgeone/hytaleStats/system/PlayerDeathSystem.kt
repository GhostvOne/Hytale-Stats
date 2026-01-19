package gg.forgeone.hytaleStats.system

import com.hypixel.hytale.component.CommandBuffer
import com.hypixel.hytale.component.Ref
import com.hypixel.hytale.component.Store
import com.hypixel.hytale.component.query.Query
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.entity.entities.Player
import com.hypixel.hytale.server.core.modules.entity.damage.Damage
import com.hypixel.hytale.server.core.modules.entity.damage.DeathComponent
import com.hypixel.hytale.server.core.modules.entity.damage.DeathSystems
import com.hypixel.hytale.server.core.universe.Universe
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore


class PlayerDeathSystem: DeathSystems.OnDeathSystem() {
    override fun onComponentAdded(
        ref: Ref<EntityStore>,
        deathComponent: DeathComponent,
        store: Store<EntityStore>,
        commandBuffer: CommandBuffer<EntityStore>
    ) {
        val playerComponent = store.getComponent(ref, Player.getComponentType())

        checkNotNull(playerComponent)

        Universe.get().sendMessage(Message.raw("Death player: " + playerComponent.displayName))
        val deathInfo: Damage? = deathComponent.deathInfo
        if (deathInfo != null) {
            Universe.get().sendMessage(Message.raw("Death info amount: " + deathInfo.amount))
        }
    }

    override fun getQuery(): Query<EntityStore?>? {
        return Query.and(Player.getComponentType());
    }
}