/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioserializabre.model;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author alunoinf
 */
public class LaboratorioSerializable {
    public static void main(String[] args) {
        List<ObjetoPatrimonio> lista = new LinkedList<ObjetoPatrimonio>();
        
        for (int i = 0; i < 100; i++) {
            ObjetoPatrimonio objeto = new ObjetoPatrimonio();
            objeto.setIentificador(i);
            objeto.setNome(UUID.randomUUID().toString());
            objeto.setDescricao(UUID.randomUUID().toString());
           // objeto.setSala(i / 10);
            lista.add(objeto);
        }
        
       PatrimonioDAOImpl dao = new PatrimonioDAOImpl();
       dao.salvar(lista);
       
       // #1
       ObjetoPatrimonio objPat = new ObjetoPatrimonio();
       objPat = dao.getObjeto(45);
       System.out.println(objPat.toString());
       
       // #2
        List<ObjetoPatrimonio> lista2 = new LinkedList<ObjetoPatrimonio>();
        lista2 = dao.getObjetos();
        
        System.out.println("-------------lista leitura objetos-----------");
        for (int i = 0; i < lista2.size() ; i++) {
            System.out.println(lista2.get(i));
        }
       
       
       
        
    }
}
