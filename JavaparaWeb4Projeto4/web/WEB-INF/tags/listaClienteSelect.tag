<%@tag body-content="empty" %>
<jsp:useBean id="beanCliente" class="br.com.videoaulasneri.dao.ClienteDao"></jsp:useBean>
<%
    String selected="";
    java.util.List listaDeCliente = (java.util.List) beanCliente.getListaClienteParaSelectOption();
    //out.println("<option value='baicodigo' >C�digo</option>");
    for (java.util.Iterator iterator = listaDeCliente.iterator(); iterator.hasNext();) {
        br.com.videoaulasneri.javabean.model.ClienteModel clienteModel = (br.com.videoaulasneri.javabean.model.ClienteModel) iterator.next();
        int cliCodigo = clienteModel.getCliCodigo();
        String cliNome = clienteModel.getCliNome();
        out.println("<option value="+cliCodigo+">" + cliNome + "</option>");		
    }
%>