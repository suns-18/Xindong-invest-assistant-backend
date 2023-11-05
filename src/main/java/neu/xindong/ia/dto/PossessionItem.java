package neu.xindong.ia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.entity.Product;

import java.util.Date;
@Data
public class PossessionItem {
    private Product product;
    private Double purchasePrice;//成本
    private Integer amount;//持仓
    private Date purchaseDate;//购买时间（只买一次）
}
