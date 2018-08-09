
package br.com.videoaulasneri.dao;

import br.com.videoaulasneri.factory.ConnectionFactory;
import br.com.videoaulasneri.javabean.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProdutoDao {
    
      private Connection connection;

    public ProdutoDao() {
        this.connection = new ConnectionFactory().getConnetion();
    }
    
     public List getListaProdutoParaSelectOption( ) throws SQLException {
       
        String sql = "select * from produtos order by prodescricao";        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();
        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ProdutoModel produtoModel = new ProdutoModel();
                produtoModel.setProCodigo(resultSet.getInt("proCodigo"));
                produtoModel.setProDescricao(resultSet.getString("proDescricao"));
                listaProduto.add(produtoModel);
            }
            return listaProduto;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
            resultSet.close();
        }
        return null;
    }

}
