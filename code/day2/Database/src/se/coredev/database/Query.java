package se.coredev.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class Query<T> {

	private final String connectionString;
	private final List<Object> paramaters;
	private String sql; 
	private Mapper<T> mapper;

	public Query(String connectionString) {
		this.connectionString = connectionString;
		this.paramaters = new ArrayList<>();
	}

	public Query<T> query(String sql) {
		this.sql = sql;
		return this;
	}

	public Query<T> mapper(Mapper<T> mapper) {
		this.mapper = mapper;
		return this;
	}

	public Query<T> parameter(Object parameter) {
		paramaters.add(parameter);
		return this;
	}
	
	public List<T> execute() throws SQLException {
		
		// Mapped result (this could be Employees, Actors, etc)
		final List<T> result = new ArrayList<>();
		
		// Create connection and PreparedStatement
		try (Connection connection = DriverManager.getConnection(connectionString);
			 PreparedStatement statement = createStatement(connection)) {
			
			// Execute query
			final ResultSet resultSet = statement.executeQuery();
			
			// Use the mapper to map one row to a type (Employee, Actor, etc)
			while(resultSet.next()) {

				// Add type (Employee, Actor, etc) to the result
				result.add(mapper.map(resultSet));
			}
		}
		
		return result;
	}

	private PreparedStatement createStatement(Connection connection) throws SQLException {
		
		// Create PreparedStatement from SQL string
		final PreparedStatement statement = connection.prepareStatement(sql);
		
		// Add parameters
		for(int i = 0; i < paramaters.size(); i++) {
			// We don't now the parameter type (if it's a String, Long, Integer, etc) that's why we use setObject
			statement.setObject(i + 1, paramaters.get(i));
		}
		
		return statement;
	}

}