package in.adavi.pradyot.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.constraints.NotNull;

/**
 * @author Pradyot H Adavi 19/09/18
 */
public class MysqlDbExperimentConfiguration extends Configuration {
	
	@NotNull
	private DataSourceFactory mysqlDb1;
	
	@NotNull
	private DataSourceFactory mysqlDb2;
	
	@JsonProperty("mysql_db_1")
	public DataSourceFactory getMysqlDb1() {
		return mysqlDb1;
	}
	
	public void setMysqlDb1(DataSourceFactory mysqlDb1) {
		this.mysqlDb1 = mysqlDb1;
	}
	
	@JsonProperty("mysql_db_2")
	public DataSourceFactory getMysqlDb2() {
		return mysqlDb2;
	}
	
	public void setMysqlDb2(DataSourceFactory mysqlDb2) {
		this.mysqlDb2 = mysqlDb2;
	}
	
	@Override
	public String toString() {
		return "MysqlDbExperimentConfiguration{" +
				"mysqlDb1=" + mysqlDb1 +
				", mysqlDb2=" + mysqlDb2 +
				"} " + super.toString();
	}
}
