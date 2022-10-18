import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing how the models are created. Models with incorrect input parameters should throw exception
 * Models with correct parameters should have all properties set correctly.
 */
public class TestModels {
    private Footwear _footWear;
    private Handgear _handGear;
    private Headgear _headGear;

    /**
     * Creates objects that are used for testing the functionality of the classes
     */
    @Before
    public void setUp(){
        _footWear = TestingHelper.createFootwear(CorrectData.FootWearNames.get(0), new Stats(10,10));
        _handGear = TestingHelper.createHandGear(CorrectData.HandGearNames.get(0), new Stats(10,0));
        _headGear = TestingHelper.createHeadGear(CorrectData.HeadGearNames.get(0), new Stats(0,10));
    }

    /**
     * Tests whether the battle can be created using the same player
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Battle_With_Same_Characters(){
        TestingHelper.createIncorrectBattleWithSameCharacter();
    }

    /**
     * Tests whether the battle can be created with more than 10 items
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Battle_With_Too_Many_Items(){
        TestingHelper.createIncorrectBattleWithTooManyItems();
    }

    /**
     * Tests whether the battle can be created with less than 10 items
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Battle_With_Less_Items(){
        TestingHelper.createIncorrectBattleWithLessItems();
    }

    /**
     * Tests whether the headgear can be created with incorrect noun. e.g. Gloves.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_HeadGear_With_Incorrect_Noun(){
        TestingHelper.createIncorrectHeadGearWithIncorrectNoun();
    }

    /**
     * Tests whether the headgear can be created with attack stat.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_HeadGear_With_Attack_Stat(){
        TestingHelper.createIncorrectHeadGearWithAttackStat();
    }

    /**
     * Tests whether the headgear can be created with only noun. e.g. Helmet.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_HeadGear_With_Only_Noun(){
        TestingHelper.createIncorrectHeadGearWithOnlyAdjective();
    }

    /**
     * Tests whether the headgear can be created with only adjective. e.g. Bad.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_HeadGear_With_Only_Adjective(){
        TestingHelper.createIncorrectHeadGearWithOnlyAdjective();
    }

    /**
     * Tests whether the handgear can be created with incorrect noun. e.g. helmet.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_HandGear_With_Incorrect_Noun(){
        TestingHelper.createIncorrectFootWearWithIncorrectNoun();
    }

    /**
     * Tests whether the handgear can be created with only noun. e.g. Gloves.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_HandGear_With_Only_Noun(){
        TestingHelper.createIncorrectFootWearWithOnlyNoun();
    }

    /**
     * Tests whether the handgear can be created with only adjective. e.g. Bad.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_HandGear_With_Only_Adjective(){
        TestingHelper.createIncorrectHandGearWithOnlyAdjective();
    }

    /**
     * Tests whether the footwear can be created with incorrect noun. e.g. helmet.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_FootWear_With_Incorrect_Noun(){
        TestingHelper.createIncorrectFootWearWithIncorrectNoun();
    }

    /**
     * Tests whether the footwear can be created with only noun. e.g. Hoverboard.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_FootWear_With_Only_Noun(){
        TestingHelper.createIncorrectFootWearWithOnlyNoun();
    }

    /**
     * Tests whether the footwear can be created with only adjective. e.g. Bad.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_FootWear_With_Only_Adjective(){
        TestingHelper.createIncorrectFootWearWithOnlyAdjective();
    }

    /**
     * Tests whether the footwear can be created with badly formatted name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_FootWear_With_Incorrect_Name_Format(){
        new Footwear("too long name", new Stats());
    }


    /**
     * Tests whether the CharacterEquippedGear can be created with empty items when using constructor with items.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_Equipped_Gear_With_Empty_Items(){
        TestingHelper.createIncorrectCharacterEquippedGearWithEmptyList();
    }

    /**
     * Tests whether the CharacterEquippedGear can be created with no items at all when using constructor with items.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_Equipped_Gear_With_Null_Items(){
        ArrayList<IGear> items = null;
        new CharacterEquippedGear(items);
    }

    /**
     * Tests whether the CharacterEquippedGear can be created with conflicting type items. e.g. helmet and gloves
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_Equipped_Gear_With_Conflicting_Types(){
        TestingHelper.createIncorrectCharacterEquippedGearWithConflictingTypes();
    }

    /**
     * Tests whether the CharacterEquippedGear can be created with more items than it has slots
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_Equipped_Gear_With_Three_FootWear(){
        TestingHelper.createIncorrectCharacterEquippedGearWithThreeFootWears();
    }

    /**
     * Tests whether the CharacterEquippedGear can be created with more items than it has slots
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_Equipped_Gear_With_Three_HandGear(){
        TestingHelper.createIncorrectCharacterEquippedGearWithThreeHandGears();
    }

    /**
     * Tests whether the CharacterEquippedGear can be created with more items than it has slots
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_Equipped_Gear_With_Two_HeadGear(){
        TestingHelper.createIncorrectCharacterEquippedGearWithTwoHelmets();
    }

    /**
     * Tests whether the Character can be created with no items at all when using constructor with items.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_With_Empty_Items(){
        TestingHelper.createCharacterWithEmptyItems();
    }

    /**
     * Tests whether the Character can be created with no items at all when using constructor with items.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Character_With_Null_Items(){
        TestingHelper.createCharacterWithNullItems();
    }

    /**
     * Tests the correct creation of character with no additional parameters.
     * Ensures that all parameters are created/set correctly.
     */
    @Test
    public void test_Correct_Character_With_Nothing(){
        var ch = TestingHelper.createCharacter(CorrectData.CharacterNames.get(0));
        assertEquals(ch.getName(), CorrectData.CharacterNames.get(0));
        assertEquals(ch.getBaseStats().getAttackRating(), 0);
        assertEquals(ch.getBaseStats().getDefenseRating(), 0);
        assertEquals(ch.getTotalStats().getAttackRating(), 0);
        assertEquals(ch.getTotalStats().getDefenseRating(), 0);
        assertEquals(ch.getEquippedItems().size(), 0);
    }

