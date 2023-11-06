package neu.xindong.ia.service;

import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.service.impl.AnswerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerServiceTest {
    @Autowired
    private AnswerServiceImpl answerService;
    @Test
    public void findAllTest(){
        List<Answer> answerList=answerService.findAll();
        for(int i=0;i<answerList.size();i++){
            System.out.printf(answerList.get(i).getId()+" "
                    +answerList.get(i).getQuestion()+" "
                    +answerList.get(i).getOption());
        }
    }
    @Test
    public void findAnswerFromAntiRiskQuestionTest(){
        System.out.printf(answerService.findAnswerFromAntiRiskQuestion().getId()+" "
                +answerService.findAnswerFromAntiRiskQuestion().getQuestion()+" "
                +answerService.findAnswerFromAntiRiskQuestion().getOption());
    }
    @Test
    public void findAnswerFromStabilityQuestionTest(){
        System.out.printf(answerService.findAnswerFromStabilityQuestion().getId()+" "
                +answerService.findAnswerFromStabilityQuestion().getQuestion()+" "
                +answerService.findAnswerFromStabilityQuestion().getOption());
    }
    @Test
    public void findAnswerFromReturnRateQuestionTest(){
        System.out.printf(answerService.findAnswerFromReturnRateQuestion().getId()+" "
                +answerService.findAnswerFromReturnRateQuestion().getQuestion()+" "
                +answerService.findAnswerFromReturnRateQuestion().getOption());
    }


}
