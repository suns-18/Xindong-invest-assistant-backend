package neu.xindong.ia;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Comparator;

@SpringBootTest
class XindongInvestAssistantBackendApplicationTests {

    @Test
    void sortEasier(){
        var array = new ArrayList<Integer>();
        array.add(1);
        array.add(0);
        array.add(8);
        array.add(9);
        array.add(2);

        array.sort(Comparator.reverseOrder());
        System.out.println(array);
    }
}
