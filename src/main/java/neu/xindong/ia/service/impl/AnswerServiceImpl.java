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
    /**Code by ryr
     * answer list
     * @return
     */
    public List<Answer> findAll(){
        return query().list();
    }
    /**Code by ryr
     * get antiRisk answer
     * @returns
     */
    public Answer findAnswerFromAntiRiskQuestion(){
        return query().eq("question",3).list().get(0);
    }

    /**Code by ryr
     * get stability answer
     * @return
     */
    public Answer findAnswerFromStabilityQuestion(){
        return query().eq("question",14).list().get(0);
    }

    /**Code by ryr
     * get returnRate answer
     * @return
     */
    public Answer findAnswerFromReturnRateQuestion(){
        return query().eq("question",4).list().get(0);
    }


}
