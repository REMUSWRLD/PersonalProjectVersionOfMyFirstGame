BEGIN;

CREATE DATABASE Game;

CREATE TABLE IF NOT EXISTS Class (
    class_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    health INT NOT NULL,
    attack_power INT NOT NULL,
    special_move VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Player (
    player_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    class_id INT NOT NULL,
    level INT NOT NULL,
    FOREIGN KEY (class_id) REFERENCES Class(class_id)
);

INSERT INTO Class (name, health, attack_power, special_move)
VALUES 
    ('Knight', 100, 15, 'Charge'),
    ('Wizard', 80, 30, 'Fireball'),
    ('Thief', 70, 25, 'Backstab');

COMMIT;