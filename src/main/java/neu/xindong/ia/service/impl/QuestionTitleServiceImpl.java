package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.QuestionTitleDao;
import neu.xindong.ia.entity.QuestionTitle;
import neu.xindong.ia.service.QuestionTitleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTitleServiceImpl extends ServiceImpl<QuestionTitleDao, QuestionTitle>
        implements QuestionTitleService {
    /*public List<QuestionTitle> findAll(){
    }*/
}
