package neu.xindong.ia.service;

import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.impl.TradeRecordServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeRecordServiceTest {
    @Autowired
    private TradeRecordServiceImpl tradeRecordService;
    @Test
    public void findAllTest() {
        System.out.printf("tradeRecode:"+tradeRecordService.findAll());
    }

    @Test
    public void findTradeRecordBySoldTest(){
        List<TradeRecord> tradeRecordList1=tradeRecordService.findTradeRecordBySold(0);
        for(TradeRecord tradeRecord:tradeRecordList1){
            System.out.println("unsold:"+tradeRecord.toString());
        }
        List<TradeRecord> tradeRecordList2=tradeRecordService.findTradeRecordBySold(1);
        for(TradeRecord tradeRecord:tradeRecordList2){
            System.out.println("sold:"+tradeRecord.toString());
        }
    }


}
