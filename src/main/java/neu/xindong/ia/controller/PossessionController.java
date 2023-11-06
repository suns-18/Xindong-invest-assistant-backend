package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.PossessionItem;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.PossessionItemService;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.service.TradeRecordService;
import neu.xindong.ia.utils.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/possessionItem")
public class PossessionController {
    @Autowired
    private PossessionItemService possessionItemService;
    @Autowired
    private TradeRecordService tradeRecordService;
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public HttpResponse getAllPossessionItem() {
        try {
        List<PossessionItem> possessions = possessionItemService.findAll();
        return HttpResponse.builder()
                .code(200)
                .data(possessions)
                .message("成功获取所有持仓信息")
                .build();
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }
    @GetMapping("/totalAssets")
    public HttpResponse getTotalAssets(){
        try {
            var records = tradeRecordService.findAll();
            var totalAssets =Calculate.calculateTotalAssets(records);
            return HttpResponse.builder()
               .code(200)
               .data(totalAssets)
               .message("成功获取总资产信息")
               .build();
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }
    @GetMapping("/totalCurrentPrice")
    public HttpResponse getTotalCurrentPrice(){
        try {
            var records = tradeRecordService.findAll();
            var purchasedProducts = productService.findAll();
            var totalCurrentPrice =Calculate.calculateTotalCurrentPrice(purchasedProducts,records);
            return HttpResponse.builder()
                    .code(200)
                    .data(totalCurrentPrice)
                    .message("成功获取总资产信息")
                    .build();
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }
    @GetMapping("/totalDailyProfit")
    public HttpResponse calculateDailyProfit(){
        try {
            var records = tradeRecordService.findAll();
            var purchasedProducts = productService.findAll();
            var totalDailyProfit =Calculate.calculateDailyProfit(purchasedProducts,records);
            return HttpResponse.builder()
                    .code(200)
                    .data(totalDailyProfit)
                    .message("成功获取总资产信息")
                    .build();
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }

//    @GetMapping("/add")
//    public HttpResponse addPossession(@RequestBody TradeRecord tradeRecord){
//        try {
//            boolean result = possessionItemService.addPossession(tradeRecord);
//            if (result){
//                return HttpResponse.builder()
//                        .code(200)
//                        .message("成功添加持仓记录")
//                        .build();
//            }else {
//                return HttpResponse.builder()
//                        .code(0)
//                        .message("添加持仓记录失败")
//                        .build();
//            }
//        } catch (Exception e) {
//            return HttpResponse.builder()
//                    .code(0)
//                    .message("数据库访问错误")
//                    .build();
//        }
//    }
//
//    @GetMapping("/sell")
//    public HttpResponse updatePossessionWhenSell(@RequestBody TradeRecord tradeRecord){
//        try {
//            boolean result = possessionitemService.updatePossessionWhenSell(tradeRecord);
//            if (result){
//                return HttpResponse.builder()
//                        .code(200)
//                        .message("成功更新卖出持仓记录")
//                        .build();
//            }else {
//                return HttpResponse.builder()
//                        .code(0)
//                        .message("添加持仓记录失败")
//                        .build();
//            }
//        } catch (Exception e) {
//            return HttpResponse.builder()
//                    .code(0)
//                    .message("数据库访问错误")
//                    .build();
//        }
//    }
//
//    @GetMapping("/buy")
//    public HttpResponse updatePossessionWhenBuy(@RequestBody TradeRecord tradeRecord){
//        try {
//            boolean result = possessionitemService.updatePossessionWhenBuy(tradeRecord);
//            if (result){
//                return HttpResponse.builder()
//                        .code(200)
//                        .message("成功更新买入持仓记录")
//                        .build();
//            }else {
//                return HttpResponse.builder()
//                        .code(0)
//                        .message("更新买入持仓记录失败")
//                        .build();
//            }
//        } catch (Exception e) {
//            return HttpResponse.builder()
//                    .code(0)
//                    .message("数据库访问错误")
//                    .build();
//        }
//    }
}
