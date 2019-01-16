package world.player.skills.thieving

import api.predef.*

class StealTableItem(val itemId: Int,
                      val itemQuantity: IntRange,
                      val levelRequired: Int,
                      val chance: Int)

/**
 * An enum representing NPCs that can be pickpocketed.
 */
enum class PickpocketNpc(val id: List<Int>,
                val level: Int,
                val stealTable: List<StealTableItem>,
                val formattedName: String) {

    MAN(id = listOf(1,2,3),
            level = 1,
            stealTable = listOf(StealTableItem(995, 3..3, 1, 100)),
            formattedName = "Man"),
    WOMAN(id = listOf(4,5,6),
            level = 1,
            stealTable = listOf(StealTableItem(995, 3..3, 1, 100)),
            formattedName = "Woman"),
    FARMER(id = listOf(7),
            level = 10,
            stealTable = listOf(StealTableItem(995, 9..9, 10, 90), StealTableItem(5318,1..1, 1, 10)),
            formattedName = "Farmer"),
    GUARD(id = listOf(9,10,32),
            level = 40,
            stealTable = listOf(StealTableItem(995, 30..30, 40, 100)),
            formattedName = "Guard");


    companion object {
        fun from(i: Int): PickpocketNpc? = values().find { it.id.contains(i) }
    }
}