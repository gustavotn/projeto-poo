package backend;

import data.DataAdapter;

import model.Product;

public class Backend {

	public static void main(String[] args) {
		DataAdapter.getCurrent().Connect();

		for(Product product : Product.ListaTodos()) {
			System.out.println(product.getName());
		}
	}
}
