<%@ page contentType="text/html; charset=ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"    %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!doctype html>
	<head>
		<title><bean:message key="titulo.exibir.reserva" /></title>
		<link href="<html:rewrite page="/css/main.css" />" rel="stylesheet">
        <script>
            function set(valor) 
            {    document.forms[0].metodo.value=valor;
            }
        </script>
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
				    <html:link action="/reserva/listar.do?metodo=recuperaTodasReservas" styleClass="list">
				        <bean:message key="titulo.ListagemDeReservas"/>
				    </html:link>
				</li>
				<li>
				    <html:link action="/reserva/criar.do" styleClass="create">
				        <bean:message key="nova.reserva"/>
				    </html:link>
				</li>
			</ul>
		</div>
		<div id="show-reserva" class="content scaffold-show">
			<h1><bean:message key="titulo.exibir.reserva"/></h1>

			<ol class="property-list reserva">
				<li class="fieldcontain">
					<span id="enderecoEmail-label" class="property-label"><bean:message key="prompt.enderecoEmail"/></span>
					<span class="property-value">${requestScope.reserva.enderecoEmail}</span>
				</li>
				
				<li class="fieldcontain">
					<span id="cor-label" class="property-label"><bean:message key="prompt.cor"/></span>
					<span class="property-value">${requestScope.reserva.cor}</span>
				</li>
				
				<li class="fieldcontain">
					<span id="tetoSolar-label" class="property-label"><bean:message key="prompt.tetoSolar"/></span>
					<span class="property-value">${requestScope.reserva.tetoSol}</span>
				</li>

				<li class="fieldcontain">
					<span id="vidroEletrico-label" class="property-label"><bean:message key="prompt.vidroEletrico"/></span>
					<span class="property-value">${requestScope.reserva.vidroElet}</span>
				</li>

				<li class="fieldcontain">
					<span id="portas-label" class="property-label"><bean:message key="prompt.portas"/></span>
					<span class="property-value">${requestScope.reserva.portas}</span>
				</li>

				<li class="fieldcontain">
					<span id="agencia-label" class="property-label"><bean:message key="prompt.agencia"/></span>
					<span class="property-value">${requestScope.reserva.agencia}</span>
				</li>
			</ol>
			<html:form action="/reserva/editarOuRemover.do">
				<fieldset class="buttons">

                    <html:hidden property="numero" value="${requestScope.reserva.numero}" />
                    
                    <input type="hidden" name="metodo" value="" />
					
					<html:submit value="Editar"  styleClass="edit"   onclick="set('recuperaUmaReservaParaAlterar');"/>
					
					<html:submit value="Remover" styleClass="delete" onclick="set('removeReserva');"/>
					
				</fieldset>
			</html:form>
		</div>
	
		<div class="footer"></div>
	</body>
</html>



