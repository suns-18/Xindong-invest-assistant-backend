package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**code by ryr
 * tradeRecordController
 */
@RestController
@RequestMapping("/api/tradeRecord")
public class TradeRecordController {
    @Autowired
    private TradeRecordService tradeRecordService;
    @GetMapping(value = "/queryList")
    public HttpResponse getAllTradeRecord() {
        List<TradeRecord> tradeRecordList=tradeRecordService.findAll();
        return HttpResponse.builder()
                .code(200)
                .message("Get trade record list successfully")
                .data(tradeRecordList)
                .build();
    }
    @GetMapping(value = "/queryByProductId")
    public HttpResponse getTradeRecordByProductId(@RequestBody Product product){
        List<TradeRecord> tradeRecordList=tradeRecordService.findTradeRecordByProductId(product);
        return HttpResponse.builder()
                .code(200)
                .message("Get trade record list by productId successfully")
                .data(tradeRecordList)
                .build();
    }
}
