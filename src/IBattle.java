import java.util.ArrayList;

/**
 * Provides method signatures for Battle class
 */
public interface IBattle {
    /**
     * Getter:
     * @return Characters participating in the battle
     */
    ICharacter[] getPlayers();

    /**
     * Getter:
     * @return List of gear that characters can equip.
     */
    ArrayList<IGear> getAvailableGear();

    /**
     * Starts the battle. Players take turns dressing themselves from the available items. Afterwards total stats
     * are compared and the player with the most damage dealt wins the battle.
     */
    void initiateBattle();

    /**
     * Getter:
     * @return the winner of the battle. If the result is tie, both players are returned as a List
     */
    ArrayList<ICharacter> getWinner();
}
