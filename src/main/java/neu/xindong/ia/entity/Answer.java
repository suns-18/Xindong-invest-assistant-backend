package neu.xindong.ia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("answer")
public class Answer {
    @TableId
    private Integer id;
    private Integer question;
    private Integer option;
}
