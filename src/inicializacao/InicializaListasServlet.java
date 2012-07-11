package inicializacao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servico.CorAppService;

public class InicializaListasServlet extends HttpServlet 
{	private final static long serialVersionUID = 1;

	ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");
	
	private CorAppService corAppService = (CorAppService)
		fabrica.getBean ("corAppService");
	
	public void init(ServletConfig config) throws ServletException		
	{		
		try
		{	System.out.println("**************>>> Inicializando Lista de cores");
			config.getServletContext()
				.setAttribute("listaDeCores", corAppService.recuperaCores());
		}
		catch (Exception e)
		{	// Efetuar log utilizando LOG4J.
			e.printStackTrace();
			throw new ServletException(e);
		}
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
    	throws ServletException 
	{
	}
}