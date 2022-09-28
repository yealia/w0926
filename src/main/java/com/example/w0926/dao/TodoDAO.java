package com.example.w0926.dao;

import com.example.w0926.dto.TodoDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public enum TodoDAO{
            INSTANCE; //enum을 하면 instance로 생성자 하나 만든다
            private final String INSERT="INSERT INTO tbl_todo(title,memo,dueDate) VALUES(?, ?, ?)";
            private final String DELETE="DELETE FROM tbl_todo WHERE tno=?";

            private final String LAST = "select last_insert_id()";

            public List<TodoDTO> list(int page, int size)throws Exception{
                StringBuffer buffer =
                new StringBuffer("select * from tbl_todo where tno >0  order by tno desc limit ?,?");

                int skip = (( page <=0 ? 1 :page )-1 )*size;

                @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
                @Cleanup PreparedStatement preparedStatement
                        = connection.prepareStatement(buffer.toString());
                preparedStatement.setInt(1,skip);
                preparedStatement.setInt(2,size);

                @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

                List<TodoDTO> list = new ArrayList<>();

                while(resultSet.next()){
                    TodoDTO dto = TodoDTO.builder()

                            .tno(resultSet.getInt("tno"))
                            .title(resultSet.getString("title"))
                            .memo(resultSet.getString("memo"))
                            .dueDate(resultSet.getDate("dueDate").toLocalDate())
                            .complete(resultSet.getBoolean("complete"))
                            .regDate(resultSet.getTimestamp("regDate").toLocalDateTime())
                            .modDate(resultSet.getTimestamp("modDate").toLocalDateTime())
                            .build();

                    list.add(dto);
                }
                return list;
            }
            public Integer insert(TodoDTO todoDTO)throws Exception{
                Integer result = null;
                @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
                @Cleanup PreparedStatement preparedStatement
                        = connection.prepareStatement(INSERT);

                preparedStatement.setString(1,todoDTO.getTitle());
                preparedStatement.setString(2,todoDTO.getMemo());
                preparedStatement.setDate(3, Date.valueOf(todoDTO.getDueDate()));

                //insert/update/delete -> int
                int count = preparedStatement.executeUpdate();
                if(count != 1){
                    throw new Exception("insert error");
                }
                preparedStatement.close();
                preparedStatement = connection.prepareStatement(LAST);

                @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

                resultSet.next();

                result = resultSet.getInt(1);

                return result;
            }
            //delete
            public Integer delete(TodoDTO todoDTO) throws Exception{
                @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
                @Cleanup PreparedStatement preparedStatement
                        = connection.prepareStatement(DELETE);
                int result = 0;
                preparedStatement.setInt(1, todoDTO.getTno());

                int count = preparedStatement.executeUpdate();
                if(count != 1){
                    throw new Exception("delete error");
                }
                preparedStatement.close();
                preparedStatement = connection.prepareStatement(LAST);

                @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                result = resultSet.getInt(1);
                return result;
            }
}
