package neu.xindong.ia.utils;

import neu.xindong.ia.dto.ProductCom;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.QuestionOption;
import neu.xindong.ia.entity.TradeRecord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Calculate {
    /**
     * code by ryr
     * calculate comprehensive
     *
     * @param optionAntiRisk
     * @param optionStability
     * @param optionReturn
     * @param productList
     * @return
     */
    public static List<ProductCom> calculateComprehensive(Integer optionAntiRisk,
                                                          Integer optionStability,
                                                          Integer optionReturn,
                                                          List<Product> productList) {


        double anti_risk;
        double flexibility;
        double return_rate;
        double comprehensive;

        List<ProductCom> productComList = new ArrayList<>();

/*        for(Product product:productList){
            anti_risk=product.getAnti_risk();
            flexibility=product.getFlexibility();
            return_rate=product.getReturn_rate();
            comprehensive=(Math.abs(anti_risk_-anti_risk))/anti_risk_
                    +(Math.abs(stability_-flexibility))/stability_
                    +(Math.abs(return_rate_-return_rate))/return_rate_;
            ProductCom productComTemp=new ProductCom();
            productComTemp.setProduct(product);
            productComTemp.setComprehensive(comprehensive);
            productCom.add(productComTemp);
        }*/

        productList.forEach(e -> {
            var com = new ProductCom();
//            var product = com.getProduct();
            var product = new Product();
            product.setId(e.getId());
            product.setName(e.getName());
            product.setDetails(e.getDetails());
            product.setPrice(e.getPrice());

            product.setAntiRisk(e.getAntiRisk());
            product.setFlexibility(e.getFlexibility());
            product.setReturnRate(e.getReturnRate());
            product.setState(e.getState());

            com.setComprehensive((Math.abs(optionAntiRisk - e.getAntiRisk())) / optionAntiRisk
                    + (Math.abs(optionStability - e.getFlexibility())) / optionStability
                    + (Math.abs(optionReturn - e.getReturnRate())) / optionReturn);

            com.setProduct(product);

            productComList.add(com);
        });

        //bubbleSort(productCom);
        productComList.sort(new Comparator<ProductCom>() {
            @Override
            public int compare(ProductCom p1, ProductCom p2) {
                return Double.compare(p1.getComprehensive(),
                        p2.getComprehensive());
            }
        });

        return productComList;

        /*List<Product> products=new ArrayList<>();
        for(ProductCom productComTemp:productCom){
            products.add(productComTemp.getProduct());
        }
        return products;*/
    }

    /**
     * code by ryr
     * bubble sort productCom by comprehensive
     *
     * @param
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
    public static Double calculateTotalAssets(List<TradeRecord> records) {

        return null;
    }

    public static Double calculateTotalCurrentPrice(List<TradeRecord> records) {

        return null;
    }

    public static Double calculateDailyProfit(List<TradeRecord> records) {

        return null;
    }


}
