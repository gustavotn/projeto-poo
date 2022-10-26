package backend;

import data.DataAdapter;
import model.Pessoa;

public class Backend {

	public static void main(String[] args) {
		DataAdapter.getCurrent().Connect();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.Carrega("");
	}
}
