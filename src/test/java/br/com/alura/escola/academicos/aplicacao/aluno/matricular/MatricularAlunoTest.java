package br.com.alura.escola.academicos.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		// MOCK -> mockito

		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();

		PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
		publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());

		MatricularAluno useCase = new MatricularAluno(repositorio, publicadorDeEventos);

		MatricularAlunoDto dados = new MatricularAlunoDto("Roberto", "401.735.868-30", "aluno@gmail.com");
		useCase.executa(dados);

		Aluno encontrado = repositorio.buscarPorCPF(new CPF("401.735.868-30"));

		assertEquals("Roberto", encontrado.getNome());
		assertEquals("401.735.868-30", encontrado.getCpf().getNumero());
		assertEquals("aluno@gmail.com", encontrado.getEmail());

	}

}
