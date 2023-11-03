package neu.xindong.ia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("question_option")
public class QuestionOption {
    @TableId
    private Integer id;
    private Integer question;
    private String title;
    private Integer value;
    private Integer questionType;
}
