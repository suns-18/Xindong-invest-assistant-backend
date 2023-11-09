package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.dto.response.ProductCom;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.QuestionOption;

import java.util.List;

public interface ProductService extends IService<Product> {

    List<Product> sortProductByRisk();


    List<Product> sortProductByFlexibility();

    List<Product> sortProductByReturn();

    List<ProductCom> sortProductByComprehensive(List<QuestionOption> questionOptionAntiRisk,
                                                List<QuestionOption> questionOptionStability,
                                                List<QuestionOption> questionOptionReturn);
    List<Product> findAll();
    Product findProductById(Integer id);

    List<Product> findFavProducts();//展示收藏产品列表

    boolean changeFavState(Product product);//添加或取消收藏产品

    List<Product> queryProductByName(String name);
}
