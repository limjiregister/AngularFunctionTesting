package service;

import domain.Profit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.ProfitRepo;

/**
 * Created by Administrator on 2016/7/15.
 */

@Service
public class ProfitServiceImpl implements ProfitService {


	@Autowired
	private ProfitRepo profitRepo;

	@Override
	public Page<Profit> toGetAllData(Integer pageNo) {

		PageRequest request = new PageRequest(pageNo - 1, 20);

		return profitRepo.findAll(request);
	}


}
