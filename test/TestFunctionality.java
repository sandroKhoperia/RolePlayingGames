import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests the functionality of the defined classes
 */
public class TestFunctionality {
    private Footwear _footWear;
    private Handgear _handGear;
    private Headgear _headGear;

    private ICharacter _player;



    /**
     * Creates objects that are used for testing the functionality of the classes
     */
    @Before
    public void setUp(){
        _player = TestingHelper.createCharacterWithStats(CorrectData.CharacterNames.get(0),new Stats(5,5));
        _footWear = TestingHelper.createFootwear(CorrectData.FootWearNames.get(0), new Stats(10,10));
        _handGear = TestingHelper.createHandGear(CorrectData.HandGearNames.get(0), new Stats(10,0));
        _headGear = TestingHelper.createHeadGear(CorrectData.HeadGearNames.get(0), new Stats(0,10));
    }

    /**
     * Tests three different types of battle:
     * 1. Player 1 wins
     * 2. Player 2 wins
     * 3. Tie
     */
    @Test
    public void test_Battle(){
        var battle = TestingHelper.createCorrectBattleWithEvenItems();
        battle.initiateBattle();
        assertEquals(battle.getWinner().size(), 1);
        assertEquals(battle.getWinner().get(0), battle.getPlayers()[0]);

        var newBattle = new Battle(new Character(CorrectData.CharacterNames.get(0)),
                new Character(CorrectData.CharacterNames.get(1), new Stats(1000,1000)),
                TestingHelper.createTenSameTypeCorrectItems());
        newBattle.initiateBattle();
        assertEquals(newBattle.getWinner().size(), 1);
        assertEquals(newBattle.getWinner().get(0), newBattle.getPlayers()[1]);

        newBattle = (Battle) TestingHelper.createCorrectBattleWithSameItems();
        newBattle.initiateBattle();
        assertEquals(newBattle.getWinner().size(), 2);
        assertEquals(newBattle.getWinner().get(0), newBattle.getPlayers()[0]);
        assertEquals(newBattle.getWinner().get(1), newBattle.getPlayers()[1]);
    }

