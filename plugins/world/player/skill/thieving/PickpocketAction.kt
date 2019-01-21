package world.player.skill.thieving

import api.predef.*
import io.luna.game.action.QueuedAction
import io.luna.game.event.impl.NpcClickEvent
import io.luna.game.model.mob.Animation
import io.luna.game.model.mob.Player
import io.luna.game.model.mob.Skill

class PickpocketAction(val npc: PickpocketNpc, val plr: Player) : QueuedAction<Player>(plr, 5) {

    init {
        println("INIT")
    }

    private fun add(npc: PickpocketNpc, plr: Player, skill: Skill){
        val inv = plr.inventory
        val stolenItem = npc.lootTable.pick()

        inv.add(stolenItem)
        skill.addExperience(npc.experience)
    }

    override fun execute() {
        val skill = plr.skill(SKILL_THIEVING)

        mob.sendMessage("pickpocketed")
        plr.animation(Animation(881))
        add(npc, plr, skill)
    }

    override fun isQueued(other: QueuedAction<*>?): Boolean =
            when (other) {
                // All alchs are queued, regardless of item
                is PickpocketAction -> true
                else -> false
            }

}