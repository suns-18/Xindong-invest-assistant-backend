package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.QuestionOption;

import java.util.List;

public interface QuestionOptionService extends IService<QuestionOption> {
    List<QuestionOption> findQuestionOptionsByQuestion(Integer question);
    QuestionOption findOptionValueByAnswer(Answer answer);
}

