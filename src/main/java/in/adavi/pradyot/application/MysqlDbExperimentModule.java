package in.adavi.pradyot.application;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import in.adavi.pradyot.core.InsertManager;
import in.adavi.pradyot.db.Table1Dao;
import in.adavi.pradyot.db.Table2Dao;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import org.hibernate.SessionFactory;

/**
 * @author Pradyot H Adavi 19/09/18
 */
public class MysqlDbExperimentModule extends AbstractModule {
	
	private final HibernateBundle<MysqlDbExperimentConfiguration> hibernateBundleMysqlDb1;
	private final HibernateBundle<MysqlDbExperimentConfiguration> hibernateBundleMysqlDb2;
	
	public MysqlDbExperimentModule(HibernateBundle<MysqlDbExperimentConfiguration> hibernateBundleMysqlDb1, HibernateBundle<MysqlDbExperimentConfiguration> hibernateBundleMysqlDb2) {
		this.hibernateBundleMysqlDb1 = hibernateBundleMysqlDb1;
		this.hibernateBundleMysqlDb2 = hibernateBundleMysqlDb2;
	}
	
	@Override
	protected void configure() {
	
	}
	
	@Singleton
	@Provides
	@Named("mysql_db_1")
	public SessionFactory providesSessionFactoryDb1()
	{
		return hibernateBundleMysqlDb1.getSessionFactory();
	}
	
	@Singleton
	@Provides
	@Named("mysql_db_2")
	public SessionFactory providesSessionFactoryDb2()
	{
		return hibernateBundleMysqlDb2.getSessionFactory();
	}
	
	@Singleton
	@Provides
	public InsertManager providesInsertManager(){
		
		Table1Dao table1Dao = new Table1Dao(hibernateBundleMysqlDb1.getSessionFactory());
		Table2Dao table2Dao = new Table2Dao(hibernateBundleMysqlDb2.getSessionFactory());
		
		Object[] daos = new Object[]{table1Dao,table2Dao};
		Class<?>[] classes = new Class<?>[]{Table1Dao.class,Table2Dao.class};
		
		InsertManager insertManager = new UnitOfWorkAwareProxyFactory(hibernateBundleMysqlDb1,hibernateBundleMysqlDb2)
				.create(InsertManager.class,classes,daos);
		
		return insertManager;
	}
}
