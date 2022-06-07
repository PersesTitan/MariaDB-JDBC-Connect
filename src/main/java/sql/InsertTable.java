package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTable {

    Connection con;
    String sql;
    String[] values;

    public InsertTable(Connection con, String sql, String...values) {
        this.con = con;
        this.sql = sql;
        this.values = values;

    }

    public void insert() {
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)){

        } catch (Exception e) {e.printStackTrace();}
    }
}
