package neu.xindong.ia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.response.TradeRecordDto;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    public HttpResponse<List<TradeRecordDto>> getAllTradeRecord() {
        List<TradeRecord> tradeRecordList = tradeRecordService.findAll();
        return getListHttpResponse(tradeRecordList);
    }

    @GetMapping(value = "/queryByProductId")
    @Operation(summary = "查询交易记录",
            description = "通过产品编号查询，返回交易记录列表")
    public HttpResponse<List<TradeRecordDto>>
    getTradeRecordByProductId(
            @RequestParam Integer id) {
        try {
            List<TradeRecord> tradeRecordList =
                    tradeRecordService
                            .findTradeRecordByProductId(id);
            Collections.sort(tradeRecordList, new Comparator<TradeRecord>() {
                @Override
                public int compare(TradeRecord o1, TradeRecord o2) {
                    return o2.getDealTime().compareTo(o1.getDealTime());
                }
            });
            return getListHttpResponse(tradeRecordList);
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
            e.printStackTrace();
            return HttpResponse.failureWhenAccessDB();
        }
    }


    private HttpResponse<List<TradeRecordDto>> getListHttpResponse(
            List<TradeRecord> tradeRecordList) {
        var dtoList = new ArrayList<TradeRecordDto>();

        tradeRecordList.forEach((record -> {
            var dtoItem = TradeRecordDto.builder()
                    .id(record.getId())
                    .sold(record.getSold())
                    .amount(record.getAmount())
                    .price(record.getPrice())
                    .dealTime(record.getDealTime())
                    .product(productService
                            .findProductById(record.getProductId()))
                    .build();
            dtoList.add(dtoItem);
        }));
        Collections.sort(dtoList, new Comparator<TradeRecordDto>() {
            @Override
            public int compare(TradeRecordDto o1, TradeRecordDto o2) {
                return o2.getDealTime().compareTo(o1.getDealTime());
            }
        });

        return HttpResponse.success(dtoList);
    }
}
