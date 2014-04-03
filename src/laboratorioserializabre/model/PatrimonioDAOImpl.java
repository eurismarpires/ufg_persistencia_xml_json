/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioserializabre.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunoinf
 */
public class PatrimonioDAOImpl implements PatrimonioDAO {

    @Override
    public List<ObjetoPatrimonio> getObjetos() {
        ObjetoPatrimonio objPat = new ObjetoPatrimonio();
        try {
            return (List<ObjetoPatrimonio>) objPat.ler("lista.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Erro de entrada e saída");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: ClassNotFoundException");
        }
        return null;

    }

    @Override
    public List<ObjetoPatrimonio> getObjetos(int idSala) {
        List<ObjetoPatrimonio> lista = new LinkedList<>();
        ObjetoPatrimonio obj = new ObjetoPatrimonio();
        try {
            lista = (List<ObjetoPatrimonio>) obj.ler("lista.txt");

            List<ObjetoPatrimonio> novaLista = new LinkedList<>();
            for (int i = 0; i < lista.size() - 1; i++) {
              //  if (lista.get(i).getSala() == idSala) {
               //     novaLista.add(lista.get(i));
              //  }
            }
            return novaLista;
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Erro de entrada e saída");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: ClassNotFoundException");
        }
        return null;
    }

    @Override
    public ObjetoPatrimonio getObjeto(int idObjeto) {
        List<ObjetoPatrimonio> lista = new LinkedList<>();
        ObjetoPatrimonio obj = new ObjetoPatrimonio();
        ObjetoPatrimonio objetoEncontrado;
        try {
            lista = (List<ObjetoPatrimonio>) obj.ler("lista.txt");

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getIentificador() == idObjeto) {
                   objetoEncontrado = lista.get(i);
                   return objetoEncontrado;
                }
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Erro de entrada e saída");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: ClassNotFoundException");
        }
        return null;
    }

    @Override
    public int getSala(int idObjeto) {
        List<ObjetoPatrimonio> lista = new LinkedList<>();
        ObjetoPatrimonio obj = new ObjetoPatrimonio();
        int salaEncontrada;
        try {
            lista = (List<ObjetoPatrimonio>) obj.ler("lista.txt");

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getIentificador()== idObjeto) {
                   //salaEncontrada = lista.get(i).getSala();
                   return 0;//salaEncontrada;
                }
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Erro de entrada e saída");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: ClassNotFoundException");
        }
        return 0;
   
    }

    @Override
    public void salvar(List<ObjetoPatrimonio> lista) {
        ObjetoPatrimonio obj = new ObjetoPatrimonio();
        try {
            obj.serializar("lista.txt", lista);
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Arquivo erro de entrada e saída");
        }
    }
}
