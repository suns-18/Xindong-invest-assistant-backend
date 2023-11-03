package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.service.AnswerService;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.service.QuestionOptionService;
import neu.xindong.ia.utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionOptionService optionService;

//    @GetMapping(value = "/queryByProductId",method= RequestMethod.POST)
//    public HttpResponse queryList(@RequestBody Product product){
//        HttpResponse resp;
//
//    }

    // 获取按风险排序的产品
    @GetMapping(value = "/sortByRisk")
    public HttpResponse getProductsSortedByRisk() {
        List<Product> products = productService.sortProductByRisk();
        return HttpResponse.builder()
                .code(200)
                .message("Products successfully sorted by risk")
                .data(products)
                .build();
    }

    // 获取按灵活性排序的产品
    @GetMapping("/sortByFlexibility")
    public HttpResponse getProductsSortedByFlexibility() {
        List<Product> products = productService.sortProductByFlexibility();
        return HttpResponse.builder()
                .code(200)
                .message("Products successfully sorted by flexibility")
                .data(products)
                .build();
    }

    @GetMapping("/sortByReturn")
    public HttpResponse getProductsSortedByReturn() {
        List<Product> products = productService.sortProductByReturn();
        return HttpResponse.builder()
                .code(200)
                .message("Products successfully sorted by return rate")
                .data(products)
                .build();
    }

    // 获取综合排序的产品
    @PostMapping("/sortByComprehensive")
    public HttpResponse getProductsSortedByComprehensive() {
        List<Product> products;
        List<Answer> answers;


        List<QuestionOption> optionsAntiRisk = new ArrayList<>();
        List<QuestionOption> optionsStability = new ArrayList<>();
        List<QuestionOption> optionsReturn = new ArrayList<>();

        answers = answerService.findAll();
        answers.forEach(e -> {
            var o = optionService.getById(e.getOption());
            switch (o.getQuestionType()) {
                case 0:
                    optionsAntiRisk.add(o);
                    break;
                case 1:
                    optionsStability.add(o);
                    break;
                case 2:
                    optionsReturn.add(o);
                    break;
            }
        });


        products = productService.sortProductByComprehensive(
                optionsAntiRisk, optionsStability, optionsReturn);
        return HttpResponse.builder()
                .code(200)
                .message("Products successfully sorted by comprehensive criteria")
                .data(products)
                .build();
    }

}
