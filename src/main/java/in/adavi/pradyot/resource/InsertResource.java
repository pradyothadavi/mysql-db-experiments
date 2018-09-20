package in.adavi.pradyot.resource;

import com.google.inject.Inject;
import in.adavi.pradyot.core.InsertManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Pradyot H Adavi 19/09/18
 */
@Path("/insert")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InsertResource {
	
	private static final Logger logger = LoggerFactory.getLogger(InsertResource.class);
	
	private final InsertManager insertManager;
	
	@Inject
	public InsertResource(InsertManager insertManager) {
		this.insertManager = insertManager;
	}
	
	
	@POST
	@Path("/{db_name}/{table_name}/{no_of_rows}")
	public Response insertDataToDb(@PathParam("db_name") String dbName,@PathParam("table_name")String tableName,
	                               @PathParam("no_of_rows")int noOfRows){
		
		logger.info("Inserting data into {}.{}",dbName,tableName);
		
		switch (dbName){
			case "mysql_db_1":
				insertManager.insertIntoDb1(tableName,noOfRows);
				break;
			
			case "mysql_db_2":
				insertManager.insertIntoDb2(tableName,noOfRows);
				break;
		}
		return Response.ok().build();
	}
}
