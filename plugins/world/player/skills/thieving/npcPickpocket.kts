import api.predef.SKILL_THIEVING
import api.predef.on
import io.luna.game.event.impl.NpcClickEvent
import io.luna.game.event.impl.NpcClickEvent.NpcSecondClickEvent
import io.luna.game.model.item.Item
import io.luna.game.model.mob.Animation
import io.luna.game.model.mob.Player
import world.player.skills.thieving.NPC


fun add(npc: NPC, plr: Player){
    val inv = plr.inventory
    if(npc.stealTable.count() > 1) {

        val availableItems = npc.stealTable.filter { it.levelRequired <= plr.skill(SKILL_THIEVING).level }
        val randomItem = availableItems.random() //TODO: Take into account drop rates
        val item = Item(randomItem.itemId, randomItem.itemQuantity.random())
        inv.add(item)
        return
    }

    val amount = npc.stealTable[0].itemQuantity.random()
    inv.add(Item(995, amount))
}

/**
 * Attempts to steal from [NPC].
 */
fun npcPickpocket(msg: NpcClickEvent, npc: NPC) : Boolean {
    val skill = msg.plr.skill(SKILL_THIEVING)

    return if (skill.level < npc.level) {
        // Check if we have required level.
        msg.plr.sendMessage("You need level ${npc.level} thieving to pick the ${npc.formattedName.toLowerCase()}'s pocket.")
        false
    } else {
        // Start stealing!
        msg.plr.animation(Animation(881))
        add(npc, msg.plr)
        true
    }
}


//Pickpocket NPC Event

on(NpcSecondClickEvent::class) {
    npcPickpocket(this, NPC.from(this.npc.id)!!)
}