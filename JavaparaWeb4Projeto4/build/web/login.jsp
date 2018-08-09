
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="cabecalho.jsp"/>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tagsNeri" %>
<div id="login">
    <form action="Logar" method="get">
        <table border="1">
            <tr>
                <td colspan="2"><h1>Acesso ao Sistema</h1></td>                    
            </tr>
            <tr>
                <td>Usuário.:</td>
                <td><input autofocus placeholder="usuario" autocomplete="on" required="true" type="text" name="usuario"></td>           
            </tr>
            <tr>
                <td>Senha.:</td>
                <td><input placeholder="senha" required="true" type="password" name="senha"></td>           
            </tr>
            <tr>
                <td><input type="reset" value="Limpar"></td>
                <td><input type="submit" name="acessar" value="Acessar"></td>
            </tr>
            <tr>
                <td colspan="2"><h1><tagsNeri:statusUsuarioSenha/></h1></td>                    
            </tr>

        </table>
    </form>
</div>
<c:import url="rodape.jsp"/>