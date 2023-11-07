package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.QuestionOptionDao;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.service.QuestionOptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionOptionServiceImpl
        extends ServiceImpl<QuestionOptionDao, QuestionOption>
        implements QuestionOptionService {
    /**
     * option list
     *
     * @param question
     * @return
     */
    public List<QuestionOption> findOptionsByQuestion(Integer question) {
        return query()
                .eq("question", question)
                .list();
    }

    /**
     * Code by ryr
     * get key question's userOption
     *
     * @param answer
     * @return
     */
    public QuestionOption findOptionValueByAnswer(Answer answer) {
//        return query().eq("id",answer.getOption()).getEntity();
        return getById(answer.getOption());
    }

}
