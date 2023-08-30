-- I revised this

create table host (
	host_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(100) not null unique,
    phone varchar(25) not null
);

create table guest (
	guest_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(100) not null unique,
    phone varchar(25) not null
);

create table location (
	location_id int primary key auto_increment,
    address varchar(100) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip varchar(5) not null,
    standard_rate decimal not null,
    weekend_rate decimal not null,
    constraint fk_location_host_id
		foreign key (host_id)
		references host(host_id)
);

create table reservation (
	reservation_id int primary key auto_increment,
    start_date date not null,
    end_date date not null,
    total_price decimal not null,
    constraint fk_reservation_location_id
		foreign key (location_id)
		references location(location_id),
	constraint fk_reservation_guest_id
		foreign key (guest_id)
		references guest(guest_id)
);

-- I have no idea how to calculate the total price within the definition
-- I used ChatGPT to investigate and roughly came up with the following:
-- UPDATE reservation
-- SET total_price = DATEDIFF(end_date, start_date) * standard_rate;
-- ...But this is likely still not correct

-- I'm also unsure of how to implement some of the nuances