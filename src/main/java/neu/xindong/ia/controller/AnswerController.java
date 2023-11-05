package neu.xindong.ia.controller;

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
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    // 获取所有答案
    @GetMapping("/all")
    public HttpResponse getAllAnswers() {
        List<Answer> answers = answerService.findAll();
        return HttpResponse.builder()
                .code(200)
                .message("成功获取用户填写的风险问卷的答案")
                .data(answers)
                .build();
    }

    @GetMapping("/antiRisk")
    public HttpResponse getAnswerAntiRiskByQuestion() {
        Answer antiRiskAnswer = answerService.findAntiRiskQuestionFromAnswer();
        try {
            if (antiRiskAnswer != null) {
                return HttpResponse.builder()
                        .code(200)
                        .message("成功获取对应问题答案的收益率")
                        .data(antiRiskAnswer)
                        .build();
            } else {
                return HttpResponse.builder()
                        .code(0)
                        .message("收益率获取失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }

    }

    @GetMapping("/stability")
    public HttpResponse getStabilityQuestionFromAnswer() {
        Answer stabilityAnswer = answerService.findStabilityQuestionFromAnswer();
        try {
            if (stabilityAnswer != null) {
                return HttpResponse.builder()
                        .code(200)
                        .message("成功获取对应问题答案的稳定性")
                        .data(stabilityAnswer)
                        .build();
            } else {
                return HttpResponse.builder()
                        .code(0)
                        .message("稳定性指标获取失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }

    }

    @GetMapping("/returnRate")
    public HttpResponse getReturnRateQuestionFromAnswer() {
        Answer returnRateAnswer = answerService.findReturnRateQuestionFromAnswer();
        try {
            if (returnRateAnswer != null) {
                return HttpResponse.builder()
                        .code(200)
                        .message("成功获取对应问题答案的收益率")
                        .data(returnRateAnswer)
                        .build();
            } else {
                return HttpResponse.builder()
                        .code(0)
                        .message("收益率获取失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }

    }

    // 根据问题ID获取答案的风险偏好值
    @GetMapping("/antiRisk/question")
    public HttpResponse getAnswerAntiRiskByQuestion(@RequestBody QuestionTitle question) {
        Integer antiRiskValue = answerService.findAnswerAntiRiskByQuestion(question);
        try {
            if (antiRiskValue != null) {
                return HttpResponse.builder()
                        .code(200)
                        .message("成功获取对应问题答案的风险偏好值")
                        .data(antiRiskValue)
                        .build();
            } else {
                return HttpResponse.builder()
                        .code(0)
                        .message("风险偏好值获取失败")
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