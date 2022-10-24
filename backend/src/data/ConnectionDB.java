package data;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionDB {
	
	private ConnectionDB() 
	{		
		this.m_url = "jdbc:sqlite:db/database.db";
	}
	
	private static ConnectionDB m_current;
	private Connection m_connection;
	private String m_url;
	
	public static ConnectionDB getCurrent()
	{
		if (m_current == null)
			m_current = new ConnectionDB();
		
		return m_current;
	}
	
	public boolean Connect()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
		
			this.m_connection = DriverManager.getConnection(this.m_url);
		}
		catch(Exception err)
		{
			System.err.println(err.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean Disconnect() 
	{
		try
		{
			if (this.m_connection != null)
			{
				if (!this.m_connection.isClosed())
					this.m_connection.close();
			}
		}
		catch(SQLException err)
		{
			System.err.println(err.getMessage());
			return false;
		}
		
		return true;
	}
	
}
