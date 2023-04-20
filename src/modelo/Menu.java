package modelo;

import java.util.ArrayList;

/**
 *
 * @author AlexTprog
 */

 /*
    PIERO JOSUE HERNANDEZ CORDOVA
    
    Una vez que que se cree la vista/interfaz de usuario para el login, 
    en este archivo se necesitas validar las credenciales ingresadas por el usuario. 
    Puedes hacer esto comparando las credenciales ingresadas por el usuario con las credenciales almacenadas 
    en un archivo o base de datos. Si las credenciales son válidas, entonces permites al usuario acceder al menú. 
    Si no son válidas, debes mostrar un mensaje de error y permitir al usuario volver a intentar ingresar sus credenciales.
 
    */
public class Menu {

    private static Menu menu;
    private Comida[] comida;
    private int pos;

    private Menu(int tmn) {
        this.comida = new Comida[tmn];
        this.pos = 0;
    }

    public static Menu getMenu() {
        if (menu == null) {
            menu = new Menu(8);
        }
        return menu;
    }

    public void addComida(Comida nuevo) {
        if (!isFull()) {
            this.comida[pos] = nuevo;
            pos++;
        } else {
            System.out.println("MENU LLENO");
        }
    }

    public boolean isFull() {
        return pos > comida.length;
    }

    public void mostrar() {
        int i = 0;
        while (comida[i] != null && i < comida.length) {
            System.out.println(comida[i]);
            i++;
        }
    }

    public int getTamaño() {
        return comida.length;
    }

    public Comida getComida(int pos) {
        /*
        int i = 0;
        Comida c = null;
        while (comida[i] != null && i < comida.length) {
            if (i == pos) {
                c = comida[i];
            }
            i++;
        }
         */
        return this.comida[pos];
    }

    public Comida getComida(String nombre) {
        int i = 0;
        Comida c = null;
        while (comida[i] != null && i < comida.length) {
            if (comida[i].getNombre().equalsIgnoreCase(nombre)) {
                c = comida[i];
            }
            i++;
        }
        return c;
    }

    public void cargarComidas(ArrayList<Comida> listaComidas) {
        for (Comida temp : listaComidas) {
            addComida(temp);
        }
    }

    public static void setLlenarComidas() {
        Comida comida1 = new Comida("Lomo Saltado", (float) 35.5, "/imagenes/arrayComida/comida1.jpg");
        Comida comida2 = new Comida("Aji de Gallina", (float) 40.5, "/imagenes/arrayComida/comida2.jpg");
        menu.addComida(comida1);
        menu.addComida(comida2);

    }
}
