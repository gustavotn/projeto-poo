package model;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import data.DataAdapter;
import data.SQLSelect;

public abstract class Entity {
	public Entity() 
	{
		this.m_code = 0;
	}
	
	public Entity(int code)
	{
		this();
		
		this.Carrega(code);
	}

	private int m_code;
	
	public String getTable()
	{
		return "";
	}
	
	public int getCode()
	{
		return this.m_code;
	}
	
	public void setCode(int value)
	{
		this.m_code = value;
	}
	
	public Map<String, String> getColumns(){
		Map<String, String> ret = new HashMap<String, String>();
		
		ret.put("ID", "setCode");
		
		return ret;
	}
	
	public boolean Grava()
	{
		return true;
	}
	
	public boolean Carrega(int code)
	{
		SQLSelect select = new SQLSelect(this.getTable());
		
		for(Map.Entry<String, String> entry : this.getColumns().entrySet())
		{
			select.getBody().put(entry.getKey(), entry.getValue());
		}
		
		select.getConditions().put("ID", " = " + code);

		Map<String, Object> result = DataAdapter.getCurrent().ExecuteOne(select.getSQL());
		
		Method[] methods = this.getClass().getDeclaredMethods();
		
		Method[] superMethod = this.getClass().getSuperclass().getMethods();

		
		try 
		{
			for(Map.Entry<String, Object> entry : result.entrySet())
			{
				for(int i = 0; i < methods.length; i++) {
					if (methods[i].getName().equals(entry.getKey().toString()))
					{
						Object value = entry.getValue();
						methods[i].invoke(this, value);
						i = methods.length;
					}
				}
				
				for(int i = 0; i < superMethod.length; i++) {
					if (superMethod[i].getName().equals(entry.getKey().toString()))
					{
						Object value = entry.getValue();
						superMethod[i].invoke(this, value);
						i = superMethod.length;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
