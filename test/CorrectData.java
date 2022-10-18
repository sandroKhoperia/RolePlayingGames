import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the data used for testing. Serves as a class with constant fields that can be accessed in the testing classes.
 */
public class CorrectData {
    public static ArrayList<String> CharacterNames = new ArrayList<>(Arrays.asList("Gladiator", "Alex", "Nick","Unnamed"));
    public static ArrayList<String> FootWearNames =
            new ArrayList<>(Arrays.asList("Happy Sneakers", "Vicious Hoverboard", "Majestic Boots", "Inexorable Sneakers")) ;
    public static ArrayList<String> HeadGearNames =
            new ArrayList<>(Arrays.asList("Basic Visor", "Unbreakable Helmet", "Lucky Hat", "Bad Hat")) ;
    public static ArrayList<String> HandGearNames =
            new ArrayList<>(Arrays.asList("Strong Gloves", "Visionary Shield", "HeartPiercing Sword", "Unstoppable Sword")) ;

    public static ArrayList<GearNoun> FootWearNouns =
            new ArrayList<>(Arrays.asList(GearNoun.HOVERBOARD, GearNoun.BOOTS, GearNoun.SNEAKERS));
    public static ArrayList<GearNoun> HeadGearNouns =
            new ArrayList<>(Arrays.asList(GearNoun.HAT, GearNoun.HELMET, GearNoun.VISOR));
    public static ArrayList<GearNoun> HandGearNouns =
            new ArrayList<>(Arrays.asList(GearNoun.GLOVES, GearNoun.SHIELD, GearNoun.SWORD));

    public static GearType FootWearType = GearType.FOOTWEAR;
    public static GearType HeadGearType = GearType.HEADGEAR;
    public static GearType HandGearType = GearType.HANDGEAR;

}
