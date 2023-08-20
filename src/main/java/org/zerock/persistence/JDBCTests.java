package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class JDBCTests {

    @Test
    public void testConnection() throws Exception {
        Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");
        log.info(clz);

        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE","C##book_ex","book_ex");
        log.info(con);
        con.close();    //bad code
    }

}
