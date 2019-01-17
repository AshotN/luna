import api.predef.SKILL_THIEVING
import api.predef.on
import io.luna.game.event.impl.NpcClickEvent
import io.luna.game.event.impl.NpcClickEvent.NpcSecondClickEvent
import io.luna.game.model.mob.Animation
import io.luna.game.model.mob.Player
import io.luna.game.model.mob.Skill
import world.player.skills.thieving.PickpocketNpc


fun add(npc: PickpocketNpc, plr: Player, skill: Skill){
    val inv = plr.inventory
    val stolenItem = npc.lootTable.pick()

    inv.add(stolenItem)
    skill.addExperience(npc.experience)
}

/**
 * Attempts to steal from [world.player.skills.thieving.PickpocketNpc].
 */
fun npcPickpocket(msg: NpcClickEvent, npc: PickpocketNpc) : Boolean {
    val skill = msg.plr.skill(SKILL_THIEVING)

    return if (skill.level < npc.level) {
        // Check if we have required level.
        msg.plr.sendMessage("You need level ${npc.level} thieving to pick the ${npc.formattedName.toLowerCase()}'s pocket.")
        false
    } else {
        // Start stealing!
        msg.plr.animation(Animation(881))
        add(npc, msg.plr, skill)
        true
    }
}


//PickpocketNpc Event

on(NpcSecondClickEvent::class) {
    npcPickpocket(this, PickpocketNpc.from(this.npc.id)!!)
}