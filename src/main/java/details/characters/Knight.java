package details.characters;


import details.characters.MoveSet.Knightmoveset;

public class Knight extends Character implements Knightmoveset {
    private int honor;
    public Knight(int honor) {
        super(" ","Knight", 100, 15, 0, true);
        this.honor = honor;
    }


    public int getHonor() {
        return honor;
    }
    public void setHonor(int honor) {
        this.honor = honor;
    }

    @Override
    public String toString(){
        return getCharacterClass() + System.lineSeparator() +
             "Level: " + getLevel() + System.lineSeparator() +
             "Honor: " + honor + System.lineSeparator() +
             "Health: " + getHealth() + System.lineSeparator() +
             "Attack Power: " + getAttackPower();
    }


}


