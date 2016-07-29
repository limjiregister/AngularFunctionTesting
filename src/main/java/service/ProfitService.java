package service;

import domain.Profit;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface ProfitService {

	Page<Profit> toGetAllData(Integer pageNo);

}
