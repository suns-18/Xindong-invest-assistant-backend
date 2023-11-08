package neu.xindong.ia.dto.response;

import lombok.Data;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.entity.QuestionTitle;

import java.util.List;

@Data
public class Question {
    private QuestionTitle title;
    private List<QuestionOption> options;
}
