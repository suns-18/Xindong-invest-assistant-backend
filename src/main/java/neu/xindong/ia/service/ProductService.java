package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.dto.ProductCom;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.QuestionOption;

import java.io.Serializable;
import java.util.List;

public interface ProductService extends IService<Product> {

    List<Product> sortProductByRisk();


    List<Product> sortProductByFlexibility();

    List<Product> sortProductByReturn();

    List<ProductCom> sortProductByComprehensive(List<QuestionOption> questionOptionAntiRisk,
                                                List<QuestionOption> questionOptionStability,
                                                List<QuestionOption> questionOptionReturn);
    List<Product> findAll();
}
