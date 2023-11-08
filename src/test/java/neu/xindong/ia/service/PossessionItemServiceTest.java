package neu.xindong.ia.service;

import neu.xindong.ia.dto.response.PossessionItem;
import neu.xindong.ia.service.impl.PossessionItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PossessionItemServiceTest {
    @Autowired
    private PossessionItemServiceImpl possessionItemService;
    @Test
    public void findAllTest(){
        List<PossessionItem> possessionItemList=possessionItemService.findAll();
        for(PossessionItem possessionItem:possessionItemList){
            System.out.println(possessionItem.getProduct().toString()+" "+
                    possessionItem.getAmount()+" "+
                    possessionItem.getPurchaseDate()+" "+
                    possessionItem.getPurchasePrice());
        }
    }
}
