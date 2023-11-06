package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.Question;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.entity.QuestionTitle;
import neu.xindong.ia.service.impl.QuestionOptionServiceImpl;
import neu.xindong.ia.service.impl.QuestionTitleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionOptionServiceImpl questionOptionService;
    @Autowired
    private QuestionTitleServiceImpl questionTitleService;
    @GetMapping(value="/queryList")
    public HttpResponse queryList(){
        /*展示所有问题及对应选项*/
        try {
            var questions = questionTitleService.list();
            var options = questionOptionService.list();
            var question = new Question();
            var questionList = new ArrayList<Question>();

            question.setOptions(new ArrayList<>());

            for(QuestionTitle questionTitle:questions){
                for (QuestionOption questionOption:options){
                    if(questionTitle.getId().equals(questionOption.getQuestion())){
                        question.setTitle(questionTitle);
                        question.getOptions().add(questionOption);
                        questionList.add(question);
                    }
                }
            }
            return HttpResponse.builder()
                    .code(200)
                    .data(questionList)
                    .message("查询成功")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }

    }

}
