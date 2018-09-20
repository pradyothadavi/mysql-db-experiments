package in.adavi.pradyot.db;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import in.adavi.pradyot.db.entity.Table2;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * @author Pradyot H Adavi 19/09/18
 */
public class Table2Dao extends AbstractDAO<Table2> {
	
	@Inject
	public Table2Dao(@Named("mysql_db_2") SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public void insert(Table2 table2){
		persist(table2);
	}
}
