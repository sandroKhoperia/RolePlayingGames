import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

/**
 * Represents the abstract class for Gear. Implements IGear and IGearValidator. Is parent to three subclasses:
 * Footwear, Handgear and Headgear
 */
public abstract class Gear implements IGear, IGearValidator  {

    protected  String _id;
    protected String _name;
    protected Stats _stats;

    protected GearNoun _gearClassification;
    protected GearType _gearType;

    protected StatType _statType;

    protected HashMap<GearType, ArrayList<GearNoun>> _gearNounMapping;

    /**
     * Constructor:
     * Creates Headgear object based on parameters. Initializes gearClassification mapping, gear and stat types and
     * performs name and stat validations for the object
     * @param name Sets name parameter
     * @param stats Sets stats parameter
     */
    public Gear(String name, Stats stats){
        initializeMapping();
        createAndSetGearAndStatTypes();
        validate(name, stats);

        _name = name;
        _stats = stats;
        _id = UUID.randomUUID().toString();


    }

    @Override
    public void validate(String name, Stats stats){
        validateStats(stats);
        var split = name.split(" ");
        var length = split.length;

        if(length < 2)
            throw new IllegalArgumentException("Item name cannot contain only nour or only adjective");

        var classifications = _gearNounMapping.get(_gearType);
        var itemName = split[length - 1].toLowerCase();
        for(var gearClass : classifications){
            if(itemName.equals(gearClass.name().toLowerCase())){
                return;
            }
        }

        throw new IllegalArgumentException("Invalid name provided for the clothing");
    }

    @Override
    public StatType getStatType() {
        return _statType;
    }

    @Override
    public String getName(){
        return _name;
    }

    /**
     * Provides method signature for subclasses to implement. sets the gear and stat types for the object.
     * e.g. Footwear object has the gear type of FOOTWEAR and stat type of Both attack and defense.
     * Is implemented in all subclasses.
     */
    protected abstract void createAndSetGearAndStatTypes();

    /**
     * Performs the validation of the stats provided while creating the Gear object. Is overridden several subclasses
     * @param stats - Checks whether the provided stat reflects the actual stat parameters.
     *              e.g. headgear can only have defense stat, footwear does not need stat validation, handgear has only
     *              attack stat.
     */
    protected void validateStats(Stats stats){}

    @Override
    public String getId(){
        return _id;
    }
    @Override
    public GearNoun getGearNoun() {
        return _gearClassification;
    }

    @Override
    public GearType getGearType(){
        return _gearType;
    }

    @Override
    public Stats getStats() {
        return _stats;
    }

    @Override
    public void setName(String name){
        _name = name;
    }

    @Override
    public void setStats(Stats stats) {
        _stats = stats;
    }

    @Override
    public void combineGear(IGear clothing){
        if(this._gearType != clothing.getGearType())
            throw new IllegalArgumentException("Cannot combine different types of gear");

        var stats = clothing.getStats();
        var name = clothing.getName().split(" ")[0];
        name = name.replaceAll(",","");

        this.setName(name+", "+_name);
        this._stats.setDefenseRating(_stats.getDefenseRating()  + stats.getDefenseRating());
        this._stats.setAttackRating(_stats.getAttackRating() + stats.getAttackRating());

    }

    /**
     * toString Override:
     * @return string representation of the gear object.
     */
    @Override
    public String toString() {
        return String.format("Name:%s, Clothing Type:%s, %s",_name, _gearType.toString().toLowerCase(), _stats.toString());
    }

    /**
     * equals Override:
     * @param obj - Checks whether the input parameter is the same as this gear based on name, gear type
     *            and gear noun
     * @return True if they are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return  false;

        var other = (IGear)obj;
        return _id.equals(other.getId()) && _name.equals(other.getName()) && _gearType == other.getGearType()
                && _gearClassification == other.getGearNoun();
    }


    /**
     * Creates and sets the mappings between gear type and specific nouns of gear. Used for name validation
     */
    private void initializeMapping(){
        _gearNounMapping = new HashMap<>();
        _gearNounMapping.put(GearType.FOOTWEAR, new ArrayList<>(Arrays.asList(
                GearNoun.BOOTS, GearNoun.HOVERBOARD, GearNoun.SNEAKERS)));
        _gearNounMapping.put(GearType.HANDGEAR, new ArrayList<>(Arrays.asList(
                GearNoun.GLOVES, GearNoun.SHIELD, GearNoun.SWORD)));
        _gearNounMapping.put(GearType.HEADGEAR, new ArrayList<>(Arrays.asList(
                GearNoun.VISOR, GearNoun.HELMET, GearNoun.HAT)));


    }
}
