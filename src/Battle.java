import java.util.ArrayList;
import java.util.Random;
/**
 * Represents the Battle simulation between two players. Implements IBattle interface and provides functionality to
 * determine which player should start equipping items first and afterwards allows players to take turns dressing
 * themselves until the all items are equipped. Also, determines and stores the winner(s).
 */
public class Battle implements IBattle{
    private final ICharacter _playerOne;

    private final ICharacter _playerTwo;
    private final ArrayList<IGear> _items;

    private final ArrayList<ICharacter> _winner;

    /**
     * Constructor:
     * Creates Battle object based on two players and a list of items characters may equip
     * @param player1 Sets the player1 object
     * @param player2 Sets the player1 object
     * @param items Sets the list of items
     */
    public Battle(ICharacter player1, ICharacter player2, ArrayList<IGear> items){
        if(items.size() != 10)
            throw new IllegalArgumentException("Total items count should be 10");

        if(player1.equals(player2)){
            throw new IllegalArgumentException("Player cannot fight with self");
        }

        _playerOne = player1;
        _playerTwo = player2;
        _items = items;
        _winner = new ArrayList<>();
    }

    @Override
    public ArrayList<ICharacter> getWinner() {
        return _winner;
    }

    @Override
    public ICharacter[] getPlayers() {
        return new ICharacter[] {_playerOne, _playerTwo};
    }

    @Override
    public ArrayList<IGear> getAvailableGear() {
        return _items;
    }


    public void initiateBattle(){
        var firstStarts = randomDrawPlayer();
        System.out.println("Players before battle:");
        System.out.printf("Player 1:%s%n", _playerOne.toString());
        System.out.printf("Player 2:%s%n", _playerTwo.toString());
        int turnNumber = 1;
        while(_items.size() > 0){
            System.out.printf("Turn %s:",turnNumber++);
            if(firstStarts){
                System.out.println("Player 1 is equipping...");
                _playerOne.chooseItem(_items);
            }
            else{
                System.out.println("Player 2 is equipping...");
                _playerTwo.chooseItem(_items);
            }
            firstStarts = !firstStarts;

            System.out.printf("Player 1:%s%n", _playerOne);
            System.out.printf("Player 2:%s%n", _playerTwo);
        }
        System.out.println("All Items Have Been Equipped. The Battle Begins Now!");

        var playerOneTotalStats = _playerOne.getTotalStats();
        var playerTwoTotalStats = _playerTwo.getTotalStats();

        System.out.printf("Player 1 Total Stats: Attack:%s, Defense:%s%n",
                playerOneTotalStats.getAttackRating(), playerOneTotalStats.getDefenseRating());
        System.out.printf("Player 2 Total Stats: Attack:%s, Defense:%s%n",
                playerTwoTotalStats.getAttackRating(), playerTwoTotalStats.getDefenseRating());
        System.out.println();
        var playerOneDamageDone = playerOneTotalStats.getAttackRating() - playerTwoTotalStats.getDefenseRating();
        var playerOneDamageReceived = playerTwoTotalStats.getAttackRating() - playerOneTotalStats.getDefenseRating();
        System.out.printf("Player 1 dealt %s damage,Player 2 dealt %s damage%n",playerOneDamageDone,playerOneDamageReceived);
        if(playerOneDamageDone > playerOneDamageReceived){
            _winner.add(_playerOne);
            System.out.println("Player 1 won");
        }
        else if( playerOneDamageDone < playerOneDamageReceived){
            _winner.add(_playerTwo);
            System.out.println("Player 2 won");
        }
        else{
            _winner.add(_playerOne);
            _winner.add(_playerTwo);
            System.out.println("Players did equal amount of damage. TIE!");
        }
    }

    /**
     * Chooses random number between 0 and one. Used to determine which player starts the dressing first
     * @return true if first player should start first, false otherwise
     */
    private boolean randomDrawPlayer(){
        Random rand = new Random();
        var drawResult = rand.nextInt(0,1);
        return drawResult == 0;
    }


}
