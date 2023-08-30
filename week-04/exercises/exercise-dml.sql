-- from ddl
drop database if exists my_house;
create database my_house;

use my_house;

create table `user` (
	user_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(100) not null unique,
    phone varchar(25) not null,
    is_host int not null,
    is_guest int not null
);

create table location (
	location_id int primary key auto_increment,
    user_id int,
    address varchar(100) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip varchar(5) not null,
    standard_rate decimal not null,
    weekend_rate decimal not null,
    constraint fk_location_user_id
		foreign key (user_id)
		references `user`(user_id)
);

create table reservation (
	reservation_id int primary key auto_increment,
    location_id int,
    user_id int,
    start_date date not null,
    end_date date not null,
    total_price decimal not null,
    constraint fk_reservation_location_id
		foreign key (location_id)
		references location(location_id),
	constraint fk_reservation_user_id
		foreign key (user_id)
		references `user`(user_id)
);

-- end ddl

insert into `user` 
(first_name, last_name, email, phone, is_host, is_guest) 
values 
('Marsiella', 'Joyes', 'mjoyes0@reference.com', '(919) 1018488', 0, 1),
('Fatima', 'Hassan', 'fhassan@reuters.com', '(706) 3701776', 1, 0),
('Christina', 'Radband', 'cradband7@deliciousdays.com', '(260) 2527265', 1, 1);

insert into location
(user_id, address, city, state, zip, standard_rate, weekend_rate) 
values 
(2, '8 Towne Crossing', 'Las Vegas', 'NV', '89110', 176, 188),
(3, '1690 Little Fleur Court', 'Memphis', 'TN', '38104', 75, 113),
(2, '5 John Wall Trail', 'New Orleans', 'LA', '70149', 236, 284);

insert into reservation
(start_date, end_date, total_price, location_id, user_id) 
values 
('2023-03-01', '2023-03-05', 100, 1, 1),
('2023-11-15', '2023-11-20', 100, 2, 1),
('2023-03-01', '2023-03-05', 100, 3, 3);

set sql_safe_updates = 0;

update location set
    address = '105 John Wall Trail'
where address = '5 John Wall Trail';

set sql_safe_updates = 1;

-- delete from `user` where user_id = 1;