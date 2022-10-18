/**
 * The concrete implementation of the base class Gear. Overrides some functionality
 * Represents headgear that can be equipped by characters.
 */
public class Headgear  extends  Gear{
    /**
     * Constructor:
     * Creates Headgear object based on parameters
     * @param name Sets name parameter
     * @param stats Sets stats parameter
     */
    public Headgear(String name, Stats stats) {
        super(name, stats);
    }


    @Override
    protected void createAndSetGearAndStatTypes() {
        _gearType = GearType.HEADGEAR;
        _statType = StatType.DEFENSE_ONLY;
    }

    @Override
    protected void validateStats(Stats stats) {
        if(stats.getAttackRating() != 0)
            throw new IllegalArgumentException("Head gear cannot have any attack stat");
    }

}
