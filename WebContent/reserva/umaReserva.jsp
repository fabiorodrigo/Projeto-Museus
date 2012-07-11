<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"    %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>

                <fieldset class="form">

                    <c:set var="erroEnderecoEmail" value="" />
                    <html:messages id="mensagem" property="enderecoEmail">
                        <c:set var="erroEnderecoEmail" value="error" />
                    </html:messages>

                    <div class="fieldcontain ${pageScope.erroEnderecoEmail}">
                        
                        <label for="enderecoEmail">
                        	<bean:message key="prompt.enderecoEmail" />
                        </label>
                        
                        <html:text property="enderecoEmail" size="30" maxlength="30"/>
			            
                    </div>

                    <c:set var="erroCor" value="" />
                    <html:messages id="mensagem" property="cor">
                        <c:set var="erroCor" value="error" />
                    </html:messages>

                    <div class="fieldcontain ${pageScope.erroCor}">
                
                        <label for="cor">
                        	<bean:message key="prompt.cor" />
                        </label>
                        
                        <html:select property="cor">
                            <html:option value="">
                                Escolha uma cor
                            </html:option>
		
                            <html:optionsCollection 
                                name="listaDeCores"
                                label="label"
                                value="valor"/>
                        </html:select>
                        <%--
                        <select name="cor">
                            <option value="" selected="selected">Escolha uma cor</option>
                            <option value="azul">Azul</option>
                            <option value="vermelho">Vermelho</option>
                            <option value="verde">Verde</option>
                        </select>
                        --%>
                    </div>

                    <div class="fieldcontain">
                        
                        <label for="tetoSolar">
                        	Opcionais
                        </label>
                        
                        <!-- O atributo value deve conter o valor que deve ser enviado. 
                             O default é "on" 
                        -->             
                        <html:checkbox property="tetoSolar" value="on" />&nbsp;&nbsp;Teto Solar&nbsp;&nbsp;&nbsp;
                        <html:checkbox property="vidroEletrico" value="on" />&nbsp;&nbsp;Vidro Elétrico

                        <%-- <input type="checkbox" name="tetoSolar" value="on">Teto Solar --%>
			            
                    </div>

                    <c:set var="erroPortas" value="" />
                    <html:messages id="mensagem" property="portas">
                        <c:set var="erroPortas" value="error" />
                    </html:messages>

                    <div class="fieldcontain ${pageScope.erroPortas}">
                        
                        <label for="portas">
                        	<bean:message key="prompt.portas" />
                        </label>
                        
                        <html:radio property="portas" value="2"/>&nbsp;&nbsp;Duas&nbsp;&nbsp;&nbsp;&nbsp;
                        <html:radio property="portas" value="4"/>&nbsp;&nbsp;Quatro
                        <%-- <input type="radio" name="portas" value="4">Duas  --%>

                    </div>

                    <c:set var="erroAgencia" value="" />
                    <html:messages id="mensagem" property="agencia">
                        <c:set var="erroAgencia" value="error" />
                    </html:messages>

                    <div class="fieldcontain ${pageScope.erroAgencia}">
                        
                        <label for="agencia">
                        	<bean:message key="prompt.agencia" />
                        </label>
                        
                        <html:select property="agencia" size="4">
                            <html:option value="Botafogo">
                                Botafogo
                            </html:option>
                     
                            <html:option value="Centro">
                                Centro
                            </html:option>
                      
                            <html:option value="Copacabana">
                                Copacabana
                            </html:option>
                     
                            <html:option value="Gavea">
                                Gávea
                            </html:option>
                      
                            <html:option value="Ipanema">
                                Ipanema
                            </html:option>
                        </html:select>

                        <%--   
                            <select name="agencia" size="4">
                                <option value="Botafogo">Botafogo</option>
                                <option value="Centro">Centro</option>
                                <option value="Copacabana">Copacabana</option>
                                <option value="Gavea">Gávea</option>
                                <option value="Ipanema">Ipanema</option>
                            </select>
                        --%>

                    </div>

                </fieldset>
