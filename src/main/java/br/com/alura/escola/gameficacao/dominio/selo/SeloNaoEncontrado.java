package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;

public class SeloNaoEncontrado extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeloNaoEncontrado(CPF cpf) {
		super("Não foi encontrado o selo para o CPF: " + cpf);
	}

	

	
}
