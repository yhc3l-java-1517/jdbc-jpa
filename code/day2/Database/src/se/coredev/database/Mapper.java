package se.coredev.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {

	// Map _ONE_ row from ResultSet to a type (Employee, Actor, etc) 
	T map(ResultSet resultSet) throws SQLException;
	
}
