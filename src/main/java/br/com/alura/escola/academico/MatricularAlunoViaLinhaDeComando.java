package br.com.alura.escola.academico;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.interfaces.RepositorioDeAlunos;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
	
	public static void main(String[] args) {
		
		RepositorioDeAlunos repositorioDeAlunosEmMemoria = new RepositorioDeAlunosEmMemoria();
		String nome = "Fulano da silva";
		String cpf = "401.735.868-30";
		String email = "fulano@email.com";
	
		PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
		publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
		
		MatricularAluno matricularAluno = new MatricularAluno(repositorioDeAlunosEmMemoria, publicadorDeEventos);
		
		matricularAluno.executa(new MatricularAlunoDto(nome, cpf, email));
		
		repositorioDeAlunosEmMemoria.buscarPorCPF(new CPF("401.735.868-30"));
		
		
	}

}
