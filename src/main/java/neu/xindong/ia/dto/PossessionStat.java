package neu.xindong.ia.dto;

import lombok.Data;

import java.util.List;
@Data
public class PossessionStat {
    private Double totalAssets;//总资产
    private Double totalCurrentPrice;//总市值
    private Double dailyProfit;//当日盈亏： {（product 的price -tradeRecord 的price）×数量} 的和
    private List<PossessionItem> list;//持仓记录列表
}
