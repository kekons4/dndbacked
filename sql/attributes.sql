drop table attributes_combat;

create table attributes_combat (
	ll_attribute_points int(255) NOT NULL,
	ul_attribute_points int(255) NOT NULL,
	spell_prof int(255),
	melee_prof int(255),
	ranged_prof int(255),
	pilot_prof int(255),
	ship_combat int(255),
	movement_speed int(255),
	attack_speed int(255),
	defense int(255)
);

insert into attributes_combat
	(ll_attribute_points, ul_attribute_points, spell_prof, melee_prof, ranged_prof, pilot_prof, ship_combat, movement_speed, attack_speed, defense)
	VALUES
	(1,4,0,0,0,0,0,1,1,0),
	(5,9,1,1,1,1,1,1,1,1),
	(10,14,2,2,2,2,2,2,2,2),
	(15,19,3,3,3,3,3,2,2,3),
	(20,24,4,4,4,4,4,3,3,4),
	(25,29,5,5,5,5,5,3,3,5),
	(30,34,6,6,6,6,6,4,4,6),
	(35,39,6,6,6,6,6,4,4,6),
	(40,44,6,6,6,6,6,5,5,6),
	(45,49,6,6,6,6,6,5,5,6),
	(50,50,6,6,6,6,6,6,5,6)