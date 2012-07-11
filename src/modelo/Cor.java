package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COR")
@SequenceGenerator(name="SEQUENCIA", 
		           sequenceName="COR_SEQ",
		           allocationSize=1)

public class Cor
{	
	private Long id;
	private String label;
	private String valor;

	public Cor() 
	{	
	}

	public Cor(String label, String valor) 
	{	this.label = label;
		this.valor = valor;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA")
	public Long getId()
	{	return id;
	}
	
	public String getLabel()
	{	return label;
	}
	
	public String getValor()
	{	return valor;
	}

	public void setId(Long id) 
	{	this.id = id;
	}

	public void setLabel(String label) 
	{	this.label = label;
	}

	public void setValor(String valor) 
	{	this.valor = valor;
	}
}