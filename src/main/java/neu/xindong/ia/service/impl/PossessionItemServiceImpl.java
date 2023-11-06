package neu.xindong.ia.service.impl;

import neu.xindong.ia.dto.PossessionItem;
import neu.xindong.ia.entity.Product;
import neu.xindong.ia.entity.TradeRecord;
import neu.xindong.ia.service.PossessionItemService;
import neu.xindong.ia.service.ProductService;
import neu.xindong.ia.service.TradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Arc_xsq
* @date 2023/11/2 20:01
*/

@Service
public class PossessionItemServiceImpl
        implements PossessionItemService {
    /**
     *查询所有持仓信息。（根据是否售出查询）数据库此时没有sold属性
     */
    /*public List<Possession> findAll(){
        return query().eq("sold","0").list();
    }

    *//**
     * 增加一条持仓记录
     * @param tradeRecord
     * @return
     *//*
    public boolean addPossession(TradeRecord tradeRecord){

        //新的持仓记录
        int possessionNum = (int) count();
        Integer possessionId = Integer.valueOf(possessionNum+1);
        Possession possession = new Possession();
        possession.setId(possessionId);
        possession.setProductId(tradeRecord.getProductId());
        possession.setPurchasePrice(tradeRecord.getPrice());
        possession.setAmount(tradeRecord.getAmount());
//        possession.setSold(false);//默认新增持仓都是买入
        possession.setSold(0);

        List<Possession> possessionList = query().eq("sold","0").list();
        for (Possession possessionItem : possessionList){
            //对于买入交易，如果产品id相同，则不增加新的持仓记录
            if(tradeRecord.getProductId().equals(possessionItem.getProductId())){
                return false;
            }
        }
        return save(possession);
    }

    *//**
     * 对于卖出交易，更新一条持仓记录。根据交易记录对持仓进行修改，包括数量、持仓成本和是否全部售出。
     * @param tradeRecord
     * @return
     *//*
    public boolean updatePossessionWhenSell(TradeRecord tradeRecord){
        List<Possession> possessionList = query().eq("sold","0").list();
        Possession possession = new Possession();
        possession.setProductId(tradeRecord.getProductId());
//        possession.setPurchasePrice(tradeRecord.getPrice());//以前是买入价格，现在是持仓成本

        for (Possession possessionItem : possessionList){
            //对于卖出交易，产品id一定相同，修改对应持仓的amount、sold、持仓成本
            if (tradeRecord.getProductId().equals(possessionItem.getProductId()) && tradeRecord.getSold().intValue()==1){
                possession.setId(possessionItem.getId());
                int currentAmount = possessionItem.getAmount().intValue()-tradeRecord.getAmount().intValue();
                if(currentAmount<0){//如果交易数量超过持有数量
                    return false;
                }else{
                    //设置amount持有数量
                    possession.setAmount(Integer.valueOf(currentAmount));
                    //设置持仓成本
                    double allCost = possessionItem.getPurchasePrice().doubleValue()*possessionItem.getAmount().intValue()
                            -tradeRecord.getPrice().doubleValue()*tradeRecord.getAmount().intValue();
                    double currentCost = allCost/Double.valueOf(currentAmount);
                    possession.setPurchasePrice(currentCost);

                    if(currentAmount==0){//如果全部卖出
                        //设置sold
//                        possession.setSold(true);
                        possession.setSold(1);
                    }
                    //更新数据库
                    return updateById(possession);
                }
            }
        }
        return false;
    }

    *//**
     * 对于买入交易，更新一条持仓记录。根据交易记录对持仓进行修改，包括数量、持仓成本。
     * @param tradeRecord
     * @return
     *//*
    public boolean updatePossessionWhenBuy(TradeRecord tradeRecord){
        List<Possession> possessionList = query().eq("sold","0").list();
        Possession possession = new Possession();
        possession.setProductId(tradeRecord.getProductId());

        for (Possession possessionItem : possessionList) {
            //对于买入交易，产品id一定相同，修改对应持仓的amount、持仓成本
            if (tradeRecord.getProductId().equals(possessionItem.getProductId()) && tradeRecord.getSold().intValue() == 0) {
                possession.setId(possessionItem.getId());
                int currentAmount = possessionItem.getAmount().intValue()+tradeRecord.getAmount().intValue();
                //设置amount持有数量
                possession.setAmount(Integer.valueOf(currentAmount));
                //设置持仓成本
                double allCost = possessionItem.getPurchasePrice().doubleValue()*possessionItem.getAmount().intValue()
                        +tradeRecord.getPrice().doubleValue()*tradeRecord.getAmount().intValue();
                double currentCost = allCost/Double.valueOf(currentAmount);
                possession.setPurchasePrice(currentCost);
                //更新数据库
                return updateById(possession);
            }
        }
        return false;
    }*/
    @Autowired
    private ProductService productService;
    @Autowired
    private TradeRecordService tradeRecordService;

    /**
     * get possession items
     * @return
     */
    /*public List<PossessionItem> findAll(){
        List<Product> productList=productService.findAll();
        List<TradeRecord> tradeRecordList=tradeRecordService.findAll();

        List<PossessionItem> possessionItemList=new ArrayList<>();

        productList.forEach(e->{
            var possessionItem = new PossessionItem();
            var product=new Product();
            product.setId(e.getId());
            product.setName(e.getName());
            product.setDetails(e.getDetails());
            product.setPrice(e.getPrice());
            product.setAntiRisk(e.getAntiRisk());
            product.setFlexibility(e.getFlexibility());
            product.setReturnRate(e.getReturnRate());
            product.setState(e.getState());
            for(TradeRecord tradeRecord:tradeRecordList){
                if(tradeRecord.getProductId()==product.getId()){
                    possessionItem.setPurchaseDate(tradeRecord.getDealTime());
                    possessionItem.setAmount(tradeRecord.getAmount());
                    possessionItem.setPurchasePrice(tradeRecord.getPrice()*tradeRecord.getAmount());
                }
            }
            possessionItem.setProduct(product);
            possessionItemList.add(possessionItem);
        });
        return possessionItemList;
    }*/
    public List<PossessionItem> findAll(){
        List<Product> productList=productService.findAll();
        List<TradeRecord> tradeRecordList=tradeRecordService.findAll();

        List<PossessionItem> possessionItemList=new ArrayList<>();

        tradeRecordList.forEach(e->{
            var possessionItem = new PossessionItem();
            var tradeRecord=new TradeRecord();
            tradeRecord.setId(e.getId());
            tradeRecord.setProductId(e.getProductId());
            tradeRecord.setPrice(e.getPrice());
            tradeRecord.setSold(e.getSold());
            tradeRecord.setAmount(e.getAmount());
            tradeRecord.setDealTime(e.getDealTime());

            for(Product product:productList){
                if(tradeRecord.getProductId()==product.getId()){
                    possessionItem.setPurchaseDate(tradeRecord.getDealTime());
                    possessionItem.setAmount(tradeRecord.getAmount());
                    possessionItem.setPurchasePrice(tradeRecord.getPrice()*tradeRecord.getAmount());
                    possessionItem.setProduct(product);
                }
            }
            possessionItemList.add(possessionItem);
        });
        return possessionItemList;
    }
}
