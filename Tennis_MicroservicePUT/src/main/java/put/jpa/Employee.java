package put.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEE_EMPLOYEEID_GENERATOR", sequenceName="EMPLOYEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_EMPLOYEEID_GENERATOR")
	private Integer employeeid;

	@Temporal(TemporalType.DATE)
	private Date dateofemployment;

	private String employeeaddress;

	@Temporal(TemporalType.DATE)
	private Date employeedateofbirth;

	private String employeefirstname;

	private String employeelastname;

	private String employeepassword;

	private String employeeusername;

	public Employee() {
	}

	public Integer getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Date getDateofemployment() {
		return this.dateofemployment;
	}

	public void setDateofemployment(Date dateofemployment) {
		this.dateofemployment = dateofemployment;
	}

	public String getEmployeeaddress() {
		return this.employeeaddress;
	}

	public void setEmployeeaddress(String employeeaddress) {
		this.employeeaddress = employeeaddress;
	}

	public Date getEmployeedateofbirth() {
		return this.employeedateofbirth;
	}

	public void setEmployeedateofbirth(Date employeedateofbirth) {
		this.employeedateofbirth = employeedateofbirth;
	}

	public String getEmployeefirstname() {
		return this.employeefirstname;
	}

	public void setEmployeefirstname(String employeefirstname) {
		this.employeefirstname = employeefirstname;
	}

	public String getEmployeelastname() {
		return this.employeelastname;
	}

	public void setEmployeelastname(String employeelastname) {
		this.employeelastname = employeelastname;
	}

	public String getEmployeepassword() {
		return this.employeepassword;
	}

	public void setEmployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}

	public String getEmployeeusername() {
		return this.employeeusername;
	}

	public void setEmployeeusername(String employeeusername) {
		this.employeeusername = employeeusername;
	}

}