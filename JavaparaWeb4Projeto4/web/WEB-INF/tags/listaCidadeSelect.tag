<%@tag body-content="empty" %>
<<jsp:useBean id="beanCidade" class="br.com.videoaulasneri.dao.CidadeDao"></jsp:useBean>
<%
    //CODIFICAÇÃO TODA EM JAVA
    String selected="";
    java.util.List listaDeCidade = (java.util.List) beanCidade.getListaCidadeCombo();
    //out.println("<option value='baicodigo' >Código</option>");
    for (java.util.Iterator iterator = listaDeCidade.iterator(); iterator.hasNext();) {
        br.com.videoaulasneri.javabean.model.CidadeModel cidade = (br.com.videoaulasneri.javabean.model.CidadeModel) iterator.next();
        int cidCodigo = cidade.getCidCodigo();
        String cidDescricao = cidade.getCidDescricao();
        if (request.getParameter("cidcodigo") != null) {
        	if (cidCodigo == Integer.parseInt(request.getParameter("cidcodigo")))
        		selected="selected";
        	else
        		selected="";
        }
        out.println("<option value="+cidCodigo+" "+selected+">" + cidDescricao + "</option>");
		
    }

%>