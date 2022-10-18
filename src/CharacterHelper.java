import java.util.ArrayList;

/**
 * Represents the helper class for Character. Serves as a static library. Has functionality of determining what type of
 * gear character needs.
 */
public class CharacterHelper {
    /**
     * Determines what items a character has a slot available for.
     * @param character - Checks the equipped items of the character and determines what type of gear character still
     *                  needs to equip in order to be fully equipped(1 headgear, 2 hand gears, 2 foot wears)
     * @return the list of types of gear character still needs items to fill slots for.
     */
    public static ArrayList<GearType> getItemNeeds(ICharacter character){
        var result = new ArrayList<GearType>();
        var equippedItems = character.getEquippedItems();
        if(!equippedItems.containsKey(GearType.HEADGEAR))
            result.add(GearType.HEADGEAR);

        if(!equippedItems.containsKey(GearType.HANDGEAR))
            result.add(GearType.HANDGEAR);
        else{
            if(equippedItems.get(GearType.HANDGEAR).getNumberOfEquippedType() < 2){
                result.add(GearType.HANDGEAR);
            }
        }

        if(!equippedItems.containsKey(GearType.FOOTWEAR))
            result.add(GearType.FOOTWEAR);
        else{
            if(equippedItems.get(GearType.FOOTWEAR).getNumberOfEquippedType() < 2){
                result.add(GearType.FOOTWEAR);
            }
        }
        return result;
    }

}
