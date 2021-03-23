package br.com.alura.escola.academicos.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.academico.dominio.aluno.CadastroDeTelefoneExcedido;
import br.com.alura.escola.academico.dominio.aluno.Email;

class AlunoTest {

	private Aluno aluno;

	@BeforeEach
	public void beforeEach() {
		this.aluno = new Aluno(new CPF("401.735.858-30"), "fulano", new Email("fulano@gmail.com"));
	}

	@Test
	void devePermitirAdicionar1Telefone() {
		this.aluno.adicionarTelefone("11", "968613451");
		assertEquals(1, this.aluno.getTelefones().size());
	}

	@Test
	void devePermitirAdicionar2Telefone() {
		this.aluno.adicionarTelefone("11", "968613451");
		this.aluno.adicionarTelefone("11", "968613451");
		assertEquals(2, this.aluno.getTelefones().size());
	}

	@Test
	void naoDevePermitirAdicionar3Telefones() {

		assertThrows(CadastroDeTelefoneExcedido.class, () -> {
			aluno.adicionarTelefone("11", "968613451");
			aluno.adicionarTelefone("11", "968613451");
			aluno.adicionarTelefone("11", "968613451");
		});

	}

}
