package gg.forgeone.hytaleStats.commands

import com.hypixel.hytale.component.Ref
import com.hypixel.hytale.component.Store
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.command.system.CommandContext
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand
import com.hypixel.hytale.server.core.universe.PlayerRef
import com.hypixel.hytale.server.core.universe.world.World
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore

class HelloCommand: AbstractPlayerCommand("hello", "Hello World") {

    override fun execute(
        p0: CommandContext,
        p1: Store<EntityStore?>,
        p2: Ref<EntityStore?>,
        p3: PlayerRef,
        p4: World
    ) {
        p0.sender().sendMessage(Message.raw("Hello World!"))
    }
}