package in.adavi.pradyot.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pradyot H Adavi 19/09/18
 */
@Entity
@Table(name = "Table1")
public class Table1 {
	
	@Id
	@Column(name = "column1")
	private String column1;
	
	public String getColumn1() {
		return column1;
	}
	
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	
	@Override
	public String toString() {
		return "Table1{" +
				"column1='" + column1 + '\'' +
				'}';
	}
}
