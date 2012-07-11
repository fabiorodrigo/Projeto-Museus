<%@ page contentType="text/html; charset=ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"    %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

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
		<div id="list-reserva" class="content scaffold-list">
			<h1><bean:message key="titulo.ListagemDeReservas" /></h1>
			
			<table>
				<thead>
					<tr>
						<th><bean:message key="prompt.enderecoEmail" /></th>
						<th><bean:message key="prompt.cor" /></th>
						<th><bean:message key="prompt.tetoSolar" /></th>
						<th><bean:message key="prompt.vidroEletrico" /></th>
						<th><bean:message key="prompt.portas" /></th>
						<th><bean:message key="prompt.agencia" /></th>
					</tr>
				</thead>
				<tbody>
                    <c:set var="status" value="0" />
                    <logic:iterate name="reservas" id="reserva">
                        <tr class="${(pageScope.status % 2) == 0 ? 'even' : 'odd'}">
                            <c:set var="status" value="${pageScope.status + 1}" />
                            <td>
                                <html:link action="/reserva/exibir.do?metodo=recuperaUmaReserva" 
                                           paramId="numero"          
                                           paramName="reserva" 
                                           paramScope="page" 
                                           paramProperty="numero">
                                    ${reserva.enderecoEmail}
                                </html:link>

								<%--  O tag <html:link> acima implementa:
								
								      <a href="/struts04/reserva/exibir.do;jsessionid=xxxxxx?metodo=recuperarReserva&id=${emp.id}">
								          joaooliveira@gmail.com
								      </a>
								--%>
                            </td>
					
                            <td>${pageScope.reserva.cor}</td>
                            <td>${pageScope.reserva.tetoSol}</td>
                            <td>${pageScope.reserva.vidroElet}</td>
                            <td>${pageScope.reserva.portas}</td>
                            <td>${pageScope.reserva.agencia}</td>
                        </tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	
		<div class="footer"></div>
	</body>
</html>


