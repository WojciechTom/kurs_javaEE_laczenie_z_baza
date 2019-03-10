package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    private static DbUtil dbUtil;
    private HikariDataSource dataSource;

    private DbUtil(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/world?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("admin");
        dataSource = new HikariDataSource(config);
        System.out.println("db util construktor");
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }



    public static DbUtil getInstance(){
        if(dbUtil == null){
            dbUtil = new DbUtil();
        }
        return dbUtil;
    }



    public void close(){
        dataSource.close();
    }

}
