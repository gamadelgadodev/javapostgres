/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkgRegform;
//librerias para el funcionamiento del proyecto
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar; 
import java.util.Date;
import java.text.DateFormat; 
import java.util.Date;
import java.util.*;   
/**
 *
 * @author Andres Viramontes
 */
public class frmRegform extends javax.swing.JFrame {
    static String idAux;//variable para guardar el id de la tupla seleccionada en la tabla
    static String usuario;
    static String passW;
    List<String> idAlb = new ArrayList<String>();//variables auxiliares para manejar los combbox que no tienen el id
    List<String> idPlay = new ArrayList<String>();//en el combobox y se nesesita tener acceso a ello
    List<String> idCan = new ArrayList<String>();
  
    
    //constructor del fromulario si se inicia como clase principal
    public frmRegform() {
        initComponents();
        //Cargan los datos en los combobox pertinentes que son llaves foraneas y poder manipularlos
        llaveForDisquera();//tienen que ir primero ya que es de donde se obtienen algunos datos concatenados para mostrar
        llaveForGen();
        llaveForGen1();
        llaveForArt();
        llaveForAlb();
        llaveForComp();
        llaveForMiemb();
        llaveForMiemb1();
        llaveForPlay();
        llaveForPlay1();
        llaveForCan();
        //cargan los datos en las tablas una vez que se inician los proyectos
         mostrarGen(); 
         mostrarMiemb();
         mostrarDisque();
         mostrarComp();
         mostrarArt();
         mostrarAlb();
         mostrarCan();
         mostrarPlay();
         mostrarDplay();
         
    }
    //constructor del formulario si se incia despues del login
        public frmRegform(String contra,String usurio) {
        usuario = usurio;//recibimos el usuario y contrasena desde el formulario de login
        passW = contra;   
        initComponents();
        //Cargan los datos en los combobox pertinentes que son llaves foraneas y poder manipularlos
        llaveForDisquera();//tienen que ir primero ya que es de donde se obtienen algunos datos concatenados para mostrar
        llaveForGen();
        llaveForGen1();
        llaveForArt();
        llaveForAlb();
        llaveForComp();
        llaveForMiemb();
        llaveForMiemb1();
        llaveForPlay();
        llaveForPlay1();
        llaveForCan();
         //cargan los datos en las tablas una vez que se inician los proyectos
         mostrarGen(); 
         mostrarMiemb();
         mostrarDisque();
         mostrarComp();
         mostrarArt();
         mostrarAlb();
         mostrarCan();
         mostrarPlay();
         mostrarDplay();
        if(usuario.contentEquals("miembro1")){//verificamos que tipo de usuario es para asi desabilitar algunos controles a los cuales dicho usuario no tiene acceso
        inhabilitaMiembro();//clase que desabilita mas controles para el usario en turno
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        addDisque.setEnabled(false);
        modDisque.setEnabled(false);
        delDisque.setEnabled(false);
        addComp.setEnabled(false);
        modComp.setEnabled(false);
        delComp.setEnabled(false);
        addArt.setEnabled(false);
        modArt.setEnabled(false);
        delArt.setEnabled(false);
        addAlb.setEnabled(false);
        modAlb.setEnabled(false);
        delAlb.setEnabled(false);
        addCan.setEnabled(false);
        modCan.setEnabled(false);
        delCan.setEnabled(false);
        }else if(usuario.contentEquals("artista1")){//verificamos que tipo de usuario es para asi desabilitar algunos controles a los cuales dicho usuario no tiene acceso
        inhabilitaArtista();//clase que desabilita mas controles para el usario en turno
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        addDisque.setEnabled(false);
        modDisque.setEnabled(false);
        delDisque.setEnabled(false);
        addComp.setEnabled(false);
        modComp.setEnabled(false);
        delComp.setEnabled(false);
        addAlb1.setEnabled(false);
        modAlb1.setEnabled(false);
        delAlb1.setEnabled(false);
        addDPlay.setEnabled(false);
        modDPlay.setEnabled(false);
        delDPlay.setEnabled(false);
        jPanel2.setEnabled(false);
        }
         
    }

