drop table inventory;

create table inventory (
	inventory_id varchar(255) NOT NULL,
	item_id varchar(255) NOT NULL,
	quantity int(255) NOT NULL,
	equiped boolean NOT NULL
);
