/**
 * The concrete implementation of the base class Gear. Overrides some functionality
 * Represents hand gear that can be equipped by characters.
 */
public class Handgear extends Gear {
    public Handgear(String name, Stats stats) {
        super(name, stats);
    }

    @Override
    protected void createAndSetGearAndStatTypes() {
        _gearType = GearType.HANDGEAR;
        _statType = StatType.ATTACK_ONLY;
    }

    @Override
    protected void validateStats(Stats stats) {
        if(stats.getDefenseRating() != 0)
            throw new IllegalArgumentException("Hand gear cannot have any defense stat");
    }
}
