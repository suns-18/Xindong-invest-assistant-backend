package neu.xindong.ia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.response.Question;
import neu.xindong.ia.dto.response.RiskConfigResult;
import neu.xindong.ia.service.AnswerService;
import neu.xindong.ia.service.QuestionOptionService;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/riskConfigResult")
@Tag(name = "风险反馈接口", description = "定义风险反馈接口")
public class RiskConfigResultController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionOptionService questionOptionService;
    @GetMapping(value = "/queryResult")
    @Operation(summary = "获取问卷反馈",
            description = "返回问卷反馈指标")
    public HttpResponse<RiskConfigResult> getRiskConfigResult() {
        try {
            var riskConfigResult = new RiskConfigResult();
            var valueFromAntiRiskQuestion = (questionOptionService.findOptionValueByAnswer
                    (answerService.findAnswerFromAntiRiskQuestion()).getValue())/5.00;
            riskConfigResult.setAntiRisk(valueFromAntiRiskQuestion);
            var valueFromReturnRateQuestion = (questionOptionService.findOptionValueByAnswer
                    (answerService.findAnswerFromReturnRateQuestion()).getValue())/4.00;
            riskConfigResult.setReturnRate(valueFromReturnRateQuestion);
            var valueFromStabilityQuestion = (questionOptionService.findOptionValueByAnswer
                    (answerService.findAnswerFromStabilityQuestion()).getValue())/6.00;
            riskConfigResult.setStability(valueFromStabilityQuestion);
            return HttpResponse.success(riskConfigResult);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访" +
                            "问错误");
        }
    }
}
