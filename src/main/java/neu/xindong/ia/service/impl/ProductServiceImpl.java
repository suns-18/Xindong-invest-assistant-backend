package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    public List<Product> findAll() {
        return list();
    }

    /**
     * get product by id
     * @param id
     * @return
     */
    public Product findProductById(Integer id) {
        return getById(id);
    }

    /**
     * code by ryr
     * sort product By Risk
     *
     * @return
     */
    public List<Product> sortProductByRisk() {
        List<Product> result = query().orderBy(true, false, "anti_risk").list();
        return result;
    }

    /**
     * code by ryr
     * sort product by flexibility
     *
     * @return
     */
    public List<Product> sortProductByFlexibility() {
        List<Product> result = query().orderBy(true, false, "flexibility").list();
        return result;
    }

    /**
     * code by ryr
     * sort product by return rate
     *
     * @return
     */
    public List<Product> sortProductByReturn() {
        List<Product> result = query().orderBy(true, false, "return_rate").list();
        return result;
    }

    public List<ProductCom> sortProductByComprehensive(List<QuestionOption> optionAntiRisk,
                                                       List<QuestionOption> optionStability,
                                                       List<QuestionOption> optionReturn) {

        var productList = findAll();

        var valueAntiRisk = optionAntiRisk.stream()
                .mapToInt(QuestionOption::getValue).sum();

        var valueStability = optionStability.stream()
                .mapToInt(QuestionOption::getValue).sum();

        var valueReturn = optionReturn.stream()
                .mapToInt(QuestionOption::getValue).sum();


        return Calculate.calculateComprehensive(valueAntiRisk,
                valueStability,
                valueReturn,
                productList);
    }
    public List<Product> findFavProduct(){
        var FavList=new ArrayList<Product>();
        var ProductList=this.findAll();
        for(Product product:ProductList){
            if(product.getState()==1){
                FavList.add(product);
            }
        }
        return FavList;
    }

    /**
     * change fav state
     * @param product
     * @return
     */
    public boolean changeFavState(Product product){
        if(product.getState()==1){
            product.setState(0);
            return updateById(product);
        }else if(product.getState()==0){
            product.setState(1);
            return updateById(product);
        }
        return false;
    }
}
