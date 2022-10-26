package model;

import java.util.Map;

import data.DataAdapter;
import data.SQLSelect;

public abstract class Entidade {
	public Entidade() {}
	
	public Entidade(String... params)
	{
		this();
	}
	
	private String m_table;
	private String m_code;
	
	public String getTable()
	{
		return this.m_table;
	}
	
	public String getCode()
	{
		return this.m_code;
	}
	
	public void setCode(String value)
	{
		this.m_code = value;
	}
	
	public boolean Grava()
	{
		return true;
	}
	
	public boolean Carrega(String... params)
	{
		SQLSelect select = new SQLSelect(this.getTable());
		
		select.getBody().put("CD_PESSOA", "Code");
		select.getBody().put("NM_PESSOA", "Name");
		
		select.getConditions().put("CD_PESSOA", " = 1");

		Map<String, Object> result = DataAdapter.getCurrent().ExecuteOne(select.getSQL());
		
		for(Map.Entry<String, Object> entry : result.entrySet())
		{
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		return true;
	}
}
