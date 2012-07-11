package servico;

import java.util.List;

import modelo.Cor;

import org.springframework.beans.factory.annotation.Autowired;

import dao.CorDAO;

// @Service
public class CorAppService
{	
	@Autowired
	private CorDAO corDAO;

	public List<Cor> recuperaCores()
	{	
		return corDAO.recuperaCores();
	}
}