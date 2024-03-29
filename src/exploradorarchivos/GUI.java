/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exploradorarchivos;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author xavie
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() throws NotBoundException  {
        initComponents();
        cargarArbol();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupmenuDirectorio = new javax.swing.JPopupMenu();
        agregarDirectorio = new javax.swing.JMenuItem();
        agregarArchivo = new javax.swing.JMenuItem();
        eliminarDirectorio = new javax.swing.JMenuItem();
        popupmenuArchivo = new javax.swing.JPopupMenu();
        eliminarArchivo = new javax.swing.JMenuItem();
        abrirArchivo = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolDirectorios = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();

        agregarDirectorio.setText("Agregar Directorio");
        agregarDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarDirectorioActionPerformed(evt);
            }
        });
        popupmenuDirectorio.add(agregarDirectorio);

        agregarArchivo.setText("Agregar Archivo");
        agregarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarArchivoActionPerformed(evt);
            }
        });
        popupmenuDirectorio.add(agregarArchivo);

        eliminarDirectorio.setText("Eliminar Directorio");
        eliminarDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDirectorioActionPerformed(evt);
            }
        });
        popupmenuDirectorio.add(eliminarDirectorio);

        eliminarArchivo.setText("Eliminar Archivo");
        eliminarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarArchivoActionPerformed(evt);
            }
        });
        popupmenuArchivo.add(eliminarArchivo);

        abrirArchivo.setText("Abrir Archivo");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });
        popupmenuArchivo.add(abrirArchivo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Root");
        arbolDirectorios.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolDirectorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolDirectoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(arbolDirectorios);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Explorador de Archivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arbolDirectoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolDirectoriosMouseClicked
        // TODO add your handling code here:
        if(evt.isMetaDown()){
            int row = arbolDirectorios.getClosestRowForLocation(evt.getX(), evt.getY());
            arbolDirectorios.setSelectionRow(row);
            Object v1 = arbolDirectorios.getSelectionPath().getLastPathComponent();
            nodo_seleccionado2 = (DefaultMutableTreeNode)v1;
            
            
            if (nodo_seleccionado2.getUserObject() instanceof NodoArbol){
                seleccionado = (NodoArbol)nodo_seleccionado2.getUserObject();
                if(seleccionado.getType() == 'a')
                    popupmenuArchivo.show(evt.getComponent(), evt.getX(), evt.getY());
                else
                    popupmenuDirectorio.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_arbolDirectoriosMouseClicked

    private void agregarDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarDirectorioActionPerformed
        // TODO add your handling code here:
        String nombre = "";
        nombre = JOptionPane.showInputDialog("Nombre de Directorio: ");
        try {
            mensaje.crearDirectorio(((NodoArbol)nodo_seleccionado2.getUserObject()).getNombre()+"/"+nombre,nodo_seleccionado2);
            cargarArbol();
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_agregarDirectorioActionPerformed

    private void agregarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarArchivoActionPerformed
        // TODO add your handling code here:
      JTextField nameField = new JTextField(5);
      JTextArea contentField = new JTextArea(10,25);

      JPanel myPanel = new JPanel();
      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
      myPanel.add(new JLabel("Nombre:"));
      myPanel.add(nameField);      
      myPanel.add(new JLabel("Contenido:"));
      myPanel.add(contentField);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Ingrese el nombre y contenido del archivo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
          try {
            mensaje.crearArchivo(((NodoArbol)nodo_seleccionado2.getUserObject()).getNombre()+"/"+nameField.getText(),contentField.getText(),nodo_seleccionado2);
            cargarArbol();
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_agregarArchivoActionPerformed

    private void eliminarDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarDirectorioActionPerformed
        // TODO add your handling code here:
        try {
            mensaje.borrarDirectorio(seleccionado.getNombre(),nodo_seleccionado2);
            cargarArbol();
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eliminarDirectorioActionPerformed

    private void eliminarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarArchivoActionPerformed
        // TODO add your handling code here:
        try {
            mensaje.borrarArchivo(seleccionado.getNombre(),nodo_seleccionado2);
            cargarArbol();
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eliminarArchivoActionPerformed

    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        // TODO add your handling code here:
        String msg = "";
       try {
           msg = mensaje.verArchivo(seleccionado.getNombre(),nodo_seleccionado2);
           String [] partes = ((NodoArbol)nodo_seleccionado2.getUserObject()).getNombre().split("/");
        JTextField nameField = new JTextField(partes[partes.length-1]);
      JTextArea contentField = new JTextArea(msg,10,25);
      nameField.setEditable(false);
      JPanel myPanel = new JPanel();
      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
      myPanel.add(new JLabel("Nombre:"));
      myPanel.add(nameField);      
      myPanel.add(new JLabel("Contenido:"));
      myPanel.add(contentField);
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Ingrese el nombre y contenido del archivo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
           try {
            mensaje.editarArchivo(((NodoArbol)nodo_seleccionado2.getUserObject()).getNombre(),contentField.getText(),nodo_seleccionado2);
            cargarArbol();
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
            cargarArbol();
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_abrirArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (NotBoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JMenuItem agregarArchivo;
    private javax.swing.JMenuItem agregarDirectorio;
    private javax.swing.JTree arbolDirectorios;
    private javax.swing.JMenuItem eliminarArchivo;
    private javax.swing.JMenuItem eliminarDirectorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popupmenuArchivo;
    private javax.swing.JPopupMenu popupmenuDirectorio;
    // End of variables declaration//GEN-END:variables
  private DefaultMutableTreeNode nodo_seleccionado2;
  private NodoArbol seleccionado;
  Registry repositorio;
  ServerNode mensaje;
  
  public void cargarArbol()throws NotBoundException {
      try {
            repositorio = LocateRegistry.getRegistry("127.0.0.1", 1099);
            mensaje = (ServerNode)repositorio.lookup("ServerNode");
            arbolDirectorios.setModel(mensaje.getEstructura());
            
        } catch (RemoteException ex) {        
        }
  }
}
