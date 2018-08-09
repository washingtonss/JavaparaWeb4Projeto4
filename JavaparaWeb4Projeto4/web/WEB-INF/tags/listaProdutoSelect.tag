
<%@tag body-content="empty" %>
<jsp:useBean id="beanCliente" class="br.com.videoaulasneri.dao.ProdutoDao"></jsp:useBean>
<% 
  String selected="";
  java.util.List listaDeProduto = (java.util.List) beanCliente.getListaProdutoParaSelectOption();
  for (java.util.Iterator iterator = listaDeProduto.iterator(); iterator.hasNext();){
  br.com.videoaulasneri.javabean.model.ProdutoModel produtoModel = (br.com.videoaulasneri.javabean.model.ProdutoModel) iterator.next();
  int proCodigo = produtoModel.getProCodigo();
  String proDescricao = produtoModel.getProDescricao();
  out.println("<option value="+proCodigo+">" + proDescricao + "</option>");
}


%>