drop table items_list;

create table items_list (
	item_id varchar(255) NOT NULL,
	item_name varchar(32) NOT NULL,
	health_points int(255),
	defense_ranged int(100),
	energy int(255),
	energy_regen int(255),
	strength int(255),
	movement_speed int(100),
	attack_speed int(100),
	awareness int(255),
	melee_prof int(100),
	ranged_prof int(100),
	force_prof int(100),
	attack_range int(100),
	computer int(100),
	repair int(100),
	marial_arts int(100),
	armor int(100),
	defense_melee int(100),
	pilot_prof int(100),
	starship_combat int(100),
	force_shield int(100)
);