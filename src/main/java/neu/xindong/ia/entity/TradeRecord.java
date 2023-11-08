package neu.xindong.ia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@TableName("trade_record")
@ToString
public class TradeRecord {
    @TableId
    private Integer id;
    private Integer productId;
    private Double price; // 建议改为cost
    private Integer amount;
    private Date dealTime;
    private Integer sold;
}