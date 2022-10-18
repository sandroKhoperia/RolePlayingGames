/**
 * Provides method signatures for the Gear class
 */
public interface IGear {
    /**
     * Combines two same type gear into a single one. The resulting gear has the
     * adjective and stats added to its original stats and name.
     * @param clothing - Checks whether this clothing can be combined into the original gear. Throws exception if not.
     */
    void combineGear(IGear clothing);

    /**
     * Getter:
     * @return Stats of the gear
     */
    Stats getStats();

    /**
     * Getter:
     * @return Name of the gear
     */
    String getName();

    /**
     * Getter:
     * @return Unique Identifier of the gear
     */
    String getId();

    /**
     * Getter:
     * @return Stat type of the gear
     */
    StatType getStatType();

    /**
     * Setter:
     * @param stats sets the stats of the gear based on the input parameter.
     */
    void setStats(Stats stats);

    /**
     * Setter:
     * @param name sets the name of the gear based on the input parameter.
     */
    void setName(String name);

    /**
     * Getter:
     * @return Gear type of the gear
     */
    GearType getGearType();

    /**
     * Getter:
     * @return Gear noun of the gear.
     */
    GearNoun getGearNoun();
}
