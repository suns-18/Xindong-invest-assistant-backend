package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.QuestionOptionDao;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.service.QuestionOptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionOptionServiceImpl
        extends ServiceImpl<QuestionOptionDao, QuestionOption>
        implements QuestionOptionService {



    public List<QuestionOption> findQuestionOptionsByQuestion(Integer question) {
        return query()
                .eq("question", question)
                .list();
    }
}
