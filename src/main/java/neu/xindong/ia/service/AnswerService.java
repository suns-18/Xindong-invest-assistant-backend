package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.dto.Question;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.QuestionTitle;

import java.util.List;

public interface AnswerService extends IService<Answer> {
    List<Answer> findAll();

    Answer findAnswerFromAntiRiskQuestion();
    Answer findAnswerFromStabilityQuestion();
    Answer findAnswerFromReturnRateQuestion();


}
