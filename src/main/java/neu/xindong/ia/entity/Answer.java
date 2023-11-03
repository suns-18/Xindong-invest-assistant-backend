package neu.xindong.ia.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("answer")
public class Answer {
    @TableId
    private Integer id;
    private Integer question;
    @TableField("`option`")
    private Integer option;
}
