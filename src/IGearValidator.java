/**
 * Provides method signature for validating Gear.
 */
public interface IGearValidator {

    /**
     * Performs gear name and stats validation.
     * @param name - Checks whether the provided name is correct for the gear. e.g. Helmet cannot be noun for the footwear
     * @param stats - Checks whether the provided stats are correct for the gear. e.g. HeadGear cannot have attack stat
     */
    void validate(String name,Stats stats);
}
