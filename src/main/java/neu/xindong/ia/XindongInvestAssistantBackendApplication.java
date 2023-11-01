package neu.xindong.ia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("neu.xindong.ia.dao")
public class XindongInvestAssistantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(XindongInvestAssistantBackendApplication.class, args);
    }

}
