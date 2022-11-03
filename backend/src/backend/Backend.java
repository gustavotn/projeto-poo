package backend;

import data.DataAdapter;

import model.Product;

public class Backend {

	public static void main(String[] args) {
		DataAdapter.getCurrent().Connect();
		
		Product pessoa = new Product(2);
		
		System.out.print(pessoa.getCode());
	}
}
