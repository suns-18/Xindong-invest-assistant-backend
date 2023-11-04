package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;

import java.util.List;

/**code by ryr
 * abstract method
 */
public interface TradeRecordService extends IService<TradeRecord> {
    List<TradeRecord> findAll();
    List<TradeRecord> findTradeRecordByProductId(Product product);

}
