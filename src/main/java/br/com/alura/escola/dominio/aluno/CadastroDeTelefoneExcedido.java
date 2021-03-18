package br.com.alura.escola.dominio.aluno;

public class CadastroDeTelefoneExcedido extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroDeTelefoneExcedido() {
		super("Quantidade de telefone maior que 2");
	}

}
