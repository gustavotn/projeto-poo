package model;

import data.DataAdapter;
import data.SQLSelect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class User extends Entity {
    public User()
    {
        super();
    }

    public User (int code)
    {
        this.Carrega(code);
    }

    private String m_name;
    private String m_password;

    public String getName() {
        return m_name;
    }

    public void setName(String value) {
        this.m_name = value;
    }

    public String getPassword() {
        return m_password;
    }

    public void setPassword(String value) {
        this.m_password = value;
    }

    @Override
    public String getTable()
    {
        return "T_USER";
    }

    @Override
    public Map<String, String> getColumns(){
        Map<String, String> ret = super.getColumns();

        ret.put("NAME", "setName");
        ret.put("PASSWORD", "setPassword");

        return ret;
    }

    @Override
    public boolean Grava()
    {
        return super.Grava();
    }

    @Override
    public boolean Carrega(int code)
    {
        return super.Carrega(code);
    }

    public static ArrayList<User> ListaTodos()
    {
        SQLSelect select = new SQLSelect("T_PRODUCT");

        select.getBody().put("ID", "m_code");

        ResultSet result = DataAdapter.getCurrent().ExecuteSelect(select.getSQL());

        ArrayList<User> users = new ArrayList<User>();

        try {
            while(result.next())
            {
                users.add(new User(result.getInt("m_code")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}

