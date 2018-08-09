
package br.com.videoaulasneri.servlets.controller;

import br.com.videoaulasneri.dao.ItensVendaDao;
import br.com.videoaulasneri.dao.VendaDao;
import br.com.videoaulasneri.javabean.model.ItensVendaModel;
import br.com.videoaulasneri.javabean.model.VendaModel;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Venda extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        RequestDispatcher rd = null;
        String venCodigo = request.getParameter("vencodigo");
    	String cliCodigo= request.getParameter("clicodigo");
    	String venData= request.getParameter("vendata");
    	//String venValorTotal= request.getParameter("venvalortotal");
        
    	
        VendaModel vendaModel = new VendaModel();
        if (venCodigo != null)
        	vendaModel.setVenCodigo(Integer.parseInt(venCodigo));
        if (cliCodigo != null)
        	vendaModel.setCliCodigo(Integer.parseInt(cliCodigo));
        
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        if(venData != null) {
        	Date venDataFormatada = formatoData.parse(venData);
        	vendaModel.setVenData(venDataFormatada);
       }
        //if (venValorTotal != null)
        	//vendaModel.setVenValorTotal(Double.parseDouble(venValorTotal));
        
        VendaDao vendaDao = new VendaDao();
        
        String selectProduto = request.getParameter("selectProduto");
        String quantidade = request.getParameter("quantidade");
        String codigoVenda = request.getParameter("vencodigo");
        
        ItensVendaModel itensVendaModel = new ItensVendaModel();
        if (selectProduto != null)
        	itensVendaModel.setProcodigo(Integer.parseInt(selectProduto));
        if (quantidade != null)
        	itensVendaModel.setVenquantidade(Integer.parseInt(quantidade));    
        if (codigoVenda != null)
        	itensVendaModel.setVencodigo(Integer.parseInt(codigoVenda));  
        
        ItensVendaDao itensVendaDao = new ItensVendaDao();
        
       
        //verificar qual é a acao
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "listarVenda";
        }

        if (acao.equals("alterar")) {

        } else if (acao.equals("excluir")) {

        } else if (acao.equals("novo")) {
            vendaDao.novaVenda(vendaModel);
            request.setAttribute("sessaoTotalRegistroVenda",  vendaDao.totalRegistros());
            rd = request.getRequestDispatcher("/venda.jsp");
        } 
        else if (acao.equals("novoItemVenda")) {
            itensVendaDao.novoItemVenda(itensVendaModel);
            List listaItensVenda = itensVendaDao.getListaItensVenda(Integer.parseInt(codigoVenda));
            
            request.setAttribute("sessaolistaItensVenda", listaItensVenda);
            //request.setAttribute("sessaoTotalRegistroVenda",  vendaDao.totalRegistros());
            rd = request.getRequestDispatcher("/venda.jsp");
        } 

        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
