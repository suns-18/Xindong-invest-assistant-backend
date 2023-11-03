package neu.xindong.ia.service;

import neu.xindong.ia.entity.Answer;
import neu.xindong.ia.service.impl.AnswerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void findAntiRiskQuestionFromAnswerTest(){
        System.out.printf(answerService.findAntiRiskQuestionFromAnswer().getId()+" "
                +answerService.findAntiRiskQuestionFromAnswer().getQuestion()+" "
                +answerService.findAntiRiskQuestionFromAnswer().getOption());
    }
    @Test
    public void findStabilityQuestionFromAnswerTest(){
        System.out.printf(answerService.findAntiRiskQuestionFromAnswer().getId()+" "
                +answerService.findAntiRiskQuestionFromAnswer().getQuestion()+" "
                +answerService.findAntiRiskQuestionFromAnswer().getOption());
    }
    @Test
    public void findReturnRateQuestionFromAnswerTest(){
        System.out.printf(answerService.findAntiRiskQuestionFromAnswer().getId()+" "
                +answerService.findAntiRiskQuestionFromAnswer().getQuestion()+" "
                +answerService.findAntiRiskQuestionFromAnswer().getOption());
    }


}
