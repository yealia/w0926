package org.zerock.dao;

import com.example.w0926.dao.TodoDAO;
import com.example.w0926.dto.TodoDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class TodoDAOTests {

    @Test
    public void testList()throws Exception {

        for (TodoDTO dto : TodoDAO.INSTANCE.list(3,10)) {

            System.out.println(dto);
        }
    }
    @Test
    public void testInserts()throws Exception{

        IntStream.rangeClosed(1,1).forEach( i -> {

            TodoDTO dto = TodoDTO.builder()
                    .title("YRtest"+i)
                    .memo("Test...")
                    .dueDate(LocalDate.now())
                    .build();
            try {
                System.out.println(TodoDAO.INSTANCE.insert(dto));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Test
    public void testDeletes()throws Exception{

        //builder 생성자를 동적으로 만들어주는거 빌드랑 빌드가 한태그
        TodoDTO dto = TodoDTO.builder().tno(1).build();

        System.out.println(TodoDAO.INSTANCE.delete(dto));

    }

}
