package org.zerock.dao;

import com.example.w0926.dao.ConnectionUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectTests {

    @Test
    public void testConnect100()throws Exception{

        //드라이브 로딩


        long start = System.currentTimeMillis();

        for(int i=0; i<100; i++){

            //커넥션

            @Cleanup
            Connection connection = ConnectionUtil.INSTANCE.getConnection();
//            Connection connection =
//                    DriverManager.getConnection(
//                            "jdbc:mariadb://192.168.0.98/webdb",
//                            "webuser",
//                            "webuser"
//                    );
            String query = "select now()";
            //쿼리
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next(); //메타 데이터 건너뛰기, 즉 실제 데이터만 읽어온다

            String str = resultSet.getString(1);

            System.out.println(str);


            //close();
        }
        long end = System.currentTimeMillis();

        //long gap = System.currentTimeMillis();

        long gap = end - start;
        System.out.println("Time : "+gap);
        //드라이버 로딩

    }
}
