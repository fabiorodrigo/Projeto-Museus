<%@ page contentType="text/html; charset=ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"    %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>

<!doctype html>
	<head>
		<title><bean:message key="titulo.aplicacao" /></title>
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
				<li><html:link action="/reserva/listar.do?metodo=recuperaTodasReservas" styleClass="list">Listagem de Reservas</html:link></li>
			</ul>
		</div>
		
        <div class="content scaffold-create">
            <h1><bean:message key="titulo.editar.reserva" /></h1>

            <html:errors />

            <html:form action="/reserva/salvaOuAtualiza.do" focus="enderecoEmail">
                
                <%@ include file='umaReserva.jsp' %>

				<input type="hidden" name="metodo" value="salvaOuAtualizaReserva" />
				
				<html:hidden property="numero"/>

				<fieldset class="buttons">
                    <html:submit value="Atualizar" styleClass="save" />
                </fieldset>
            </html:form>
        </div>
	
		<div class="footer"></div>
	</body>
</html>

