import java.util.*;

/**
 * Represents the Player. Implements ICharacter allowing player to choose the best available gear from the item options
 * Follows the rules of choosing the item.
 */
public class Character implements ICharacter{
    private final String _id;

    private final String _name;
    private final Stats _baseStats;

    private final HashMap<GearType, ICharacterEquippedGear> _equippedItems;

    public Character(String name){
        _id = UUID.randomUUID().toString();
        _baseStats = new Stats();
        _equippedItems = new HashMap<>();
        _name = name;
    }

    public Character(String name, Stats baseStats){
        _id = UUID.randomUUID().toString();
        _baseStats = baseStats;
        _equippedItems = new HashMap<>();
        _name = name;
    }

    public Character(String name, Stats baseStats, ArrayList<IGear> items){
        if(items == null || items.size() == 0)
            throw new IllegalArgumentException("Cannot equip nonexistent item");

        _id = UUID.randomUUID().toString();
        _equippedItems = new HashMap<>();
        _baseStats = baseStats;
        _name = name;

        for(var item: items){
            if(item == null)
                throw new IllegalArgumentException("Cannot equip nonexistent item");
            equipItem(item);
        }



    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public HashMap<GearType, ICharacterEquippedGear> getEquippedItems() {
        return _equippedItems;
    }

    @Override
    public Stats getBaseStats(){
        return _baseStats;
    }
    @Override
    public Stats getTotalStats(){
        var attackStat = _baseStats.getAttackRating();
        var defenseStat = _baseStats.getDefenseRating();
        for (var key: _equippedItems.keySet()){
            for(var item: _equippedItems.get(key).getEquippedItems()){
                var itemStats = item.getStats();
                attackStat += itemStats.getAttackRating();
                defenseStat += itemStats.getDefenseRating();
            }

        }
        return new Stats(attackStat,defenseStat);
    }


    @Override
    public void chooseItem(ArrayList<IGear> items){
        if(items == null || items.size() == 0){
            throw new IllegalArgumentException("Cannot equip nonexistent item");
        }

        if(items.size() == 1){
            equipItem(items.get(0));
            items.remove(items.get(0));
            return;
        }
        var itemNeeds = CharacterHelper.getItemNeeds(this);
        var neededItems = items.stream()
                .filter(x -> itemNeeds.size() == 0 || itemNeeds.stream().anyMatch(y -> y == x.getGearType()))
                .sorted(Comparator.comparing(IGear::getStats)).toList();

        ArrayList<IGear> sortedItems;
        if(neededItems.size() == 0){
             items.sort(Comparator.comparing(IGear::getStats));
            sortedItems = new ArrayList<>(items);
        }
        else{
            sortedItems = new ArrayList<>( neededItems);
        }

        var possibleItem = sortedItems.get(0);
        var possibleItems = sortedItems.stream()
                .filter(x -> x.getStats().equals(possibleItem.getStats())).toList();
        if(possibleItems.size() > 1){
            var idx = generateRandomIndex(possibleItems.size());
            var item = possibleItems.get(idx);
            equipItem(item);
            items.remove(item);
        }
        else{
            equipItem(possibleItem);
            items.remove(possibleItem);
        }
    }

    /**
     * equals override;
     * @param obj compares this object with obj based on name, id, base stats and equipped items size.
     * @return true if two objects are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        var other = (ICharacter)obj;
        return _name.equals(other.getName()) && _id.equals(other.getId()) && _baseStats.equals(other.getBaseStats())
                && _equippedItems.keySet().size() == other.getEquippedItems().keySet().size();
    }

    /**
     * toString override.
     * @return string representation of the Character object with all equipped gear.
     */
    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var key: _equippedItems.keySet()){
            for (var item: _equippedItems.get(key).getEquippedItems()){
                sb.append(key).append("\n   ");
                sb.append(item.toString());
                sb.append("\n");
            }
        }
        return String.format("Name:%s\nBase Stats: %s\nEquipped Items:\n%s",_name, _baseStats,sb);
    }

    /**
     * @param item Equips the selected item.
     * If the item can be combined with other items, combines the selected item with the equipped item with the
     *             longest name.
     */
    private void equipItem(IGear item){
        var key  = item.getGearType();
        if(!_equippedItems.containsKey(key)){
            _equippedItems.put(key, new CharacterEquippedGear(item));
        }
        else{
            var equippedGear = this.getEquippedItems().get(key);
            if(equippedGear.canCombine()){
                var equippedItems = equippedGear.getEquippedItems();
                if(key == GearType.HEADGEAR){
                    var firstItem = equippedItems.get(0);
                    firstItem.combineGear(item);
                    equippedGear.replaceGear(0,firstItem);
                }
                else{
                    var index = equippedItems.get(0).getName().length() >= equippedItems.get(1).getName().length()? 0 :1;
                    var firstItem = equippedItems.get(index);
                    firstItem.combineGear(item);
                    equippedGear.replaceGear(index,firstItem);
                }

            }
            else{
                _equippedItems.get(key).addGear(item);
            }
        }
    }

    /**
     *
     * @param size Generates random integer from 0 to size exclusive
     * @return generated integer. Used for choosing a random item from the list.
     */
    private static int generateRandomIndex(int size){
        Random rand = new Random(5);
        return rand.nextInt(0, size);
    }

}
