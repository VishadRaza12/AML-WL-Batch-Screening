package risknucleus.aml.watchlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import risknucleus.aml.watchlist.model.Watchlist_condition;
import risknucleus.aml.watchlist.model.Watchlist_conditiondetail;
@Repository
public interface ConditionDetailRepository extends JpaRepository<Watchlist_conditiondetail,Integer>{

	
//	@Query(value="select c.Condition_ID, a.Scenario_ID, b.Score, c.operatorID, b.ScenarioName, a.Condition_Name, a.id as ConditionID, c.id , c.ParentID, c.LEVELCHILD_ID, c.LEVEL_ID, c.ActionID, e.id, c.TableID, c.ColumnID, e.Function_Name, f.colType, f.Column_Name, g.Table_Name, e.No_Of_Argument, c.FunctionID ,c.InputID from watchlist_condition a inner join  watchlist_condition_detail c on c.Condition_ID = a.id left join  watchlist_function_setup e on e.id = c.FunctionID left join  watchlist_column_setup f on f.id = c.ColumnID left join  watchlist_table_setup g on g.id = c.TableID inner join  watchlist_scenario_setup b on a.Scenario_ID = b.ScenarioID order by b.Score desc", nativeQuery=true)
//	public List<Watchlist_conditiondetail> savecondition();
	
	@Query("select t from Watchlist_conditiondetail t where t.watchlist_condition=?1 order by LEVELCHILD_ID asc")
	public List<Watchlist_conditiondetail> findAllByCondition_ID(Watchlist_condition condition);

//	@Query("select t from Watchlist_conditiondetail t where Condition_ID=?1 ")
//	public List<Watchlist_conditiondetail> getconditiondata(Integer Condition_ID);
}

