package neu.xindong.ia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

// 加上@Data注解，自动帮你生成Getter和Setter
// 加上@TableName注解，括号里写上表的名字
// 加上@TableId注解，表示对应属性是数据库表的主码（键）
// 数据库文档中的下划线表示单词间隔，类名单词首字母必须大写（大驼峰）
// 变量名是小驼峰
@Data
@TableName("question_title")
@ToString
public class QuestionTitle {
    @TableId
    private Integer id;
    private String title;
}
