/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Boleta;
import modelo.Caja;

/**
 *
 * @author Daniel
 */
public class ControladorCaja {

    private ArrayList<Boleta> boletas;
    Caja miCaja = Caja.getCaja();

    public ControladorCaja() {
        boletas = new ArrayList<Boleta>();
    }
    
    /*
    Developer: Wilfredo Huallpartupa Gallegos
    
    Para la implementación de una BDD, para este proyecto, debemos cambiar 
    el método leerArchivo(), por uno nuevo llamado cargarDatos(), dentro de este
    método ejecutaremos código, que abra la conección a la BDD y ejecutar 
    código SQL para obtener la información registrada en BDD. Para cargar esta información 
    en el ArrayList boletas.
    */

    public void leerArchivo() {
        try {
            FileInputStream file = new FileInputStream("boletas.dat");
            ObjectInputStream fileInput = new ObjectInputStream(file);
            boolean finArchivo = false;
            while (!finArchivo) {
                try {
                    boletas.add((Boleta) fileInput.readObject());
                } catch (EOFException e) {
                    finArchivo = true;
                    System.out.println("fin de archivo");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            fileInput.close();
            cargarCaja();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sin boletas");
        }
    }
    /*
    Developer: Wilfredo Huallpartupa Gallegos
    
    El método salvarArchivo() debe cambiarse por uno nuevo llamado guardarDatos(), 
    en este método ejecutaremos código para almacenar los datos creados, por el usuario,
    en la BDD.
 
    */

    /* Refactorización - Salvar Archivo (code smell: Long Method)
        Técnica: Extract Method
        Hecho por: Juan Martín Domínguez Matos (19200275)
    */
    
    // INICIO DE LA REFACTORIZACIÓN
    // salvarArchivo ahora cuenta con 1 solo try-catch.
    public void salvarArchivo() {
        try {
            FileOutputStream file = abrirArchivo();
            ObjectOutputStream fileOut = crearObjectOutputStream(file);
            escribirBoletas(fileOut);
            cerrarArchivo(fileOut);
            mostrarMensajeExitoso();
        } catch (IOException e) {
            mostrarMensajeError();
    }
}

    // Se crea un método para abrir el archivo de boletas
    private FileOutputStream abrirArchivo() throws IOException {
        return new FileOutputStream("boletas.dat");
    }

    // Se crea un objeto que será usado para escribir en un archivo
    private ObjectOutputStream crearObjectOutputStream(FileOutputStream file) throws IOException {
        return new ObjectOutputStream(file);
    }

    // Se crea el método escribirBoletas para guardar los registros necesarios en la boleta
    private void escribirBoletas(ObjectOutputStream fileOut) throws IOException {
        Boleta b = miCaja.getUltimo();
        for (int i = 0; i < miCaja.getTamanio(); i++) {
            fileOut.writeObject(b);
            b = b.sig;
            System.out.println(b.cliente.getDni());
        }
    }

    // Método para cerrar el archivo en el que se está escribiendo
    private void cerrarArchivo(ObjectOutputStream fileOut) throws IOException {
        fileOut.close();
    }
    
    private void mostrarMensajeExitoso() {
        JOptionPane.showMessageDialog(null, "Las boletas fueron registradas.");
    }

    private void mostrarMensajeError() {
        JOptionPane.showMessageDialog(null, "Boletas no registradas.");
    }
    // FIN DE LA REFACTORIZACIÓN

    public void cargarCaja() {
        for (Boleta b : this.boletas) {
            miCaja.addBoleta(b);
            System.out.println(b.cliente.getNombre());
        }
    }
}
