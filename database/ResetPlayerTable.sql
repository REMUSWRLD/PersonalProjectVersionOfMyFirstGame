-- Reset player table
begin transaction
TRUNCATE TABLE player;
ALTER SEQUENCE player_player_id_seq RESTART WITH 1;
commit