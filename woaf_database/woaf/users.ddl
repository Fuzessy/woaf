drop table if exists users;
drop table if exists groups;
drop table if exists user_groups;

create table users(
	user_id INT AUTO_INCREMENT NOT NULL,
	fullname VARCHAR(128) not null,
	username VARCHAR(16) not null,
	password VARCHAR(256) not null,
	UNIQUE(username),
	PRIMARY KEY(user_id)
);	

create table groups(
	group_id INT NOT NULL,
	group_name VARCHAR(32) not null,
	UNIQUE(group_name),
	PRIMARY KEY(group_id)
);	

create table user_groups(
	user_id INT NOT NULL,
	group_id INT NOT NULL,
	PRIMARY KEY(user_id,group_id)
);	

-- create view for JDBC Realm
drop view if exists v_users;
CREATE VIEW v_users AS 
SELECT username, password
FROM users;

drop view if exists v_user_groups;
CREATE VIEW v_user_groups AS 
SELECT users.username as username, groups.group_name as group_name
FROM user_groups
JOIN users ON user_groups.user_id = users.user_id
JOIN groups ON user_groups.group_id = groups.group_id;


delete from users;
insert into users values (0,"Füzesi Zsolt","fuz","3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79"); /*12345*/
