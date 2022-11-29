package data;

import java.util.HashMap;
import java.util.Map;

public class SQLSelect {
	public SQLSelect() {}
	
	public SQLSelect(String Table) 
	{
		this.m_table = Table;
		this.m_body = new HashMap<String, String>();
		this.m_conditions = new HashMap<String, String>();
	}
	
	private String m_table;
	private Map<String, String> m_body;
	private Map<String, String> m_conditions;
	
	public String getTable()
	{
		return this.m_table;
	}
	
	public void setTable(String value)
	{
		this.m_table = value;
	}
	
	public Map<String, String> getBody() {
		return m_body;
	}

	public void setBody(Map<String, String> m_body) {
		this.m_body = m_body;
	}

	public Map<String, String> getConditions() {
		return m_conditions;
	}

	public void setConditions(Map<String, String> m_conditions) {
		this.m_conditions = m_conditions;
	}
	
	public String getSQL()
	{
		StringBuilder sqlBuilder = new StringBuilder();
		
		sqlBuilder.append("SELECT ");
		
		int count = 1;
		
		for(Map.Entry<String, String> entry : this.getBody().entrySet())
		{
			sqlBuilder.append(entry.getKey()).append(" AS ").append(entry.getValue());
			
			if (count != this.getBody().size())
				sqlBuilder.append(", ");
			else 
				sqlBuilder.append(" ");
			
			count++;
		}
		
		sqlBuilder.append("FROM ").append(this.getTable());
		
		if (this.getConditions().size() != 0)
		{
			sqlBuilder.append(" WHERE 1=1 ");
			
			for(Map.Entry<String, String> entry : this.getConditions().entrySet())
			{
				sqlBuilder.append("AND ").append(entry.getKey()).append(entry.getValue());
				
			}
		}
		
		return sqlBuilder.toString();
	}
	
}
