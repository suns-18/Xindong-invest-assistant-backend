package neu.xindong.ia.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPIConfig(){
        return new OpenAPI()
                .info(info());
    }
    public Info info(){
        return new Info()
                .title("信东智能投资顾问API文档")
                .version("V0.0.1")
                .description("这是信东智能投资顾问客户端API文档");
    }
}
