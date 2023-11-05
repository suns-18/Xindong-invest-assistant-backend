package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.dto.PossessionItem;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.entity.TradeRecord;

import java.util.List;


public interface PossessionItemService {
    /*List<Possession> findAll();
    boolean addPossession(TradeRecord tradeRecord);
    boolean updatePossessionWhenSell(TradeRecord tradeRecord);
    boolean updatePossessionWhenBuy(TradeRecord tradeRecord);*/
    List<PossessionItem> findAll();

}
