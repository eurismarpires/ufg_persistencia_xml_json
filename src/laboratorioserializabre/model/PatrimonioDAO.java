/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioserializabre.model;

import java.util.List;

/**
 *
 * @author alunoinf
 */
public interface PatrimonioDAO {
    void salvar(List<ObjetoPatrimonio> lista);
    List<ObjetoPatrimonio> getObjetos();
    List<ObjetoPatrimonio> getObjetos(int idSala);
    ObjetoPatrimonio getObjeto(int idObjeto);
    int getSala(int idObjeto);
    
    
}
