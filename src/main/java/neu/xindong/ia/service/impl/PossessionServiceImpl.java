package neu.xindong.ia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.ia.dao.PossessionDao;
import neu.xindong.ia.entity.Possession;
import neu.xindong.ia.service.PossessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossessionServiceImpl extends ServiceImpl<PossessionDao, Possession>
        implements PossessionService {
    /**
     * 查询所有持仓信息
     */
    public List<Possession> findAll(){
//获取全部后，对相同产品进行数量相加：
        return null;
    }
}
