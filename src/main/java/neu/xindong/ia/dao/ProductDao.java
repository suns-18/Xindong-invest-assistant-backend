package neu.xindong.ia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import neu.xindong.ia.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<Product> {

}