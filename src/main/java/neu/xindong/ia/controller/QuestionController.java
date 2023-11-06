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
        HttpResponse resp = null;
        try {
            var questions = questionTitleService.list();
            var options = questionOptionService.list();
            var question = new Question();
            var questionList = new ArrayList<Question>();
            for(QuestionTitle questionTitle:questions){
                for (QuestionOption questionOption:options){
                    if(questionTitle.getId().equals(questionOption.getQuestion())){
                        question.setTitle(questionTitle);
                        question.getOptions().add(questionOption);
                        questionList.add(question);
                    }
                }
            }
            resp.setCode(1);
            resp.setData(questionList);
            resp.setMessage("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            resp = HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
        return resp;
    }

}
