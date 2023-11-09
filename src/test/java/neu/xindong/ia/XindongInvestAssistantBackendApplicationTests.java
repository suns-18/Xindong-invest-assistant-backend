package neu.xindong.ia;

import jakarta.annotation.Resource;
import neu.xindong.ia.controller.QuestionController;
import neu.xindong.ia.controller.TradeRecordController;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.*;
import neu.xindong.ia.service.TradeRecordService;
import neu.xindong.ia.service.impl.PossessionItemServiceImpl;
import neu.xindong.ia.service.impl.QuestionOptionServiceImpl;
import neu.xindong.ia.service.impl.QuestionTitleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
class XindongInvestAssistantBackendApplicationTests {
    Logger log = Logger.getLogger(String.valueOf(XindongInvestAssistantBackendApplicationTests.class));
    @Autowired
    private QuestionController questionController;
    @Autowired
    private TradeRecordController tradeRecordController;
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
    @Test
    void testQuestion(){
        HttpResponse httpResponse = questionController.queryList();
        System.out.println(httpResponse);
    }
    @Test
    void testTrade(){
        Product product = new Product();
        product.setId(1);
        HttpResponse httpResponse = tradeRecordController.getTradeRecordByProductId(product);
        System.out.println(httpResponse);
    }
    @Resource
    private PossessionItemServiceImpl possessionService;
    @Resource
    private QuestionTitleServiceImpl questionTitleService;
    @Resource
    private QuestionOptionServiceImpl questionOptionService;
    @Resource
    private TradeRecordService tradeRecordService;

    /**
     * 测试买入卖出添加记录
     */
    @Test
    public void testTradeRecordAdd(){
        TradeRecord tradeRecord = new TradeRecord();
        tradeRecord.setProductId(5);
        tradeRecord.setAmount(14);
        tradeRecord.setPrice(55.00);
        if(tradeRecordService.purchase(tradeRecord)){
            System.out.println("successful to add");
        }else{
            System.out.println("failed to add");
        }

    }

    @Test
    public void testDate() {

    }

}
