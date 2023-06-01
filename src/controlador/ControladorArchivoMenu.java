package controlador;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Comida;
import modelo.Inventario;
import modelo.Menu;

/**
 *
 * @author Carlos
 */
public class ControladorArchivoMenu {
    /* Refactorización - (code smell: Duplicidad de código, Long Method)
        Técnica: Extract Method
        Hecho por: Wilfredo Huallpartupa Gallegos (18200083)
    */
    String ingrCebolla = "Cebolla";
    String ingrArroz = "Arroz";
    String ingrPollo = "Pollo";
    
    /*
    Developer: Wilfredo Huallpartupa Gallegos
    
    Para la implementación de una BDD, para este proyecto, debemos cambiar 
    el método leerArchivo(), por uno nuevo llamado cargarDatos(), dentro de este
    método ejecutaremos código, que abra la conección a la BDD y ejecutar 
    código SQL para obtener la información registrada en BDD. Para cargar esta información 
    en el ArrayList a.
    */
    
    /* Refactorización - (code smell: Long Method)
        Técnica: Extract Method
        Hecho por: Wilfredo Huallpartupa Gallegos (18200083)
    */
    public void leerArchivo(List<Comida> a) {
        try {
            FileInputStream file = new FileInputStream("Comidas.dat");
            ObjectInputStream fileInput = new ObjectInputStream(file);
            boolean finArchivo = false;
            while (!finArchivo) {
                finArchivo = agregarComida(a, fileInput);
            }
            fileInput.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sin comidas.");
        }
    }
    
    public boolean agregarComida(List<Comida> a, ObjectInputStream fileInput){
        try {
                a.add((Comida) fileInput.readObject());
            } catch (EOFException e) {
                   return true;
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return false;
    }
    
    /*
    Developer: Wilfredo Huallpartupa Gallegos
    
    El método salvarArchivo() debe cambiarse por uno nuevo llamado guardarDatos(), 
    en este método ejecutaremos código para almacenar los datos creados, por el usuario,
    en la BDD.
 
    */

    public void salvarArchivo(List<Comida> a) {
        try {
            FileOutputStream file = new FileOutputStream("Comidas.dat");
            ObjectOutputStream fileOut = new ObjectOutputStream(file);
            for (int i = 0; i < a.size(); i++) {
                fileOut.writeObject(a.get(i));
            }
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Las comidas fueron registradas.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Comidas no registradas.");
        }
    }    
    
    /*
    Developer: Wilfredo Huallpartupa Gallegos
    
    Es necesario modificar método inicializarMenu(), debemos eliminar todo el código
    del método, colocamos código para obtener los datos de la lista de Comidas
    que se han registrando en la base de datos (BDD)
    
    */
    public void inicializarMenu(List<Comida> a) {
        Inventario miInventario = Inventario.getInventario();

        // comidas predefinidas
        Comida com0 = new Comida("Lomo Saltado", 12.5f, "/imagenes/arrayComida/comida1.jpg");
        Comida com1 = new Comida("Ají de Gallina", 10.0f, "/imagenes/arrayComida/comida2.jpg");
        Comida com2 = new Comida("Arroz con Pollo", 10.0f, "/imagenes/arrayComida/comida3.jpg");
        Comida com3 = new Comida("Arroz Chaufa", 8.5f, "/imagenes/arrayComida/comida4.jpg");
        Comida com4 = new Comida("Aeropuerto", 12.0f, "/imagenes/arrayComida/comida5.jpg");
        Comida com5 = new Comida("Tallarín Saltado", 11.0f, "/imagenes/arrayComida/comida6.jpg");
        Comida com6 = new Comida("Seco a la Norteña", 13.50f, "/imagenes/arrayComida/comida7.jpg");
        Comida com7 = new Comida("Ceviche", 12.0f, "/imagenes/arrayComida/comida8.jpg");

        com0.agregarIngrediente(miInventario.buscarIngrediente("Lomo"));
        com0.agregarIngrediente(miInventario.buscarIngrediente(ingrArroz));
        com0.agregarIngrediente(miInventario.buscarIngrediente("Papa"));
        com0.agregarIngrediente(miInventario.buscarIngrediente(ingrCebolla));

        com1.agregarIngrediente(miInventario.buscarIngrediente("Gallina"));
        com1.agregarIngrediente(miInventario.buscarIngrediente("Aji amarillo"));
        com1.agregarIngrediente(miInventario.buscarIngrediente("Papa"));
        com1.agregarIngrediente(miInventario.buscarIngrediente(ingrArroz));

        com2.agregarIngrediente(miInventario.buscarIngrediente(ingrArroz));
        com2.agregarIngrediente(miInventario.buscarIngrediente(ingrPollo));
        com2.agregarIngrediente(miInventario.buscarIngrediente("Alverjas"));
        com2.agregarIngrediente(miInventario.buscarIngrediente("Zanahoria"));

        com3.agregarIngrediente(miInventario.buscarIngrediente(ingrArroz));
        com3.agregarIngrediente(miInventario.buscarIngrediente(ingrPollo));
        com3.agregarIngrediente(miInventario.buscarIngrediente("Huevo"));
        com3.agregarIngrediente(miInventario.buscarIngrediente("Pimenton"));

        com4.agregarIngrediente(miInventario.buscarIngrediente(ingrPollo));
        com4.agregarIngrediente(miInventario.buscarIngrediente(ingrArroz));
        com4.agregarIngrediente(miInventario.buscarIngrediente("Huevo"));
        com4.agregarIngrediente(miInventario.buscarIngrediente("Fideos"));

        com5.agregarIngrediente(miInventario.buscarIngrediente("Fideos"));
        com5.agregarIngrediente(miInventario.buscarIngrediente("Res"));
        com5.agregarIngrediente(miInventario.buscarIngrediente("Cebolla China"));
        com5.agregarIngrediente(miInventario.buscarIngrediente("Tomate"));

        com6.agregarIngrediente(miInventario.buscarIngrediente("Res"));
        com6.agregarIngrediente(miInventario.buscarIngrediente("Alverjas"));
        com6.agregarIngrediente(miInventario.buscarIngrediente(ingrCebolla));
        com6.agregarIngrediente(miInventario.buscarIngrediente(ingrArroz));

        com7.agregarIngrediente(miInventario.buscarIngrediente("Pescado"));
        com7.agregarIngrediente(miInventario.buscarIngrediente(ingrCebolla));
        com7.agregarIngrediente(miInventario.buscarIngrediente("Limones"));
        com7.agregarIngrediente(miInventario.buscarIngrediente("Camote"));

        a.add(com0);
        a.add(com1);
        a.add(com2);
        a.add(com3);
        a.add(com4);
        a.add(com5);
        a.add(com6);
        a.add(com7);

    }

    public List<Comida> crearArrayList() {
        List<Comida> a;
        a = new ArrayList<>();
        return a;
    }

    public void cargarArchivo() {
        Menu miMenu = Menu.getMenu();
        List<Comida> temp = crearArrayList();
        leerArchivo(temp);
        miMenu.cargarComidas(temp);
    }

    public void crearArchivo() {
        List<Comida> temp = crearArrayList();
        leerArchivo(temp);
        inicializarMenu(temp);
        salvarArchivo(temp);
    }
}
