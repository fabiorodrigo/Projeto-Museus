<%@ page contentType="text/html; charset=ISO-8859-1" %>

<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>

<!doctype html>
	<head>
		<title><bean:message key="titulo.ListagemDeReservas" /></title>
		<link href="<html:rewrite page="/css/main.css" />" rel="stylesheet">
	</head>
	<body>
		<div id="strutsLogo">
		    <html:link href="http://struts.apache.org/">
		        <html:img page="/images/struts_logo.jpg" alt="Struts" />
		    </html:link>
		</div>
		
		<div class="nav">
			<ul>
				<li><html:link styleClass="home" page="/">Principal</html:link></li>
				<li>
				    <html:link action="/reserva/criar.do" styleClass="create">
				        <bean:message key="nova.reserva"/>
				    </html:link>
				</li>
			</ul>
		</div>
        <div id="list-reserva" class="content scaffold-create">
		
			<h1><bean:message key="titulo.exibir.reserva"/></h1>
			
			<div class="errors">
			    <ul>
			        <li><bean:message key="mensagem.reserva.nao.encontrada"/></li>
                </ul>			        
			</div>
		</div>
		<div class="footer"></div>
	</body>
</html>
