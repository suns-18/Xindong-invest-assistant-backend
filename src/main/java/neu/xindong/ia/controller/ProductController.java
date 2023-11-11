package neu.xindong.ia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import neu.xindong.ia.dto.HttpResponse;
import neu.xindong.ia.dto.response.ProductCom;
import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.ProductParam;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.service.AnswerService;
import neu.xindong.ia.service.ProductParamService;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.service.QuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "产品接口", description = "定义产品接口")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionOptionService optionService;
    @Autowired
    private ProductParamService productParamService;


    @GetMapping("/all")
    @Operation(summary = "获取所有产品",
            description = "返回所有产品的列表")
    public HttpResponse<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.findAll();
            return HttpResponse.success(products);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }
    @GetMapping("/getById")
    @Operation(summary = "根据id获取产品",
            description = "返回对应id的产品")
    public HttpResponse<Product> getById(@RequestParam int id) {
        try {
            var product = productService.getById(id);
            return HttpResponse.success(product);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @GetMapping("/fav")
    @Operation(summary = "获取已收藏产品",
            description = "返回已收藏产品的列表")
    public HttpResponse<List<Product>> getFavProducts() {
        try {
            List<Product> favProducts =
                    productService.findFavProducts();

            return HttpResponse.success(favProducts);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    // 获取按风险排序的产品
    @GetMapping(value = "/sortByRisk")
    @Operation(summary = "按产品非风险性排序",
            description = "返回排序后的产品列表")
    public HttpResponse<List<Product>> getProductsSortedByRisk() {
        try {
            List<Product> products = productService.sortProductByRisk();
            return HttpResponse.success(products);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    // 获取按灵活性排序的产品
    @GetMapping("/sortByFlexibility")
    @Operation(summary = "按产品灵活度排序",
            description = "返回排序后的产品列表")
    public HttpResponse<List<Product>> getProductsSortedByFlexibility() {
        try {
            List<Product> products = productService.sortProductByFlexibility();
            return HttpResponse.success(products);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @GetMapping("/sortByReturn")
    @Operation(summary = "按产品收益率排序",
            description = "返回排序后的产品列表")
    public HttpResponse<List<Product>> getProductsSortedByReturn() {
        try {
            List<Product> products = productService.sortProductByReturn();
            return HttpResponse.success(products);

        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    // 获取综合排序的产品
    @GetMapping("/sortByComprehensive")
    @Operation(summary = "按产品综合指标排序",
            description = "返回排序后的产品列表")
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
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @PostMapping("/changeFavState")
    @Operation(summary = "产品收藏状态更改",
            description = "对某一Id产品进行收藏或取消收藏的操作，返回操作结果")
    public HttpResponse<Object> changeFavState(
            @RequestBody Product product) {
        try {
            productService.changeFavState(product);
            return HttpResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "操作失败，数据库访问错误");
        }
    }

    @GetMapping("/sortByReturnPart")
    @Operation(summary = "搜索产品并按收益率排序",
            description = "返回排序后的产品列表")
    public HttpResponse<List<Product>> getProductsSortedByReturn(@RequestParam String name) {
        try {
            List<Product> products = productService.sortProductByReturn(name);
            return HttpResponse.success(products);

        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @GetMapping(value = "/sortByRiskPart")
    @Operation(summary = "搜索产品并按非风险性排序",
            description = "返回排序后的产品列表")
    public HttpResponse<List<Product>> getProductsSortedByRisk(@RequestParam String name) {
        try {
            List<Product> products = productService.sortProductByRisk(name);
            return HttpResponse.success(products);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @GetMapping("/sortByFlexibilityPart")
    @Operation(summary = "搜索产品并按灵活度排序",
            description = "返回排序后的产品列表")
    public HttpResponse<List<Product>> getProductsSortedByFlexibility(@RequestParam String name) {
        try {
            List<Product> products = productService.sortProductByFlexibility(name);
            return HttpResponse.success(products);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @GetMapping("/sortByComprehensivePart")
    @Operation(summary = "搜索产品并按综合指标排序",
            description = "返回排序后的产品列表")
    public HttpResponse<List<ProductCom>> getProductsSortedByComprehensive(@RequestParam String name) {
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
                    optionsAntiRisk, optionsStability, optionsReturn,name);

            return HttpResponse.success(products);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }
    @GetMapping("/queryProductByName")
    @Operation(summary = "搜索产品",
            description = "返回有关的产品列表")
    public HttpResponse<List<Product>> queryProductByName(@RequestParam String name){
        try {
            List<Product> products = productService.queryProductByName(name);
            return HttpResponse.success(products);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }

    @GetMapping("/findParamById")
    @Operation(summary = "获取产品链接参数",
            description = "返回产品链接参数")
    public HttpResponse<ProductParam> findParamById(@RequestParam Integer id){
        try {
            ProductParam productParam = productParamService.findParamByProduct(id);
            return HttpResponse.success(productParam);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.failure(
                    0, "数据库访问错误");
        }
    }



}
