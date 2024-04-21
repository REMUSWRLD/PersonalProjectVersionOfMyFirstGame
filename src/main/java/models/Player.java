package models;

public class Player {
    private int character_id;
    private String name;
    private String character_Class;
    private int level;

    public Player() {
    }

    public Player(int character_id, String name, String character_Class, int level) {
        this.character_id = character_id;
        this.name = name;
        this.character_Class = character_Class;
        this.level = level;
    }

    public int getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter_Class() {
        return character_Class;
    }

    public void setCharacter_Class(String character_Class) {
        this.character_Class = character_Class;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
