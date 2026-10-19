package XML;

import Models.Videojuego;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;

public class FileServices {
    public static void toXML(List<Videojuego> listaVideoxogos, String ruta) {
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try{
            FileWriter fw = new FileWriter(ruta);
            XMLStreamWriter xsw = xof.createXMLStreamWriter(fw);
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeCharacters("\n");

            xsw.writeStartElement("videoxogos");
            xsw.writeCharacters("\n");

            for (Videojuego v : listaVideoxogos) {
                xsw.writeCharacters("  ");
                xsw.writeStartElement("videoxogo");
                xsw.writeAttribute("id", String.valueOf(v.getId()));
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("titulo");
                xsw.writeCharacters(v.getTitulo() != null ? v.getTitulo() : "");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("plataforma");
                xsw.writeCharacters(v.getPlataforma() != null ? v.getPlataforma() : "");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("anoLanzamento");
                xsw.writeCharacters(String.valueOf(v.getAnoLanzamento()));
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("descripcion");
                xsw.writeCharacters(v.getDescripcion() != null ? v.getDescripcion() : "");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("  ");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");
            }

            xsw.writeEndElement();
            xsw.writeCharacters("\n");
            xsw.writeEndDocument();

            xsw.flush();
            xsw.close();
            fw.close();
            System.out.println("Arquivo XML xerado correctamente en: " + ruta);

        } catch (Exception e) {
            System.err.println("Erro : " + e.getMessage());
        }

    }
    //serial
    public static void Serial(Videojuego v){

        try(FileOutputStream FoS = new FileOutputStream("serial");
            ObjectOutputStream OoS = new ObjectOutputStream(FoS)) {

            OoS.writeObject(v);
            System.out.println("Guardado en serial");
        }catch (IOException e){
            System.out.println("Error" + e);
        }
    }

    //Deserializar
    public static List<Videojuego> Deserializa(String ruta){
        File file = new File(ruta);

        List<Videojuego>  ds = null;
        try(FileInputStream FiS = new FileInputStream(file);
            ObjectInputStream OiS = new ObjectInputStream(FiS)) {

            ds = (List<Videojuego>) OiS.readObject();
            System.out.println("Guardado en serial");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error" + e);
        }
        return  ds;
    }
    //Escribir en un txt
    public static void escribirVideojuegoEnTxt(List<Videojuego> listaVideoxogos, String ruta) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta))){

            for(Videojuego v : listaVideoxogos){
                dos.writeUTF(v.getTitulo()+","+v.getPlataforma()+","+v.getDescripcion()+","+v.getAnoLanzamento());
            }
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

}
