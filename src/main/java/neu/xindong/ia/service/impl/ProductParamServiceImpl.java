package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.ProductParamDao;
import neu.xindong.ia.entity.ProductParam;
import neu.xindong.ia.service.ProductParamService;
import org.springframework.stereotype.Service;

@Service
public class ProductParamServiceImpl extends ServiceImpl<ProductParamDao,ProductParam>
        implements ProductParamService {
    /**
     * get product param by productId
     * @param id
     * @return
     */
    public ProductParam findParamByProduct(Integer id){
        return query().eq("productId",id).list().get(0);
    }

}
