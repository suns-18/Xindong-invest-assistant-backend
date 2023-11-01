package neu.xindong.ia.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("product")
public class Product {
    @TableId
    private Integer id;
    private String name;
    private String details;
    private Double price;
    private Double anti_risk;
    private Double flexibility;
    private Double return_rate;
    private Integer state;

}
