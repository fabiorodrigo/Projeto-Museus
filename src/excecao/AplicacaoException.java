package excecao;

public class AplicacaoException extends Exception
{	
	private final static long serialVersionUID = 1;
	
	public AplicacaoException()
	{	super();
	}

	public AplicacaoException(String msg)
	{	super(msg);
	}

	public AplicacaoException(Exception e)
	{	super(e);
	}
}	