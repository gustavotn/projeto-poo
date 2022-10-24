package backend;

import data.ConnectionDB;

public class backend {

	public static void main(String[] args) {
		ConnectionDB.getCurrent().Connect();
	}

}
