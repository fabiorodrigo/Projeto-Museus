package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import modelo.Cor;

import org.springframework.stereotype.Repository;

import dao.CorDAO;
import excecao.ObjetoNaoEncontradoException;

@Repository
public class JPACorDAO implements CorDAO
{	
    @PersistenceContext
	private EntityManager em;

    public long inclui(Cor umaCor) 
	{	
		em.persist(umaCor);
		return umaCor.getId();
	}

	public void altera(Cor umaCor) 
		throws ObjetoNaoEncontradoException 
	{	try
		{	em.getReference(Cor.class, umaCor.getId());
		
			em.merge(umaCor);
		}
		catch(EntityNotFoundException e)
		{	throw new ObjetoNaoEncontradoException();
		}
	}

	public void exclui(long id) 
		throws ObjetoNaoEncontradoException 
	{	try
		{	Cor e = em.getReference(Cor.class, new Long(id));
	
			em.remove(e);
		}
		catch(EntityNotFoundException e)
		{	throw new ObjetoNaoEncontradoException();
		}
	}

	public Cor recuperaUmaCor(long id) 
		throws ObjetoNaoEncontradoException 
	{	
		Cor umaCor = em.find(Cor.class, new Long(id));
			
		if (umaCor == null)
		{	throw new ObjetoNaoEncontradoException();
		}

		return umaCor;
	}

	@SuppressWarnings("unchecked")
	public List<Cor> recuperaCores()
	{	
		List<Cor> cores = em
			.createQuery("select c from Cor c order by c.id asc")
			.getResultList();

		return cores;
	}
}