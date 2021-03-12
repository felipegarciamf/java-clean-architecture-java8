package br.com.alura.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.interfaces.RepositorioDeAlunos;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

	private List<Aluno> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
		System.out.println(aluno.getNome() + " Matriculado com sucesso!");
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		Aluno aluno = this.matriculados.stream()
		.filter(a -> a.getCpf().equals(cpf.getNumero()))
		.findFirst()
		.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
		System.out.println(aluno.getCpf() + " Encontrado!");
		return aluno;
		 
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}

}
