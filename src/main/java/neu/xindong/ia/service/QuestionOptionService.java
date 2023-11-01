package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.QuestionOption;

public interface QuestionOptionService extends IService<QuestionOption> {
    /*插入一条记录*/
    boolean save(QuestionOption entity);

}

