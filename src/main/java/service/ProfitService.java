package service;

import domain.Profit;
import domain.ProfitSearch;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface ProfitService {

	Page<Profit> toGetAllData(Integer pageNo);

	public  void toSavePartData(List<Profit> data);

	List<Profit> toGetExportDatas(List<Integer> list);

	Page<Profit> toDoSearch(ProfitSearch profitSearch);

}
