package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Reserva;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servico.ReservaAppService;
import excecao.AplicacaoException;
import form.ReservaForm;

public class ReservaActions extends DispatchAction 
{	
	ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

	private ReservaAppService reservaAppService = (ReservaAppService)
		fabrica.getBean ("reservaAppService");

	public ActionForward recuperaTodasReservas(ActionMapping mapping,
                                               ActionForm form,
                                               HttpServletRequest request,
                                               HttpServletResponse response)
        throws Exception 
    {	
        List<Reserva> reservas = reservaAppService.recuperaReservas();

        if (reservas.size() > 0)
        {	
        	request.setAttribute("reservas", reservas);
            
        	return mapping.findForward("Listar");
        }
        else
        {	
        	return mapping.findForward("Inexistente");
        }
    }

	public ActionForward salvaOuAtualizaReserva(ActionMapping mapping,
                                                ActionForm form,
                                                HttpServletRequest request,
                                                HttpServletResponse response)
        throws Exception 
    {	Reserva umaReserva = new Reserva(
    						((ReservaForm)form).getNumero(),
    						((ReservaForm)form).getEnderecoEmail(),
    						((ReservaForm)form).getCor(),
    						((ReservaForm)form).getTetoSolar(),
    						((ReservaForm)form).getVidroEletrico(),
    						((ReservaForm)form).getPortas(),
    						((ReservaForm)form).getAgencia());

    	// Reserva umaReserva = new Reserva();
    	// RequestUtils.populate(umaReserva, request);

    	if (((ReservaForm)form).getNumero() == 0)
    	{	
    		umaReserva.setNumero(null);
    		reservaAppService.inclui(umaReserva);

    		request.setAttribute("reserva", umaReserva);

    		return mapping.findForward("Exibir");
    	}
    	else
    	{	
    		try
    		{	reservaAppService.altera(umaReserva);

    			request.setAttribute("reserva", umaReserva);

    			return mapping.findForward("Exibir");
    		}
    		catch(AplicacaoException e)
    		{	
    			return mapping.findForward("Inexistente");
    		}
    	}
    }

	public ActionForward removeReserva(ActionMapping mapping,
			                           ActionForm form,
			                           HttpServletRequest request,
			                           HttpServletResponse response)
        throws Exception 
    {	
		long numero;

		try
		{	numero = Long.parseLong(request.getParameter("numero"));
		}
		catch(NumberFormatException e)
		{	numero = -1L;
		}

		try
		{	reservaAppService.exclui(numero);
			
			return recuperaTodasReservas(mapping, form, request, response);
		}
		catch(AplicacaoException e)
		{
			return mapping.findForward("Inexistente");
		}
    }

	public ActionForward recuperaUmaReserva(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response)
    	throws Exception 
	{	
		long numero;
		
		try
		{	numero = Long.parseLong(request.getParameter("numero"));
		}
		catch(NumberFormatException e)
		{
			numero = -1L;
		}
		
    	try
    	{	 Reserva reserva = reservaAppService.recuperaUmaReserva(numero);
    		     		 
    		request.setAttribute("reserva", reserva);
		
    		return mapping.findForward("Exibir");
    	}
    	catch(AplicacaoException e)
    	{	
    		return mapping.findForward("Inexistente");
    	}
	}

	public ActionForward recuperaUmaReservaParaAlterar(ActionMapping mapping,
                                                       ActionForm form,
                                                       HttpServletRequest request,
                                                       HttpServletResponse response)
        throws Exception 
    {	
		long numero;

		try
		{	numero = Long.parseLong(request.getParameter("numero"));
		}
		catch(NumberFormatException e)
		{
			numero = -1L;
		}

		try
		{	 Reserva reserva = reservaAppService.recuperaUmaReserva(numero);

			((ReservaForm)form).setNumero(reserva.getNumero()); 
			((ReservaForm)form).setEnderecoEmail(reserva.getEnderecoEmail());
			((ReservaForm)form).setCor(reserva.getCor());
			((ReservaForm)form).setTetoSolar(reserva.getTetoSolar());
			((ReservaForm)form).setVidroEletrico(reserva.getVidroEletrico());
			((ReservaForm)form).setPortas(reserva.getPortas());
			((ReservaForm)form).setAgencia(reserva.getAgencia());

			return mapping.findForward("Editar");
		}
		catch(AplicacaoException e)
		{
			return mapping.findForward("Inexistente");
		}
    }
}