package details.characters;

import details.characters.MoveSet.Thiefmoveset;

import static details.characters.CharacterCreation.opponent;

public class Thief extends Character implements Thiefmoveset {
    private int agility;
    public Thief(int agility) {
        super(" ", "Thief", 90, 12, 0, true);
        this.agility = agility;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public String toString(){
        return getCharacterClass() + System.lineSeparator() +
                "Level: " + getLevel() + System.lineSeparator() +
                "Agility: " + agility + System.lineSeparator() +
                "Health: " + getHealth() + System.lineSeparator() +
                "Attack Power: " + getAttackPower();
    }

    public void attack(){
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
    }
    public void defend(){
    }
}
