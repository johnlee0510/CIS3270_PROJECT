
package project;

import java.sql.*;

public interface DBconnector {

	public abstract Connection DBconnect() throws SQLException;

	public abstract void add() throws SQLException;

	public abstract void update() throws SQLException;

	public abstract void delete() throws SQLException;

}