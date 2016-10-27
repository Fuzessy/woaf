drop table if exists contract;
drop table if exists customer;
drop table if exists address;
drop table if exists state_transition;
drop table if exists state;
drop table if exists state_machine;
drop table if exists subject;



create table subject(
	subject_id INT not null,
	name VARCHAR(32) not null,
	PRIMARY KEY(subject_id)
);

create table state_machine(
	state_machine_id int not null,
	subject_id int not null,
	name VARCHAR(30) not null,
	foreign key (subject_id) references subject(subject_id),
	PRIMARY KEY(state_machine_id)
);

create table state(
	state_id int not null,
	state_machine_id int not null,
	name varchar(32) not null,
	foreign key (state_machine_id) references state_machine(state_machine_id),
	primary key(state_id)
);

create table state_transition(
	transition_id int not null,
	name varchar(32) not null,
	state_from int,
	state_to int not null,
	foreign key (state_from) references state(state_id),
	foreign key (state_to) references state(state_id),
	primary key(transition_id)
);

create table address(
	address_id int auto_increment not null,
	country varchar(64),
	city  varchar(64),
	zip_code varchar(6),
	street  varchar(64),
	number varchar(64),
	primary key(address_id)
);

create table customer(
	customer_id int auto_increment not null,
	state_id int not null,
	first_name varchar(64),
	last_name varchar(64),
	primary_address_id integer not null,
	foreign key(state_id) references state(state_id),
	foreign key(primary_address_id) references address(address_id),
	primary key(customer_id)
);

create table contract(
	contract_id int auto_increment not null,
	state_id int not null,
	contract_date date not null,
	contract_number varchar(32) not null,
	customer_id integer not null,
	foreign key (state_id) references state(state_id),
	foreign key (customer_id) references customer(customer_id),
	primary key(contract_id)
);

