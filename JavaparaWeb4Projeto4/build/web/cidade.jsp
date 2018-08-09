
<%@taglib tagdir="/WEB-INF/tags" prefix="tagsNeri" %>
<tagsNeri:verificaSessao/>
<%@taglib tagdir="/WEB-INF/tags" prefix="tagsNeri" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="cabecalho.jsp"/>

<form id="formCidade" method="get" action="Cidade">
    <c:choose>
        <c:when test="${param.acao eq 'novo'}">
            <h1>Nova Cidade</h1><br>                    

            <div class="campos">
                <label for="ciddescricao">Descrição.:</label>
                <input type="text" name="ciddescricao"  id="descricao" required="true" size="30" maxlength="30"/>
            </div><br>
            <div class="campos">
                <label for="cidcodigo">Código.:</label>
                <input type="text" value="${param.cidcodigo}" name="cidcodigo"  id="cidcodigo" required="true" size="5" readonly="true"/>
            </div><br>
            <div class="campos">
                <label for="ciduf">UF.:</label>
                <input type="text" value="${param.ciduf}" name="ciduf"  id="ciduf" required="true" size="2" maxlength="30"/>
            </div><br>
            <input type="submit" name="acao" value="novo"/>
        </c:when>
        <c:otherwise>
            <h1>Alteração de Cidade</h1><br>
            <div class="campos">
                <label for="cidcodigo">Código.:</label>
                <input type="text" value="${param.cidcodigo}" name="cidcodigo"  id="cidcodigo" required="true" size="5" readonly="true"/>
            </div><br>
            <div class="campos">
                <label for="ciddescricao">Descrição.:</label>
                <input type="text" value="${param.ciddescricao}" name="ciddescricao"  id="ciddescricao" required="true" size="30" maxlength="30"/>
            </div><br>
            <div class="campos">
                <label for="ciduf">UF.:</label>
                <input type="text" value="${param.ciduf}" name="ciduf"  id="ciduf" required="true" size="2" maxlength="30"/>
            </div><br>
            <input type="submit" name="acao" value="alterar"/>
        </c:otherwise>
    </c:choose>
</form>
<c:import url="rodape.jsp"/>
