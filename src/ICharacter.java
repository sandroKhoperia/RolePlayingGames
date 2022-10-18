import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides method signatures for the Character class.
 */
public interface ICharacter {

    /**
     * Getter:
     * @return base Stats of the character.
     */
    Stats getBaseStats();

    /**
     * Getter:
     * @return combines base stats with the stats of each equipped item and returns total Stats of the character.
     */
    Stats getTotalStats();

    /**
     * Getter:
     * @return Name of the character
     */
    String getName();

    /**
     * Getter:
     * @return Id of the character
     */
    String getId();

    /**
     * Getter:
     * @return Hashmap of equipped items by the character for each gear type.
     */
    HashMap<GearType, ICharacterEquippedGear> getEquippedItems();

    /**
     * Selects the item from the list and equips it.
     * 1. Chooses the item that the character has the available gear type slot for.
     * 2. If multiple slots are available. Chooses the item that has the most attack rating
     * 3. If several items have the maximum attack rating, chooses the item that has the most defense rating.
     * 4. If several items have the maximum defense rating, chooses the item randomly
     * The Character always tries to choose the best item possible.
     * @param items - Checks whether there are any items in the list. Throws exception if there are not any items.
     */
    void chooseItem(ArrayList<IGear> items);
}
