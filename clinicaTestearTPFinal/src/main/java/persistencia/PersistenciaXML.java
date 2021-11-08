package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistenciaXML implements IPersistencia<Object>{
    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;


    /**
     * Abre un input y prepara un archivo para ser leido.
     *
     * @param nombre nombre del archivo xml
     * @throws IOException Si el archivo no existe
     */
    @Override
    public void abrirInput(String nombre) throws IOException {
        fileInputStream = new FileInputStream(nombre);
        xmlDecoder = new XMLDecoder(fileInputStream);

    }

    /**
     * Abre un output y prepara un archivo para su carga
     * @param nombre
     * @throws IOException Si no existe pero no puede ser creado o si es una carpeta.
     */
    @Override
    public void abrirOutput(String nombre) throws IOException {
        fileOutputStream = new FileOutputStream(nombre);
        xmlEncoder = new XMLEncoder(fileOutputStream);

    }

    /**
     * Cierra el output abierto anteriormente para persistir datos
     * @throws IOException
     */
    @Override
    public void cerrarOutput() throws IOException {
        if (xmlEncoder != null)
            xmlEncoder.close();
    }

    /**
     * Cierra el input anteriormente abierto para la carga de datos en el programa a partir de un archivo
     * @throws IOException
     */
    @Override
    public void cerrarInput() throws IOException {
        if (xmlDecoder !=null)
            xmlDecoder.close();
    }

    /**
     * Escribe en el archivo seleccionado el objeto para persistirlo
     * @param objeto
     * @throws IOException
     */
    @Override
    public void escribir(Object objeto) throws IOException {
        xmlEncoder.writeObject(objeto);
    }

    /**
     * A partir del input, lee un archivo .xml y retorna un objeto
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Object leer() throws IOException, ClassNotFoundException {
        return xmlDecoder.readObject();
    }
}
