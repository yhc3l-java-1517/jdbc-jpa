public final class DatabaseTest {

	public static void main(String[] args) throws Exception {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/UserDatabase", "root", "secret");
		        Statement statement = connection.createStatement();) {

			// INSERT, UPDATE & DELETE - Do not do this! Ever! (C.UD)
			String insertEmployee = "INSERT INTO `UserDatabase`.`Employee` (`firstName`, `lastName`, `employeeNumber`)" + 
									"VALUES ('Darth', 'Vader', '4004');";
			
			int rowsAffected = statement.executeUpdate(insertEmployee);
			System.out.println("Inserted " + rowsAffected + " row(s)");
			
			// SELECT - READ (R)
//			ResultSet result = statement.executeQuery("SELECT * FROM Employee");
//			while (result.next()) {
//				
//				int id = result.getInt(1);
//				String firstName = result.getString(2);
//				String lastName = result.getString(3);
//				String employeeNumber = result.getString(4);
//				
//				System.out.println("Id:" + id + ", first name:"+ firstName + 
//				                   ", last name:" + lastName + 
//				                   ", employee number:" + employeeNumber);
//			}
		}

		System.out.println("--------------- Finished ---------------");
	}

}
