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

/**
 * code by ryr
 * tradeRecordController
 */
@RestController
@RequestMapping("/api/tradeRecord")
public class TradeRecordController {
    @Autowired
    private TradeRecordService tradeRecordService;

    @GetMapping(value = "/queryList")
    public HttpResponse<List<TradeRecord>> getAllTradeRecord() {
        List<TradeRecord> tradeRecordList = tradeRecordService.findAll();
        return HttpResponse.success(tradeRecordList);
    }

    @GetMapping(value = "/queryByProductId")
    public HttpResponse<List<TradeRecord>>
    getTradeRecordByProductId(@RequestBody Product product) {
        try {
            List<TradeRecord> tradeRecordList =
                    tradeRecordService
                            .findTradeRecordByProductId(product);
            return HttpResponse.success(tradeRecordList);
        } catch (Exception e) {
            return HttpResponse.failure(0, "数据库访问错误");
        }

    }
}
