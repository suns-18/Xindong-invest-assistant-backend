package neu.xindong.ia.service;

import neu.xindong.ia.dto.response.ProductCom;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.service.impl.ProductServiceImpl;
import neu.xindong.ia.service.impl.QuestionOptionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private QuestionOptionServiceImpl questionOptionService;
    @Test
    public void findAllTest(){
        for(Product product:productService.findAll()){
            System.out.printf(product.getId()+" "
                    +product.getName()+" "
                    +product.getDetails()+" "
                    +product.getPrice()+" "
                    +product.getAntiRisk()+" "
                    +product.getFlexibility()+" "
                    +product.getReturnRate()+" "
                    +product.getState());
        }
    }
    @Test
    public void sortProductByRiskTest(){
        for(Product product:productService.sortProductByRisk()){
            System.out.printf(product.getId()+" "
                    +product.getName()+" "
                    +product.getDetails()+" "
                    +product.getPrice()+" "
                    +product.getAntiRisk()+" "
                    +product.getFlexibility()+" "
                    +product.getReturnRate()+" "
                    +product.getState());
        }
    }
    @Test
    public void sortProductByFlexibilityTest(){
        for(Product product:productService.sortProductByFlexibility()){
            System.out.printf(product.getId()+" "
                    +product.getName()+" "
                    +product.getDetails()+" "
                    +product.getPrice()+" "
                    +product.getAntiRisk()+" "
                    +product.getFlexibility()+" "
                    +product.getReturnRate()+" "
                    +product.getState());
        }
    }
    @Test
    public void sortProductByReturnTest(){
        for(Product product:productService.sortProductByReturn()){
            System.out.printf(product.getId()+" "
                    +product.getName()+" "
                    +product.getDetails()+" "
                    +product.getPrice()+" "
                    +product.getAntiRisk()+" "
                    +product.getFlexibility()+" "
                    +product.getReturnRate()+" "
                    +product.getState());
        }
    }
    @Test
    public void sortProductByComprehensiveTest(){
        List<QuestionOption> optionAntiRisk=questionOptionService.findOptionsByQuestion(3);
        List<QuestionOption> optionStability=questionOptionService.findOptionsByQuestion(14);
        List<QuestionOption> optionReturn=questionOptionService.findOptionsByQuestion(4);

        List<ProductCom> productComList=productService.sortProductByComprehensive(optionAntiRisk,optionStability,optionReturn);
        for(ProductCom productCom:productComList){
            System.out.printf("comprehensive: "+productCom.getComprehensive());
        }
    }
    @Test
    public void findFavProductTest(){
        List<Product> productList=productService.findFavProducts();
        for(Product product:productList){
            System.out.println(product.toString());
        }
    }
    @Test
    public void changeFavStateTest(){
        Product product=new Product();
        product.setState(0);
        System.out.println("return value: "+productService.changeFavState(product));
    }


}
