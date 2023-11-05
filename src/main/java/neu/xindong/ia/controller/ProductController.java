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
    public HttpResponse getAllProducts(){
        List<Product> products = productService.findAll();
        return HttpResponse.builder()
                .code(200)
                .data(products)
                .build();
    }

    // 获取按风险排序的产品
    @GetMapping(value = "/sortByRisk")
    public HttpResponse getProductsSortedByRisk() {
        try {
            List<Product> products = productService.sortProductByRisk();
            if (products != null){
                return HttpResponse.builder()
                        .code(200)
                        .message("按风险排序成功")
                        .data(products)
                        .build();
            } else{
                return HttpResponse.builder()
                        .code(0)
                        .message("按风险排序失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }

    // 获取按灵活性排序的产品
    @GetMapping("/sortByFlexibility")
    public HttpResponse getProductsSortedByFlexibility() {
        try {
            List<Product> products = productService.sortProductByFlexibility();
            if (products != null){
                return HttpResponse.builder()
                        .code(200)
                        .message("按灵活性排序成功")
                        .data(products)
                        .build();
            } else{
                return HttpResponse.builder()
                        .code(0)
                        .message("按灵活性排序失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }

    @GetMapping("/sortByReturn")
    public HttpResponse getProductsSortedByReturn() {
        try {
            List<Product> products = productService.sortProductByReturn();
            if (products != null){
                return HttpResponse.builder()
                        .code(200)
                        .message("按收益率排序成功")
                        .data(products)
                        .build();
            } else{
                return HttpResponse.builder()
                        .code(0)
                        .message("按收益率排序失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }

    // 获取综合排序的产品
    @PostMapping("/sortByComprehensive")
    public HttpResponse getProductsSortedByComprehensive() {
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
            if (products != null){
                return HttpResponse.builder()
                        .code(200)
                        .message("综合排序成功")
                        .data(products)
                        .build();
            }
            else{
                return HttpResponse.builder()
                        .code(0)
                        .message("综合排序失败")
                        .build();
            }
        } catch (Exception e) {
            return HttpResponse.builder()
                    .code(0)
                    .message("数据库访问错误")
                    .build();
        }
    }

}
