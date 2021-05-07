package hu.nive.ujratervezes.kepesitovizsga.jurrasic;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    private List<String> result = new ArrayList<>();

    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try (
                Connection conn = dataSource.getConnection();
               Statement stmt =
                       conn.createStatement();

        ) {

            getDinos(stmt);
            return result;

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error", sqle);
        }
    }

    public void getDinos(Statement stmt) {


        try (
                ResultSet rs = stmt.executeQuery("SELECT * FROM dinosaur WHERE (expected) < (actual) ORDER BY breed");
        ) {
            while (rs.next()) {

                result.add(rs.getString("breed"));

            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("ERRORRR", sqle);
        }
    }


}
