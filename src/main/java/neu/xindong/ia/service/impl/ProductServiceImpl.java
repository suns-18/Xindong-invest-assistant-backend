package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.ProductDao;
import neu.xindong.ia.dto.ProductCom;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.utils.Calculate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product>
        implements ProductService {
    List<Product> findAll(){
        return list();
    }
    /**code by ryr
     * sort product By Risk
     * @return
     */
    public List<Product> sortProductByRisk(){
        List<Product> result=query().orderBy(true,false,"anti_risk").list();
        return result;
    }
    /**code by ryr
     * sort product by flexibility
     * @return
     */
    public List<Product> sortProductByFlexibility(){
        List<Product> result=query().orderBy(true,false,"flexibility").list();
        return result;
    }
    /**code by ryr
     * sort product by return rate
     * @return
     */
    public List<Product> sortProductByReturnRate(){
        List<Product> result=query().orderBy(true,false,"return_rate").list();
        return result;
    }
    public List<ProductCom> sortProductByComprehensive(List<QuestionOption> questionOptionAntiRisk,
                                                       List<QuestionOption> questionOptionStability,
                                                       List<QuestionOption> questionOptionReturn){

        var productList = findAll();

        //var optionAntiRisk = questionOptionAntiRisk.


        return Calculate.calculateComprehensive(questionOptionAntiRisk,
                                                                questionOptionStability,
                                                                questionOptionReturn,
                                                                productList);
    }

}
