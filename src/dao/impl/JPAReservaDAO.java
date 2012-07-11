package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import modelo.Reserva;

import org.springframework.stereotype.Repository;

import dao.ReservaDAO;
import excecao.ObjetoNaoEncontradoException;

@Repository
public class JPAReservaDAO implements ReservaDAO
{	
    @PersistenceContext
	private EntityManager em;

    public long inclui(Reserva umaReserva) 
	{	
		em.persist(umaReserva);
		return umaReserva.getNumero();
	}

	public void altera(Reserva umaReserva) 
		throws ObjetoNaoEncontradoException 
	{	try
		{	em.getReference(Reserva.class, umaReserva.getNumero());
		
			em.merge(umaReserva);
		}
		catch(EntityNotFoundException e)
		{	throw new ObjetoNaoEncontradoException();
		}
	}

	public void exclui(long id) 
		throws ObjetoNaoEncontradoException 
	{	try
		{	Reserva e = em.getReference(Reserva.class, new Long(id));
	
			em.remove(e);
		}
		catch(EntityNotFoundException e)
		{	throw new ObjetoNaoEncontradoException();
		}
	}

	public Reserva recuperaUmaReserva(long id) 
		throws ObjetoNaoEncontradoException 
	{	
		Reserva umaReserva = em.find(Reserva.class, new Long(id));
			
		if (umaReserva == null)
		{	throw new ObjetoNaoEncontradoException();
		}

		return umaReserva;
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> recuperaReservas()
	{	
		List<Reserva> reservas = em
			.createQuery("select r from Reserva r order by r.numero asc")
			.getResultList();

		return reservas;
	}
}