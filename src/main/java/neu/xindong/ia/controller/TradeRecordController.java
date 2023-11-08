package neu.xindong.ia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * code by ryr
 * tradeRecordController
 */
@RestController
@RequestMapping("/api/tradeRecord")
@Tag(name = "交易记录接口", description = "定义交易记录接口")
public class TradeRecordController {
    @Autowired
    private TradeRecordService tradeRecordService;
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/queryList")
    @Operation(summary = "获取交易记录",
            description = "返回交易记录列表")
    public HttpResponse<List<TradeRecord>> getAllTradeRecord() {
        List<TradeRecord> tradeRecordList = tradeRecordService.findAll();
        return HttpResponse.success(tradeRecordList);
    }

    @GetMapping(value = "/queryByProductId")
    @Operation(summary = "查询交易记录",
            description = "通过产品编号查询，返回交易记录列表")
    public HttpResponse<List<TradeRecord>>
    getTradeRecordByProductId(
            @RequestBody Product product) {
        try {
            List<TradeRecord> tradeRecordList =
                    tradeRecordService
                            .findTradeRecordByProductId(product);
            return HttpResponse.success(tradeRecordList);
        } catch (Exception e) {
            return HttpResponse.failure(0, "数据库访问错误");
        }
    }

    @PostMapping("/purchase")
    @Operation(summary = "产品买入",
            description = "买入对应产品ID的产品，传入的数据带有，返回操作结果")
    public HttpResponse<Object> purchase(
            @RequestBody TradeRecord record) {
        try {
            tradeRecordService.purchase(record);
            return HttpResponse.success();
        } catch (Exception e) {
            return HttpResponse.failureWhenAccessDB();
        }
    }

    @PostMapping("/sell")
    @Operation(summary = "产品卖出",
            description = "卖出对应交易记录ID的产品，返回操作结果")
    public HttpResponse<Object> sell(
            @RequestBody TradeRecord record) {
        try {
            tradeRecordService.sell(record);
            return HttpResponse.success();
        } catch (Exception e) {
            return HttpResponse.failureWhenAccessDB();
        }
    }
}
