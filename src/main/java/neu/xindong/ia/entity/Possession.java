package neu.xindong.ia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("possession")
public class Possession {
    @TableId
    private Integer id;
    private Integer productId;
    private Double purchasePrice;
    private Integer amount;
    private Integer sold;
}
