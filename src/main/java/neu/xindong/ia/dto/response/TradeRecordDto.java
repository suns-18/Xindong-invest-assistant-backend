package neu.xindong.ia.dto.response;

import lombok.experimental.SuperBuilder;
import neu.xindong.ia.entity.Product;

import java.util.Date;

@SuperBuilder
public class TradeRecordDto {
    Integer id;
    Product product;
    Double price;
    Integer amount;
    Date dealTime;
    Integer sold;
}