    /**
     * Tests the correct creation of character with base stats. Ensures that all parameters are created/set correctly.
     */
    @Test
    public void test_Correct_Character_With_Base_Stats(){
        var stats = TestingHelper.createStats(5,5);
        var ch = TestingHelper.createCharacterWithStats(CorrectData.CharacterNames.get(0),stats);
        assertEquals(ch.getName(), CorrectData.CharacterNames.get(0));
        assertEquals(ch.getBaseStats().getAttackRating(), 5);
        assertEquals(ch.getBaseStats().getDefenseRating(), 5);
        assertEquals(ch.getTotalStats().getAttackRating(), 5);
        assertEquals(ch.getTotalStats().getDefenseRating(), 5);
        assertEquals(ch.getEquippedItems().size(), 0);
    }

    /**
     * Tests the correct creation of character with base stats and items.
     */
    @Test
    public void test_Correct_Character_With_Base_Stats_And_Two_FootWear(){
        var stats = TestingHelper.createStats(5,5);
        var items = TestingHelper.createTwoFootWears();
        var ch = TestingHelper.createCharacterWithStatsAndItems(CorrectData.CharacterNames.get(0),stats,items);
        assertEquals(ch.getName(), CorrectData.CharacterNames.get(0));
        assertEquals(ch.getBaseStats().getAttackRating(), 5);
        assertEquals(ch.getBaseStats().getDefenseRating(), 5);
        assertEquals(ch.getTotalStats().getAttackRating(), 15);
        assertEquals(ch.getTotalStats().getDefenseRating(), 15);
        var equippedItems = ch.getEquippedItems();
        assertEquals(equippedItems.size(), 1);
        for (var key: equippedItems.keySet()){
            assertEquals(key, GearType.FOOTWEAR);
            var equipped = equippedItems.get(key);
            assertEquals(2, equipped.getNumberOfEquippedType());
            var gears = equipped.getEquippedItems();
            for (int i = 0; i< gears.size(); ++i){
                assertEquals(items.get(i), gears.get(i));
            }
        }
    }

