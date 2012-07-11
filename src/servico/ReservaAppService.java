package servico;

import java.util.List;

import modelo.Reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.ReservaDAO;
import excecao.AplicacaoException;
import excecao.ObjetoNaoEncontradoException;

//@Service
public class ReservaAppService
{	
	@Autowired
	private ReservaDAO reservaDAO;
	
	@Transactional
	public long inclui(Reserva umReserva) 
	{	return reservaDAO.inclui(umReserva);
	}

	@Transactional
	public void altera(Reserva umReserva)
		throws AplicacaoException
	{	try
		{	reservaDAO.altera(umReserva);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AplicacaoException("Reserva não encontrada.");
		}
	}
	
	@Transactional
	public void exclui(long numero) 
		throws AplicacaoException
	{	try
		{	reservaDAO.exclui(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AplicacaoException("Reserva não encontrada.");
		}
	}

	public Reserva recuperaUmaReserva(long numero) 
		throws AplicacaoException
	{	try
		{	return reservaDAO.recuperaUmaReserva(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AplicacaoException("Reserva não encontrada.");
		}
	}

	public List<Reserva> recuperaReservas() 
	{	return reservaDAO.recuperaReservas();
	}
}