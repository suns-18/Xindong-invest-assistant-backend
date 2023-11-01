package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("./api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/queryByProductId",method= RequestMethod.POST)
    public HttpResponse queryList(@RequestBody Product product){
        HttpResponse resp;

    }

    // 获取按风险排序的产品
    @GetMapping(value = "/sortByRisk",method= )
    public HttpResponse getProductsSortedByRisk() {

    }

}
