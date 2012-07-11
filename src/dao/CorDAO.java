package dao;

import java.util.List;

import modelo.Cor;
import excecao.ObjetoNaoEncontradoException;


public interface CorDAO
{	
	long inclui(Cor umaCor); 

	void altera(Cor umaCor)
		throws ObjetoNaoEncontradoException; 
	
	void exclui(long id) 
		throws ObjetoNaoEncontradoException; 
	
	Cor recuperaUmaCor(long numero) 
		throws ObjetoNaoEncontradoException; 
	
	List<Cor> recuperaCores();
}