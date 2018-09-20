package in.adavi.pradyot.core;

import com.google.inject.Inject;
import in.adavi.pradyot.db.Table1Dao;
import in.adavi.pradyot.db.Table2Dao;
import in.adavi.pradyot.db.entity.Table1;
import in.adavi.pradyot.db.entity.Table2;
import io.dropwizard.hibernate.UnitOfWork;

/**
 * @author Pradyot H Adavi 19/09/18
 */
public class InsertManager {
	
	private final Table1Dao table1Dao;
	private final Table2Dao table2Dao;
	
	@Inject
	public InsertManager(Table1Dao table1Dao, Table2Dao table2Dao) {
		this.table1Dao = table1Dao;
		this.table2Dao = table2Dao;
	}
	
	@UnitOfWork(value = "mysql_db_1")
	public void insertIntoDb1(String tableName, int noOfRows){
		
		switch (tableName){
			case "table1":
				for (int i = 0; i < noOfRows; i++){
					Table1 table1 = new Table1();
					table1.setColumn1(String.valueOf(i));
					table1Dao.insert(table1);
				}
				break;
		}
	}
	
	@UnitOfWork(value = "mysql_db_2")
	public void insertIntoDb2(String tableName, int noOfRows){
		
		switch (tableName){
			case "table2":
				for (int i = 0; i < noOfRows; i++){
					Table2 table2 = new Table2();
					table2.setColumn1(String.valueOf(i));
					table2Dao.insert(table2);
				}
				break;
		}
	}
}
