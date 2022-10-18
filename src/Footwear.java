/**
 * The concrete implementation of the base class Gear. Overrides some functionality
 * Represents footwear that can be equipped by characters.
 */
public class Footwear extends Gear{
    public Footwear(String name, Stats stats) {
        super(name, stats);
    }

    @Override
    protected void createAndSetGearAndStatTypes() {
        _gearType = GearType.FOOTWEAR;
        _statType = StatType.BOTH;
    }


}
