package learn.solarfarm.data;

import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SolarPanelMapper implements RowMapper<SolarPanel> {
    @Override
    public SolarPanel mapRow(ResultSet rs, int rowNum) throws SQLException {

//        String materialString = rs.getString("material_type"); // Replace with your column name
//        System.out.println(materialString);
//        Material x = Material.valueOf(materialString); // Convert the string to enum

        SolarPanel panel = new SolarPanel();
        panel.setSection(rs.getString("section"));
        panel.setRow(rs.getInt("row"));
        panel.setColumn(rs.getInt("column"));
        panel.setYearInstalled(rs.getInt("year_installed"));
//        panel.setMaterial(x);
        panel.setMaterial(Material.valueOf(rs.getString("material_type")));
        panel.setTracking(rs.getBoolean("is_tracking"));
        return panel;

    }
}
