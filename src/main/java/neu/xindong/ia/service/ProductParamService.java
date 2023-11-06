package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.ProductParam;

public interface ProductParamService extends IService<ProductParam> {
    ProductParam findParamByProduct(Integer id);
}
