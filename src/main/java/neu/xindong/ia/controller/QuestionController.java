package neu.xindong.ia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.Question;
import neu.xindong.ia.service.impl.QuestionOptionServiceImpl;
import neu.xindong.ia.service.impl.QuestionTitleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/question")
@Tag(name = "问卷接口", description = "定义问卷接口")
public class QuestionController {
    @Autowired
    private QuestionOptionServiceImpl optionService;
    @Autowired
    private QuestionTitleServiceImpl titleService;

    @GetMapping(value = "/queryList")
    @Operation(summary = "获取问卷",
            description = "返回所有问题描述和选项")
    public HttpResponse<List<Question>> queryList() {
        try {
            var titles = titleService.findAll();
            var questionList = new ArrayList<Question>();

            var question = new Question();
            titles.forEach(title -> {
                var options = optionService
                        .findOptionsByQuestion(title.getId());
                question.setOptions(new ArrayList<>());

                question.setTitle(title);
                question.setOptions(options);

                questionList.add(question);
            });

            return HttpResponse.success(questionList);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

}
