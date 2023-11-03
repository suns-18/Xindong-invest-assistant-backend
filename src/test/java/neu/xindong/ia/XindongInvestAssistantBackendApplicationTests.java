package neu.xindong.ia;

import jakarta.annotation.Resource;
import neu.xindong.ia.controller.QuestionController;
import neu.xindong.ia.entity.*;
import neu.xindong.ia.service.PossessionService;
import neu.xindong.ia.service.QuestionTitleService;
import neu.xindong.ia.service.impl.PossessionServiceImpl;
import neu.xindong.ia.service.impl.QuestionOptionServiceImpl;
import neu.xindong.ia.service.impl.QuestionTitleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.List;

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

    @Resource
    private PossessionServiceImpl possessionService;
    @Resource
    private QuestionTitleServiceImpl questionTitleService;
    @Resource
    private QuestionOptionServiceImpl questionOptionService;

    /**
     * 测试possessionService
     * 测试查询所有持仓信息
     */
    @Test
    public void testFindAllPossession(){
        List<Possession> possessionList = possessionService.findAll();
        if (possessionList.isEmpty()){
            System.out.println("Failed to find possession, possessionList is empty!");
        }else{
            System.out.println("Successful to find possession, the following is possessionList!");
            System.out.println(possessionList.toString());
        }
    }

    /**
     * 测试possessionService
     * 测试增加一条持仓记录，成功
     * 测试用例为：tradeRecord的产品id是持仓表中没有的产品
     */
    @Test
    public void testAddPossession1(){

        TradeRecord tradeRecord = new TradeRecord();
        tradeRecord.setProductId(2);
        tradeRecord.setPrice(748.35);
        tradeRecord.setAmount(10);
        if(possessionService.addPossession(tradeRecord)){
            System.out.println("Successful to add possession!");
        }else{
            System.out.println("Failed to add possession!");
        }
    }
    /**
     * 测试possessionService
     * 测试增加一条持仓记录，失败
     * 测试用例为：tradeRecord的产品id是持仓表中已存在的持仓产品
     */
    @Test
    public void testAddPossession2(){

        TradeRecord tradeRecord = new TradeRecord();
        tradeRecord.setProductId(1);//测试数据库中已存在的持仓产品
        tradeRecord.setPrice(2000.00);
        tradeRecord.setAmount(2);
        if(possessionService.addPossession(tradeRecord)){
            System.out.println("Successful to add possession!");
        }else{
            System.out.println("Failed to add possession!");
        }
    }

    /**
     * 测试possessionService
     * 测试在卖出交易时更新一条持仓记录，失败。
     * 测试用例：tradeRecord的卖出数量超过持有数量
     */
    @Test
    public void testUpdatePossessionWhenSell1(){
        TradeRecord tradeRecord = new TradeRecord();
        tradeRecord.setProductId(2);
        tradeRecord.setPrice(848.35);//假设涨了100，原价748.35
        tradeRecord.setAmount(100);//卖出数量超过持有
        tradeRecord.setSold(1);
        if(!possessionService.updatePossessionWhenSell(tradeRecord)){
            System.out.println("Failed to update possession when sell!");
        }else {
            System.out.println("Successful to update possession when sell!");
        }
    }
    /**
     * 测试possessionService
     * 测试在卖出交易时更新一条持仓记录，成功。
     * 测试用例：tradeRecord的卖出数量不超过持有数量
     */
    @Test
    public void testUpdatePossessionWhenSell2(){
        TradeRecord tradeRecord = new TradeRecord();
        tradeRecord.setProductId(2);
        tradeRecord.setPrice(48.35);//假设涨了100，原价748.35
        tradeRecord.setAmount(5);//卖出数量≤持有数量
        tradeRecord.setSold(1);
        if(!possessionService.updatePossessionWhenSell(tradeRecord)){
            System.out.println("Failed to update possession when sell!");
        }else {
            System.out.println("Successful to update possession when sell!");
        }
    }

    /**
     * 测试possessionService
     * 测试在买入交易时更新一条持仓记录，成功。
     * 测试用例：tradeRecord的产品id在持仓表里，sold=0
     */
    @Test
    public void testUpdatePossessionWhenBuy1(){
        TradeRecord tradeRecord = new TradeRecord();
        tradeRecord.setProductId(2);
        tradeRecord.setPrice(948.35);//再次买入价格
        tradeRecord.setAmount(7);
        tradeRecord.setSold(0);
        if(possessionService.updatePossessionWhenBuy(tradeRecord)){
            System.out.println("Successful to update possession when buy!");
        }else {
            System.out.println("Failed to update possession when buy!");
        }
    }

    /**
     * 测试possessionService
     * 测试在买入交易时更新一条持仓记录，失败。
     * 测试用例：tradeRecord的产品id不在持仓表里或者sold=1
     */
    @Test
    public void testUpdatePossessionWhenBuy2(){
        TradeRecord tradeRecord = new TradeRecord();
        tradeRecord.setProductId(120);
        tradeRecord.setPrice(948.35);
        tradeRecord.setAmount(7);
        tradeRecord.setSold(0);
        if(possessionService.updatePossessionWhenBuy(tradeRecord)){
            System.out.println("Successful to update possession when buy!");
        }else {
            System.out.println("Failed to update possession when buy!");
        }
    }

    /**
     * 测试questionTitleService
     */
    @Test
    public void testFindQuestionTitleByQuestion(){
        int question = 4;
        List<QuestionTitle> questionTitleList = questionTitleService.findQuestionTitleByQuestion(Integer.valueOf(question));
        if(questionTitleList.isEmpty()){
            System.out.println("Failed to find questionTitle by question!");
        }else {
            System.out.println("Successful to find questionTitle by question!");
            System.out.println("The question is : "+ questionTitleList.toString());
        }
    }

    /**
     * 测试questionOptionService
     */
    @Test
    public void testFindQuestionOptionsByQuestion(){
        int question = 4;
        List<QuestionOption> questionOptionList = questionOptionService.findQuestionOptionsByQuestion(Integer.valueOf(question));
        if(questionOptionList.isEmpty()){
            System.out.println("Failed to find questionOption by question!");
        }else {
            System.out.println("Successful to find questionOption by question!");
            System.out.println("The questionOption include : "+ questionOptionList.toString());
        }
    }

    /**
     * 测试questionOptionService
     */
    @Test
    public void testFindOptionValueByAnswer(){
        Answer answer = new Answer();
        answer.setOption(12);
        QuestionOption questionOption = new QuestionOption();
        questionOption = questionOptionService.findOptionValueByAnswer(answer);
        System.out.println("The optionValue found by answer is : "+questionOption.toString());
    }

}
