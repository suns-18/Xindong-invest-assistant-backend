package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.ProductDao;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product>
        implements ProductService {
    public List<Product> sortProductByRisk(){
        List<Product> result=query().orderBy(true,false,"anti_risk").list();
        return result;
    }
    public List<Product> sortProductByFlexibility(){
        List<Product> result=query().orderBy(true,false,"flexibility").list();
        return result;
    }
    public List<Product> sortProductByReturn(){
        List<Product> result=query().orderBy(true,false,"return_rate").list();
        return result;
    }
    public List<Product> sortProductByComprehensive(Product product, Answer answer){
        List<Product> result=null;

        return result;
    }

}
