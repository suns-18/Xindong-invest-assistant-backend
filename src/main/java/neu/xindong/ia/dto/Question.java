package neu.xindong.ia.dto;

import lombok.Data;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.entity.QuestionTitle;

@Data
public class Question {
    private QuestionTitle title;
    private QuestionOption options;
}
