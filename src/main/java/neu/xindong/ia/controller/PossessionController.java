package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.PossessionService;
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
    private PossessionService possessionService;
    @GetMapping("/all")
    public HttpResponse getAllPossessions() {
        List<Possession> possessions = possessionService.findAll();
        HttpResponse response = null;
        if (possessions != null && !possessions.isEmpty()) {
            response.setCode(200);
            response.setMessage("持仓信息查询成功");
            response.setData(possessions);
        } else {
            response.setCode(0);
            response.setMessage("持仓信息查询失败");
        }
        return response;
    }

    @GetMapping("/add")
    public HttpResponse addPossession(@RequestBody TradeRecord tradeRecord){
        try {
            boolean result = possessionService.addPossession(tradeRecord);
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
            boolean result = possessionService.updatePossessionWhenSell(tradeRecord);
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
            boolean result = possessionService.updatePossessionWhenBuy(tradeRecord);
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
