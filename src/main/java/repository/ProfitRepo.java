package repository;

import domain.Profit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface ProfitRepo extends JpaRepository<Profit, Integer> {

}
