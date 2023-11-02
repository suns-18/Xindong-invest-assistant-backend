package neu.xindong.ia.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product")
public class Product {
    @TableId
    private Integer id;
    private String name;
    private String details;
    private Double price;
    private Double antiRisk;
    private Double flexibility;
    private Double returnRate;
    private Integer state;
}
