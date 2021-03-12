package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.interfaces.RepositorioDeAlunos;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
	
	public static void main(String[] args) {
		
		RepositorioDeAlunos repositorioDeAlunosEmMemoria = new RepositorioDeAlunosEmMemoria();
		String nome = "Fulano da silva";
		String cpf = "401.735.868-30";
		String email = "fulano@email.com";
	
		MatricularAluno matricularAluno = new MatricularAluno(repositorioDeAlunosEmMemoria);
		
		matricularAluno.executa(new MatricularAlunoDto(nome, cpf, email));
		
		repositorioDeAlunosEmMemoria.buscarPorCPF(new CPF("401.735.868-30"));
		
		
	}

}
