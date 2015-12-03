package se.coredev.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public final class Main {

	static final String connectionString = "jdbc:mysql://localhost/UserDatabase?user=root&password=secret";
	static final String insertEmployeeSql = "INSERT INTO Employee (firstName, lastName, employeeNumber) VALUES (?,?,?)";
	static final String selectEmployee = "SELECT * FROM Employee WHERE employeeNumber = ?";
	static final String selectAllEmployee = "SELECT * FROM Employee";

	private static final Mapper<Employee> EMPLOYEE_MAPPER = new Mapper<Employee>() {
		
		@Override
		public Employee map(ResultSet resultSet) throws SQLException {
			return new Employee(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
		}
	};

	
	public static void main(String[] args) throws Exception {

		
		List<Employee> result = new Query<Employee>(connectionString).query(selectEmployee)
				                                                     .parameter("1001")
				                                                     .mapper(EMPLOYEE_MAPPER)
				                                                     .execute();
		
		for(Employee employee : result) {
			System.out.println(employee);
		}
		
		System.out.println("----------- Finished -------------");

	}

}
