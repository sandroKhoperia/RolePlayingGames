import java.util.ArrayList;
/**
 * Provides method signatures for the CharacterEquippedGear class.
 */
public interface ICharacterEquippedGear {
    /**
     * Getter:
     * @return List of equipped items for a single gear type slot that the character has.
     */
    ArrayList<IGear> getEquippedItems();

    /**
     * Getter:
     * @return the number of items equipped for this gear type slot.
     */
    int getNumberOfEquippedType();

    /**
     * Checks whether the combination of gear can be combined. Checks whether there are any available slots left for
     * this type of gear.
     * @return true if gear can be combined, false otherwise.
     */
    boolean canCombine();

    /**
     * Replaces the gear at specified index.
     * @param index - Checks whether there exists the index requested. Throws exception if not.
     * @param clothing - Checks whether there are any conflicting type of gear. Throws exception if there are.
     */
    void replaceGear(int index, IGear clothing);

    /**
     * Add a new gear into the equipped gear list
     * @param item - Checks whether there are slots left and the gear types match. Throws exception if no more slots
     *             are left or there is a gear type miss match.
     */
    void addGear(IGear item);
}
