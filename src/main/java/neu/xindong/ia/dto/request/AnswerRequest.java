package neu.xindong.ia.dto.request;


import neu.xindong.ia.entity.Answer;

import java.util.List;

public record AnswerRequest(
        List<Answer> answers) {
}
