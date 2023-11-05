package neu.xindong.ia.dto;

import lombok.Data;

@Data
public class RiskConfigResult {
    private Double antiRisk;//非风险性来源于AnswerService
    private Double stability;//稳定性
    private Double returnRate;//回报率
}
