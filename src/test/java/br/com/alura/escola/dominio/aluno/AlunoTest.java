package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;

class AlunoTest {
	
	
	private static MatricularAlunoDto dados;
	private Aluno aluno;


	@BeforeAll
	public static void init() {
		dados = new MatricularAlunoDto("Jose", "401.735.868-30", "jose@gmail.com");
	}
	

	@Test
	void deveRetornarUmaExcecaoCadastroDeTelefoneExcedido() {
		aluno = dados.criarAluno();
	
		assertThrows(CadastroDeTelefoneExcedido.class, () -> {
			aluno.adicionarTelefone("11", "968613451");
			aluno.adicionarTelefone("11", "968613451");
			aluno.adicionarTelefone("11", "968613451");
		});

	}

}
