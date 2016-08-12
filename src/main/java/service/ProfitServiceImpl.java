package service;

import domain.Profit;
import domain.ProfitSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import repository.ProfitRepo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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


	@Transactional
	@Override
	public void toSavePartData(java.util.List<Profit> data) {

		profitRepo.save(data);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Profit> toGetExportDatas(List<Integer> list) {

		return profitRepo.toGetSelections(list);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Profit> toDoSearch(ProfitSearch profitSearch) {

		return profitRepo.findAll(new Specification<Profit>() {
			@Override
			public Predicate toPredicate(Root<Profit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//构建条件集合
				List<Predicate> predicates = new ArrayList<Predicate>();
				//业务编号
				if (profitSearch != null && !StringUtils.isEmpty(profitSearch.getBusinessNo())) {

					System.out.println("BusinessNo:"+profitSearch.getBusinessNo());

					Predicate p = cb.like(root.get("businessNo").as(String.class), "%" + profitSearch.getBusinessNo() + "%");
					predicates.add(p);
				}

				//业务员
				if (profitSearch != null && !StringUtils.isEmpty(profitSearch.getSaleMan())) {

					System.out.println("SaleMan:" + profitSearch.getSaleMan());

					Predicate p = cb.like(root.get("salesman").as(String.class), "%" + profitSearch.getSaleMan() + "%");
					predicates.add(p);
				}

				//收货人
				if (profitSearch != null && !StringUtils.isEmpty(profitSearch.getReciverMan())) {

					Predicate p = cb.like(root.get("recipient").as(String.class), "%" + profitSearch.getReciverMan() + "%");
					predicates.add(p);
				}
				//录单人
				if (profitSearch != null && !StringUtils.isEmpty(profitSearch.getCreator())) {

					Predicate p = cb.like(root.get("recordingPerson").as(String.class), "%" + profitSearch.getCreator() + "%");
					predicates.add(p);
				}

				//部门
				if (profitSearch != null && !StringUtils.isEmpty(profitSearch.getDepartment())) {

					Predicate p = cb.like(root.get("department").as(String.class), "%" + profitSearch.getDepartment() + "%");
					predicates.add(p);
				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		},new PageRequest(Integer.parseInt(profitSearch.getPageNo())-1,Integer.parseInt(profitSearch.getPageCount())));
	}
}
