

package br.com.videoaulasneri.javabean.model;


public class BairroModel {
  private int baiCodigo;
  private String baiDescricao;

    /**
     * @return the baiCodigo
     */
    public int getBaiCodigo() {
        return baiCodigo;
    }

    /**
     * @param baiCodigo the baiCodigo to set
     */
    public void setBaiCodigo(int baiCodigo) {
        this.baiCodigo = baiCodigo;
    }

    /**
     * @return the baiDescricao
     */
    public String getBaiDescricao() {
        return baiDescricao;
    }

    /**
     * @param baiDescricao the baiDescricao to set
     */
    public void setBaiDescricao(String baiDescricao) {
        this.baiDescricao = baiDescricao;
    }
  
}
