/* 
    Code Smell de tipo Long method con tecnica extract method 
    Hernandez Cordova, Piero Josue
*/

package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author AlexTprog
 */

//Lista Circ de Boletas
public class Caja {

    private static Caja caja;
    private Boleta ultimo;
    private int tamanio;

    private Caja() {
        ultimo = null;
        tamanio = 0;
    }

    public static Caja getCaja() {
        if (caja == null) {
            caja = new Caja();
        }
        return caja;
    }

    public boolean isCajaVacia() {
        return ultimo == null;
    }

    //Solo para cargar desde los archivos
    public void addBoleta(Boleta nuevo) {
        ultimo = nuevo;
        tamanio++;

    }

    private static final Logger logger = Logger.getLogger(controlador.ControladorArchivoInventario.class.getName());
    public void addBoleta(Pedido p) {
        Boleta nuevo = new Boleta(p);

        if (isCajaVacia()) {
            ultimo = nuevo;
            tamanio++;
        } else {
            if (!isBoletaActiva(p.cliente.getDni())) {
                nuevo.sig = ultimo.sig;
                ultimo.sig = nuevo;
                ultimo = nuevo;
                tamanio++;
            } else {
                buscarBoleta(p.cliente).addPedido(p);
                logger.log(Level.INFO,"Ya Hay un Boleta Activa");
            }
        }
    }

    public boolean isBoletaActiva(String dni) {
        Boleta aux = ultimo;
        boolean band = false;
        //Si el estado de la boleta es false, sigue activa = no esta pagada
        while (aux.sig != ultimo && !band) {
            if (aux.cliente.getDni().equals(dni) && !aux.estado) {
                band = true;
            }
            aux = aux.sig;
        }
        return band;
    }

    public Boleta buscarBoleta(Cliente c) {
        Boleta aux = ultimo.sig;
        do {
            if (aux.cliente.equals(c)) {
                return aux;
            }
            aux = aux.sig;
        } while (aux != ultimo.sig);
        return aux;
    }

    public Boleta buscarBoleta(String dni) {
        Boleta aux = ultimo.sig;
        do {
            if (aux.cliente.getDni().equals(dni) && aux.estado == false) {
                return aux;
            }
            aux = aux.sig;
        } while (aux != ultimo.sig);
        return aux;
    }

    public float calcTotal() {
        float total = 0;
        Boleta aux = ultimo;
        while (aux.sig != ultimo) {
            aux.calcMonto();
            total += aux.monto;
            aux = aux.sig;
        }
        return total;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Boleta getUltimo() {
        return ultimo;
    }

    public List<Boleta> getBoletasActivas() {
        ArrayList<Boleta> temp = new ArrayList<>();
        Boleta aux = ultimo;

        if (!isCajaVacia()) {
            for (int i = 0; i < caja.getTamanio(); i++) {
                if (aux.estado == false) {
                    temp.add(aux);
                }
                aux = aux.sig;
            }
        }
        return temp;
    }
}
