drop database if exists solar_farm_test;
create database solar_farm_test;
use solar_farm_test;

create table material (
    material_id int primary key auto_increment,
    material_type varchar(128) not null;
);

create table panel (
	panel_id int primary key auto_increment,
    material_id int not null,
    section varchar(128) not null,
    row int not null;
    column int not null;
    year_installed int not null;
    is_tracking int not null;
    constraint fk_panel_material_id
        foreign key(material_id)
        references material(material_id)
    -- constraint uq_section_row_column
    --     unique(section, row, column)
);

delimiter //
create procedure set_known_good_state()
begin
	delete from material;
	delete from panel;
	alter table material auto_increment=1;
	alter table panel auto_increment=1;

	insert into material (material_type) values
	    ("Multicrystalline Silicon"),
	    ("Monocrystalline Silicon"),
	    ("Amorphous Silicon"),
	    ("Cadmium Telluride"),
	    ("Copper Indium Gallium Selenide");

	insert into panel (material_id, section, row, column, year_installed, is_tracking) values 
	    (1, "The Ridge", 1, 1, 2020, 1),
	    (2, "The Ridge", 1, 2, 2019, 1),
	    (3, "Flats", 1, 1, 2017, 1),
	    (4, "Flats", 2, 6, 2017, 1),
	    (5, "Flats", 3, 7, 2000, 0);
        
end//
delimiter ;