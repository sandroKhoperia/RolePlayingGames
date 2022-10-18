import java.util.ArrayList;
/**
 * Represents the gear character has equipped. Implements ICharacterEquippedGear and provides functionality of
 * determining whether the particular gear can be combined with one of the items in the equipped gear, replacing the old
 * gear with combined one, and adding a new gear to the equipped gear list.
 */
public class CharacterEquippedGear implements ICharacterEquippedGear{
    private final ArrayList<IGear> _gears;
    private int _numberOfEquippedType;

    /**
     * Constructor:
     * Creates CharacterEquippedGear object based on the item equipped.
     * @param item Adds the equipped item into the list.
     */
    public CharacterEquippedGear(IGear item){
        _gears = new ArrayList<>();
        _gears.add(item);
        _numberOfEquippedType = 1;
    }

    /**
     * Constructor:
     * Creates CharacterEquippedGear object based on the item equipped.
     * @param items Performs the validation of provided items and sets the parameters.
     */
    public CharacterEquippedGear(ArrayList<IGear> items){
        validate(items);
        _gears = items;
        _numberOfEquippedType = items.size();
    }
    @Override
    public ArrayList<IGear> getEquippedItems(){
        return _gears;
    }

    @Override
    public int getNumberOfEquippedType(){
        return _numberOfEquippedType;
    }

    @Override
    public boolean canCombine(){
        if(_gears.size() == 0)
            return false;

        var gearType = _gears.get(0).getGearType();

        if (gearType == GearType.HEADGEAR) {
            return _numberOfEquippedType == 1;
        }
        return _numberOfEquippedType == 2;
    }

    @Override
    public void replaceGear(int index, IGear item){
        if(_gears.get(0).getGearType() != item.getGearType()){
            throw new IllegalArgumentException("Cannot replace a conflicting type");
        }
        _gears.set(index, item);
    }

    @Override
    public void addGear(IGear item){
        if(_numberOfEquippedType >= 2)
            throw new IllegalStateException("Slot limit has been reached.");

        else if(_numberOfEquippedType == 0){
            _gears.add(item);
            _numberOfEquippedType++;
        }
        else{
            var type = _gears.get(0).getGearType();
            if(item.getGearType() != type){
                throw new IllegalStateException("Clothing type miss match detected");
            }

            if(type == GearType.HEADGEAR){
                throw new IllegalStateException("Slot limit has been reached.");
            }
            _gears.add(item);
            _numberOfEquippedType++;
        }
    }

    /**
     * Performs the validation of provided items.
     * @param items - Checks whether the items list is not empty, does not contain more items than the character has
     *              available slots for, and potential miss matches between the types of items provided and the already
     *              stored values. Throws exception if any of those cases apply.
     */
    private void validate(ArrayList<IGear> items){
        if(items == null || items.size() == 0)
            throw new IllegalArgumentException("No items provided");

        if(items.size() > 2)
            throw new IllegalArgumentException("Equipment slot limit has been reached");

        var type = items.get(0).getGearType();

        if(type == GearType.HEADGEAR && items.size() > 1){
            throw  new IllegalArgumentException("Equipment slot limit has been reached");
        }

        for (var item : items){
            if(item.getGearType() != type){
                throw new IllegalArgumentException("Clothing type miss match detected");
            }
        }

    }

}
