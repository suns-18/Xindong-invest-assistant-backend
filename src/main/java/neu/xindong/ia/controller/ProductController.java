package neu.xindong.ia.controller;

import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.ProductCom;
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


    @GetMapping("/all")
    public HttpResponse<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.findAll();
            return HttpResponse.success(products);
        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    // 获取按风险排序的产品
    @GetMapping(value = "/sortByRisk")
    public HttpResponse<List<Product>> getProductsSortedByRisk() {
        try {
            List<Product> products = productService.sortProductByRisk();
            return HttpResponse.success(products);
        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    // 获取按灵活性排序的产品
    @GetMapping("/sortByFlexibility")
    public HttpResponse<List<Product>> getProductsSortedByFlexibility() {
        try {
            List<Product> products = productService.sortProductByFlexibility();
            return HttpResponse.success(products);
        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @GetMapping("/sortByReturn")
    public HttpResponse<List<Product>> getProductsSortedByReturn() {
        try {
            List<Product> products = productService.sortProductByReturn();
            return HttpResponse.success(products);

        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    // 获取综合排序的产品
    @PostMapping("/sortByComprehensive")
    public HttpResponse<List<ProductCom>> getProductsSortedByComprehensive() {
        try {
            List<ProductCom> products;
            List<Answer> answers;

            List<QuestionOption> optionsAntiRisk = new ArrayList<>();
            List<QuestionOption> optionsStability = new ArrayList<>();
            List<QuestionOption> optionsReturn = new ArrayList<>();

            answers = answerService.findAll();
            answers.forEach(e -> {
                var o = optionService.getById(e.getOption());
                switch (o.getQuestionType()) {
                    case 0 -> optionsAntiRisk.add(o);
                    case 1 -> optionsStability.add(o);
                    case 2 -> optionsReturn.add(o);
                }
            });

            products = productService.sortProductByComprehensive(
                    optionsAntiRisk, optionsStability, optionsReturn);

            return HttpResponse.success(products);
        } catch (Exception e) {
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

}
