package neu.xindong.ia.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@TableName("product_param")
@ToString
public class ProductParam {
    private Integer id;
    private Integer productId;
    private String param;
}
