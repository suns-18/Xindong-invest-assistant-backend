package neu.xindong.ia;

import neu.xindong.ia.controller.QuestionController;
import org.apache.ibatis.jdbc.Null;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
class XindongInvestAssistantBackendApplicationTests {
    Logger log = Logger.getLogger(String.valueOf(XindongInvestAssistantBackendApplicationTests.class));
    @Autowired
    private QuestionController questionController;
    @Test
    void sortEasier(){
        var array = new ArrayList<Integer>();
        array.add(1);
        array.add(0);
        array.add(8);
        array.add(9);
        array.add(2);

        array.sort(Comparator.reverseOrder());
        System.out.println(array);
    }
    /*对questionController的测试*/
    @Test
    void Question(){
        Assertions.assertNotNull(questionController.queryList(),"Project模块>>列表请求测试1：返回所有，未通过");
        log.info("Project模块>>列表请求测 试1：返回所有，通过");
        log.info("Question模块>>列表请求测试通过");
    }
}
