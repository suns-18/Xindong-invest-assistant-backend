package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;

import java.util.List;

/**
 * code by ryr
 * abstract method
 */
public interface TradeRecordService extends IService<TradeRecord> {
    List<TradeRecord> findAll();//也调用总资产的数据

    List<TradeRecord> findTradeRecordByProductId(Product product);

    List<TradeRecord> findTradeRecordBySold(Integer sold);

    boolean purchase(TradeRecord record);

    boolean sell(TradeRecord record);
}
