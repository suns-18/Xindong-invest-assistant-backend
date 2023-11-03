package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.entity.TradeRecord;

import java.util.List;

public interface PossessionService extends IService<Possession> {
    List<Possession> findAll();
    boolean addPossession(TradeRecord tradeRecord);
    boolean updatePossessionWhenSell(TradeRecord tradeRecord);
    boolean updatePossessionWhenBuy(TradeRecord tradeRecord);
}
