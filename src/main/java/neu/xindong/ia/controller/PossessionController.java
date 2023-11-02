package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.service.impl.AnswerServiceImpl;
import neu.xindong.ia.service.impl.PossessionServiceImpl;
import neu.xindong.ia.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("./api/possession")
public class PossessionController {
    private PossessionServiceImpl possessionService;
    @GetMapping
    public HttpResponse getAllPossessions() {
        List<Possession> possessions = possessionService.findAll();
        HttpResponse response = null;
        if (possessions != null && !possessions.isEmpty()) {
            response.setCode(1);
            response.setMessage("持仓信息查询成功");
            response.setData(possessions);
        } else {
            response.setCode(0);
            response.setMessage("持仓信息查询失败");
        }
        return response;
    }

}
