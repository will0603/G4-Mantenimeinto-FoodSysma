/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelo.Caja;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Comida;
import modelo.Ingrediente;
import modelo.Inventario;
import modelo.ListaPedido;
import modelo.TextPrompt;
import modelo.Pedido;
import controlador.ControladorArchivoInventario;
import vista.VentanaValidError;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author anthony.ricse
 * @author Juan Martin Dominguez M
 */
public class PanelDatos extends javax.swing.JFrame {

    private Comida comida; //Comida que se va a pedir    
    Caja micaja = Caja.getCaja();
    ListaPedido misPedidos = ListaPedido.getListaPedido();
    PanelMenu conexion;

    public PanelDatos(PanelMenu menu) {
        this.conexion = menu;
        initComponents();
        setLocationRelativeTo(null);
        TextPrompt placeName = new TextPrompt("Nombre", txtNombre);
        TextPrompt placeDni = new TextPrompt("Dni", txtDni);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPrueba = new javax.swing.JPanel();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        lblFotos = new javax.swing.JLabel();
        lblNombreComida = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panPrueba.setBackground(new java.awt.Color(255, 255, 255));
        panPrueba.setMinimumSize(new java.awt.Dimension(350, 400));
        panPrueba.setPreferredSize(new java.awt.Dimension(350, 400));
        panPrueba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panPrueba.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 140, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Datos :");
        panPrueba.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/confirmar.jpg"))); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panPrueba.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 80, 80));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panPrueba.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 70, 60));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panPrueba.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 123, 140, 30));

        lblPrecio.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        panPrueba.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 80, 50));
        panPrueba.add(lblFotos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 110, 100));

        lblNombreComida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        panPrueba.add(lblNombreComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 120, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Precio: S/.");
        panPrueba.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, 30));

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agregar Pedido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        panPrueba.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 70));

        getContentPane().add(panPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String mensajeDni = "", mensajeNombre = "", mensajeEnviar = "";
        boolean validDni = true, validNombre = true;
        
        /* VALIDACIÓN DEL 'NOMBRE' */
        
        // Validar máximo de caracteres del nombre (50)
        // Validar caracteres alfabéticos, apóstrofe (') y guion (-) en nombre
        // Ejemplo con apóstrofe: O'Connor | Ejemplo con guion: Gomez-Ruiz 
        if (txtNombre.getText().length() > 50 || !txtNombre.getText().matches("[a-zA-Z' -]+")) {
            validNombre = false;
            mensajeNombre = "El nombre debe tener una longitud max. de 50 caracteres"
                            + " y tener caracteres válidos.";
            System.out.println(mensajeNombre);
            
            mensajeEnviar = mensajeNombre;
        }
        
        /* VALIDACIÓN DEL 'DNI' */
        
        // Validar el número de caracteres del String que recibe el DNI tipeado
        // Validar 'solo caracteres numéricos' del DNI tipeado
        if(txtDni.getText().length() != 8 || !txtDni.getText().matches("\\d+")) {
            validDni = false;
            mensajeDni = "El DNI debe tener una longitud de 8 caracteres"
                        + " y ser de caracteres numéricos solamente.";
            System.out.println(mensajeDni);
            
            if(validNombre == false){
                mensajeEnviar = mensajeEnviar.concat(" \n\n "+mensajeDni);
            }
            else{
                mensajeEnviar = mensajeDni;
            }
        }
        
        // Si el nombre y DNI son válidos, se registra el cliente y su pedido
        if(validNombre == true && validDni == true){
            Cliente client = new Cliente(txtNombre.getText(), txtDni.getText());
            Pedido pedido = new Pedido(comida, client);
            descontarIngredientes(pedido);
            misPedidos.addPedido(pedido);
            micaja.addBoleta(pedido);
            this.dispose();
            conexion.actualizarTablas();
        } // Si el nombre o DNI no es válido, aparecerá la ventana de error en los datos
        else{           
            this.dispose();
            VentanaValidError vve = new VentanaValidError(mensajeEnviar);
            vve.setSize(new Dimension(360,310));
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int posX = (pantalla.width - vve.getWidth()) / 2;
            int posY = (pantalla.height - vve.getHeight()) / 2;
            vve.setLocationRelativeTo(null);
            vve.setVisible(true);
        }
        limpiarCampos();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        conexion.actualizarTablas();
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblFotos;
    public javax.swing.JLabel lblNombreComida;
    public javax.swing.JLabel lblPrecio;
    public javax.swing.JPanel panPrueba;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void setComidaAPedir(Comida c) {
        this.comida = c;
        lblPrecio.setText("" + comida.getPrecio());
        lblNombreComida.setText(comida.getNombre());
        lblFotos.setIcon(new javax.swing.ImageIcon(getClass().getResource(comida.getImg())));
    }

    public void limpiarCampos() {
        lblNombreComida.setText("");
        lblPrecio.setText("");
        txtNombre.setText("");
        txtDni.setText("");
    }

    public void descontarIngredientes(Pedido p) {
        Inventario miInventario = Inventario.getInventario();
        for (Ingrediente i : p.comida.getIngredientes()) {
            Ingrediente temp = miInventario.buscarIngrediente(i.getNombre());
            temp.disIngrediente(1);
        }
    }
}