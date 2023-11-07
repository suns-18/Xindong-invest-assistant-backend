package neu.xindong.ia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.Question;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.QuestionTitle;
import neu.xindong.ia.service.AnswerService;
import neu.xindong.ia.service.impl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
@Tag(name = "答案接口", description = "定义答案接口")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    // 获取所有答案
    @GetMapping("/all")
    @Operation(summary="获取答案",
            description = "返回所有答案")
    public HttpResponse getAllAnswers() {
        List<Answer> answers = answerService.findAll();
        return HttpResponse.success(answers);
    }

    @GetMapping("/antiRisk")
    @Operation(summary = "获取非风险性答案",description = "返回用户非风险性答案")
    public HttpResponse getAnswerFromAntiRiskByQuestion() {
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
    @Operation(summary = "获取稳定性答案",description = "返回用户工作稳定性答案")
    public HttpResponse getStabilityFromQuestionFromAnswer() {

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
    @Operation(summary = "获取收益率答案",description = "返回用户期待收益率答案")
    public HttpResponse getAnswerFromReturnRateQuestion() {
        Answer returnRateAnswer = answerService.findAnswerFromReturnRateQuestion();
        try {
            return HttpResponse.success(returnRateAnswer);
        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }

    }

//    // 根据问题ID获取答案的风险偏好值
//    @GetMapping("/antiRisk/question")
//    public HttpResponse getAnswerAntiRiskByQuestion(@RequestBody QuestionTitle question) {
//        Integer antiRiskValue = answerService.findAnswerAntiRiskByQuestion(question);
//        try {
//            if (antiRiskValue != null) {
//                return HttpResponse.builder()
//                        .code(200)
//                        .message("成功获取对应问题答案的风险偏好值")
//                        .data(antiRiskValue)
//                        .build();
//            } else {
//                return HttpResponse.builder()
//                        .code(0)
//                        .message("风险偏好值获取失败")
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