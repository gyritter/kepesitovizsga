package hu.nive.ujratervezes.kepesitovizsga.jurrasic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                PreparedStatement stmt =
                       conn.prepareStatement("SELECT * FROM dinosaur WHERE (expected) < (actual) ORDER BY breed");


        ) {


            return getDinos(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error", sqle);
        }
    }

    public List<String> getDinos(PreparedStatement stmt) {


        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {

                result.add(rs.getString("breed"));

            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("ERRORRR", sqle);
        }
        return result;
    }


}
