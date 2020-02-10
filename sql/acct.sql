drop table acct;

create table acct ( 
	email_id varchar(32) NOT NULL,
	username varchar(16) NOT NULL,
	password varchar(16) NOT NULL,
	char_id_one varchar(255),
	char_id_two varchar(255),
	char_id_three varchar(255)
);