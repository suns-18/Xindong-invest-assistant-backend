package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.AnswerDao;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.service.AnswerService;
import org.springframework.stereotype.Service;
import java.util.List;

// 必须继承ServiceImpl类，<Mapper, Entity>
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerDao, Answer>
        implements AnswerService {
    /**
     * 查询所有答案
     * @return
     */
    public List<Answer> findAll(){
        return query().list();
    }
    /**
     *根据选定的三个问题id获取对应答案
     */
    public Integer findAnswerAntiRiskByQuestion(Question question){
        return n;
    }
}
