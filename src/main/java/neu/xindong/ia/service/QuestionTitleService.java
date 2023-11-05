package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.QuestionTitle;

import java.util.List;

public interface QuestionTitleService extends IService<QuestionTitle> {
    List<QuestionTitle> findQuestionTitleByQuestion(Integer question);
}
