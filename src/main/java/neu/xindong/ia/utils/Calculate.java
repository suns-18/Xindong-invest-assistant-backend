package neu.xindong.ia.utils;

import neu.xindong.ia.dto.ProductCom;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.QuestionOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Calculate {
    /**code by ryr
     * calculate comprehensive
     * @param questionOptionAntiRisk
     * @param questionOptionStability
     * @param questionOptionReturn
     * @param productList
     * @return
     */
    public static List<ProductCom> calculateComprehensive(QuestionOption questionOptionAntiRisk,
                                         QuestionOption questionOptionStability,
                                         QuestionOption questionOptionReturn,
                                         List<Product> productList){

        int optionAntiRiskValue=questionOptionAntiRisk.getValue();
        int optionStabilityValue=questionOptionStability.getValue();
        int optionReturnValue=questionOptionReturn.getValue();

        double anti_risk;
        double flexibility;
        double return_rate;
        double comprehensive;

        List<ProductCom> productComList = new ArrayList<>();

/*        for(Product product:productList){
            anti_risk=product.getAnti_risk();
            flexibility=product.getFlexibility();
            return_rate=product.getReturn_rate();
            comprehensive=(Math.abs(anti_risk_value-anti_risk))/anti_risk_value
                    +(Math.abs(stability_value-flexibility))/stability_value
                    +(Math.abs(return_rate_value-return_rate))/return_rate_value;
            ProductCom productComTemp=new ProductCom();
            productComTemp.setProduct(product);
            productComTemp.setComprehensive(comprehensive);
            productCom.add(productComTemp);
        }*/

        productList.forEach(e->{
            var com = new ProductCom();
            var product = com.getProduct();

            product.setId(e.getId());
            product.setName(e.getName());
            product.setDetails(e.getDetails());
            product.setPrice(e.getPrice());

            product.setAntiRisk(e.getAntiRisk());
            product.setFlexibility(e.getFlexibility());
            product.setReturnRate(e.getReturnRate());
            product.setState(e.getState());

            com.setComprehensive((Math.abs(optionAntiRiskValue-e.getAntiRisk()))/optionAntiRiskValue
                    +(Math.abs(optionStabilityValue-e.getFlexibility()))/optionStabilityValue
                    +(Math.abs(optionReturnValue-e.getReturnRate()))/optionReturnValue);

            productComList.add(com);
        });

        //bubbleSort(productCom);
        productComList.sort(new Comparator<ProductCom>() {
            @Override
            public int compare(ProductCom p1, ProductCom p2) {
                return Double.compare(p2.getComprehensive(),
                        p1.getComprehensive());
            }
        });

        return productComList;

        /*List<Product> products=new ArrayList<>();
        for(ProductCom productComTemp:productCom){
            products.add(productComTemp.getProduct());
        }
        return products;*/
    }

    /**code by ryr
     * bubble sort productCom by comprehensive
     * @param productCom
     */
    /*public void bubbleSort(List<ProductCom> productCom) {
        int len = productCom.size();
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (productCom.get(j).getComprehensive() > productCom.get(j+1).getComprehensive()) {
                    double tmp = productCom.get(j).getComprehensive();
                    productCom.get(j).setComprehensive(productCom.get(j+1).getComprehensive());
                    productCom.get(j+1).setComprehensive(tmp);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }*/


}
