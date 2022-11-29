package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;

public final class DataAdapter {
	
	private DataAdapter() 
	{		
		this.m_url = "jdbc:sqlite:C:/Git/projeto-poo/backend/db/database.db";
	}
	
	private static DataAdapter m_current;
	private Connection m_connection;
	private String m_url;
	
	public static DataAdapter getCurrent()
	{
		if (m_current == null)
			m_current = new DataAdapter();
		
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
			//return false;
		}
		
		try
		{
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
	
	private boolean Execute(String Query)
	{
		try
		{
			if (this.Connect())
			{
				Statement stmt = this.m_connection.createStatement();
				
				return stmt.execute(Query);
			}

			return false;
		} 
		catch (SQLException err) 
		{
			err.printStackTrace();
			return false;
		}
	}

	public ResultSet ExecuteSelect(String Query)
	{
		try
		{
			if (this.Connect())
			{
				Statement stmt = this.m_connection.createStatement();
				
				return stmt.executeQuery(Query);
			}

			return null;
		} 
		catch (SQLException err) 
		{
			err.printStackTrace();
			return null;
		}
	}
	
	public boolean ExecuteUpdate(String Query)
	{
		return this.Execute(Query);
	}
	
	public boolean ExecuteDelete(String Query)
	{
		return this.Execute(Query);
	}
	
	public boolean ExecuteInsert(String Query)
	{
		return this.Execute(Query);
	}
	
	public Object ExecuteCount(String Query)
	{
		ResultSet result = this.ExecuteSelect(Query);
		
		try 
		{
			while(result.next())
			{
				return result.getObject(1);
			}
		} 
		catch (SQLException err) 
		{
			err.printStackTrace();
		}
		
		return null;
	}
	
	public Map<String, Object> ExecuteOne(String Query)
	{
		ResultSet result = this.ExecuteSelect(Query);
		
		Map<String, Object> ret = new HashMap<String, Object>();
		
		int count = 1;
		
		try 
		{
			ResultSetMetaData resultMD = result.getMetaData();
			
			result.next();
			
			while(resultMD.getColumnCount() >= count)
			{
				ret.put(resultMD.getColumnLabel(count), result.getObject(count));
				
				count++;
			}

			return ret;
		} 
		catch (SQLException err) 
		{
			err.printStackTrace();
		}
		
		return null;
	}
}
