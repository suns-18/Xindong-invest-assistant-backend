package neu.xindong.ia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.request.AnswerRequest;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/answer")
@Tag(name = "答案接口", description = "定义答案接口")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    // 获取所有答案
    @GetMapping("/all")
    @Operation(summary = "获取答案",
            description = "返回所有答案")
    public HttpResponse<List<Answer>> getAllAnswers() {
        try {
            List<Answer> answers = answerService.findAll();
            return HttpResponse.success(answers);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failureWhenAccessDB();
        }
    }

    @GetMapping("/antiRisk")
    @Operation(summary = "获取非风险性答案", description = "返回用户非风险性答案")
    public HttpResponse<Answer> getAnswerFromAntiRiskByQuestion() {
        try {
            Answer antiRiskAnswer
                    = answerService
                    .findAnswerFromAntiRiskQuestion();
            return HttpResponse.success(antiRiskAnswer);
        } catch (Exception e) {
            return HttpResponse.failure(0, "数据库访问错误");
        }

    }

    @GetMapping("/stability")
    @Operation(summary = "获取稳定性答案", description = "返回用户工作稳定性答案")
    public HttpResponse<Answer> getStabilityFromQuestionFromAnswer() {

        try {
            Answer stabilityAnswer =
                    answerService
                            .findAnswerFromStabilityQuestion();
            return HttpResponse.success(stabilityAnswer);

        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }

    }

    @GetMapping("/returnRate")
    @Operation(summary = "获取收益率答案", description = "返回用户期待收益率答案")
    public HttpResponse<Answer> getAnswerFromReturnRateQuestion() {
        try {
            Answer returnRateAnswer =
                    answerService.findAnswerFromReturnRateQuestion();
            return HttpResponse.success(returnRateAnswer);
        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }

    }

    @Operation(summary = "保存答案",
            description = "输入答案的集合，提交到服务器，返回提交操作的结果")
    @PostMapping("/save")
    public HttpResponse<Object> saveAnswer(
            @RequestBody AnswerRequest answerReq) {
        try {
            answerService.saveBatch(answerReq.answers());
            return HttpResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "操作失败，数据库访问错误");
        }
    }
}