package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="RESERVA")
@SequenceGenerator(name="SEQUENCIA", 
		           sequenceName="RESERVA_SEQ",
		           allocationSize=1)

public class Reserva
{	
	private Long numero;
	private String enderecoEmail;
  	private String cor;
  	private boolean tetoSolar;
  	private boolean vidroEletrico;
  	private String portas;
  	private String agencia;

  	public Reserva() 
  	{	
  	}

  	public Reserva(Long numero, String enderecoEmail, String cor, 
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

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA")
	public Long getNumero()
	{	return numero;
	}
	
	@Column(name="ENDERECO_EMAIL")
	public String getEnderecoEmail()
	{	return enderecoEmail;
	}
	
	public String getCor()
	{	return cor;
	}
	
	@Column(name="TETO_SOLAR")
	public boolean getTetoSolar()
	{	return tetoSolar;
	}
	
	@Column(name="VIDRO_ELETRICO")
	public boolean getVidroEletrico()
	{	return vidroEletrico;
	}
	
	@Transient
	public String getTetoSol()
	{	return ((tetoSolar) ? "Sim" : "Não");
	}
	
	@Transient
	public String getVidroElet()
	{	return ((vidroEletrico) ? "Sim" : "Não");
	}

	public String getPortas()
	{	return portas;
	}
	
	public String getAgencia()
	{	return agencia;
	}
	
	public void setNumero(Long numero)
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