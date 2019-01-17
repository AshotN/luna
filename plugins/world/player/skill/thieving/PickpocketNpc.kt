package world.player.skills.thieving

import api.item.LootTable
import api.item.LootTableItem
import api.predef.*
import io.luna.util.Rational

/**
 * An enum representing NPCs that can be pickpocketed.
 */
enum class PickpocketNpc(val id: List<Int>,
                val level: Int,
                val lootTable: LootTable,
                val experience: Double,
                val stunDamage: IntRange,
                val stunTime: Int,
                val formattedName: String) {

    MAN(id = listOf(1,2,3),
            level = 1,
            lootTable = lootTable { rarity(ALWAYS){
                995 x 3 //Gold
            } },
            stunDamage = 1..1,
            stunTime = 5,
            experience = 8.0,
            formattedName = "Man"),
    WOMAN(id = listOf(4,5,6),
            level = MAN.level,
            lootTable = MAN.lootTable,
            experience = MAN.experience,
            stunDamage = MAN.stunDamage,
            stunTime = MAN.stunTime,
            formattedName = "Woman"),
    FARMER(id = listOf(7),
            level = 10,
            lootTable = lootTable {
                rarity(COMMON) {
                    995 x 3 //Gold
                }
                rarity(RARE) {
                    5318 x 1 //Potato Seed
                } },
            stunDamage = 5..5,
            stunTime = 1,
            experience = 14.5,
            formattedName = "Farmer"),
    //TODO: HAM
    ALKHARIDWARRIOR(id = listOf(18),
            level = 25,
            lootTable = lootTable { rarity(ALWAYS){
                995 x 18 //Gold
            } },
            stunDamage = 2..2,
            stunTime = 5,
            experience = 26.0,
            formattedName = "Al-Kharid warrior"),//TODO: check
    WARRIORWOMAN(id = listOf(15),
            level = 25,
            lootTable = lootTable { rarity(ALWAYS){
                995 x 18 //Gold
            } },
            stunDamage = 2..2,
            stunTime = 5,
            experience = 26.0,
            formattedName = "Warrior woman"),//TODO: check
    Rogue(id = listOf(187),
            level = 32,
            lootTable = lootTable {
                rarity(COMMON){
                    995 x 25..120 //Gold
                }
                rarity(COMMON){
                    556 x 8 //Air Rune
                }
                rarity(UNCOMMON){
                    1993 x 1 // Jug of Wine
                }
                rarity(RARE){
                    1993 x 1 // Jug of Wine
                }
                rarity(RARE){
                    2357 x 1 // Gold bar
                }
                rarity(VERY_RARE){
                    1219 x 1 //	Iron Dagger(p)
                }
            },
            stunDamage = 2..2,
            stunTime = 5,
            experience = 35.5,
            formattedName = "Rogue"),//TODO: check
    MASTERFARMER(id = listOf(2234,2235),
            level = 38,
            lootTable = lootTable {
                //Allotments
                rarity(Rational(10,56)){
                    5318 x 1..4 //Potato Seed
                }
                rarity(Rational(100,747)){
                    5319 x 1..3 //Onion Seed
                }
                rarity(Rational(10,143)){
                    5324 x 1..3 //Cabbage Seed
                }
                rarity(Rational(10,156)){
                    5322 x 1..2 //Tomato Seed
                }
                rarity(Rational(10,448)){
                    5320 x 1..2 //Sweetcorn Seed
                }
                rarity(Rational(10,825)){
                    5323 x 1..1 //Strawberry Seed
                }
                rarity(Rational(1,187)){
                    5321 x 1..1 //Watermelon Seed
                }

                //Hops
                rarity(Rational(1,18)){
                    5305 x 1..4 //Barley Seed
                }
                rarity(Rational(1,18)){
                    5307 x 1..3 //Hammerstone Seed
                }
                rarity(Rational(10,239)){
                    5308 x 1..2 //Asgarnian Seed
                }
                rarity(Rational(10,241)){
                    5306 x 1..3 //Jute Seed
                }
                rarity(Rational(10,361)){
                    5309 x 1..2 //Yanillian Seed
                }
                rarity(Rational(10,361)){
                    5310 x 1..1 //Krandorian Seed
                }
                rarity(Rational(1,142)){
                    5311 x 1..1 //Wildblood Seed
                }

                //Flowers
                rarity(Rational(10,218)){
                    5096 x 1..1 //Marigold Seed
                }
                rarity(Rational(10,329)){
                    5098 x 1..1 //Nasturtium Seed
                }
                rarity(Rational(10,509)){
                    5097 x 1..1 //Rosemary Seed
                }
                rarity(Rational(10,689)){
                    5099 x 1..1 //Woad Seed
                }
                rarity(Rational(10,863)){
                    5100 x 1..1 //Limpwurt Seed
                }

                //Bushes
                rarity(Rational(10,258)){
                    5101 x 1..1 //Redberry Seed
                }
                rarity(Rational(10,368)){
                    5102 x 1..1 //Cadavaberry Seed
                }
                rarity(Rational(10,515)){
                    5103 x 1..1 //Dwellberry Seed
                }
                rarity(Rational(1,129)){
                    5104 x 1..1 //Jangerberry Seed
                }
                rarity(Rational(1,355)){
                    5105 x 1..1 //Whiteberry Seed
                }
                rarity(Rational(1,937)){
                    5106 x 1..1 //Poison Ivy Seed
                }

                //Herbs
                rarity(Rational(10,651)){
                    5291 x 1..1 //Guam Seed
                }
                rarity(Rational(10,956)){
                    5292 x 1..1 //Marrentill Seed
                }
                rarity(Rational(1,140)){
                    5293 x 1..1 //Tarromin Seed
                }
                rarity(Rational(1,206)){
                    5294 x 1..1 //Harralander Seed
                }
                rarity(Rational(1,302)){
                    5295 x 1..1 //Ranarr Seed
                }
                rarity(Rational(1,443)){
                    5296 x 1..1 //Toadflax Seed
                }
                rarity(Rational(1,651)){
                    5297 x 1..1 //Irit Seed
                }
                rarity(Rational(1,947)){
                    5298 x 1..1 //Avantoe Seed
                }
                rarity(Rational(1,1389)){
                    5299 x 1..1 //Kwuarm Seed
                }
                rarity(Rational(1,2083)){
                    5300 x 1..1 //Snapdragon Seed
                }
                rarity(Rational(1,2976)){
                    5301 x 1..1 //Cadantine Seed
                }
                rarity(Rational(1,4167)){
                    5302 x 1..1 //Lantadyme Seed
                }
                rarity(Rational(1,6944)){
                    5303 x 1..1 //Dwarf Weed Seed
                }
                rarity(Rational(1,10417)){
                    5304 x 1..1 //Torstol Seed
                }

                //Special
                rarity(Rational(1,400)){
                    5282 x 1..1 //Mushroom Spore
                }
                rarity(Rational(1,667)){
                    5281 x 1..1 //Belladonna Seed
                }
                rarity(Rational(1,1000)){
                    5280 x 1..1 //Cactus Seed
                }
            },
            stunDamage = 3..3,
            stunTime = 5,
            experience = 43.0,
            formattedName = "Master Farmer"),//TODO: check
    GUARD(id = listOf(9,10,32),
            level = 40,
            lootTable = lootTable { rarity(ALWAYS){
                995 x 30 //Gold
            } },
            stunDamage = 2..2,
            stunTime = 5,
            experience = 46.8,
            formattedName = "Guard");


    companion object {
        fun from(i: Int): PickpocketNpc? = values().find { it.id.contains(i) }
    }
}