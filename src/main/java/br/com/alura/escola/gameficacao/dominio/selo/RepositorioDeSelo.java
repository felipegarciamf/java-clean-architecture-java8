package br.com.alura.escola.gameficacao.dominio.selo;

import java.util.List;

import br.com.alura.escola.shared.dominio.CPF;

public interface RepositorioDeSelo {
	
	void incluirSelo(Selo selo);
	
	List<Selo> selosDoAlunoDoCPF(CPF cpf);

}
