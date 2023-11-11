package neu.xindong.ia.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import neu.xindong.ia.entity.Product;

import java.util.Date;

@SuperBuilder
@Data
public class TradeRecordDto {
    Integer id;
    Product product;
    Double price;
    Integer amount;
    Date dealTime;
    Integer sold;
}
