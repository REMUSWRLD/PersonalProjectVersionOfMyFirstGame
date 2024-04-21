package models;

public class Classes {
    private int class_id;
    private String name;
    private int health;
    private int attackPower;
    private String specialMove;

    public Classes() {
    }

    public Classes(int class_id, String name, int health, int attackPower, String specialMove) {
        this.class_id = class_id;
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.specialMove = specialMove;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
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

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getSpecialMove() {
        return specialMove;
    }

    public void setSpecialMove(String specialMove) {
        this.specialMove = specialMove;
    }
}
