package br.com.alura.escola.dominio.aluno.interfaces;

import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;

public interface RepositorioDeAlunos {
	
	void matricular(Aluno aluno);
	
	Aluno buscarPorCPF(CPF cpf);
	
	List<Aluno> listarTodosAlunosMatriculados();
	
	//...

}