    /**
     * Tests whether the method throws exception if add method is called when maximum number of slots are already allocated
     */
    @Test(expected = IllegalStateException.class)
    public void test_Add_Second_HeadGear(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_headGear);
        equippedGear.addGear(_headGear);
    }

    /**
     * Tests whether the method throws exception if add method is called when maximum number of slots are already allocated
     */
    @Test(expected = IllegalStateException.class)
    public void test_Add_Third_HandGear(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_handGear);
        equippedGear.addGear(_handGear);
        equippedGear.addGear(_handGear);
    }

    /**
     * Tests whether the method throws exception if add method is called when maximum number of slots are already allocated
     */
    @Test(expected = IllegalStateException.class)
    public void test_Add_Third_FootWear(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_footWear);
        equippedGear.addGear(_footWear);
        equippedGear.addGear(_footWear);
    }

    /**
     * Tests whether the method throws exception if replace method is called on different type of gear.
     * e.g. you should not be able to replace hand gear with headgear.
     */
    @Test(expected = IllegalStateException.class)
    public void test_Add_Conflicting_Type(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_headGear);
        equippedGear.addGear(_footWear);
    }

    /**
     * Tests whether the method throws exception if replace method is called on different type of gear.
     * e.g. you should not be able to replace hand gear with headgear.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Replace_Conflicting_Type(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_headGear);
        equippedGear.replaceGear(0,_footWear);
    }

    /**
     * Tests the functionality of the method getItemNeeds. Should return all the item slot gear types that are remaining
     * to be filled.
     */
    @Test
    public void test_Get_Item_Needs(){
        var itemsNeeded = CharacterHelper.getItemNeeds(_player);
        assertEquals(itemsNeeded.size(), 3);
        assertTrue(itemsNeeded.contains(GearType.HEADGEAR));
        assertTrue(itemsNeeded.contains(GearType.HANDGEAR));
        assertTrue(itemsNeeded.contains(GearType.FOOTWEAR));

        var helmets = TestingHelper.createTwoHelmets();
        _player.chooseItem(helmets);

        itemsNeeded = CharacterHelper.getItemNeeds(_player);
        assertEquals(itemsNeeded.size(), 2);
        assertFalse(itemsNeeded.contains(GearType.HEADGEAR));
        assertTrue(itemsNeeded.contains(GearType.HANDGEAR));
        assertTrue(itemsNeeded.contains(GearType.FOOTWEAR));

        var footWears = TestingHelper.createTwoFootWears();
        _player.chooseItem(footWears);
        itemsNeeded = CharacterHelper.getItemNeeds(_player);
        assertEquals(itemsNeeded.size(), 2);
        assertFalse(itemsNeeded.contains(GearType.HEADGEAR));
        assertTrue(itemsNeeded.contains(GearType.HANDGEAR));
        assertTrue(itemsNeeded.contains(GearType.FOOTWEAR));

    }

    /**
     * Tests the character functionality of choosing the item: items should be removed from the list after equipping.
     * Makes sure that the chosen gear is following all 4 rules and chosen accordingly. Also checks whether the item
     * is actually equipped after choosing.
     */
    @Test
    public void test_Choose_Item(){
        var itemList = new ArrayList<IGear>();
        itemList.add(_headGear);
        _player.chooseItem(itemList);
        assertEquals(_player.getTotalStats().getDefenseRating(), 15);
        assertEquals(_player.getTotalStats().getAttackRating(), 5);
        assertEquals(_player.getEquippedItems().size(), 1);
        assertEquals(_player.getEquippedItems().get(GearType.HEADGEAR).getEquippedItems().get(0), _headGear);
        assertEquals(itemList.size(), 0);

        itemList = TestingHelper.createTenSameTypeCorrectItems();
        while(itemList.size() > 0){
            _player.chooseItem(itemList);
        }
        assertEquals(_player.getEquippedItems().size(), 2);
        assertEquals(_player.getEquippedItems().get(GearType.FOOTWEAR).getEquippedItems().size(), 2);

    }

    /**
     * Tests the replace gear functionality
     */
    @Test
    public void test_Replace_Clothing(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_footWear);
        var newFootWear = TestingHelper.createFootwear(CorrectData.FootWearNames.get(3), new Stats(3,3));
        equippedGear.replaceGear(0, newFootWear);

        assertEquals(equippedGear.getEquippedItems().get(0), newFootWear);
    }

    /**
     * Tests the functionality of adding a new clothing. Tests whether the added object is the same.
     */
    @Test
    public void test_Add_Clothing(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_footWear);
        equippedGear.addGear(_footWear);
        assertEquals(equippedGear.getEquippedItems().size(), 2);
        for(var item : equippedGear.getEquippedItems()){
            assertEquals(item, _footWear);
        }
    }

    /**
     * Tests the availability of combining two different gear. Should be true as
     * there is no slot left for the footwear.
     */
    @Test
    public void test_Can_Combine_Clothing_True(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_footWear);
        equippedGear.addGear(_footWear);
        assertTrue(equippedGear.canCombine());
    }

    /**
     * Tests the availability of combining two different gear. Should be false as
     * there is still slot available for second footwear
     */
    @Test
    public void test_Can_Combine_Clothing_False(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_footWear);
        assertFalse(equippedGear.canCombine());
    }

    /**
     * Tests whether the exception is thrown if two different types of gear are combined
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Combine_Different_Gears(){
        var conflictingItems = TestingHelper.createConflictingItems();
        conflictingItems.get(0).combineGear(conflictingItems.get(1));
    }

    /**
     * Tests combining same type gear several times to get a final item with combined stats and adjectives
     */
    @Test
    public void test_Combine_Gears(){
        var footWears = TestingHelper.createTwoFootWears();

        var first = footWears.get(0);
        first.combineGear(footWears.get(1));
        assertEquals(first.getName(),"Vicious, Happy Sneakers" );
        assertEquals(first.getStats().getAttackRating(), 10);
        assertEquals(first.getStats().getDefenseRating(),10);

        var newFootWear = TestingHelper.createFootwear(CorrectData.FootWearNames.get(2), new Stats(5,5));
        first.combineGear(newFootWear);
        assertEquals(first.getName(),"Majestic, Vicious, Happy Sneakers" );
        assertEquals(first.getStats().getAttackRating(), 15);
        assertEquals(first.getStats().getDefenseRating(),15);
    }
}