    /**
     * Codigo generado por java para el funcionamiento de la interfaz grafica
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Miemb = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMiembro = new javax.swing.JTextField();
        modMiemb = new javax.swing.JButton();
        delMiemb = new javax.swing.JButton();
        addMiemb = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDatePickerMiem = new org.jdatepicker.JDatePicker();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Gen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtextGenero = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_Disque = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtdisquera = new javax.swing.JTextField();
        modDisque = new javax.swing.JButton();
        delDisque = new javax.swing.JButton();
        addDisque = new javax.swing.JButton();
        txtPagWeb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDatePickerDisque = new org.jdatepicker.JDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla_Comp = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtComp = new javax.swing.JTextField();
        modComp = new javax.swing.JButton();
        delComp = new javax.swing.JButton();
        addComp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ComboComp = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tabla_Art = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtArt = new javax.swing.JTextField();
        modArt = new javax.swing.JButton();
        delArt = new javax.swing.JButton();
        addArt = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ComboDisqF = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tabla_Alb = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtAlbum = new javax.swing.JTextField();
        modAlb = new javax.swing.JButton();
        delAlb = new javax.swing.JButton();
        addAlb = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        ComboGenF = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        ComboArtF = new javax.swing.JComboBox<>();
        txtnAlbum = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Tabla_Can = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtCan = new javax.swing.JTextField();
        modCan = new javax.swing.JButton();
        delCan = new javax.swing.JButton();
        addCan = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        ComboAlbF = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        ComboCompF = new javax.swing.JComboBox<>();
        txtnDurM = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtnDurS = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ComboCompE = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jDatePickerCan = new org.jdatepicker.JDatePicker();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Tabla_Play = new javax.swing.JTable();
        txtPlay = new javax.swing.JTextField();
        modAlb1 = new javax.swing.JButton();
        delAlb1 = new javax.swing.JButton();
        addAlb1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        ComboMiembF = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        ComboPriv = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Tabla_DPlay = new javax.swing.JTable();
        modDPlay = new javax.swing.JButton();
        delDPlay = new javax.swing.JButton();
        addDPlay = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        ComboPlayF = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        ComboCanF = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Tabla_Consulta2 = new javax.swing.JTable();
        consultaR2 = new javax.swing.JButton();
        ComboPlayF1 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Tabla_Consulta = new javax.swing.JTable();
        consultaR1 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        ComboMiembF1 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        ComboGenF1 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla_Miemb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Miemb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_MiembMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_Miemb);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre Miembro");

        modMiemb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modMiemb.setText("Modificar");
        modMiemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modMiembActionPerformed(evt);
            }
        });

        delMiemb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delMiemb.setText("Eliminar");
        delMiemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delMiembActionPerformed(evt);
            }
        });

        addMiemb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addMiemb.setText("Añadir");
        addMiemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMiembActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de nacimiento");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMiembro)
                        .addComponent(modMiemb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delMiemb, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jDatePickerMiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMiemb, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jDatePickerMiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addMiemb, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(modMiemb, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(delMiemb, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        txtMiembro.getAccessibleContext().setAccessibleName("nombreMiebro");
        txtEmail.getAccessibleContext().setAccessibleName("emailMiembro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 85, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 85, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Miembro", jPanel2);

        Tabla_Gen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Gen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_GenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Gen);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del género");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Añadir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextGenero)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtextGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        jTabbedPane4.addTab("Género", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("tabGenero");

        Tabla_Disque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Disque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_DisqueMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla_Disque);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre de la disquera");

        modDisque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modDisque.setText("Modificar");
        modDisque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modDisqueActionPerformed(evt);
            }
        });

        delDisque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delDisque.setText("Eliminar");
        delDisque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delDisqueActionPerformed(evt);
            }
        });

        addDisque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addDisque.setText("Añadir");
        addDisque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDisqueActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Pagna web");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de fundación");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdisquera)
                        .addComponent(modDisque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delDisque, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(addDisque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPagWeb)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jDatePickerDisque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdisquera, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPagWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jDatePickerDisque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addDisque, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(modDisque, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(delDisque, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane4.addTab("Disquera", jPanel5);

        Tabla_Comp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_CompMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tabla_Comp);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nombre Compositor");

        modComp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modComp.setText("Modificar");
        modComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modCompActionPerformed(evt);
            }
        });

        delComp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delComp.setText("Eliminar");
        delComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCompActionPerformed(evt);
            }
        });

        addComp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addComp.setText("Añadir");
        addComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Pais de origen");

        ComboComp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Reino Unido", "Estados Unidos", "Japón", "México", "Brasil", "Canadá", "China", "Alemania", "Rusia", "India", "Colombia", "Argentina" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComp)
                    .addComponent(modComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delComp, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(addComp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboComp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtComp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboComp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addComp, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(modComp, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(delComp, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane4.addTab("Compositor", jPanel4);

        Tabla_Art.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Art.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_ArtMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(Tabla_Art);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nombre Artista");

        modArt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modArt.setText("Modificar");
        modArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modArtActionPerformed(evt);
            }
        });

        delArt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delArt.setText("Eliminar");
        delArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delArtActionPerformed(evt);
            }
        });

        addArt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addArt.setText("Añadir");
        addArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArtActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Disquera");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArt)
                    .addComponent(modArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delArt, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(addArt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboDisqF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboDisqF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addArt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(modArt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(delArt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane4.addTab("Artista", jPanel6);

        Tabla_Alb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Alb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_AlbMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Tabla_Alb);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Cantidad de canciones");

        modAlb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modAlb.setText("Modificar");
        modAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modAlbActionPerformed(evt);
            }
        });

        delAlb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delAlb.setText("Eliminar");
        delAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delAlbActionPerformed(evt);
            }
        });

        addAlb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addAlb.setText("Añadir");
        addAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlbActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Artista");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Género");

        ComboArtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboArtFActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Nombre Album");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlbum)
                    .addComponent(modAlb, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(delAlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAlb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboGenF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboArtF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnAlbum, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(673, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(673, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(ComboGenF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboArtF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtnAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addAlb, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modAlb, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(delAlb, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(632, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(715, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Álbum", jPanel7);

        Tabla_Can.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Can.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_CanMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Tabla_Can);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText(":");

        modCan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modCan.setText("Modificar");
        modCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modCanActionPerformed(evt);
            }
        });

        delCan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delCan.setText("Eliminar");
        delCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCanActionPerformed(evt);
            }
        });

        addCan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addCan.setText("Añadir");
        addCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCanActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Compositor");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Álbum");

        ComboCompF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCompFActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Explicita");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("S");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Duracion");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("M");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Nombre canción");

        ComboCompE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Si", "No" }));
        ComboCompE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCompEActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Fecha de lanzamiento");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCan)
                                .addComponent(ComboAlbF, 0, 270, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboCompF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtnDurM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnDurS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(delCan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(modCan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(addCan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(ComboCompE, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jDatePickerCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(673, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboAlbF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboCompF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnDurM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnDurS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDatePickerCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboCompE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(addCan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modCan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delCan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(726, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Canción", jPanel8);

        Tabla_Play.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_PlayMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(Tabla_Play);

        modAlb1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modAlb1.setText("Modificar");
        modAlb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modAlb1ActionPerformed(evt);
            }
        });

        delAlb1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delAlb1.setText("Eliminar");
        delAlb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delAlb1ActionPerformed(evt);
            }
        });

        addAlb1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addAlb1.setText("Añadir");
        addAlb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlb1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Privacidad");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Usuario");

        ComboPriv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Privada", "Publica" }));
        ComboPriv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPrivActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Nombre de la Playlist");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPlay)
                    .addComponent(modAlb1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(delAlb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAlb1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboMiembF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboPriv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(673, Short.MAX_VALUE)))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(673, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txtPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(ComboMiembF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboPriv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addAlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modAlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(delAlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(632, Short.MAX_VALUE)))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(715, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Playlist", jPanel9);

        Tabla_DPlay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_DPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_DPlayMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(Tabla_DPlay);

        modDPlay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modDPlay.setText("Modificar");
        modDPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modDPlayActionPerformed(evt);
            }
        });

        delDPlay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delDPlay.setText("Eliminar");
        delDPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delDPlayActionPerformed(evt);
            }
        });

        addDPlay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addDPlay.setText("Añadir");
        addDPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDPlayActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Cancion");

        ComboPlayF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPlayFActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Playlist");

        ComboCanF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCanFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(modDPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(delDPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addDPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComboPlayF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboCanF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboPlayF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboCanF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addDPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modDPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(delDPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane4.addTab("Detalle Playlist", jPanel10);

        Tabla_Consulta2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Consulta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_Consulta2MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(Tabla_Consulta2);

        consultaR2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consultaR2.setText("Consulta");
        consultaR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaR2ActionPerformed(evt);
            }
        });

        ComboPlayF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPlayF1ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Playlist");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Obtenga las cacniones que se tienen en una playlist");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboPlayF1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(consultaR2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ComboPlayF1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(consultaR2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Reporte1", jPanel12);

        Tabla_Consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_ConsultaMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(Tabla_Consulta);

        consultaR1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consultaR1.setText("Consulta");
        consultaR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaR1ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Género");

        ComboMiembF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMiembF1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Miembro");

        ComboGenF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboGenF1ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Obtenga el numero de canciones de un género que tiene una ");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("persona en sus playlist:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(consultaR1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(ComboMiembF1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboGenF1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(67, 67, 67)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ComboMiembF1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboGenF1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(consultaR1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Reporte2", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void inhabilitaMiembro(){//clase que desabilita mas controles para el usario en turno
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        addDisque.setEnabled(false);
        modDisque.setEnabled(false);
        delDisque.setEnabled(false);
        addComp.setEnabled(false);
        modComp.setEnabled(false);
        delComp.setEnabled(false);
        addArt.setEnabled(false);
        modArt.setEnabled(false);
        delArt.setEnabled(false);
        addAlb.setEnabled(false);
        modAlb.setEnabled(false);
        delAlb.setEnabled(false);
        addCan.setEnabled(false);
        modCan.setEnabled(false);
        delCan.setEnabled(false);
        
    }
    public void inhabilitaArtista(){//clase que desabilita mas controles para el usario en turno
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        addDisque.setEnabled(false);
        modDisque.setEnabled(false);
        delDisque.setEnabled(false);
        addComp.setEnabled(false);
        modComp.setEnabled(false);
        delComp.setEnabled(false);
        addAlb1.setEnabled(false);
        modAlb1.setEnabled(false);
        delAlb1.setEnabled(false);
        addDPlay.setEnabled(false);
        modDPlay.setEnabled(false);
        delDPlay.setEnabled(false);
        addMiemb.setEnabled(false);
        modMiemb.setEnabled(false);
        delMiemb.setEnabled(false);
        txtMiembro.setEnabled(false);
        txtEmail.setEnabled(false);
        jDatePickerMiem.setEnabled(false);
        Tabla_Miemb.setEnabled(false);
   }
    
    public void llaveForDisquera()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        ComboDisqF.removeAllItems();//se limpia el combobox a llenar
         Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboDisqF.addItem(""); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idDisquera,NombreDisquera FROM Disquera"); //Consulta para obtener los datos 
            while(rs.next())
            {
                ComboDisqF.addItem(rs.getString("idDisquera")+","+rs.getString("NombreDisquera"));//se agregan los datos al combobox
                //modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForGen()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        ComboGenF.removeAllItems();//se limpia el combobox a llenar
         Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboGenF.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idGenero,NombreGenero FROM Genero");//Consulta para obtener los datos 
            while(rs.next())
            {
                ComboGenF.addItem(rs.getString("idGenero")+","+rs.getString("NombreGenero")); //se agregan los datos al combobox
                //modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForGen1()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        ComboGenF1.removeAllItems();//se limpia el combobox a llenar
         Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboGenF1.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idGenero,NombreGenero FROM Genero");//Consulta para obtener los datos 
            while(rs.next())
            {
                ComboGenF1.addItem(rs.getString("idGenero")+","+rs.getString("NombreGenero")); //se agregan los datos al combobox
                //modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForMiemb()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        ComboMiembF.removeAllItems();//se limpia el combobox a llenar
         Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboMiembF.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idMiembro,NombreMiembro FROM Miembro");//Consulta para obtener los datos 
            while(rs.next())
            {
                ComboMiembF.addItem(rs.getString("idMiembro")+","+rs.getString("NombreMiembro")); //se agregan los datos al combobox
                //modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
     public void llaveForMiemb1()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        ComboMiembF1.removeAllItems();//se limpia el combobox a llenar
         Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboMiembF1.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idMiembro,NombreMiembro FROM Miembro");//Consulta para obtener los datos 
            while(rs.next())
            {
                ComboMiembF1.addItem(rs.getString("idMiembro")+","+rs.getString("NombreMiembro")); //se agregan los datos al combobox
                //modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForArt()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        ComboArtF.removeAllItems();//se limpia el combobox a llenar
         Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboArtF.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT A.idArtista,A.NombreArtista,D.NombreDisquera FROM Artista A INNER JOIN Disquera D on A.idDisquera=D.idDisquera");
            //Consulta para obtener los datos 
            while(rs.next())
            {
                ComboArtF.addItem(rs.getString("idArtista")+","+rs.getString("NombreArtista")+","+rs.getString("NombreDisquera"));//se agregan los datos al combobox 
                //modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForAlb()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        idAlb.clear();
        idAlb.add(" ");
        ComboAlbF.removeAllItems();//se limpia el combobox a llenar
        Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboAlbF.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT A.idAlbum,A.NombreAlbum,A.CantidadCanciones,B.NombreArtista FROM Album A INNER JOIN Artista B on A.idArtista=B.idArtista");
            //Consulta para obtener los datos 
            while(rs.next())
            {
               idAlb.add(rs.getString("idAlbum"));
               ComboAlbF.addItem(rs.getString("NombreArtista")+","+rs.getString("NombreAlbum")+",("+rs.getString("CantidadCanciones")+")");//se agregan los datos al combobox 
                //modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForCan()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        idCan.clear();
        idCan.add(" ");
        ComboCanF.removeAllItems();//se limpia el combobox a llenar
        Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboCanF.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT C.idCancion,C.NombreCancion,extract(year from C.FechaLanzamiento)as Anio,A.NombreArtista FROM Cancion C INNER JOIN Album B on C.idAlbum=B.idAlbum INNER JOIN Artista A on B.idArtista=A.idArtista");
            //Consulta para obtener los datos 
            while(rs.next())
            {
               idCan.add(rs.getString("idCancion"));
               ComboCanF.addItem(rs.getString("NombreCancion")+","+rs.getString("NombreArtista")+",("+rs.getString("Anio")+")"); 
               //se agregan los datos al combobox
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForPlay()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        idPlay.clear();
        idPlay.add(" ");
        ComboPlayF.removeAllItems();//se limpia el combobox a llenar
        Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboPlayF.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idPlaylist,NombrePlaylist FROM Playlist");//Consulta para obtener los datos 
            
            while(rs.next())
            {
               idPlay.add(rs.getString("idPlaylist"));
               ComboPlayF.addItem(rs.getString("NombrePlaylist")); 
                //se agregan los datos al combobox;
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForPlay1()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        idPlay.clear();
        idPlay.add(" ");
        ComboPlayF1.removeAllItems();//se limpia el combobox a llenar
        Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboPlayF1.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idPlaylist,NombrePlaylist FROM Playlist");
            //Consulta para obtener los datos 
            while(rs.next())
            {
               idPlay.add(rs.getString("idPlaylist"));
               ComboPlayF1.addItem(rs.getString("NombrePlaylist")); 
               //se agregan los datos al combobox
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    public void llaveForComp()//Hace una consulta en la base de datos y obtiene los datos que van dentro de el combobox al que se esta llenando
    {
        ComboCompF.removeAllItems();//se limpia el combobox a llenar
         Connection c=null; //variables para la conexcion a la base de datos
        Statement stmt = null;
        String datos[] = new String[1];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Disquera");
        ComboCompF.addItem(""); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idCompositor,NombreCompositor FROM Compositor");
            //Consulta para obtener los datos 
            while(rs.next())
            {
               
               ComboCompF.addItem(rs.getString("idCompositor")+","+rs.getString("NombreCompositor")); 
                //se agregan los datos al combobox
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    private void addDisqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDisqueActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para insertar
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = jDatePickerDisque.getModel().getDay() + "/" +  jDatePickerMiem.getModel().getMonth() + "/" + jDatePickerMiem.getModel().getYear();
        //JOptionPane.showMessageDialog(null, "Fecha"+date);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Disquera(NombreDisquera,PaginaWeb,FechaFundacion)" +
               "VALUES ('" + txtdisquera.getText() + "','" + txtPagWeb.getText() + "','" 
                    +  date +"')";//insersion en l base y despues un commit para enviar los cambios
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtdisquera.setText(null);
            txtPagWeb.setText(null);
            jDatePickerDisque.getModel().setSelected(false);//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        } // TODO add your handling code here:
        llaveForDisquera();
        mostrarDisque();
        llaveForDisquera();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_addDisqueActionPerformed

    private void delDisqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delDisqueActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = jDatePickerDisque.getModel().getDay() + "/" +  jDatePickerMiem.getModel().getMonth() + "/" + jDatePickerMiem.getModel().getYear();
        //JOptionPane.showMessageDialog(null, "Fecha"+date);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE FROM Disquera WHERE idDisquera=" + idAux;
            //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtdisquera.setText(null);
            txtPagWeb.setText(null);
            jDatePickerDisque.getModel().setSelected(false);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        } // TODO add your handling code here:
        mostrarDisque();// TODO add your handling code here:// TODO add your handling code here:
        llaveForDisquera();
        llaveForDisquera();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_delDisqueActionPerformed

    private void modDisqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modDisqueActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = jDatePickerDisque.getModel().getDay() + "/" +  jDatePickerMiem.getModel().getMonth() + "/" + jDatePickerMiem.getModel().getYear();
        //JOptionPane.showMessageDialog(null, "Fecha"+date);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE Disquera SET NombreDisquera=" + "'" + txtdisquera.getText() + "'" + "," + "PaginaWeb=" + "'" + txtPagWeb.getText() + "'"
                + "," + "FechaFundacion=" + "'" + date + "'"+ " WHERE idDisquera=" + idAux;
             //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtdisquera.setText(null);
            txtPagWeb.setText(null);
            jDatePickerDisque.getModel().setSelected(false);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        } // TODO add your handling code here:
        llaveForDisquera();
        mostrarDisque();// TODO add your handling code here:
        llaveForDisquera();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_modDisqueActionPerformed
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_DisqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_DisqueMouseClicked
        int fila = Tabla_Disque.getSelectedRow();
        //se obtiene el indice de la tabla
        if (fila >= 0) {
            //se obtienen los datos y se castean o se pasan al control correspondiente
            idAux = Tabla_Disque.getValueAt(fila, 0).toString();
            txtdisquera.setText(Tabla_Disque.getValueAt(fila, 1).toString());
            txtPagWeb.setText(Tabla_Disque.getValueAt(fila, 2).toString());
            String[] fech = Tabla_Disque.getValueAt(fila, 3).toString().split("-");
            //JOptionPane.showMessageDialog(null,Tabla_Miemb.getValueAt(fila, 4).toString());
            int dia = Integer.valueOf(fech[1]);
            int mes = Integer.valueOf(fech[2]);
            int ano = Integer.valueOf(fech[0]);

            jDatePickerDisque.getModel().setMonth(mes);
            jDatePickerDisque.getModel().setYear(ano);
            jDatePickerDisque.getModel().setDay(dia);
            jDatePickerDisque.getModel().setSelected(true);
            //jtextGenero.setText(nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }    // TODO add your handling code here:
    }//GEN-LAST:event_Tabla_DisqueMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //boton para insertar en la base y variables nesesarias para la conexion
        Connection c=null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Genero(NombreGenero)" +
               "VALUES ('" + jtextGenero.getText() +"')";//insersion en l base y despues un commit para enviar los cambios
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            jtextGenero.setText(null);//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
         llaveForGen();
        mostrarGen(); //Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE FROM Genero WHERE idGenero ="+idAux;
            //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            jtextGenero.setText(null);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
         llaveForGen();
        mostrarGen();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection c=null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE Genero SET NombreGenero = '"+jtextGenero.getText()+"'  WHERE idGenero = "+idAux;
             //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            jtextGenero.setText(null);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
         llaveForGen();
        mostrarGen();       //Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_jButton1ActionPerformed
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_GenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_GenMouseClicked
        int fila = Tabla_Gen.getSelectedRow();
        //se obtiene el indice de la tabla
        if (fila >= 0) {
            idAux = Tabla_Gen.getValueAt(fila, 0).toString();//se obtienen los datos y se castean o se pasan al control correspondiente
            String nombre = Tabla_Gen.getValueAt(fila, 1).toString();

            jtextGenero.setText(nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }// TODO add your handling code here:
    }//GEN-LAST:event_Tabla_GenMouseClicked

    private void addMiembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMiembActionPerformed
       //Boton para agregar variables para crear la conexion
        Connection c=null;  
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = jDatePickerMiem.getModel().getDay() + "/" +  jDatePickerMiem.getModel().getMonth() + "/" + jDatePickerMiem.getModel().getYear();
        //JOptionPane.showMessageDialog(null, "Fecha"+date);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Miembro(NombreMiembro,Email,FechaNacimiento,MiembroDesde)" +
               "VALUES ('" + txtMiembro.getText() + "','" + txtEmail.getText() + "','" 
                    +  date + "','" + dtf.format(LocalDateTime.now()) +"')";//insersion en la base y despues un commit para enviar los cambios
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtMiembro.setText(null);
            txtEmail.setText(null);
            jDatePickerMiem.getModel().setSelected(false);//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        llaveForMiemb();
        mostrarMiemb();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_addMiembActionPerformed

    private void delMiembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delMiembActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = jDatePickerMiem.getModel().getDay() + "/" +  (jDatePickerMiem.getModel().getMonth()+1) + "/" + jDatePickerMiem.getModel().getYear();
        //JOptionPane.showMessageDialog(null, "Fecha"+date);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE FROM Miembro WHERE idMiembro=" + idAux;
             //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            txtMiembro.setText(null);
            txtEmail.setText(null);
            jDatePickerMiem.getModel().setSelected(false);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarMiemb();// TODO add your handling code here:
        llaveForMiemb();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_delMiembActionPerformed

    private void modMiembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modMiembActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = jDatePickerMiem.getModel().getDay() + "/" +  (jDatePickerMiem.getModel().getMonth()+1) + "/" + jDatePickerMiem.getModel().getYear();
        // JOptionPane.showMessageDialog(null, "Fecha"+date);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE Miembro SET NombreMiembro = '" + txtMiembro.getText() + "' , Email = '" + txtEmail.getText() + "' , FechaNacimiento = '" + date + "' , MiembroDesde = '" + dtf.format(LocalDateTime.now()) + "' WHERE idMiembro=" + idAux;
            //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            txtMiembro.setText(null);
            txtEmail.setText(null);
            jDatePickerMiem.getModel().setSelected(false);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }        // TODO add your handling code here:
        mostrarMiemb();
        llaveForMiemb();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_modMiembActionPerformed

    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_MiembMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_MiembMouseClicked
        int fila = Tabla_Miemb.getSelectedRow();//se obtiene el indice de la tabla
        
        if (fila >= 0) {
            idAux = Tabla_Miemb.getValueAt(fila, 0).toString();//se obtienen los datos y se castean o se pasan al control correspondiente
            txtMiembro.setText(Tabla_Miemb.getValueAt(fila, 1).toString());
            txtEmail.setText(Tabla_Miemb.getValueAt(fila, 3).toString());
            String[] fech = Tabla_Miemb.getValueAt(fila, 4).toString().split("-");
            //JOptionPane.showMessageDialog(null,Tabla_Miemb.getValueAt(fila, 4).toString());
            int dia = Integer.valueOf(fech[1]);
            int mes = Integer.valueOf(fech[2]);
            int ano = Integer.valueOf(fech[0]);

            jDatePickerMiem.getModel().setMonth(mes);
            jDatePickerMiem.getModel().setYear(ano);
            jDatePickerMiem.getModel().setDay(dia);
            jDatePickerMiem.getModel().setSelected(true);
            //jtextGenero.setText(nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla_MiembMouseClicked
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_CompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CompMouseClicked
        int fila = Tabla_Comp.getSelectedRow();//se obtiene el indice de la tabla

        if (fila >= 0) {
            //se obtienen los datos y se castean o se pasan al control correspondiente
            idAux = Tabla_Comp.getValueAt(fila, 0).toString();
            txtComp.setText(Tabla_Comp.getValueAt(fila, 1).toString());
            ComboComp.getModel().setSelectedItem(Tabla_Comp.getValueAt(fila, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }// TODO add your handling code here:
    }//GEN-LAST:event_Tabla_CompMouseClicked

    private void modCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modCompActionPerformed
         Connection c=null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE Compositor SET NombreCompositor = '" + txtComp.getText() + "' , PaisOrigen = '" + ComboComp.getModel().getSelectedItem().toString() +"' WHERE idCompositor=" + idAux;
             //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtComp.setText(null);
            ComboComp.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }// TODO add your handling code here:
        mostrarComp();// TODO add your handling code here:
        llaveForComp();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_modCompActionPerformed

    private void delCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCompActionPerformed
        Connection c=null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE FROM Compositor WHERE idCompositor=" + idAux;
            //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtComp.setText(null);
            ComboComp.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }// TODO add your handling code here:
        mostrarComp();// TODO add your handling code here:
        llaveForComp();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_delCompActionPerformed

    private void addCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Compositor(NombreCompositor,PaisOrigen,NumeroCanciones)" +
              "VALUES ('" + txtComp.getText() + "','" + ComboComp.getModel().getSelectedItem().toString() + "',"+ 0 +")";
            //insersion en l base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtComp.setText(null);
            ComboComp.getModel().setSelectedItem(" ");//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }// TODO add your handling code here:
        mostrarComp();
        llaveForComp();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_addCompActionPerformed
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_ArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_ArtMouseClicked
        int fila = Tabla_Art.getSelectedRow();//se obtiene el indice de la tabla

        if (fila >= 0) {
            //se obtienen los datos y se castean o se pasan al control correspondiente
            idAux = Tabla_Art.getValueAt(fila, 0).toString();
            txtArt.setText(Tabla_Art.getValueAt(fila, 1).toString());
            ComboDisqF.getModel().setSelectedItem(Tabla_Art.getValueAt(fila, 2).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }// T// TODO add your handling code here:
    }//GEN-LAST:event_Tabla_ArtMouseClicked

    private void modArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modArtActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        String[] id=ComboDisqF.getModel().getSelectedItem().toString().split(",");
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE Artista SET idDisquera=" + "'" + id[0] + "'," + "NombreArtista=" + "'" + txtArt.getText() +
               "' WHERE idArtista=" + idAux;
               //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtArt.setText(null);
            ComboDisqF.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }// TODO add your handling code here:
        mostrarArt();
        llaveForArt();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_modArtActionPerformed

    private void delArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delArtActionPerformed
         Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        String[] id=ComboDisqF.getModel().getSelectedItem().toString().split(",");
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE FROM Artista WHERE idArtista=" + idAux;
             //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtArt.setText(null);
            ComboDisqF.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarArt();//Recargar llaves foraneas y tablas correspondientes:
        llaveForArt();
    }//GEN-LAST:event_delArtActionPerformed

    private void addArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArtActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para insertar
        String[] id=ComboDisqF.getModel().getSelectedItem().toString().split(",");
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Artista(idDisquera,NombreArtista)" +
               "VALUES ('" + id[0] + "','" + txtArt.getText() + "')";
              //insersion en l base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtArt.setText(null);
            ComboDisqF.getModel().setSelectedItem(" ");//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }// TODO add your handling code here:
        mostrarArt();
        llaveForArt();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_addArtActionPerformed
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_AlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_AlbMouseClicked
        int fila = Tabla_Alb.getSelectedRow();//se obtiene el indice de la tabla

        if (fila >= 0) {//se obtienen los datos y se castean o se pasan al control correspondiente
            idAux = Tabla_Alb.getValueAt(fila, 0).toString();
            ComboGenF.getModel().setSelectedItem(Tabla_Alb.getValueAt(fila, 1).toString());
            ComboArtF.getModel().setSelectedItem(Tabla_Alb.getValueAt(fila, 2).toString());
            txtAlbum.setText(Tabla_Alb.getValueAt(fila, 3).toString());
            txtnAlbum.setText(Tabla_Alb.getValueAt(fila, 4).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }// T// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla_AlbMouseClicked

    private void modAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modAlbActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        String[] id1=ComboGenF.getModel().getSelectedItem().toString().split(",");
        String[] id2=ComboArtF.getModel().getSelectedItem().toString().split(",");
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql =  "UPDATE Album SET idGenero=" + "'" + id1[0] + "'," + "idArtista='" + id2[0] + "'," + "NombreAlbum='" + txtAlbum.getText() + "'," + "CantidadCanciones='" + txtnAlbum.getText() +
              "' WHERE idAlbum=" + idAux;
             //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtAlbum.setText(null);
            txtnAlbum.setText(null);
            ComboArtF.getModel().setSelectedItem(" ");
            ComboGenF.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarAlb();//Recargar llaves foraneas y tablas correspondientes
        llaveForAlb();
    }//GEN-LAST:event_modAlbActionPerformed

    private void delAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delAlbActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        String id1=ComboGenF.getModel().getSelectedItem().toString();
        String id2=ComboArtF.getModel().getSelectedItem().toString();
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql =  "DELETE FROM Album  WHERE idAlbum=" + idAux ;
            //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtAlbum.setText(null);
            txtnAlbum.setText(null);
            ComboArtF.getModel().setSelectedItem(" ");
            ComboGenF.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarAlb();///Recargar llaves foraneas y tablas correspondientes
        llaveForAlb();
    }//GEN-LAST:event_delAlbActionPerformed

    private void addAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlbActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para insertar
        String[] id1=ComboGenF.getModel().getSelectedItem().toString().split(",");
        String[] id2=ComboArtF.getModel().getSelectedItem().toString().split(",");
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Album(idGenero,idArtista,NombreAlbum,CantidadCanciones)" +
               "VALUES ('" + id1[0] + "','" + id2[0] + "','" + txtAlbum.getText() + "','" + txtnAlbum.getText() + "')";
              //insersion en l base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtAlbum.setText(null);
            txtnAlbum.setText(null);
            ComboArtF.getModel().setSelectedItem(" ");
            ComboGenF.getModel().setSelectedItem(" ");//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }// TODO add your handling code here:
        mostrarAlb(); 
        llaveForAlb();//Recargar llaves foraneas y tablas correspondientese:
    }//GEN-LAST:event_addAlbActionPerformed

    private void ComboArtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboArtFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboArtFActionPerformed
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_CanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CanMouseClicked
        int fila = Tabla_Can.getSelectedRow();//se obtiene el indice de la tabla
        if (fila >= 0) {
            //se obtienen los datos y se castean o se pasan al control correspondiente
            idAux = Tabla_Can.getValueAt(fila, 0).toString();
            ComboAlbF.getModel().setSelectedItem(Tabla_Can.getValueAt(fila, 1).toString());
            ComboCompF.getModel().setSelectedItem(Tabla_Can.getValueAt(fila, 2).toString());
            txtCan.setText(Tabla_Can.getValueAt(fila, 3).toString());
            String[] fech = Tabla_Can.getValueAt(fila, 4).toString().split("-");
            //JOptionPane.showMessageDialog(null,Tabla_Miemb.getValueAt(fila, 4).toString());
            int dia = Integer.valueOf(fech[1]);
            int mes = Integer.valueOf(fech[2]);
            int ano = Integer.valueOf(fech[0]);

            jDatePickerCan.getModel().setMonth(mes);
            jDatePickerCan.getModel().setYear(ano);
            jDatePickerCan.getModel().setDay(dia);
            jDatePickerCan.getModel().setSelected(true);
            ComboCompE.getModel().setSelectedItem(Tabla_Can.getValueAt(fila, 5).toString());
            String[] pal = Tabla_Can.getValueAt(fila, 6).toString().split(":");
            txtnDurM.setText(pal[0]); 
            txtnDurS.setText(pal[1]);
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }// TODO add your handling code here:
    }//GEN-LAST:event_Tabla_CanMouseClicked

    private void modCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modCanActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        String id1=idAlb.get(ComboAlbF.getSelectedIndex());
        String id2=ComboCompF.getModel().getSelectedItem().toString();
        String date = jDatePickerCan.getModel().getDay() + "/" +  jDatePickerCan.getModel().getMonth() + "/" + jDatePickerCan.getModel().getYear();
        String duracion= txtnDurM.getText()+ ":" + txtnDurS.getText();
        
        try {
             
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE Cancion SET idAlbum=" + "'" + id1 + "'," + "idCompositor=" + "'" +  id2.charAt(0)+
                "'," + "NombreCancion=" + "'" + txtCan.getText()+ "'," + "FechaLanzamiento=" + "'" + date + "'," + "Explicita=" + "'" + ComboCompE.getModel().getSelectedItem().toString()+
                "'," + "Duracion=" + "'" +  "00:" + duracion +
               "' WHERE idCancion=" + idAux;
             //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
    
            stmt.close();
            c.commit();
            c.close();
            txtCan.setText(null);
            txtnDurM.setText(null);
            txtnDurS.setText(null);
            ComboAlbF.getModel().setSelectedItem(" ");
            ComboCompF.getModel().setSelectedItem(" ");
            ComboCompE.getModel().setSelectedItem(" ");
            jDatePickerCan.getModel().setSelected(false);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarCan();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_modCanActionPerformed

    private void delCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCanActionPerformed
       Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        String id1=idAlb.get(ComboAlbF.getSelectedIndex());
        String id2=ComboCompF.getModel().getSelectedItem().toString();
        String date = jDatePickerCan.getModel().getDay() + "/" +  jDatePickerCan.getModel().getMonth() + "/" + jDatePickerCan.getModel().getYear();
        String duracion= txtnDurM.getText()+ ":" + txtnDurS.getText();
        
        try {
             
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE FROM Cancion  WHERE idCancion=" + idAux;
            //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
    
            stmt.close();
            c.commit();
            c.close();
            txtCan.setText(null);
            txtnDurM.setText(null);
            txtnDurS.setText(null);
            ComboAlbF.getModel().setSelectedItem(" ");
            ComboCompF.getModel().setSelectedItem(" ");
            ComboCompE.getModel().setSelectedItem(" ");
            jDatePickerCan.getModel().setSelected(false);
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarCan();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_delCanActionPerformed

    private void addCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCanActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para insertar
        String id1=idAlb.get(ComboAlbF.getSelectedIndex());
        String id2=ComboCompF.getModel().getSelectedItem().toString();
        String date = jDatePickerCan.getModel().getDay() + "/" +  jDatePickerCan.getModel().getMonth() + "/" + jDatePickerCan.getModel().getYear();
        String duracion= txtnDurM.getText()+ ":" + txtnDurS.getText();
        
        try {
             
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Cancion(idAlbum,idCompositor,NombreCancion,FechaLanzamiento,Explicita,Duracion)" +
                    "VALUES ('" + id1 + "','" + id2.charAt(0) + "','" + txtCan.getText() + "','" + date + "','" + ComboCompE.getModel().getSelectedItem().toString() + "','" + "00:" + duracion + "')";
              //insersion en l base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
    
            stmt.close();
            c.commit();
            c.close();
            txtCan.setText(null);
            txtnDurM.setText(null);
            txtnDurS.setText(null);
            ComboAlbF.getModel().setSelectedItem(" ");
            ComboCompF.getModel().setSelectedItem(" ");
            ComboCompE.getModel().setSelectedItem(" ");
            jDatePickerCan.getModel().setSelected(false);//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarCan();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_addCanActionPerformed

    private void ComboCompFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCompFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCompFActionPerformed

    private void ComboCompEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCompEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCompEActionPerformed
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_PlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PlayMouseClicked
       int fila = Tabla_Play.getSelectedRow();//se obtiene el indice de la tabla

        if (fila >= 0) {
            //se obtienen los datos y se castean o se pasan al control correspondiente
            idAux = Tabla_Play.getValueAt(fila, 0).toString();
            ComboMiembF.getModel().setSelectedItem(Tabla_Play.getValueAt(fila, 1).toString());
            ComboPriv.getModel().setSelectedItem(Tabla_Play.getValueAt(fila, 5).toString());
            txtPlay.setText(Tabla_Play.getValueAt(fila, 2).toString());
            //txtnAlbum.setText(Tabla_Alb.getValueAt(fila, 4).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        } 
    }//GEN-LAST:event_Tabla_PlayMouseClicked

    private void modAlb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modAlb1ActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] id=ComboMiembF.getModel().getSelectedItem().toString().split(",");
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE Playlist SET idMiembro=" + "'" + id[0] + "'," + "NombrePlaylist='" + txtPlay.getText() + "'," + "Privada='" + ComboPriv.getModel().getSelectedItem().toString() +
              "' WHERE idPlaylist=" + idAux;
                  //modificacion en la base y despues un commit para enviar los cambios   
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtPlay.setText(null);
            ComboMiembF.getModel().setSelectedItem(" ");
            ComboPriv.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarPlay();
        llaveForPlay();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_modAlb1ActionPerformed

    private void delAlb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delAlb1ActionPerformed
         Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] id=ComboMiembF.getModel().getSelectedItem().toString().split(",");
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE FROM Playlist  WHERE idPlaylist=" + idAux;
            //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtPlay.setText(null);
            ComboMiembF.getModel().setSelectedItem(" ");
            ComboPriv.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarPlay();
        llaveForPlay();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_delAlb1ActionPerformed

    private void addAlb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlb1ActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para insertar
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] id=ComboMiembF.getModel().getSelectedItem().toString().split(",");
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO Playlist(idMiembro,NombrePlaylist,FechaCreacion,Privada)" +
               "VALUES ('" + id[0] + "','" + txtPlay.getText() + "','" + dtf.format(LocalDateTime.now()) + "','" + ComboPriv.getModel().getSelectedItem().toString() + "')";
              //insersion en l base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
            txtPlay.setText(null);
            ComboMiembF.getModel().setSelectedItem(" ");
            ComboPriv.getModel().setSelectedItem(" ");//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarPlay();
        llaveForPlay();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_addAlb1ActionPerformed

    private void ComboPrivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPrivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPrivActionPerformed
    //funcion que obtiene los datos presionados en la tabla para mostrarlos en los controles
    private void Tabla_DPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_DPlayMouseClicked
         int fila = Tabla_DPlay.getSelectedRow();//se obtiene el indice de la tabla
        if (fila >= 0) {
            //se obtienen los datos y se castean o se pasan al control correspondiente
            idAux = Tabla_DPlay.getValueAt(fila, 0).toString();
            ComboPlayF.getModel().setSelectedItem(Tabla_DPlay.getValueAt(fila, 1).toString());
            ComboCanF.getModel().setSelectedItem(Tabla_DPlay.getValueAt(fila, 2).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }// TODO add your handling code here:
    }//GEN-LAST:event_Tabla_DPlayMouseClicked

    private void modDPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modDPlayActionPerformed
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String id1=idPlay.get(ComboPlayF.getSelectedIndex());
        String id2=idCan.get(ComboCanF.getSelectedIndex());
        
        try {
             
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql =  "UPDATE DetallePlaylist SET idPlaylist = '" + id1 + "' , idCancion = '" + id2 + "' WHERE idDPlaylist=" + idAux;
             //modificacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
    
            stmt.close();
            c.commit();
            c.close();
            ComboCanF.getModel().setSelectedItem(" ");
            ComboPlayF.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarDplay();
        mostrarPlay();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_modDPlayActionPerformed

    private void delDPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delDPlayActionPerformed
         Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para la operacion en la base de datos
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String id1=idPlay.get(ComboPlayF.getSelectedIndex());
        String id2=idCan.get(ComboCanF.getSelectedIndex());
        
        try {
             
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql =  "DELETE FROM DetallePlaylist  WHERE idDPlaylist=" + idAux;
            //Eliminacion en la base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
    
            stmt.close();
            c.commit();
            c.close();
            ComboCanF.getModel().setSelectedItem(" ");
            ComboPlayF.getModel().setSelectedItem(" ");
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarDplay();
        mostrarPlay();//Recargar llaves foraneas y tablas correspondientes
    }//GEN-LAST:event_delDPlayActionPerformed

    private void addDPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDPlayActionPerformed
        //Boton para agregar variables para crear la conexion
        Connection c=null;
        Statement stmt = null;
        //Cast de variables nesesarias para insertar
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String id1=idPlay.get(ComboPlayF.getSelectedIndex());
        String id2=idCan.get(ComboCanF.getSelectedIndex());
        
        try {
             
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql =  "INSERT INTO DetallePlaylist(idPlaylist,idCancion,FechaAgregado)" +
               "VALUES ('" + id1 + "','" + id2 +"','" + dtf.format(LocalDateTime.now())+ "')";
            //insersion en l base y despues un commit para enviar los cambios
            stmt.executeUpdate(sql);
    
            stmt.close();
            c.commit();
            c.close();
            ComboCanF.getModel().setSelectedItem(" ");
            ComboPlayF.getModel().setSelectedItem(" ");//Dejar los controles en blaco un reset
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
        mostrarDplay();//Recargar llaves foraneas y tablas correspondientes
        mostrarPlay();
    }//GEN-LAST:event_addDPlayActionPerformed

    private void ComboCanFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCanFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCanFActionPerformed

    private void ComboPlayFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPlayFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPlayFActionPerformed

    private void Tabla_ConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_ConsultaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla_ConsultaMouseClicked
     //boton asignado para realizar las consultas de los reportes
    private void consultaR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaR1ActionPerformed
         //se crean las variables nesesarias para la conexion a la base
        Connection c=null;
        Statement stmt = null;
         //se crea un modelo para llenar la tabla con los resultados obtenidos por consulta
        String datos[] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        String[] id1=ComboMiembF1.getModel().getSelectedItem().toString().split(",");
        String[] id2=ComboGenF1.getModel().getSelectedItem().toString().split(",");
        modelo.addColumn("Genero");
        modelo.addColumn("Total de canciones");
        Tabla_Consulta.setModel(modelo);
        //Tabla_Cliente.setModel(modelo);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select G.NombreGenero,count(G.idGenero)TotalCanciones from Genero G inner join Album A on G.idGenero=A.idGenero inner join Cancion C on C.idAlbum=A.idAlbum \n" +
                "inner join DetallePlaylist D on C.idCancion=D.idCancion inner join Playlist P on P.idPlaylist=D.idPlaylist where G.idGenero="+ id2[0]+" and P.idmiembro="+ id1[0]+"\n" +
                "GROUP BY G.NombreGenero");
            //se crea la consulta con los datos proporcionados por el usuario
            while(rs.next())
            {
                datos[0] = rs.getString("NombreGenero");
                datos[1] = rs.getString("TotalCanciones");
                modelo.addRow(datos);
                //se muestran los resultados de la consulta
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }//GEN-LAST:event_consultaR1ActionPerformed

    private void ComboMiembF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMiembF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMiembF1ActionPerformed

    private void ComboGenF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboGenF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboGenF1ActionPerformed

    private void Tabla_Consulta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_Consulta2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla_Consulta2MouseClicked
    //boton asignado para realizar las consultas de los reportes
    private void consultaR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaR2ActionPerformed
        //se crean las variables nesesarias para la conexion a la base
        Connection c=null;
        Statement stmt = null;
        String datos[] = new String[4];
        //se crea un modelo para llenar la tabla con los resultados obtenidos por consulta
        DefaultTableModel modelo = new DefaultTableModel();
        String id1=idPlay.get(ComboPlayF1.getSelectedIndex());
        modelo.addColumn("Cancion");
        modelo.addColumn("Duracion");
        modelo.addColumn("Artista");
        Tabla_Consulta2.setModel(modelo);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select  C.NombreCancion,AR.NombreArtista,C.Duracion from (select idCancion from DetallePlaylist where idPlaylist= "+id1+" ) as t inner join Cancion C on C.idCancion=t.idCancion \n" +
            "inner join Album A on C.idAlbum=A.idAlbum inner join Artista AR on AR.idArtista=A.idArtista");
            //se crea la consulta con los datos proporcionados por el usuario
            while(rs.next())
            {
                datos[0] = rs.getString("NombreCancion");
                datos[1] = rs.getString("Duracion");
                datos[2] = rs.getString("NombreArtista");
                modelo.addRow(datos);
                //se muestran los resultados de la consulta
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }//GEN-LAST:event_consultaR2ActionPerformed

    private void ComboPlayF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPlayF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPlayF1ActionPerformed
    
    
    //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
     void mostrarMiemb()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[7];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idMiembro");
        modelo.addColumn("NombreMiembro");
        modelo.addColumn("Edad");
        modelo.addColumn("Email");
        modelo.addColumn("FechaNacimiento");
        modelo.addColumn("MiembroDesde");
        modelo.addColumn("TiempoMiembro");
        Tabla_Miemb.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Miembro");//consulta y llenando de datos en la tabla 
            while(rs.next())
            {
                datos[0] = rs.getString("idMiembro");
                datos[1] = rs.getString("NombreMiembro");
                datos[2] = rs.getString("Edad");
                datos[3] = rs.getString("Email");
                datos[4] = rs.getString("FechaNacimiento");
                datos[5] = rs.getString("MiembroDesde");
                datos[6] = rs.getString("TiempoMiembro");
                modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
     //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
      void mostrarDisque()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[5];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idDisquera");
        modelo.addColumn("NombreDisquera");
        modelo.addColumn("PaginaWeb");
        modelo.addColumn("FechaFundación");
        modelo.addColumn("NumeroArtistas");
        Tabla_Disque.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Disquera");//consulta y llenando de datos en la tabla 
            while(rs.next())
            {
                datos[0] = rs.getString("idDisquera");
                datos[1] = rs.getString("NombreDisquera");
                datos[2] = rs.getString("PaginaWeb");
                datos[3] = rs.getString("FechaFundacion");
                datos[4] = rs.getString("NumeroArtistas");
                modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
      //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
      void mostrardetplay()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[5];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idDisquera");
        modelo.addColumn("NombreDisquera");
        modelo.addColumn("PaginaWeb");
        modelo.addColumn("FechaFundación");
        modelo.addColumn("NumeroArtistas");
        Tabla_Disque.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Disquera");//consulta y llenando de datos en la tabla 
            while(rs.next())
            {
                datos[0] = rs.getString("idDisquera");
                datos[1] = rs.getString("NombreDisquera");
                datos[2] = rs.getString("PaginaWeb");
                datos[3] = rs.getString("FechaFundacion");
                datos[4] = rs.getString("NumeroArtistas");
                modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
      //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
      void mostrarArt()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[3];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idArtista");
        modelo.addColumn("NombreArtista");
        modelo.addColumn("Disquera");
        Tabla_Art.setModel(modelo); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            int cont=1;
            ResultSet rs = stmt.executeQuery("SELECT * FROM Artista");//consulta y llenando de datos en la tabla 
            
            while(rs.next())
            {
                datos[0] = rs.getString("idArtista");
                datos[1] = rs.getString("NombreArtista");
               
                for (int i = 1; i < ComboDisqF.getItemCount(); i++) {
                     String[] d2 = ComboDisqF.getItemAt(i).toString().split(",");
                     if(d2[0].contentEquals(rs.getString("idDisquera")))
                        datos[2]=ComboDisqF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                modelo.addRow(datos);
                cont++;
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
      //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
      void mostrarAlb()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[6];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idAlbum");
        modelo.addColumn("idGenero");
        modelo.addColumn("idArtista");
        modelo.addColumn("NombreAlbum");
        modelo.addColumn("CantidadCanciones");
        modelo.addColumn("TipoAlbum");
        Tabla_Alb.setModel(modelo); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            int cont=1;
            ResultSet rs = stmt.executeQuery("SELECT * FROM Album");//consulta y llenando de datos en la tabla 
            //ResultSet rs2 = stmt.executeQuery("SELECT * FROM Disquera");
            while(rs.next())
            {
                datos[0] = rs.getString("idAlbum");
                datos[3] = rs.getString("NombreAlbum");
                datos[4] = rs.getString("CantidadCanciones");
                datos[5] = rs.getString("TipoAlbum");
                for (int i = 1; i < ComboGenF.getItemCount(); i++) {
                    String[] d2 = ComboGenF.getItemAt(i).split(",");
                    if(d2[0].contentEquals(rs.getString("idGenero")))
                        datos[1]=ComboGenF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                for (int i = 1; i < ComboArtF.getItemCount(); i++) {
                    String[] d2 = ComboArtF.getItemAt(i).split(",");
                    if(d2[0].contentEquals(rs.getString("idArtista")))
                        datos[2]=ComboArtF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                modelo.addRow(datos);
                cont++;
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
      //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
      void mostrarCan()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[7];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idCanción");
        modelo.addColumn("idAlbum");
        modelo.addColumn("idCompositor");
        modelo.addColumn("NombreCancion");
        modelo.addColumn("FechaLanzamiento");
        modelo.addColumn("Explicita");
        modelo.addColumn("Duracion");
        
        Tabla_Can.setModel(modelo); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            int cont=1;
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cancion");//consulta y llenando de datos en la tabla 
            
            while(rs.next())
            {
                datos[0] = rs.getString("idCancion");
                datos[3] = rs.getString("NombreCancion");
                datos[4] = rs.getString("FechaLanzamiento");
                datos[5] = rs.getString("Explicita");
                datos[6] = rs.getString("Duracion");
                for (int i = 1; i < ComboAlbF.getItemCount(); i++) {
                    String[] d2 = idAlb.get(i).split(",");
                    if(d2[0].contentEquals(rs.getString("idAlbum")))
                        datos[1]=ComboAlbF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                for (int i = 1; i < ComboCompF.getItemCount(); i++) {
                     String[] d2 = ComboCompF.getItemAt(i).split(",");
                    if(d2[0].contentEquals(rs.getString("idCompositor")))
                        datos[2]=ComboCompF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                modelo.addRow(datos);
                cont++;
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla  
    void mostrarDplay()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[3];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idDetallePlaylist");
        modelo.addColumn("Playlist");
        modelo.addColumn("Cancion");
        
        Tabla_DPlay.setModel(modelo); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            int cont=1;
            ResultSet rs = stmt.executeQuery("SELECT * FROM DetallePlaylist");//consulta y llenando de datos en la tabla 
            while(rs.next())
            {
                datos[0] = rs.getString("idDPlaylist");
                for (int i = 1; i < ComboPlayF.getItemCount(); i++) {
                    String[] d2 = idPlay.get(i).split(",");
                    if(d2[0].contentEquals(rs.getString("idPlaylist")))
                        datos[1]=ComboPlayF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                for (int i = 1; i < ComboCanF.getItemCount(); i++) {
                    String[] d2 = idCan.get(i).split(",");
                    if(d2[0].contentEquals(rs.getString("idCancion")))
                        datos[2]=ComboCanF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                modelo.addRow(datos);
                cont++;
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla  
    void mostrarGen()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[5];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idGenero");
        modelo.addColumn("NombreGénero");
        Tabla_Gen.setModel(modelo); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Genero");//consulta y llenando de datos en la tabla 
            while(rs.next())
            {
                datos[0] = rs.getString("idGenero");
                datos[1] = rs.getString("NombreGenero");
                modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
    void mostrarComp()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[4];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idCompositor");
        modelo.addColumn("NombreCompositor");
        modelo.addColumn("NumeroCanciones");
        modelo.addColumn("PaisOrigen");
        Tabla_Comp.setModel(modelo); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Compositor");//consulta y llenando de datos en la tabla 
            while(rs.next())
            {
                datos[0] = rs.getString("idCompositor");
                datos[1] = rs.getString("NombreCompositor");
                datos[2] = rs.getString("NumeroCanciones");
                datos[3] = rs.getString("PaisOrigen");
                modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
    //funcion que hace una consulta a la base de datos y lo muestra su respectiva tabla
     void mostrarPlay()
    {
        //variables nesesarias para la conexion con la base de datos
        Connection c=null;
        Statement stmt = null;
        //Creacion de un modelo de tabla de base de datos y donde se agregan las columnas a este
        String datos[] = new String[6];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idPlaylist");
        modelo.addColumn("Miembro");
        modelo.addColumn("NombrePlaylist");
        modelo.addColumn("DuracionTotal");
        modelo.addColumn("FechaCreacion");
        modelo.addColumn("Visibilidad");
        Tabla_Play.setModel(modelo); 
        //Tabla_Cliente.setModel(modelo); 
       try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemamusica","postgres","postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Playlist");//consulta y llenando de datos en la tabla 
            while(rs.next())
            {
                datos[0] = rs.getString("idPlaylist");
                for (int i = 1; i < ComboMiembF.getItemCount(); i++) {
                    String[] d2 = ComboMiembF.getItemAt(i).split(",");
                    if(d2[0].contentEquals(rs.getString("idMiembro")))
                        datos[1]=ComboMiembF.getItemAt(i);
                }//obtener los datos desde el combobox con su id para su presentacion en la tabla de la manera requerida 
                datos[2] = rs.getString("NombrePlaylist");
                datos[3] = rs.getString("DuracionTotal");
                datos[4] = rs.getString("FechaCreacion");
                datos[5] = rs.getString("Privada");
                modelo.addRow(datos);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos"+e.toString());
        }
    }
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
            java.util.logging.Logger.getLogger(frmRegform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAlbF;
    private javax.swing.JComboBox<String> ComboArtF;
    private javax.swing.JComboBox<String> ComboCanF;
    private javax.swing.JComboBox<String> ComboComp;
    private javax.swing.JComboBox<String> ComboCompE;
    private javax.swing.JComboBox<String> ComboCompF;
    private javax.swing.JComboBox<String> ComboDisqF;
    private javax.swing.JComboBox<String> ComboGenF;
    private javax.swing.JComboBox<String> ComboGenF1;
    private javax.swing.JComboBox<String> ComboMiembF;
    private javax.swing.JComboBox<String> ComboMiembF1;
    private javax.swing.JComboBox<String> ComboPlayF;
    private javax.swing.JComboBox<String> ComboPlayF1;
    private javax.swing.JComboBox<String> ComboPriv;
    private javax.swing.JTable Tabla_Alb;
    private javax.swing.JTable Tabla_Art;
    private javax.swing.JTable Tabla_Can;
    private javax.swing.JTable Tabla_Comp;
    private javax.swing.JTable Tabla_Consulta;
    private javax.swing.JTable Tabla_Consulta2;
    private javax.swing.JTable Tabla_DPlay;
    private javax.swing.JTable Tabla_Disque;
    private javax.swing.JTable Tabla_Gen;
    private javax.swing.JTable Tabla_Miemb;
    private javax.swing.JTable Tabla_Play;
    private javax.swing.JButton addAlb;
    private javax.swing.JButton addAlb1;
    private javax.swing.JButton addArt;
    private javax.swing.JButton addCan;
    private javax.swing.JButton addComp;
    private javax.swing.JButton addDPlay;
    private javax.swing.JButton addDisque;
    private javax.swing.JButton addMiemb;
    private javax.swing.JButton consultaR1;
    private javax.swing.JButton consultaR2;
    private javax.swing.JButton delAlb;
    private javax.swing.JButton delAlb1;
    private javax.swing.JButton delArt;
    private javax.swing.JButton delCan;
    private javax.swing.JButton delComp;
    private javax.swing.JButton delDPlay;
    private javax.swing.JButton delDisque;
    private javax.swing.JButton delMiemb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private org.jdatepicker.JDatePicker jDatePickerCan;
    private org.jdatepicker.JDatePicker jDatePickerDisque;
    private org.jdatepicker.JDatePicker jDatePickerMiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField jtextGenero;
    private javax.swing.JButton modAlb;
    private javax.swing.JButton modAlb1;
    private javax.swing.JButton modArt;
    private javax.swing.JButton modCan;
    private javax.swing.JButton modComp;
    private javax.swing.JButton modDPlay;
    private javax.swing.JButton modDisque;
    private javax.swing.JButton modMiemb;
    private javax.swing.JTextField txtAlbum;
    private javax.swing.JTextField txtArt;
    private javax.swing.JTextField txtCan;
    private javax.swing.JTextField txtComp;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMiembro;
    private javax.swing.JTextField txtPagWeb;
    private javax.swing.JTextField txtPlay;
    private javax.swing.JTextField txtdisquera;
    private javax.swing.JTextField txtnAlbum;
    private javax.swing.JTextField txtnDurM;
    private javax.swing.JTextField txtnDurS;
    // End of variables declaration//GEN-END:variables
}
