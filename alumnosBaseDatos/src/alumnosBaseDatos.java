
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngarciacarrillo
 */
public class alumnosBaseDatos extends javax.swing.JFrame {

    public String db = "dam1";
    public String url = "jdbc:mysql://51.254.137.26/"+db;
    public String user = "dam1";
    public String pass = "dam1234";
    Connection link = null;
    String nombreA;
    String cursoA;
    String apellidosA;
    String idA;
      
    
    

   
    
    
    public alumnosBaseDatos() {
        initComponents();
        conectar();
        
    }
    
   public Connection conectar(){
   
        try {
            link = DriverManager.getConnection(url,user,pass);
        } catch (SQLException ex) {
            Logger.getLogger(alumnosBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
   return link;
   }

public void Añadir(){
nombreA = nombre.getText();
cursoA= curso.getText();
apellidosA = apellido.getText();
idA=id.getText();
        try {
            
            PreparedStatement stmt = link.prepareStatement("INSERT INTO alumnos(nombre,curso,apellidos, id) VALUES ('"+nombreA+"','"+cursoA+"','"+apellidosA+"','"+idA+"')");
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(alumnosBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
public void Borrar() {
    idA=id.getText();
   
        try {
            PreparedStatement stmt = link.prepareStatement("DELETE FROM alumnos WHERE id = '"+idA+"'");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(alumnosBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
}     

public void modificar(){

String idModificar= JOptionPane.showInputDialog(null, "¿Cual es el alumno a modificar?, Introduce su ID");
String nuevoNombre= JOptionPane.showInputDialog (null, "Introduce nombre");
String nuevoApellidos= JOptionPane.showInputDialog (null, "Introduce apellido");
String nuevoCurso = JOptionPane.showInputDialog (null, "Introduce curso");

        try {
            //PreparedStatement stmt = link.prepareStatement("UPDATE alumnos SET nombre ='"+nuevoNombre+"' WHERE id = '"+idModificar+"'" );
             PreparedStatement stmt = link.prepareStatement("UPDATE alumnos SET nombre ='"+nuevoNombre+"',curso= '"+nuevoCurso+"', apellidos = '"+nuevoApellidos+"' WHERE id = '"+idModificar+"'" );
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "hecho");
        } catch (SQLException ex) {
            
            Logger.getLogger(alumnosBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        curso = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre: ");

        jLabel2.setText("curso:");

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        borrar.setLabel("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellidos:");

        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });

        jLabel4.setText("ID:");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        modificar.setText("modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(añadir)
                        .addGap(42, 42, 42)
                        .addComponent(borrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(modificar)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nombre)
                                        .addComponent(curso, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(apellido)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadir)
                    .addComponent(borrar)
                    .addComponent(modificar))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
    Añadir();
    curso.setText("");
    nombre.setText("");
    apellido.setText("");
    id.setText("");
   
    }//GEN-LAST:event_añadirActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        Borrar();
        curso.setText("");
        nombre.setText("");
        apellido.setText("");
        id.setText("");
        
    }//GEN-LAST:event_borrarActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        modificar();
        curso.setText("");
        nombre.setText("");
        apellido.setText("");
        id.setText("");
        
    }//GEN-LAST:event_modificarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(alumnosBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumnosBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumnosBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumnosBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new alumnosBaseDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JButton añadir;
    private javax.swing.JButton borrar;
    private javax.swing.JTextField curso;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
