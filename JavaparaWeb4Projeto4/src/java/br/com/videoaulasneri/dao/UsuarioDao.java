
package br.com.videoaulasneri.dao;

import br.com.videoaulasneri.factory.ConnectionFactory;
import br.com.videoaulasneri.javabean.model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnetion();
    }

//    public boolean verificaUsuario() {
//        if (this.usuario != null && this.senha != null) {
//            if (this.usuario.equals("neri") && this.senha.equals("1234"))
//                return true;
//        }
    public boolean verificaUsuario(UsuarioModel usuarios) throws SQLException {
        String sql = "select * from usuarios where usuario=? and senha=?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuarios.getUsuario());
            ps.setString(2, usuarios.getSenha());
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
            resultSet.close();
        }
        return false;
    }

    public UsuarioModel getUsuario(String usuario, String senha) throws SQLException {
        String sql = "select * from usuarios where usuario=? and senha=?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                UsuarioModel usuarios = new UsuarioModel();
                usuarios.setUsuario(usuario);
                usuarios.setSenha(senha);
                usuarios.setNivel(resultSet.getInt("nivel"));
                usuarios.setNomeCompleto(resultSet.getString("nomecompleto"));
//                System.out.println("O connection esta fechado ? = "+connection.isClosed());
//                System.out.println("O PreparedStatement esta fechado ? = "+ps.isClosed());
//                System.out.println("O ResultSet esta fechado ? = "+resultSet.isClosed());

                return usuarios;
            }
        } catch (SQLException ex) {
//            System.out.println("catch O connection esta fechado ? = "+connection.isClosed());
//                System.out.println("catchO PreparedStatement esta fechado ? = "+ps.isClosed());
//                System.out.println("catchO ResultSet esta fechado ? = "+resultSet.isClosed());
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
            resultSet.close();
//                System.out.println("O connection esta fechado ? = "+connection.isClosed());
//                System.out.println("O PreparedStatement esta fechado ? = "+ps.isClosed());
//                System.out.println("O ResultSet esta fechado ? = "+resultSet.isClosed());
        }
        return null;
    }

    public List getListaUsuarios() throws SQLException {
        String sql = "select * from usuarios";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<UsuarioModel> listaUsuarios = new ArrayList<UsuarioModel>();
        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                UsuarioModel usuarios = new UsuarioModel();
                usuarios.setUsuario(resultSet.getString("usuario"));
                usuarios.setSenha(resultSet.getString("senha"));
                usuarios.setNivel(resultSet.getInt("nivel"));
                usuarios.setNomeCompleto(resultSet.getString("nomecompleto"));
                listaUsuarios.add(usuarios);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
            resultSet.close();
        }
        return null;
    }

    public List getListaUsuariosPaginada(int pagina, String ordenacao, String pesquisa, String campoapesquisar) throws SQLException {
        int limite = 10;
        int offset = (pagina * limite) - limite;
        String sql = "";
        if (campoapesquisar.equals("nivel"))
            
            if (pesquisa.equals(""))
                sql = "select * from usuarios where "+campoapesquisar+"> 0 order by "+ordenacao+" LIMIT 10 OFFSET " + offset;
        else
            sql = "select * from usuarios where "+campoapesquisar+" = "+pesquisa+" order by " +ordenacao+ " LIMIT 10 OFFSET " + offset;
        else
            sql = "select * from usuarios where "+campoapesquisar+" like '%"+pesquisa+"%' order by " +ordenacao+ " LIMIT 10 OFFSET " + offset;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<UsuarioModel> listaUsuarios = new ArrayList<UsuarioModel>();
        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                UsuarioModel usuarios = new UsuarioModel();
                usuarios.setUsuario(resultSet.getString("usuario"));
                usuarios.setSenha(resultSet.getString("senha"));
                usuarios.setNivel(resultSet.getInt("nivel"));
                usuarios.setNomeCompleto(resultSet.getString("nomecompleto"));
                listaUsuarios.add(usuarios);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //connection.close();
            //ps.close();
            //resultSet.close();
        }
        return null;
    }

    //metodo para retornar o numero total de registros para paginacao
    public String totalRegistros(String pesquisa, String campoapesquisar) throws SQLException {
        PreparedStatement psConta = null;
        ResultSet resultSetConta = null;
        String sqlConta = "";
        try {
            if (campoapesquisar.equals("nivel"))
                if (pesquisa.equals(""))
                    sqlConta = "select count (*) AS contaRegistros from usuarios where "+campoapesquisar+" > 0";
            else
                sqlConta = "select count (*) AS contaRegistros from usuarios where "+campoapesquisar+" = "+pesquisa;
            else 
                sqlConta = "select count(*) AS contaRegistros from usuarios where "+campoapesquisar+" like '%"+pesquisa+"%' ";
            psConta = connection.prepareStatement(sqlConta);
            resultSetConta = psConta.executeQuery();
            resultSetConta.next();
            String qtdTotalRegistros = resultSetConta.getString("contaRegistros");
            return qtdTotalRegistros;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            connection.close();
            psConta.close();
            resultSetConta.close();
        }
        return "Nerizon com erro";
    }

    //excluir usuarios usando Model UsuarioModel
    public boolean excluiUsuario(UsuarioModel usuarios) throws SQLException {
        String sql = "delete from usuarios where usuario=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuarios.getUsuario());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
        }

        return false;
    }
    
            

    public void alteraUsuario(UsuarioModel usuarios) throws SQLException, SQLException {
        String sql = "UPDATE usuarios SET senha=?, nivel=?,nomecompleto=?  where usuario=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuarios.getSenha());
            ps.setInt(2, usuarios.getNivel());
            ps.setString(3, usuarios.getNomeCompleto());
            ps.setString(4, usuarios.getUsuario());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
        }
    } 
    

    //excluir usuarios usando variavel String
    public boolean excluiUsuario1(String usuarios) throws SQLException {
        String sql = "delete from usuarios where usuario=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuarios);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
        }

        return false;
    }

    public void novoUsuario(UsuarioModel usuarios) throws SQLException {
        String sql = "insert into usuarios values (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuarios.getUsuario());
            ps.setString(2, usuarios.getSenha());
            ps.setInt(3, usuarios.getNivel());
            ps.setString(4, usuarios.getNomeCompleto());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            ps.close();
        }
    }
       
}
