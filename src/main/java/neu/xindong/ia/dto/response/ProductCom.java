package neu.xindong.ia.dto.response;

import lombok.Data;
import neu.xindong.ia.entity.Product;
@Data
public class ProductCom {
    private Product product;
    private Double comprehensive;
}
