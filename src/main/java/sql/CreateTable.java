package sql;

import java.sql.Connection;

public class CreateTable {

    Connection con;
    String tableName;
    String sql;

    public CreateTable(Connection con, String tableName, String sql) {
        this.con = con;
        this.tableName = tableName;
        this.sql = sql;
    }

    //테이블이 존재하면 생성하지 않음
    public void create() {
        //java 10 이상
        try (var sta = con.createStatement()) {
            sta.execute(createSQL(sql));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        java 10 미만
//        try (Statement sta = con.createStatement()){
//            sta.execute(createSQL(sql));
//        } catch (Exception e) {e.printStackTrace();}
    }

    private String createSQL(String str) {
        return String.format("CREATE TABLE IF NOT EXISTS %s (", tableName) + str + ")";
    }
}