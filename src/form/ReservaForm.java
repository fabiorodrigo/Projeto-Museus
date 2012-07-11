package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

public class ReservaForm extends ActionForm 
{	
	private final static long serialVersionUID = 1;

	private long numero;
	private String enderecoEmail;
  	private String cor;
	private boolean tetoSolar;
	private boolean vidroEletrico;
  	private String portas;
  	private String agencia;

  	public ReservaForm() 
	{	
  		this.portas = "4";
  	}

  	public ReservaForm(Long numero, String enderecoEmail, String cor, 
	                   boolean tetoSolar, boolean vidroEletrico, 
  	                   String portas, String agencia) 
  	{	this.numero = numero;
  		this.enderecoEmail = enderecoEmail;
    	this.cor = cor;
    	this.tetoSolar = tetoSolar;
    	this.vidroEletrico = vidroEletrico;    	
    	this.portas = portas;    	
    	this.agencia = agencia; 
    }

  	public ActionErrors validate(ActionMapping mapping, 
                                 HttpServletRequest req )
	{	ActionErrors erros = new ActionErrors();

		// Obtém acesso ao message resources para este módulo de aplicação
		
		MessageResources resources = 
			(MessageResources) req.getAttribute(Globals.MESSAGES_KEY);
				
		// É interessante verificar se o campo é igual a null para o 
		// caso da tabela no banco de dados aceitar nulos.
    	if(enderecoEmail == null || enderecoEmail.trim().length() == 0) 
		{	String promptEnderecoEmail = resources.getMessage("prompt.enderecoEmail");
			
			ActionMessage novoErro = new ActionMessage("erro.global.campo.requerido",
														promptEnderecoEmail);
			
			erros.add("enderecoEmail", novoErro);
    	}
    	
    	if(cor == null || cor.trim().length() == 0) 
		{	String promptCor = resources.getMessage("prompt.cor");
			ActionMessage novoErro = new ActionMessage("erro.global.campo.requerido", promptCor);
			erros.add("cor", novoErro);
    	}

    	if(portas == null || portas.trim().length() == 0) 
		{	
    		String promptPortas = resources.getMessage("prompt.portas");
    		ActionMessage novoErro = new ActionMessage("erro.global.campo.requerido", promptPortas);
			erros.add("portas", novoErro);
    	}

    	if(agencia == null || agencia.trim().length() == 0) 
		{	String promptAgencia = resources.getMessage("prompt.agencia");
			ActionMessage novoErro = new ActionMessage("erro.global.campo.requerido", promptAgencia);
			erros.add("agencia", novoErro);
    	}

   		return erros;
  	}

	public long getNumero()
	{	return numero;
	}
	
	public String getEnderecoEmail()
	{	return enderecoEmail;
	}
	
	public String getCor()
	{	return cor;
	}
	
	public boolean getTetoSolar()
	{	return tetoSolar;
	}
	
	public boolean getVidroEletrico()
	{	return vidroEletrico;
	}
	
	public String getTetoSol()
	{	return ((tetoSolar) ? "Sim" : "Não");
	}
	
	public String getVidroElet()
	{	return ((vidroEletrico) ? "Sim" : "Não");
	}
	
	public String getPortas()
	{	return portas;
	}
	
	public String getAgencia()
	{	return agencia;
	}
	
	public void setNumero(long numero)
	{	this.numero = numero;
	}

	public void setEnderecoEmail(String enderecoEmail)
	{	this.enderecoEmail = enderecoEmail;
	}

	public void setCor(String cor)
	{	this.cor = cor;
	}

	public void setTetoSolar(boolean tetoSolar)
	{	this.tetoSolar = tetoSolar;
	}

	public void setVidroEletrico(boolean vidroEletrico)
	{	this.vidroEletrico = vidroEletrico;
	}

	public void setPortas(String portas)
	{	this.portas = portas;
	}

	public void setAgencia(String agencia)
	{	this.agencia = agencia;
	}
}