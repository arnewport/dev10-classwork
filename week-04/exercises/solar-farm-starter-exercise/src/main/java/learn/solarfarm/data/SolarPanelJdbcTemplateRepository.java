package learn.solarfarm.data;

import learn.solarfarm.models.SolarPanel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolarPanelJdbcTemplateRepository implements SolarPanelRepository {

    private final JdbcTemplate jdbcTemplate;

    public SolarPanelJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SolarPanel> findBySection(String section) throws DataAccessException {
        final String sql = """
                select
                    p.section,
                    p.`row`,
                    p.`column`,
                    p.year_installed,
                    m.material_type,
                    p.is_tracking
                from panel p
                inner join material m on p.material_id = m.material_id
                where p.section = ?;
                """;

        return jdbcTemplate.query(sql, new SolarPanelMapper(), section);
    }

    @Override
    public SolarPanel findByKey(String section, int row, int column) throws DataAccessException {
        final String sql = """
                select
                    p.section,
                    p.`row`,
                    p.`column`,
                    p.year_installed,
                    m.material_type,
                    p.is_tracking
                from panel p
                inner join material m on p.material_id = m.material_id
                where p.section = ? and p.`row` = ? and p.`column` = ?;
                """;

        return jdbcTemplate.query(sql, new SolarPanelMapper(), section, row, column)
                .stream().findFirst().orElse(null);
    };

//    @Override
//    public SolarPanel findByKey(String section, int row, int column) throws DataAccessException {
//        List<SolarPanel> all = findAll();
//        for (SolarPanel solarPanel : all) {
//            if (solarPanel.isMatch(section, row, column)) {
//                return solarPanel;
//            }
//        }
//        return null;
//    }

//    private List<SolarPanel> findAll() throws DataAccessException {
//        ArrayList<SolarPanel> result = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//                SolarPanel sp = lineToSolarPanel(line);
//                if (sp != null) {
//                    result.add(sp);
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            // If the file doesn't exist, no big deal.
//            // We'll create it when we add a new solar panel.
//            // No file just means no solar panels yet.
//        } catch (IOException ex) {
//            throw new DataAccessException("Could not open the file path: " + filePath, ex);
//        }
//        return result;
//    }


    @Override
    public SolarPanel findById(int panelId) {

        final String sql = """
                select
                    p.section,
                    p.`row`,
                    p.`column`,
                    p.year_installed,
                    m.material_type,
                    p.is_tracking
                from panel p
                inner join material m on p.material_id = m.material_id
                where p.panel_id = ?;
                """;

        return jdbcTemplate.query(sql, new SolarPanelMapper(), panelId)
                .stream().findFirst().orElse(null);
    }

//    @Override
//    public SolarPanel findById(int panelId) throws DataAccessException {
//        List<SolarPanel> all = findAll();
//        for (SolarPanel panel : all) {
//            if (panel.getId() == panelId) {
//                return panel;
//            }
//        }
//        return null;
//    }

//    @Override
//    public List<SolarPanel> findActive() {
//
//        final String sql = """
//                select panel_id, `name`, `description`,
//                start_date, end_date, funding_goal
//                from panel
//                where ? between start_date and end_date
//                order by start_date asc;
//                """;
//
//        return jdbcTemplate.query(sql, new SolarPanelMapper(), LocalDate.now());
//    }

//    @Override
//    public List<SolarPanel> findActiveAndFuture() {
//
//        final String sql = """
//                select panel_id, `name`, `description`,
//                start_date, end_date, funding_goal
//                from panel
//                where end_date >= ?
//                order by start_date asc;
//                """;
//
//        return jdbcTemplate.query(sql, new SolarPanelMapper(), LocalDate.now());
//    }

//    @Override
//    public List<SolarPanel> findByDateRange(LocalDate start, LocalDate end) {
//
//        final String sql = """
//                select panel_id, `name`, `description`,
//                    start_date, end_date, funding_goal
//                from panel
//                where not (end_date < ?
//                    or start_date > ?)
//                order by start_date asc;
//                """;
//
//        return jdbcTemplate.query(sql, new SolarPanelMapper(), start, end);
//    }

//    @Override
//    public SolarPanel create(SolarPanel panel) {
//
//        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
//                .withTableName("panel")
//                .usingGeneratedKeyColumns("panel_id");
//
//        HashMap<String, Object> args = new HashMap<>();
//        args.put("name", panel.getName());
//        args.put("description", panel.getDescription());
//        args.put("start_date", panel.getStartDate());
//        args.put("end_date", panel.getEndDate());
//        args.put("funding_goal", panel.getFundingGoal());
//
//        int panelId = insert.executeAndReturnKey(args).intValue();
//        panel.setSolarPanelId(panelId);
//        return panel;
//    }

    @Override
    public SolarPanel create(SolarPanel panel) throws DataAccessException {
        return panel;
    }

//    @Override
//    public boolean update(SolarPanel panel) {
//
//        final String sql = """
//                update panel set
//                    `name` = ?,
//                    `description` = ?,
//                    start_date = ?,
//                    end_date = ?,
//                    funding_goal = ?
//                where panel_id = ?;
//                """;
//
//        return jdbcTemplate.update(sql,
//                panel.getName(),
//                panel.getDescription(),
//                panel.getStartDate(),
//                panel.getEndDate(),
//                panel.getFundingGoal(),
//                panel.getSolarPanelId()) > 0;
//    }

    @Override
    public boolean update(SolarPanel panel) throws DataAccessException {
        return true;
    }

//    @Override
//    @Transactional
//    public boolean deleteById(int panelId) {
//        jdbcTemplate.update("delete from pledge where panel_id = ?;", panelId);
//        return jdbcTemplate.update("delete from panel where panel_id = ?;", panelId) > 0;
//    }

    @Override
    @Transactional
    public boolean deleteById(int panelId) throws DataAccessException {
        return true;
    }

}
