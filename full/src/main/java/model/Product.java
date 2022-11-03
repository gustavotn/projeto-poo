package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.DataAdapter;
import data.SQLSelect;

public class Product extends Entity {
	public Product()
	{
		super();
	}
	
	public Product (int code)
	{
		this.Carrega(code);
	}
	
	private String m_name;
	private String m_description;
	private double m_price;
	
	public String getName() {
		return m_name;
	}

	public void setName(String value) {
		this.m_name = value;
	}

	public String getDescription() {
		return m_description;
	}

	public void setDescription(String value) {
		this.m_description = value;
	}

	public double getPrice() {
		return m_price;
	}

	public void setPrice(double value) {
		this.m_price = value;
	}
	
	@Override
	public String getTable()
	{
		return "T_PRODUCT";
	}
	
	@Override
	public Map<String, String> getColumns(){
		Map<String, String> ret = new HashMap<String, String>();
		
		ret.put("NAME", "m_name");
		ret.put("DESCRIPTION", "m_description");
		ret.put("PRICE", "m_price");
		
		return ret;
	}
	
	@Override
	public boolean Grava()
	{
		super.Grava();
		
		return true;
	}
	
	@Override
	public boolean Carrega(int code)
	{
		super.Carrega(code);
		
		return true;
	}
	
	public static ArrayList<Product> ListaTodos(){
		SQLSelect select = new SQLSelect("T_PRODUCT");
		
		select.getBody().put("ID", "m_code");

		ResultSet result = DataAdapter.getCurrent().ExecuteSelect(select.getSQL());
		
		ArrayList<Product> produtos = new ArrayList<Product>();
		
		try {
			while(result.next())
			{
				produtos.add(new Product(result.getInt("m_code")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
