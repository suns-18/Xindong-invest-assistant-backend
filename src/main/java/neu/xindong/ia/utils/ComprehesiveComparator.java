package neu.xindong.ia.utils;

import neu.xindong.ia.dto.ProductCom;

import java.util.Comparator;

public class ComprehesiveComparator implements Comparator<ProductCom> {

    @Override
    public int compare(ProductCom p1, ProductCom p2) {
        return Double.compare(p1.getComprehensive(),
                p2.getComprehensive());
    }
}
