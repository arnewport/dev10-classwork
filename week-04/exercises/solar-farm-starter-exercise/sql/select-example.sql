use solar_farm;

select 
    p.section,
    p.`row`,
    p.`column`,
    p.year_installed,
    m.material_type,
    p.is_tracking
from panel p
inner join material m on p.material_id = m.material_id;