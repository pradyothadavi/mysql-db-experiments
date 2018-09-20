package in.adavi.pradyot.application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import in.adavi.pradyot.db.entity.Table1;
import in.adavi.pradyot.db.entity.Table2;
import in.adavi.pradyot.resource.InsertResource;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Pradyot H Adavi 19/09/18
 */
public class MysqlDbExperimentApplication extends Application<MysqlDbExperimentConfiguration> {
	
	
	private final HibernateBundle<MysqlDbExperimentConfiguration> hibernateBundleMysqlDb1 = new
			HibernateBundle<MysqlDbExperimentConfiguration>(Table1.class) {
				@Override
				public PooledDataSourceFactory getDataSourceFactory(MysqlDbExperimentConfiguration mysqlDbExperimentConfiguration) {
					return mysqlDbExperimentConfiguration.getMysqlDb1();
				}
				
				@Override
				public String name() {
					return "mysql_db_1";
				}
			};
	
	private final HibernateBundle<MysqlDbExperimentConfiguration> hibernateBundleMysqlDb2 = new
			HibernateBundle<MysqlDbExperimentConfiguration>(Table2.class) {
				
				@Override
				public PooledDataSourceFactory getDataSourceFactory(MysqlDbExperimentConfiguration mysqlDbExperimentConfiguration) {
					return mysqlDbExperimentConfiguration.getMysqlDb2();
				}
				
				@Override
				public String name() {
					return "mysql_db_2";
				}
			};
	
	@Override
	public void initialize(Bootstrap<MysqlDbExperimentConfiguration> bootstrap) {
		
		bootstrap.addBundle(hibernateBundleMysqlDb1);
		bootstrap.addBundle(hibernateBundleMysqlDb2);
	}
	
	@Override
	public void run(MysqlDbExperimentConfiguration mysqlDbExperimentConfiguration, Environment environment) throws Exception {
		
		Injector injector = Guice.createInjector(new MysqlDbExperimentModule(hibernateBundleMysqlDb1,
				hibernateBundleMysqlDb2));
		
		environment.jersey().register(injector.getInstance(InsertResource.class));
	
	}
}
