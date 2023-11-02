package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.service.PossessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/possession")
public class PossessionController {
    @Autowired
    private PossessionService possessionService;
    @GetMapping
    public HttpResponse getAllPossessions() {
        List<Possession> possessions = possessionService.findAll();
        HttpResponse response = null;
        if (possessions != null && !possessions.isEmpty()) {
            response.setCode(200);
            response.setMessage("持仓信息查询成功");
            response.setData(possessions);
        } else {
            response.setCode(0);
            response.setMessage("持仓信息查询失败");
        }
        return response;
    }

}
