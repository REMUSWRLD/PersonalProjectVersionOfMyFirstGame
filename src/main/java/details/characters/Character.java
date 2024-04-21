package details.characters;

public class Character {
    private String characterClass;
    private String name;
    private int health;
    private int level;
    private int attackPower;
    private boolean isAlive;

    public Character(String name,String characterClass, int health, int attackPower, int level, boolean isAlive) {
        this.characterClass = characterClass;
        this.name = name;
        this.health = health;
        this.level = level;
        this.attackPower = attackPower;
        this.isAlive = isAlive;
    }

    // Getters and setters for each attribute


    public String getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean isAlive) {
        isAlive = true;
    }

    // toString method to print character details
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", level=" + level +
                ", attackPower=" + attackPower +
                '}';

    }

    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
    }
}
