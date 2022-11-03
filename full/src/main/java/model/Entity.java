package model;

import java.lang.reflect.Field;
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
		
		Field[] fields = this.getClass().getDeclaredFields();
		Field[] superfields = this.getClass().getSuperclass().getDeclaredFields();
		
		try {
			for(Map.Entry<String, Object> entry : result.entrySet())
			{
				for(int i = 0; i < fields.length; i++) {
					if (fields[i].getName() == entry.getKey())
					{
						fields[i].set(this, entry.getValue());
					}
				}
				
				for(int i = 0; i < superfields.length; i++) {
					if (superfields[i].getName() == entry.getKey())
					{
						superfields[i].set(this, entry.getValue());
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
