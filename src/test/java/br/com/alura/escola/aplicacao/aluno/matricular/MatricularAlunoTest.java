package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		// MOCK -> mockito
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		MatricularAluno useCase = new MatricularAluno(repositorio);
		
		
		MatricularAlunoDto dados = new MatricularAlunoDto("Roberto", "401.735.868-30", "aluno@gmail.com");
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCPF(new CPF("401.735.868-30"));
		
		assertEquals("Roberto", encontrado.getNome());
		assertEquals("401.735.868-30", encontrado.getCpf());
		assertEquals("aluno@gmail.com", encontrado.getEmail());
		
		
		
	}

}
