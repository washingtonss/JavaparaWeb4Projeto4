<%@tag body-content="empty" %>
<jsp:useBean id="beanBairro" class="br.com.videoaulasneri.dao.BairroDao"></jsp:useBean>
<%
    String selected="";
    java.util.List listaDeBairro = (java.util.List) beanBairro.getListaBairroParaSelectOption();
    //out.println("<option value='baicodigo' >C�digo</option>");
    for (java.util.Iterator iterator = listaDeBairro.iterator(); iterator.hasNext();) {
        br.com.videoaulasneri.javabean.model.BairroModel bairro = (br.com.videoaulasneri.javabean.model.BairroModel) iterator.next();
        int baiCodigo = bairro.getBaiCodigo();
        String baiDescricao = bairro.getBaiDescricao();
        if (request.getParameter("baicodigo") != null) {
        	if (baiCodigo == Integer.parseInt(request.getParameter("baicodigo")))
        		selected="selected";
        	else
        		selected="";
        }
        out.println("<option value="+baiCodigo+" "+selected+">" + baiDescricao + "</option>");
		
    }

%>