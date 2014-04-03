/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioserializabre.testexml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import java.io.File;
import java.util.List;
import java.util.UUID;
import laboratorioserializabre.model.ObjetoPatrimonio;
import laboratorioserializabre.model.Sala;

/**
 *
 * @author alunoinf
 */
//http://xstream.codehaus.org/persistence-tutorial.html
public class LaboratorioSerializable {

    public static void main(String[] args) {
        PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/tmp/eurismar"));
        List list = new XmlArrayList(strategy);
        for (int i = 0; i < 100; i++) {
            ObjetoPatrimonio objeto = new ObjetoPatrimonio();
            objeto.setIentificador(i);
            objeto.setNome(UUID.randomUUID().toString());
            objeto.setDescricao(UUID.randomUUID().toString());
            objeto.setSala(new Sala(i, UUID.randomUUID().toString()));
            list.add(objeto);
        }
        String xml = list.toString();
        System.out.println(xml);
        new LaboratorioSerializable().testeJSON();


    }

    public void testeJSON() {
        ObjetoPatrimonio objeto = new ObjetoPatrimonio();
        objeto.setIentificador(1);
        objeto.setNome(UUID.randomUUID().toString());
        objeto.setDescricao(UUID.randomUUID().toString());
        objeto.setSala(new Sala(10, UUID.randomUUID().toString()));
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("patrimonio", ObjetoPatrimonio.class);
        System.out.println(xstream.toXML(objeto));

    }
}
