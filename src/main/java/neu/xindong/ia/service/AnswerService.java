package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.dto.Question;
import neu.xindong.ia.entity.Answer;

import java.util.List;

public interface AnswerService extends IService<Answer> {
    List<Answer> findAll();

    Answer findAntiRiskQuestionFromAnswer();
    Answer findStabilityQuestionFromAnswer();
    Answer findReturnRateQuestionFromAnswer();

    Integer findAnswerAntiRiskByQuestion(Question question);
}
