package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.PossessionitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/possession")
public class PossessionController {
    @Autowired
    private PossessionitemService possessionitemService;
    @GetMapping("/all")
    public HttpResponse getAllPossessions() {
        List<Possession> possessions = possessionitemService.findAll();
        return HttpResponse.builder()
                .code(200)
                .message("成功获取所有持仓信息")
                .build();
    }

    @GetMapping("/add")
    public HttpResponse addPossession(@RequestBody TradeRecord tradeRecord){
        try {
            boolean result = possessionitemService.addPossession(tradeRecord);
            if (result){
                return HttpResponse.builder()
                        .code(200)
                        .message("成功添加持仓记录")
                        .build();
            }else {
                return HttpResponse.builder()
                        .code(0)
                        .message("添加持仓记录失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }

    @GetMapping("/sell")
    public HttpResponse updatePossessionWhenSell(@RequestBody TradeRecord tradeRecord){
        try {
            boolean result = possessionitemService.updatePossessionWhenSell(tradeRecord);
            if (result){
                return HttpResponse.builder()
                        .code(200)
                        .message("成功更新卖出持仓记录")
                        .build();
            }else {
                return HttpResponse.builder()
                        .code(0)
                        .message("添加持仓记录失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }

    @GetMapping("/buy")
    public HttpResponse updatePossessionWhenBuy(@RequestBody TradeRecord tradeRecord){
        try {
            boolean result = possessionitemService.updatePossessionWhenBuy(tradeRecord);
            if (result){
                return HttpResponse.builder()
                        .code(200)
                        .message("成功更新买入持仓记录")
                        .build();
            }else {
                return HttpResponse.builder()
                        .code(0)
                        .message("更新买入持仓记录失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }
}
