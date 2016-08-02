package repository;

import domain.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProfitRepo extends JpaRepository<Profit, Integer> {


	@Query(value = "select p from Profit p where p.id in ?1")
	List<Profit> toGetSelections(List<Integer> list);

}
