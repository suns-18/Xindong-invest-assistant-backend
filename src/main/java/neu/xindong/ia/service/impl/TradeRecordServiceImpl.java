package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.TradeRecordDao;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TradeRecordServiceImpl extends ServiceImpl<TradeRecordDao, TradeRecord> implements TradeRecordService {
    /**
     * trade list
     * @return
     */
    public List<TradeRecord> findAll(Integer tradeRecord) {
        return query()
                .eq("tradeRecord", tradeRecord)
                .list();
    }

}
