delete from user where 1=1;
delete from contract where 1=1;
delete from customer where 1=1;
delete from address where 1=1;
delete from state_transition where 1=1;
delete from state where 1=1;
delete from state_machine where 1=1;
delete from subject where 1=1;

insert user (user_id,fullname,username,password) values (1,"Füzesi Zsolt","fuz","12345");

insert subject (subject_id,name) values (1,"Szerződések");
insert subject (subject_id,name) values (2,"Partnerek");

insert state_machine(state_machine_id, subject_id,name) values (1,1,"Szerződések");

insert state(state_id, state_machine_id, name) values (1,1,"Rögzített");
insert state(state_id, state_machine_id, name) values (2,1,"Elbírált");
insert state(state_id, state_machine_id, name) values (3,1,"Jóváhagyott");
insert state(state_id, state_machine_id, name) values (4,1,"Megszűnt");
insert state(state_id, state_machine_id, name) values (5,1,"Elutasított");
insert state(state_id, state_machine_id, name) values (6,1,"Felmondott");

insert state_transition(transition_id, name, state_from, state_to) values(1,"Rögzítés", null,1);
insert state_transition(transition_id, name, state_from, state_to) values(2,"Elbírálás",   1,2);
insert state_transition(transition_id, name, state_from, state_to) values(3,"Elutasítás",  1,5);
insert state_transition(transition_id, name, state_from, state_to) values(4,"Jóváhagyás",  2,3);
insert state_transition(transition_id, name, state_from, state_to) values(5,"Elutasítás",  2,5);
insert state_transition(transition_id, name, state_from, state_to) values(6,"Felmondás",   3,6);


insert state_machine(state_machine_id, subject_id,name) values (2,2,"Partnerek");

insert state(state_id, state_machine_id, name) values (7,2,"Élő");
insert state(state_id, state_machine_id, name) values (8,2,"Megszűnt");
insert state(state_id, state_machine_id, name) values (9,2,"Tiltott");

insert state_transition(transition_id, name, state_from, state_to) values(7,"Rögzítés", null,7);
insert state_transition(transition_id, name, state_from, state_to) values(8,"Adatmódosítás", 7,7);
insert state_transition(transition_id, name, state_from, state_to) values(9,"Üzletkötés tiltás", 7,9);
insert state_transition(transition_id, name, state_from, state_to) values(10,"Megszüntetés", 7,8);
insert state_transition(transition_id, name, state_from, state_to) values(11,"Megszüntetés", 9,8);


insert into address (address_id, country, city, zip_code, street, number) values (1,"Magyarország","Pécel","2119","Bacsó Béla utca","9.");
insert into address (address_id, country, city, zip_code, street, number) values (2,"Magyarország","Budapest","1171","Olcsva utca","10.");

insert into customer (customer_id, state_id, first_name, last_name, primary_address_id) values (1, 7, "Zsolt", "Füzesi", 1);
insert into customer (customer_id, state_id, first_name, last_name, primary_address_id) values (2, 7, "Barbara", "Ecseri", 2);

insert into contract (contract_id, state_id, contract_date, contract_number, customer_id) values (0,1,"2016.01.01.","SZERZODESSZAM",1);
insert into contract (contract_id, state_id, contract_date, contract_number, customer_id) values (0,1,"2016.05.01.","SZERZODESSZÁM2",1);
insert into contract (contract_id, state_id, contract_date, contract_number, customer_id) values (0,2,"2016.05.01.","TOP-SECRET2",2);


                                                  