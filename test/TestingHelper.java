import java.util.ArrayList;

/**
 * Testing Helper class. Serves as a static library for reusing the functionality in the testing classes.
 */
public class TestingHelper {

    /**
     * Tries to create the incorrect Battle object with same characters.
     * @return throws exception
     */
    public static IBattle createIncorrectBattleWithSameCharacter(){
        var character = createCharacter(CorrectData.CharacterNames.get(0));
        return new Battle(character, character, createTenMatchingCorrectItems());
    }

    /**
     * Creates the Battle object with different characters and 10 same items
     * @return Battle Object
     */
    public static IBattle createCorrectBattleWithSameItems(){
        return new Battle(createCharacter(CorrectData.CharacterNames.get(0)), createCharacter(CorrectData.CharacterNames.get(1)), createTenSameItems());
    }

    /**
     * Tries to create the incorrect Battle object with more than 10 items.
     * @return throws exception
     */
    public static IBattle createIncorrectBattleWithTooManyItems(){
        return new Battle(createCharacter(CorrectData.CharacterNames.get(0)), createCharacter(CorrectData.CharacterNames.get(1)), createTooManyItems());
    }

    /**
     * Tries to create the incorrect Battle object with less than 10 items.
     * @return throws exception
     */
    public static IBattle createIncorrectBattleWithLessItems(){
        return new Battle(createCharacter(CorrectData.CharacterNames.get(0)), createCharacter(CorrectData.CharacterNames.get(1)), createTwoHelmets());
    }

    /**
     * Creates the Battle object with different characters and 10 items that will be evenly distributed among the players
     * @return Battle Object
     */
    public static IBattle createCorrectBattleWithEvenItems(){
        return new Battle(createCharacter(CorrectData.CharacterNames.get(0)), createCharacter(CorrectData.CharacterNames.get(1)), createTenMatchingCorrectItems());
    }

    /**
     * Creates the Battle object with different characters and 10 items that are only one gear type.
     * @return Battle Object
     */
    public static IBattle createCorrectBattleWithOneTypeItemOnly(){
        return new Battle(createCharacter(CorrectData.CharacterNames.get(0)), createCharacter(CorrectData.CharacterNames.get(1)), createTenSameTypeCorrectItems());
    }

    /**
     * Creates Character object based on Name provided.
     * @return Character object.
     */
    public static ICharacter createCharacter(String name){
        return new Character(name);
    }

    /**
     * Creates Character object based on Name and Stats provided.
     * @return Character object.
     */
    public static ICharacter createCharacterWithStats(String name, Stats stats){
        return new Character(name,stats);
    }

    /**
     * Creates Character object based on Name, Stats, and items provided.
     * @return Character object.
     */
    public static ICharacter createCharacterWithStatsAndItems(String name, Stats stats, ArrayList<IGear> items){
        return new Character(name,stats, items);
    }

    /**
     * Tries to create Character object with no items at all.
     * @return throws exception.
     */
    public static ICharacter createCharacterWithNullItems(){
        return new Character(CorrectData.CharacterNames.get(0),new Stats(0,0), createNullList());
    }

    /**
     * Tries to create Character object with no items at all.
     * @return throws exception.
     */
    public static ICharacter createCharacterWithEmptyItems(){
        return new Character(CorrectData.CharacterNames.get(0),new Stats(0,0), createEmptyList());
    }

    /**
     * Creates CharacterEquippedGear object based on gear provided.
     * @return CharacterEquippedGear object.
     */
    public static ICharacterEquippedGear createCharacterEquippedGear(IGear gear){
        return new CharacterEquippedGear(gear);
    }

    /**
     * Tries to create CharacterEquippedGear object with no items at all.
     * @return throws exception.
     */
    public static ICharacterEquippedGear createIncorrectCharacterEquippedGearWithEmptyList(){
        return new CharacterEquippedGear(createEmptyList());
    }

    /**
     * Tries to create CharacterEquippedGear object with conflicting gear types.
     * @return throws exception.
     */
    public static ICharacterEquippedGear createIncorrectCharacterEquippedGearWithConflictingTypes(){
        return new CharacterEquippedGear(createConflictingItems());
    }

    /**
     * Tries to create CharacterEquippedGear object with more items than slots.
     * @return throws exception.
     */
    public static ICharacterEquippedGear createIncorrectCharacterEquippedGearWithTwoHelmets(){
        return new CharacterEquippedGear(createTwoHelmets());
    }

    /**
     * Tries to create CharacterEquippedGear object with more items than slots.
     * @return throws exception.
     */
    public static ICharacterEquippedGear createIncorrectCharacterEquippedGearWithThreeFootWears(){
        return new CharacterEquippedGear(createThreeFootWears());
    }

    /**
     * Tries to create CharacterEquippedGear object with more items than slots.
     * @return throws exception.
     */
    public static ICharacterEquippedGear createIncorrectCharacterEquippedGearWithThreeHandGears(){
        return new CharacterEquippedGear(createThreeHandGears());
    }

    /**
     * Creates a list of conflicting type of gears
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createConflictingItems(){
        var result = new ArrayList<IGear>();
        result.add(createHandGear(CorrectData.HandGearNames.get(0), createStats(8,0)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        return result;
    }

    /**
     * Creates a list of two head gears
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createTwoHelmets(){
        var result = new ArrayList<IGear>();
        result.add(createHeadGear(CorrectData.HeadGearNames.get(1), createStats(0,4)));
        result.add(createHeadGear(CorrectData.HeadGearNames.get(3), createStats(0,10)));
        return result;
    }

    /**
     * Creates a list of two foot wears
     * @return ArrayList of Gear
     */

