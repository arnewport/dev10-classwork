use solar_farm;

insert into material (material_type) values
    ("POLY_SI"),
    ("MONO_SI"),
    ("A_SI"),
    ("CD_TE"),
    ("CIGS");
/*
insert into material (material_type) values
    ("Multicrystalline Silicon"),
    ("Monocrystalline Silicon"),
    ("Amorphous Silicon"),
    ("Cadmium Telluride"),
    ("Copper Indium Gallium Selenide");
    
 */   
    
--    POLY_SI("Multicrystalline Silicon"),
--    MONO_SI("Monocrystalline Silicon"),
--    A_SI("Amorphous Silicon"),
--    CD_TE("Cadmium Telluride"),
--    CIGS("Copper Indium Gallium Selenide");

insert into panel (material_id, section, `row`, `column`, year_installed, is_tracking) values 
    (1, "The Ridge", 1, 1, 2020, 1),
    (2, "The Ridge", 1, 2, 2019, 1),
    (3, "Flats", 1, 1, 2017, 1),
    (4, "Flats", 2, 6, 2017, 1),
    (5, "Flats", 3, 7, 2000, 0);