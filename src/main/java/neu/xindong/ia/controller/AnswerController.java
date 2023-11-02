package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("./api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    // 获取所有答案
    @GetMapping
    public HttpResponse getAllAnswers() {
        List<Answer> answers = answerService.findAll();
        return HttpResponse.builder()
                .code(1)
                .message("成功获取用户填写的风险问卷的答案")
                .data(answers)
                .build();
    }

    // 根据问题ID获取答案的风险偏好值
//    @GetMapping("/antiRisk")
//    public HttpResponse getAnswerAntiRiskByQuestion(@RequestBody Question question) {
//        Integer antiRiskValue = answerService.findAnswerAntiRiskByQuestion(question);
//        if (antiRiskValue != null) {
//            return HttpResponse.builder()
//                    .code(1)
//                    .message("成功获取对应问题答案的风险偏好值")
//                    .data(antiRiskValue)
//                    .build();
//        } else {
//            return HttpResponse.builder()
//                    .code(0)
//                    .message("风险偏好值获取失败")
//                    .build();
//        }
//    }

}
