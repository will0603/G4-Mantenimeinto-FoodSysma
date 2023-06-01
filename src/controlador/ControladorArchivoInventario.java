package controlador;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Ingrediente;
import modelo.Inventario;

/**
 *
 * @author Carlos
 */
 

public class ControladorArchivoInventario {
//Reemplace la especificación de tipo en esta llamada de constructor con el operador de diamante 
       ArrayList<Ingrediente> a = new ArrayList<>();

     /*
    Developer: Wilfredo Huallpartupa Gallegos
    
    Para la implementación de una BDD, para este proyecto, debemos cambiar 
    el método leerArchivo(), por uno nuevo llamado cargarDatos(), dentro de este
    método ejecutaremos código, que abra la conección a la BDD y ejecutar 
    código SQL para obtener la información registrada en BDD. Para cargar esta información 
    en el ArrayList a.
    */
    
 // VEGA CENTENO RODRIGO SEBASTIAN
 // Agregar la funcionalidad de añadir-eliminar-modificar un elemento en la base de datos. 
 // Eliminar las clases que trabajen con archivos 
    // eliminar esta clase 
       
/* 
    Code Smell de tipo Long method 
    Refactorizacion con la tecnica extract method 
    Vega Centeno Rodrigo Sebastian 19200277 
   */
       
    public void leerArchivo() {
        try {
            FileInputStream file = new FileInputStream("ingredientes.dat");
            ObjectInputStream fileInput = new ObjectInputStream(file);
            boolean finArchivo = false;
            while (!finArchivo) {
            finArchivo = AgregarIngrediente(a, fileInput);
            }
            fileInput.close();
            cargarArchivo();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sin ingredientes.");
        }
    }
    
    public boolean AgregarIngrediente( ArrayList<Ingrediente> a,ObjectInputStream fileInput){
        
        try {
                 a.add((Ingrediente) fileInput.readObject());
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
    
    // eliminar la clase de salvarArchivo 
    
    // Creacion del metodo logger  para registrar el mensaje. Level.INFO especifica el nivel de registro como información.
    private static final Logger logger = Logger.getLogger(controlador.ControladorArchivoInventario.class.getName());
    public void salvarArchivo() {
        try {
            FileOutputStream file = new FileOutputStream("ingredientes.dat");
            ObjectOutputStream fileOut = new ObjectOutputStream(file);
            Inventario inv = Inventario.getInventario();
            for (int i = 0; i < inv.getTamaño(); i++) {
                fileOut.writeObject(inv.getIngredientes()[i]);
            }
            fileOut.close();
            logger.log(Level.INFO,"Los ingredientes fueron guardados.");           
        } catch (IOException e) {
            logger.log(Level.INFO,"Ingredientes no registrados.");
        }
    }
    
    /*
    Developer: Wilfredo Huallpartupa Gallegos
    
    Es necesario modificar método inicializarInventario(), debemos eliminar todo el código
    del método, colocamos código para obtener los datos de la lista de ingredientes
    que se han registrando en la base de datos (BDD)
    
    */
    public void inicializarInventario(List<Ingrediente> a) {
        Ingrediente ing1 = new Ingrediente("Lomo", "carnes", 10);
        Ingrediente ing2 = new Ingrediente("Arroz", "vegetales", 10);
        Ingrediente ing3 = new Ingrediente("Papa", "vegetales", 10);
        Ingrediente ing4 = new Ingrediente("Cebolla", "vegetales", 10);
        Ingrediente ing5 = new Ingrediente("Gallina", "carnes", 10);
        Ingrediente ing6 = new Ingrediente("Aji amarillo", "vegetales", 10);
        Ingrediente ing7 = new Ingrediente("Pollo", "carnes", 10);
        Ingrediente ing8 = new Ingrediente("Alverjas", "vegetales", 10);
        Ingrediente ing9 = new Ingrediente("Zanahoria", "vegetales", 10);
        Ingrediente ing10 = new Ingrediente("Huevo", "carnes", 10);
        Ingrediente ing11 = new Ingrediente("Pimenton", "vegetales", 10);
        Ingrediente ing12 = new Ingrediente("Fideos", "vegetales", 10);
        Ingrediente ing13 = new Ingrediente("Res", "carnes", 10);
        Ingrediente ing14 = new Ingrediente("Cebolla China", "vegetales", 10);
        Ingrediente ing15 = new Ingrediente("Pescado", "carnes", 10);
        Ingrediente ing16 = new Ingrediente("Limones", "vegetales", 10);
        Ingrediente ing17 = new Ingrediente("Camote", "vegetales", 10);
        Ingrediente ing18 = new Ingrediente("Tomate", "vegetales", 10);

        a.add(ing1);
        a.add(ing2);
        a.add(ing3);
        a.add(ing4);
        a.add(ing5);
        a.add(ing6);
        a.add(ing7);
        a.add(ing8);
        a.add(ing9);
        a.add(ing10);
        a.add(ing11);
        a.add(ing12);
        a.add(ing13);
        a.add(ing14);
        a.add(ing15);
        a.add(ing16);
        a.add(ing17);
        a.add(ing18);
    }


    public ArrayList<Ingrediente> crearArrayList() {
        ArrayList<Ingrediente> a = new ArrayList<>();
        return a;
    }


    public void cargarArchivo() {
        Inventario miInventario = Inventario.getInventario();

        miInventario.cargarInventario(a);
    }
}
