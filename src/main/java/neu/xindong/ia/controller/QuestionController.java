package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.Question;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @GetMapping(value="/queryList")
    public HttpResponse queryList(){
        /*展示所有问题及对应选项*/
        HttpResponse resp = null;
        try {
            /*question.getOptions();
            resp =;*/
            /*resp.setCode(1);
            resp.setMessage("查询成功");*/
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
