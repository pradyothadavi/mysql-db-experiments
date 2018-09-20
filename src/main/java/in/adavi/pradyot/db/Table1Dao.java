package in.adavi.pradyot.db;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import in.adavi.pradyot.db.entity.Table1;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * @author Pradyot H Adavi 19/09/18
 */
public class Table1Dao extends AbstractDAO<Table1> {
	
	@Inject
	public Table1Dao(@Named("mysql_db_1") SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public void insert(Table1 table1){
		persist(table1);
	}
}
