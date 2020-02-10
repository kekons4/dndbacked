drop table character_final_stats;

create table character_final_stats (
char_id varchar(255) NOT NULL,
inventory_id varchar(255) NOT NULL,  
player_name varchar(16) NOT NULL,
credits int(255) NOT NULL,
wampa_wampa int(255) NOT NULL,
species varchar(16) NOT NULL,
title varchar(16),
origin varchar(16),
security_rating varchar(8),
level int(255) NOT NULL,
current_xp int(255) NOT NULL,
next_level_xp int(255) NOT NULL,
pilot_rating varchar(8),
power_level int(255) NOT NULL,
health_points int(255) NOT NULL,
defense_ranged int(100) NOT NULL,
energy int(255),
energy_regen int(255),
strength int(255) NOT NULL,
movement_speed int(100) NOT NULL,
attack_speed int(100) NOT NULL,
awareness int(255) NOT NULL,
melee_prof int(100) NOT NULL,
ranged_prof int(100) NOT NULL,
force_prof int(100) NOT NULL,
attack_range int(100) NOT NULL,
computer int(100) NOT NULL,
repair int(100) NOT NULL,
martial_arts int(100) NOT NULL,
armor int(100),
defense_melee int(100) NOT NULL,
pilot_prof int(100),
starship_combat int(100),
force_shield int(100), 
player_active boolean NOT NULL
);