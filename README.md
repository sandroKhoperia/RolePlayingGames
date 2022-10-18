# RolePlayingGames
In many role-playing games, characters go into battle with some degree of attack and defense capabilities (represented as numerical values). These values are calculated based on the character's base attack/defense (those values don't change after initialization), plus “wearing” different articles of clothing to either increase performance (attack) or minimize damage inflicted by other characters (defense). In this assignment, you are to represent the following types of clothing.

Head gear: These items go on the character’s head (hats/helmets/visors) and are only useful for defense.

Hand gear: These items go on the character’s hands (gloves/swords/shield) and are only used for attack. Since you have 2 hands, you can have 2 of these items.

Footwear: These items go on the character’s feet (boots/sneakers/hoverboard) and can be for attack or defense. Since you have 2 feet, you can have 2 of these items.

Each item has a name consisting of an adjective and a noun, in that order, and the amount that it modifies the character’s attack and defense values.

Combining Items
When the game starts out, the characters start with an attack power and a defense strength. As they go through the game, they can pick up new items to add to those two values. The following rules apply:

They cannot pick up more items that they can hold. This means that they are limited to:

One piece of head gear

Two pieces of footwear

Two pieces of hand gear

To be clever, when a character picks up two items of the same type, their names are combined, they make a new piece of footwear that combines the powers and name.
Let's make the assumption that combining only happens when the player doesn't have empty slot for that gear.
The new name is the adjective from one item and the full name from the other. For instance, to combine

Scurrying Sandals -- defense strength: 1, attack strength 0

Happy HoverBoard -- defense strength: 3, attack strength 1

You get

Scurrying, Happy HoverBoard -- defense strength: 4, attack strength 1

Only items of the same type have their names combined.

Rather than creating a whole game, a driver class is created that represents a battle.
During a battle, two characters get total 10 possible items to choose from. 

This new class has the functionality to:
Choose two characters  Take two characters and a list of items as arguments to its contructor.

"Dress" those characters with items from the 10 possible choices. The two characters take turns to dress themself. Each turn, the character can only choose one item. After an item is chosen, it is removed from the following turns. The items should be chosen based on:
Which items can be combined Rule 1: Prefer the type of item that the character has available slot for. For example, if the character already has 2 footwear, 1 hand gear and 1 helmet, the character should try to choose 1 more hand gear.

Rule 2: if rule 1 leads to multiple choices, pick the item has the highest attack strength

Rule 3: If there is still a tie after Rule 1 and 2, pick the item has the highest defense strength

Rule 4: if there is yet still a tie after Rule 1,2,3, pick a random one.
For each turn, Print out each character in the fight along with what they are wearing and their attack and defense strength

After all the 10 items are chosen, Print out who is the winner of the battle. The winner is determined by who has less damage after a battle. Damage is calculated by one's opponent's attack power minus that character's defense points. For example:

Player 1 has 8 attack points and 6 defense strength.

Player 2 has 4 attack points and 7 defense strength.

The battle ends with Player 1 having -2 units of damage and Player 2 having 1 unit of damage.

Player 1 wins.

If there is a tie, it should be stated as such.
