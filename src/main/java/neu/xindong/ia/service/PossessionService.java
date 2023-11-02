package neu.xindong.ia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.xindong.ia.entity.Possession;

import java.util.List;

public interface PossessionService extends IService<Possession> {
    List<Possession> findAll();
}
