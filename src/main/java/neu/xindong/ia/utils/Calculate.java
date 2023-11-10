package neu.xindong.ia.utils;

import neu.xindong.ia.dto.response.ProductCom;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


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

        List<ProductCom> productComList = new ArrayList<>();

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
    }


    /*@Autowired
    private static ProductService productService;//目前不可用，待解决*/

    public static Double calculateTotalAssets(
            List<TradeRecord> records) {

        /*double totalAssets = 0.00;
        for (TradeRecord tradeRecord : records) {
            if (tradeRecord.getSold().intValue() == 0) {
                totalAssets += tradeRecord.getPrice().doubleValue()
                        * tradeRecord.getAmount().doubleValue();
            } else {
                totalAssets -= tradeRecord.getPrice().doubleValue()
                        * tradeRecord.getAmount().doubleValue();
            }
        }*/

        return records.stream()
                .mapToDouble(record -> {
                    double price = record.getPrice().doubleValue();
                    double amount = record.getAmount().doubleValue();
                    return (record.getSold().intValue() == 0) ?
                            price * amount : -price * amount;
                })
                .sum();
    }

    public static Double calculateTotalCurrentPrice(
            List<Product> purchasedProducts,
            List<TradeRecord> records) {

        /*double totalCurrentPrice = 0.00;
        for (TradeRecord tradeRecord : records) {
            Product product = productService.findProductById(tradeRecord.getProductId());
            if (tradeRecord.getSold().intValue() == 0) {
                totalCurrentPrice += product.getPrice().doubleValue() * tradeRecord.getAmount().doubleValue();
            } else {
                totalCurrentPrice -= product.getPrice().doubleValue() * tradeRecord.getAmount().doubleValue();
            }
        }

        return totalCurrentPrice;*/

        /*return records.stream()
                .filter(record -> record.getSold() == 0)
                .mapToDouble(record -> {
                    var optionalProduct = purchasedProducts.stream()
                            .filter(e -> e.getId().equals(record.getProductId()))
                            .findFirst();

                    return optionalProduct.map(product -> product.getPrice()
                                    * record.getAmount())
                            .orElse(0.0);
                }).sum();*/

        return records.stream()
                .collect(Collectors.toMap(TradeRecord::getProductId, Function.identity(), (existing, replacement) -> replacement))
                .values()
                .stream()
                .filter(record -> record.getSold() == 0)
                .mapToDouble(record -> {
                    var optionalProduct = purchasedProducts.stream()
                            .filter(e -> e.getId().equals(record.getProductId()))
                            .findFirst();

                    return optionalProduct.map(product -> product.getPrice()
                                    * record.getAmount())
                            .orElse(0.0);
                }).sum();
    }

    public static Double calculateDailyProfit(
            List<Product> purchasedProducts,
            List<TradeRecord> records) {
        /*double dailyProfit = 0.00;
        for (TradeRecord tradeRecord : records) {
            Product product = productService.findProductById(tradeRecord.getProductId());
            if (tradeRecord.getSold().intValue() == 0) {
                dailyProfit += (product.getPrice().doubleValue() - tradeRecord.getPrice().doubleValue()) * tradeRecord.getAmount().doubleValue();
            } else {
                dailyProfit -= (product.getPrice().doubleValue() - tradeRecord.getPrice().doubleValue()) * tradeRecord.getAmount().doubleValue();
            }
        }
        return dailyProfit;*/

        /*return records.stream()
                .filter(record -> record.getSold() == 0)
                .mapToDouble(record -> {
                    var optionalProduct = purchasedProducts.stream()
                            .filter(e -> e.getId().equals(record.getProductId()))
                            .findFirst();

                    return optionalProduct.map(product -> (product.getPrice()-record.getPrice())
                                    * record.getAmount())
                            .orElse(0.0);
                }).sum();*/

        return records.stream()
                .collect(Collectors.toMap(TradeRecord::getProductId, Function.identity(), (existing, replacement) -> replacement))
                .values()
                .stream()
                .filter(record -> record.getSold() == 0)
                .mapToDouble(record -> {
                    var optionalProduct = purchasedProducts.stream()
                            .filter(e -> e.getId().equals(record.getProductId()))
                            .findFirst();

                    return optionalProduct.map(product -> (product.getPrice()-record.getPrice())
                                    * record.getAmount())
                            .orElse(0.0);
                }).sum();
    }


}
