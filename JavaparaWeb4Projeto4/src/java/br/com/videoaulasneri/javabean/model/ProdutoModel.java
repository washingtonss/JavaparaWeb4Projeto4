

package br.com.videoaulasneri.javabean.model;

import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProdutoModel {
    private int proCodigo;
    private int catCodigo;
    private String proDescricao;
    private double proQtdEstoque;
    private double proPrecoCusto;
    private int proPrecLucro;
    private double proPrecoVenda;
    private Date proDataCadastro;
    private Date proDataUltVenda;

    public int getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(int proCodigo) {
        this.proCodigo = proCodigo;
    }

    public int getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(int catCodigo) {
        this.catCodigo = catCodigo;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public double getProQtdEstoque() {
        return proQtdEstoque;
    }

    public void setProQtdEstoque(double proQtdEstoque) {
        this.proQtdEstoque = proQtdEstoque;
    }

    public double getProPrecoCusto() {
        return proPrecoCusto;
    }

    public void setProPrecoCusto(double proPrecoCusto) {
        this.proPrecoCusto = proPrecoCusto;
    }

    public int getProPrecLucro() {
        return proPrecLucro;
    }

    public void setProPrecLucro(int proPrecLucro) {
        this.proPrecLucro = proPrecLucro;
    }

    public double getProPrecoVenda() {
        return proPrecoVenda;
    }

    public void setProPrecoVenda(double proPrecoVenda) {
        this.proPrecoVenda = proPrecoVenda;
    }

    public Date getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(Date proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public Date getProDataUltVenda() {
        return proDataUltVenda;
    }

    public void setProDataUltVenda(Date proDataUltVenda) {
        this.proDataUltVenda = proDataUltVenda;
    }
    
    
}
