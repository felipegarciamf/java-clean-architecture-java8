package br.com.alura.escola.gameficacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.alura.escola.gameficacao.dominio.selo.Selo;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelo {

	private List<Selo> selos = new ArrayList<Selo>();

	@Override
	public void incluirSelo(Selo selo) {
		selos.add(selo);
	}

	@Override
	public List<Selo> selosDoAlunoDoCPF(CPF cpf) {
		return this.selos.stream().filter(s -> s.getCpfDoAluno().getNumero().equals(cpf.getNumero()))
				.collect(Collectors.toList());
	}

}
