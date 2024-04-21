package details.characters;

import details.characters.MoveSet.Wizardmoveset;

import static details.characters.CharacterCreation.opponent;

public class Wizard extends Character implements Wizardmoveset {
    private int mana;
    public Wizard(int mana) {
        super(" ","Wizard", 100, 15, 0, true);
        this.mana = mana;
    }


    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString(){
        return getCharacterClass() + System.lineSeparator() +
                "Level: " + getLevel() + System.lineSeparator() +
                "Mana: " + mana + System.lineSeparator() +
                "Health: " + getHealth() + System.lineSeparator() +
                "Attack Power: " + getAttackPower();
    }


    public void attack(){
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
    }
    public void heal(){
        this.setHealth(this.getHealth() + 10);
    }
    public void defend(){
    }
}