    /**
     * Tests that CharacterEquippedGear is created correctly and all parameters are created/set correctly.
     */
    @Test
    public void test_Correct_Character_Equipped_Gear_With_HeadGear(){
        var equippedGear = TestingHelper.createCharacterEquippedGear(_headGear);

        assertEquals(equippedGear.getNumberOfEquippedType(), 1);
        var item = equippedGear.getEquippedItems();
        assertEquals(item.get(0).getName(), _headGear.getName());
        assertEquals(item.get(0).getGearType(), _headGear.getGearType());
        assertEquals(item.get(0).getGearNoun(), _headGear.getGearNoun());
        assertEquals(item.get(0).getClass(), _headGear.getClass());
        assertEquals(item.get(0).getStats().getAttackRating(), _headGear.getStats().getAttackRating());
        assertEquals(item.get(0).getStats().getDefenseRating(), _headGear.getStats().getDefenseRating());
    }

    /**
     * Tests the correct creation of GearWithStatType. Checks that all parameters are created/set correctly
     */
    @Test
    public void test_Gear_With_Stat_Type(){
        assertEquals(_footWear.getStatType(), StatType.BOTH);
        assertEquals(_handGear.getStatType(), StatType.ATTACK_ONLY);
        assertEquals(_headGear.getStatType(), StatType.DEFENSE_ONLY);
    }

    /**
     * Tests the correct creation of FootWear. Checks that all parameters are created/set correctly
     */
    @Test
    public void test_Correct_FootWear(){
        var ftWear = TestingHelper.createFootwear(CorrectData.FootWearNames.get(0), new Stats(10,10));
        assertEquals(ftWear.getName(), _footWear.getName());
        assertEquals(ftWear.getGearType(), _footWear.getGearType());
        assertEquals(ftWear.getGearNoun(), _footWear.getGearNoun());
        assertEquals(ftWear.getClass(), _footWear.getClass());
        assertEquals(ftWear.getStats().getAttackRating(), _footWear.getStats().getAttackRating());
        assertEquals(ftWear.getStats().getDefenseRating(), _footWear.getStats().getDefenseRating());
    }

    /**
     * Tests the correct creation of HeadGear. Checks that all parameters are created/set correctly
     */
    @Test
    public void test_Correct_HeadGear(){
        var hdGear = TestingHelper.createHeadGear(CorrectData.HeadGearNames.get(0), new Stats(0,10));
        assertEquals(hdGear.getName(), _headGear.getName());
        assertEquals(hdGear.getGearType(), _headGear.getGearType());
        assertEquals(hdGear.getGearNoun(), _headGear.getGearNoun());
        assertEquals(hdGear.getClass(), _headGear.getClass());
        assertEquals(hdGear.getStats().getAttackRating(), _headGear.getStats().getAttackRating());
        assertEquals(hdGear.getStats().getDefenseRating(), _headGear.getStats().getDefenseRating());
    }

    /**
     * Tests the correct creation of HandGear. Checks that all parameters are created/set correctly
     */
    @Test
    public void test_Correct_HandGear(){
        var hndGear = TestingHelper.createHandGear(CorrectData.HandGearNames.get(0), new Stats(10,0));
        assertEquals(hndGear.getName(), _handGear.getName());
        assertEquals(hndGear.getGearType(), _handGear.getGearType());
        assertEquals(hndGear.getGearNoun(), _handGear.getGearNoun());
        assertEquals(hndGear.getClass(), _handGear.getClass());
        assertEquals(hndGear.getStats().getAttackRating(), _handGear.getStats().getAttackRating());
        assertEquals(hndGear.getStats().getDefenseRating(), _handGear.getStats().getDefenseRating());
    }

}
