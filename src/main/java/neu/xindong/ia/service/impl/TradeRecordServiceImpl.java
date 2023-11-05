package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.TradeRecordDao;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TradeRecordServiceImpl extends ServiceImpl<TradeRecordDao, TradeRecord> implements TradeRecordService {
    /**code by ryr
     * trade list
     * @return
     */
    public List<TradeRecord> findAll() {
        return query().list();
    }

    /**code by ryr
     * get tradeRecord by product id
     * @param product
     * @return
     */
    public List<TradeRecord> findTradeRecordByProductId(Product product){
        return query().like("product_id",product.getId()).list();
    }
    public List<TradeRecord> findTradeRecordBySold(Integer sold){
        return null;
    }


}
