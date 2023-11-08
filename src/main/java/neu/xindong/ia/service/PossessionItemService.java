package neu.xindong.ia.service;

import neu.xindong.ia.dto.response.PossessionItem;

import java.util.List;


public interface PossessionItemService {
    /*List<Possession> findAll();
    boolean addPossession(TradeRecord tradeRecord);
    boolean updatePossessionWhenSell(TradeRecord tradeRecord);
    boolean updatePossessionWhenBuy(TradeRecord tradeRecord);*/
    List<PossessionItem> findAll();

}
