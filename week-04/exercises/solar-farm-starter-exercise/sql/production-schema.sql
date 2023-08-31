drop database if exists solar_farm;
create database solar_farm;
use solar_farm;

create table material (
    material_id int primary key auto_increment,
    material_type varchar(128) not null
);

create table panel (
	panel_id int primary key auto_increment,
    material_id int not null,
    section varchar(128) not null,
    `row` int not null,
    `column` int not null,
    year_installed int not null,
    is_tracking int not null,
    constraint fk_panel_material_id
        foreign key(material_id)
        references material(material_id)
    -- constraint uq_section_row_column
    --     unique(section, row, column)
);