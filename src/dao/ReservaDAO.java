package dao;

import java.util.List;

import modelo.Reserva;
import excecao.ObjetoNaoEncontradoException;


public interface ReservaDAO
{	
	long inclui(Reserva umaReserva); 

	void altera(Reserva umaReserva)
		throws ObjetoNaoEncontradoException; 
	
	void exclui(long id) 
		throws ObjetoNaoEncontradoException; 
	
	Reserva recuperaUmaReserva(long numero) 
		throws ObjetoNaoEncontradoException; 
	
	List<Reserva> recuperaReservas();
}