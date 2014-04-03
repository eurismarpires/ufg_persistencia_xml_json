
package laboratorioserializabre.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjetoPatrimonio implements java.io.Serializable{
    
    private int ientificador;
    private String descricao;
    private String nome;
    private Sala sala;

    public ObjetoPatrimonio() {
    }

    public int getIentificador() {
        return ientificador;
    }

    public void setIentificador(int ientificador) {
        this.ientificador = ientificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }


    
    public void serializar(String path, Object obj) throws FileNotFoundException, IOException{
        FileOutputStream outFile = new FileOutputStream(path);
    
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        s.writeObject(obj);
        s.close();
    }
    public Object ler(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream obj = new ObjectInputStream(inFile);        
        Object o =  obj.readObject();
        obj.close();
        return o;
    }
   /* public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjetoPatrimonio ob = new ObjetoPatrimonio();
        ob.setIentificador(1);
        ob.setNome("pc");
        ob.setDescricao("computador");
         System.out.print(ob);
        ob.serializar("teste.txt", ob);
        System.out.println("gravei");
        
        ObjetoPatrimonio ob2 = new ObjetoPatrimonio();
        ob2 = (ObjetoPatrimonio) ob2.ler("teste.txt");
        
        System.out.println("vou ler");
        System.out.println(ob2.getIentificador());
        System.out.println(ob2.getNome());
        System.out.println(ob2.getDescricao());
        System.out.print(ob2);
        
    }
    */
    @Override
    public String toString(){
        return "Id:" +  getIentificador() + "\n" 
                + "Nome:" +  getNome() + "\n" 
                + "Descrição:" + getDescricao() + "\n"
                + "Sala:"  + getSala();
    }

}
