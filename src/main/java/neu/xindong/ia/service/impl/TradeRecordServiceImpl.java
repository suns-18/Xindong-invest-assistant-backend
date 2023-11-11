package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.TradeRecordDao;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TradeRecordServiceImpl extends ServiceImpl<TradeRecordDao, TradeRecord> implements TradeRecordService {
    /**
     * trade list
     *
     * @return
     */
    public List<TradeRecord> findAll() {
        return query().list();
    }

    /**
     * get tradeRecord by product id
     *
     * @param product_id
     * @return
     */
    public List<TradeRecord> findTradeRecordByProductId(Integer id) {
        return query().like("product_id", id).list();
    }

    /**
     * find sold record list and unsold record list
     *
     * @param sold
     * @return
     */
    public List<TradeRecord> findTradeRecordBySold(Integer sold) {
        return query().eq("sold", sold).list();
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean purchase(TradeRecord record) {
        record.setDealTime(new Date());
        int num = (int) count();
        record.setId(num + 1);
        record.setSold(0);
        return save(record);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean sell(TradeRecord record) {
        record.setDealTime(new Date());
        int num = (int) count();
        record.setId(num + 1);
        record.setSold(1);

        return save(record);
    }


}
