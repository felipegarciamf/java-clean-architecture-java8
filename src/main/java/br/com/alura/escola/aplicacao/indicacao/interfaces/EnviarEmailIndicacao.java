package br.com.alura.escola.aplicacao.indicacao.interfaces;

import br.com.alura.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

	void enviarPara(Aluno indicado);

}
