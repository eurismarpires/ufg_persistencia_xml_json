/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioserializabre.model;

/**
 *
 * @author alunoinf
 */
public class Sala {
    private int id;
    private String descricao;

    public Sala(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