    public static ArrayList<IGear> createTwoFootWears(){
        var result = new ArrayList<IGear>();
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(5,5)));
        result.add(createFootwear(CorrectData.FootWearNames.get(1), createStats(5,5)));
        return result;
    }

    /**
     * Creates a list of three hand gears
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createThreeHandGears(){
        var result = new ArrayList<IGear>();
        result.add(createHandGear(CorrectData.HandGearNames.get(0), createStats(8,0)));
        result.add(createHandGear(CorrectData.HandGearNames.get(1), createStats(5,0)));
        result.add(createHandGear(CorrectData.HandGearNames.get(2), createStats(6,0)));
        return result;
    }

    /**
     * Creates a list of three foot wears
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createThreeFootWears(){
        var result = new ArrayList<IGear>();
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(1), createStats(3,6)));
        result.add(createFootwear(CorrectData.FootWearNames.get(2), createStats(5,5)));
        return result;
    }

    /**
     * Creates a list of ten evenly matched items that are used to fully equip two players
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createTenMatchingCorrectItems(){
        var result = new ArrayList<IGear>();
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(1), createStats(3,6)));
        result.add(createFootwear(CorrectData.FootWearNames.get(2), createStats(5,5)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createHandGear(CorrectData.HandGearNames.get(0), createStats(8,0)));
        result.add(createHandGear(CorrectData.HandGearNames.get(1), createStats(5,0)));
        result.add(createHandGear(CorrectData.HandGearNames.get(2), createStats(6,0)));
        result.add(createHandGear(CorrectData.HandGearNames.get(3), createStats(12,0)));
        result.add(createHeadGear(CorrectData.HeadGearNames.get(1), createStats(0,4)));
        result.add(createHeadGear(CorrectData.HeadGearNames.get(3), createStats(0,10)));
        return result;
    }

    /**
     * Creates a list of ten same stat items
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createTenSameItems(){
        var result = new ArrayList<IGear>();
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        return result;
    }

    /**
     * Creates a list of ten items of the same gear type
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createTenSameTypeCorrectItems(){
        var result = new ArrayList<IGear>();
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(1), createStats(3,6)));
        result.add(createFootwear(CorrectData.FootWearNames.get(2), createStats(5,5)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        return result;
    }

    /**
     * Creates a list of more than ten gears
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createTooManyItems(){
        var result = new ArrayList<IGear>();
        result.add(createFootwear(CorrectData.FootWearNames.get(0), createStats(2,3)));
        result.add(createFootwear(CorrectData.FootWearNames.get(1), createStats(3,6)));
        result.add(createFootwear(CorrectData.FootWearNames.get(2), createStats(5,5)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        result.add(createFootwear(CorrectData.FootWearNames.get(3), createStats(8,4)));
        return result;
    }

    /**
     * Creates an empty list
     * @return ArrayList of Gear
     */
    public static ArrayList<IGear> createEmptyList(){
       return new ArrayList<>();
    }

    /**
     * @return null
     */
    public static ArrayList<IGear> createNullList(){
        return null;
    }

    /**
     * Creates stats based on attack and defense stats provided
     * @return Stats object
     */
    public static Stats createStats(int attack, int defense){
        return new Stats(attack, defense);
    }

    /**
     * Creates a footwear based on name and stats provided
     * @return FootWear object
     */
    public static Footwear createFootwear(String name, Stats stats){
        return new Footwear(name, stats);
    }

    /**
     * Tries to create a footwear with only adjective
     * @return throws exception
     */
    public static Footwear createIncorrectFootWearWithOnlyAdjective(){
        return new Footwear("Bad", new Stats(0, 0));
    }

    /**
     * Tries to create a footwear with only noun
     * @return throws exception
     */
    public static Footwear createIncorrectFootWearWithOnlyNoun(){
        return new Footwear("Sneakers", new Stats(0, 0));
    }

    /**
     * Tries to create a footwear with incorrect noun
     * @return throws exception
     */
    public static Footwear createIncorrectFootWearWithIncorrectNoun(){
        return new Footwear("Incorrect Visor", new Stats(0, 0));
    }

    /**
     * Creates a headgear with name and stats
     * @return HeadGear object
     */
    public static Headgear createHeadGear(String name, Stats stats){
        return new Headgear(name, stats);
    }

    /**
     * Tries to create a footwear with only adjective
     * @return throws exception
     */
    public static Footwear createIncorrectHeadGearWithOnlyAdjective(){
        return new Footwear("Bad", new Stats(0, 0));
    }

    /**
     * Tries to create a headgear with incorrect noun
     * @return throws exception
     */
    public static Headgear createIncorrectHeadGearWithIncorrectNoun(){
        return new Headgear("Incorrect Sneakers", new Stats(0, 0));
    }

    /**
     * Tries to create a headgear with incorrect stat
     * @return throws exception
     */
    public static Headgear createIncorrectHeadGearWithAttackStat(){
        return new Headgear("Incorrect Visor", new Stats(1, 0));
    }

    /**
     * Creates HandGear object based on name and stats provided
     * @return HandGear object
     */
    public static Handgear createHandGear(String name, Stats stats){
        return new Handgear(name, stats);
    }

    /**
     * Tries to create a handgear with only adjective
     * @return throws exception
     */
    public static Handgear createIncorrectHandGearWithOnlyAdjective(){
        return new Handgear("Bad", new Stats(0, 0));
    }

}
