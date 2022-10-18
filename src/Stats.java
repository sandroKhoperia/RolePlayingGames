/**
 * Represents the attack and defense ratings. Implements the Comparable interface used to sort items based on attack
 * rate, then defense rate. Used in Gear and Character classes.
 */
public class Stats implements Comparable<Stats>{
    private int _attackRating;
    private int _defenseRating;

    /**
     * Constructor:
     * Creates Stats object with default values
     */
    public Stats(){}

    /**
     * Constructor:
     * Creates Stats object based on parameters
     * @param attackRating Sets attackRating parameter
     * @param defenseRating Sets defenseRating parameter
     */
    public Stats(int attackRating, int defenseRating){
        _attackRating = attackRating;
        _defenseRating = defenseRating;
    }

    /**
     * Getter:
     * @return Numerical value of attack rating
     */
    public int getAttackRating() {
        return _attackRating;
    }

    /**
     * Getter:
     * @return Numerical value of defense rating
     */
    public int getDefenseRating() {
        return _defenseRating;
    }

    /**
     * Setter:
     * @param attackRating sets the attackRating parameter
     */
    public void setAttackRating(int attackRating) {
        this._attackRating = attackRating;
    }

    /**
     * Setter:
     * @param defenseRating sets the defenseRating parameter
     */
    public void setDefenseRating(int defenseRating) {
        this._defenseRating = defenseRating;
    }


    /**
     * toString() override:
     * @return string representation of the object. Includes attack and defense rating numeric values.
     */
    @Override
    public String toString() {
        return String.format("Attack Rating:%s, Defense Rating: %s", _attackRating, _defenseRating);
    }

    /**
     * equals() override:
     * @param obj Object to compare
     * @return true if two stats are equal based on attack and defense ratings, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        var other = (Stats)obj;
        return this._attackRating == other.getAttackRating() && this._defenseRating == other.getDefenseRating();
    }

    /**
     * compareTo() override:
     * @param o the object to be compared.
     * @return -1 if attack stat of this object is greater than that of o. 1 if it is less. If both stats are equal
     * Same comparison applies to the defense rating.
     */
    @Override
    public int compareTo(Stats o) {
        if(this._attackRating > o.getAttackRating()){
            return -1;
        }
        else if(this._attackRating < o.getAttackRating()){
            return 1;
        }
        else{
            if(this._defenseRating > o.getDefenseRating()){
                return -1;
            }
            else {
                return 1;
            }
        }
    }
}
