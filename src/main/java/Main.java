import sql.CreateTable;

import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName ("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        final String url = "jdbc:mariadb://localhost:3306/Practice"; //서버 url 입력
        final String user = "TestUser"; //유저 이름
        final String password = "1234"; //유저 비밀번호
        final String tableName = "TEST_TABLE";

        final String createSQL = "ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20)";

        //java 10 이상
        try (var con = DriverManager.getConnection(url, user, password)) {
            CreateTable createTable = new CreateTable(con, tableName, createSQL);
            createTable.create();

        } catch (Exception e) {e.printStackTrace();}

        //java 10 미만
//        try (Connection con = DriverManager.getConnection(url, user, password)) {
//
//        } catch (Exception e) {e.printStackTrace();}
    }
}
