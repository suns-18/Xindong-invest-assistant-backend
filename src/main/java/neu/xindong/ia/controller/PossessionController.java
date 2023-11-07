package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.PossessionItem;
import neu.xindong.ia.dto.PossessionStat;
import neu.xindong.ia.service.PossessionItemService;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.service.TradeRecordService;
import neu.xindong.ia.utils.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/possession")
public class PossessionController {
    @Autowired
    private PossessionItemService possessionItemService;
    @Autowired
    private TradeRecordService tradeRecordService;
    @Autowired
    private ProductService productService;

    @GetMapping("/possessionStat")
    public HttpResponse<PossessionStat> getPossessionStat() {
        try {
            var records = tradeRecordService.findAll();
            var purchasedProducts = productService.findAll();
            List<PossessionItem> possessions = possessionItemService.findAll();

            PossessionStat possessionStat = new PossessionStat();

            possessionStat.setList(possessions);

            possessionStat.setTotalAssets(Calculate.calculateTotalAssets(records));

            possessionStat.setTotalCurrentPrice(
                    Calculate.calculateTotalCurrentPrice(purchasedProducts, records));

            possessionStat.setDailyProfit(
                    Calculate.calculateDailyProfit(purchasedProducts, records));

            return HttpResponse.success(possessionStat);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(0, "数据库访问错误");
        }
    }

   /* public List<PossessionItem>  getAllPossessionItem() {

            List<PossessionItem> possessions = possessionItemService.findAll();
            return possessions;

    }*/

   /* public Double getTotalAssets(){

            var records = tradeRecordService.findAll();
            var totalAssets =Calculate.calculateTotalAssets(records);
            return totalAssets;

    }

    public Double getTotalCurrentPrice(){

            var records = tradeRecordService.findAll();
            var purchasedProducts = productService.findAll();
            var totalCurrentPrice =Calculate.calculateTotalCurrentPrice(purchasedProducts,records);
            return totalCurrentPrice;

    }

    public Double calculateDailyProfit() {

        var records = tradeRecordService.findAll();
        var purchasedProducts = productService.findAll();
        var totalDailyProfit = Calculate.calculateDailyProfit(purchasedProducts, records);
        return totalDailyProfit;

    }*/
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