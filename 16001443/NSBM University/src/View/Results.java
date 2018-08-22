/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CourseWorkController;
import Controller.MarksController;
import Controller.RegistrationController;
import Controller.SubjSemRegistrationController;
import Controller.SubjectController;
import DTO.CourseWorkDTO;
import DTO.MarksDTO;
import DTO.StudentDTO;
import DTO.SubjSemRegistrationDTO;
import DTO.SubjectDTO;
import db.DBConnection;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import utilities.CustomizeTable;
import utilities.CustomizeTableHeader;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




/**
 *
 * @author dimut
 */
public class Results extends javax.swing.JPanel {

    private static Results results;
    private DefaultTableModel mdlMarks;
    private int courseWorkTypeLoad;
    private int courseWorkLoad;
    private int subjectCodesLoadCount;
   
    /**
     * Creates new form Results
     */
    private Results() {
        initComponents();
        setSize(2270, 1140);
        mdlMarks = (DefaultTableModel) tblCourseWork.getModel();
        tblCourseWork.removeColumn(tblCourseWork.getColumnModel().getColumn(4));
        AutoCompleteDecorator.decorate(cmbCourseWork);
        AutoCompleteDecorator.decorate(cmbCourseWorkType);
        AutoCompleteDecorator.decorate(cmbSubCode);
        customizeSubjectsTable();
    }

    public static Results getInstance() {
        if (results == null) {
            results = new Results();
        }
        return results;
    }

    public void setInitialStage() {
        loadCourseWorkTypes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtSemRegId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMarks = new javax.swing.JTextField();
        pneCourseWork = new javax.swing.JScrollPane();
        tblCourseWork = new javax.swing.JTable();
        cmbCourseWork = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        cmbCourseWorkType = new javax.swing.JComboBox<String>();
        btnSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbSubCode = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        lblSubjectName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtstudentname = new javax.swing.JLabel();
        txtMarks1 = new javax.swing.JTextField();
        txtaverage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnmail = new javax.swing.JButton();
        btnaverage = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(2206, 1035));
        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel4.setText("COURSE WORK TYPE");
        add(jLabel4);
        jLabel4.setBounds(960, 50, 290, 40);

        txtSemRegId.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtSemRegId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSemRegIdKeyReleased(evt);
            }
        });
        add(txtSemRegId);
        txtSemRegId.setBounds(440, 70, 390, 40);

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel5.setText("SEMESTER REGISTRATION ID");
        add(jLabel5);
        jLabel5.setBounds(40, 70, 380, 40);

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel6.setText("COURSE WORK");
        add(jLabel6);
        jLabel6.setBounds(960, 170, 200, 40);

        txtMarks.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(txtMarks);
        txtMarks.setBounds(440, 190, 390, 40);

        tblCourseWork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Code", "Subject", "Course Work", "Marks", "Mark Id"
            }
        ));
        tblCourseWork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCourseWorkMouseClicked(evt);
            }
        });
        pneCourseWork.setViewportView(tblCourseWork);

        add(pneCourseWork);
        pneCourseWork.setBounds(20, 650, 2220, 360);

        cmbCourseWork.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(cmbCourseWork);
        cmbCourseWork.setBounds(1310, 170, 350, 40);

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel7.setText("MARKS");
        add(jLabel7);
        jLabel7.setBounds(40, 200, 200, 40);

        cmbCourseWorkType.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmbCourseWorkType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCourseWorkTypeItemStateChanged(evt);
            }
        });
        add(cmbCourseWorkType);
        cmbCourseWorkType.setBounds(1310, 50, 350, 40);

        btnSave.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(1370, 570, 222, 49);

        jButton2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(1650, 570, 222, 49);

        btnDelete.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete);
        btnDelete.setBounds(1930, 570, 222, 49);

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel10.setText("SUBJECT CODE");
        add(jLabel10);
        jLabel10.setBounds(40, 330, 207, 40);

        cmbSubCode.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmbSubCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSubCodeItemStateChanged(evt);
            }
        });
        add(cmbSubCode);
        cmbSubCode.setBounds(440, 320, 320, 40);

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel8.setText("AVERAGE MARKS");
        add(jLabel8);
        jLabel8.setBounds(800, 1060, 230, 40);

        lblSubjectName.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        add(lblSubjectName);
        lblSubjectName.setBounds(1310, 300, 390, 40);

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel9.setText("STUDENT NAME");
        add(jLabel9);
        jLabel9.setBounds(40, 440, 207, 40);

        txtstudentname.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        add(txtstudentname);
        txtstudentname.setBounds(440, 440, 440, 40);

        txtMarks1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(txtMarks1);
        txtMarks1.setBounds(440, 190, 390, 40);

        txtaverage.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        txtaverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaverageActionPerformed(evt);
            }
        });
        add(txtaverage);
        txtaverage.setBounds(1070, 1060, 290, 40);

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel11.setText("SUBJECT NAME");
        add(jLabel11);
        jLabel11.setBounds(960, 300, 207, 40);

        btnmail.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        btnmail.setText("SEND MAIL");
        btnmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmailActionPerformed(evt);
            }
        });
        add(btnmail);
        btnmail.setBounds(1830, 1050, 280, 50);

        btnaverage.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        btnaverage.setText("AVERAGE");
        btnaverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaverageActionPerformed(evt);
            }
        });
        add(btnaverage);
        btnaverage.setBounds(1500, 1050, 280, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            MarksDTO marksDTO = new MarksDTO();
            SubjSemRegistrationDTO subjSemRegistrationDTO = new SubjSemRegistrationDTO();
            subjSemRegistrationDTO.setSemesterRegistrationId(txtSemRegId.getText());
            subjSemRegistrationDTO.setSubjectId(cmbSubCode.getSelectedItem().toString());
            marksDTO.setSubjSemRegistrationId(SubjSemRegistrationController.getSubjectSemesterRegistrationId(subjSemRegistrationDTO).getSubjSemRegistrationId());
            marksDTO.setCourseWorkId(CourseWorkController.getCourseWorkId(cmbCourseWork.getSelectedItem().toString()).getCourseWorkId());
            marksDTO.setMarks(Integer.parseInt(txtMarks.getText()));
            boolean addMarks = MarksController.addMarks(marksDTO);
            if (addMarks) {
                loadTable();
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbCourseWorkTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCourseWorkTypeItemStateChanged
        if (courseWorkTypeLoad > 0) {
            loadCourseWork();
            loadTable();
        }
    }//GEN-LAST:event_cmbCourseWorkTypeItemStateChanged

    private void txtSemRegIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSemRegIdKeyReleased
        txtSemRegId.setText(txtSemRegId.getText().toUpperCase());
        setStudentName();
        filterSubjectCodes();
        loadTable();
    }//GEN-LAST:event_txtSemRegIdKeyReleased

    private void cmbSubCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSubCodeItemStateChanged
        if (subjectCodesLoadCount > 0) {
            setSubjectName();
            loadCourseWork();
        }
    }//GEN-LAST:event_cmbSubCodeItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblCourseWork.getSelectedRow() > -1) {
            try {
                boolean deleteMarks = MarksController.deleteMarks(Integer.parseInt(tblCourseWork.getModel().getValueAt(tblCourseWork.getSelectedRow(), 4).toString()));
                if (deleteMarks) {
                    loadTable();
                }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            } catch (Exception ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (tblCourseWork.getSelectedRow() > -1) {
                MarksDTO marksDTO = new MarksDTO();
                SubjSemRegistrationDTO subjSemRegistrationDTO = new SubjSemRegistrationDTO();
                subjSemRegistrationDTO.setSemesterRegistrationId(txtSemRegId.getText());
                subjSemRegistrationDTO.setSubjectId(cmbSubCode.getSelectedItem().toString());
                marksDTO.setSubjSemRegistrationId(SubjSemRegistrationController.getSubjectSemesterRegistrationId(subjSemRegistrationDTO).getSubjSemRegistrationId());
                marksDTO.setCourseWorkId(CourseWorkController.getCourseWorkId(cmbCourseWork.getSelectedItem().toString()).getCourseWorkId());
                marksDTO.setMarks(Integer.parseInt(txtMarks.getText()));
                marksDTO.setMarkid(Integer.parseInt(tblCourseWork.getModel().getValueAt(tblCourseWork.getSelectedRow(), 4).toString()));
                boolean updateMarks = MarksController.updateMarks(marksDTO);
                if (updateMarks) {
                    loadTable();
                }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            }
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblCourseWorkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCourseWorkMouseClicked
        if (tblCourseWork.getSelectedRow() > -1) {
            txtMarks.setText(tblCourseWork.getValueAt(tblCourseWork.getSelectedRow(), 3).toString());
            cmbSubCode.setSelectedItem(tblCourseWork.getValueAt(tblCourseWork.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tblCourseWorkMouseClicked

    private void txtaverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaverageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaverageActionPerformed

    private void btnmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmailActionPerformed
        try {
            Connection connection=DBConnection.getDBConnection().getConnection();
            final String username="plpdesilva@gmail.com";
            final String password="123";
            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");

            props.put("mail.smtp.socketFactory.port", "465");

            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            props.put("mail.smtp.auth", "true");

            props.put("mail.smtp.port", "465");
           Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {

                            @Override
	                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

	                        return new javax.mail.PasswordAuthentication(username,password);
	                    }

	                });

           String name=txtstudentname.getText();
           String subname=lblSubjectName.getText();
           String marks=txtMarks.getText();
           String[] str=txtstudentname.getText().split(" ");
           String firstname=str[0];
           String sql="select email from student where firstName=?";
           
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setObject(1, firstname);
                ResultSet rst = preparedStatement.executeQuery();
               
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("plpdesilva@gmail.com"));
                    if (rst.next()) {
                        message.setRecipients(javax.mail.Message.RecipientType.TO,
                        InternetAddress.parse(rst.getString(1)));
                    }else{
                        JOptionPane.showMessageDialog(this, "cannot find email address");
                    }
                    message.setSubject("Subject Results");
                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                   
                messageBodyPart1.setText("\n\nYour exam results of subject- "+subname);
                MimeMultipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart1);
                MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                messageBodyPart2.setText("\n\n "+marks);
                multipart.addBodyPart(messageBodyPart2);
                message.setContent(multipart);
                Transport.send(message);
                //this.dispose();
                JOptionPane.showMessageDialog(null, "Email Sent!!!");
                System.out.println("Done");





            }catch (SQLException ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            


            }
	    




        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (AddressException ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnmailActionPerformed

    private void btnaverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaverageActionPerformed
        calculateTotal();
    }//GEN-LAST:event_btnaverageActionPerformed

    /*Load data to table with course work type id and semester registration id*/
    private void loadTable() {
        if (txtstudentname.getText() != null) {
            try {
                CourseWorkDTO courseWorkDTO = new CourseWorkDTO();
                courseWorkDTO.setCourseWorkTypeId(CourseWorkController.getCourseWorkTypeId(cmbCourseWorkType.getSelectedItem().toString()).getCourseWorkTypeId());
                courseWorkDTO.setSemesterRegistrationId(txtSemRegId.getText());
                ArrayList<MarksDTO> allMarksViaSemRegIdAndCourseId = MarksController.getAllMarksViaSemRegIdAndCourseId(courseWorkDTO);
                mdlMarks.setRowCount(0);
                for (MarksDTO marksDTO : allMarksViaSemRegIdAndCourseId) {
                    Object[] ob = {marksDTO.getSubjectCode(), marksDTO.getSubjectName(), marksDTO.getCourseWorkName(), marksDTO.getMarks(), marksDTO.getMarkid()};
                    mdlMarks.addRow(ob);
                }
            } catch (Exception ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*Set student name using registration id*/
    private void setStudentName() {
        try {
            StudentDTO studentNameViaRegId = RegistrationController.getStudentNameViaSemRegId(txtSemRegId.getText());
            txtstudentname.setText(null);
            if (studentNameViaRegId.getFirstName() != null && studentNameViaRegId.getLastName() != null) {
                txtstudentname.setText(studentNameViaRegId.getFirstName() + " " + studentNameViaRegId.getLastName());
            }
        } catch (Exception ex) {
            Logger.getLogger(SemesterRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Set subject name according to subject code while changing subject code in combo box*/
    private void setSubjectName() {
        try {
            String subjectName = "";
            if (cmbSubCode.getSelectedItem() != null) {
                subjectName = SubjectController.getRelaventSubjectNameViaCode(cmbSubCode.getSelectedItem().toString()).getSubjectName();
            } else {
                subjectName = "";
            }
            lblSubjectName.setText(subjectName);
        } catch (Exception ex) {
            Logger.getLogger(SemesterRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Load codes via semester registration id*/
    private void filterSubjectCodes() {
        try {
            if (txtstudentname.getText() != null) {
                subjectCodesLoadCount = 0;
                ArrayList<SubjectDTO> subjectCodesViaSemRegId = SubjSemRegistrationController.getSubjectCodesViaSemRegId(txtSemRegId.getText());
                cmbSubCode.removeAllItems();
                for (SubjectDTO subjectDTO : subjectCodesViaSemRegId) {
                    cmbSubCode.addItem(subjectDTO.getSubjectId());
                }
                subjectCodesLoadCount++;
                setSubjectName();
                loadCourseWork();
            }
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Load course work to combo box*/
    private void loadCourseWork() {
        try {
            courseWorkLoad = 0;
            CourseWorkDTO courseWorkDTO = new CourseWorkDTO();
            courseWorkDTO.setCourseWorkTypeId(CourseWorkController.getCourseWorkTypeId(cmbCourseWorkType.getSelectedItem().toString()).getCourseWorkTypeId());
            courseWorkDTO.setSubjectId(cmbSubCode.getSelectedItem().toString());
            ArrayList<CourseWorkDTO> allCourseWorks = CourseWorkController.getAllCourseWorksViaSubject(courseWorkDTO);
            cmbCourseWork.removeAllItems();
            for (CourseWorkDTO courseWork : allCourseWorks) {
                cmbCourseWork.addItem(courseWork.getCourseWorkName());
            }
            courseWorkLoad++;
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Load course work types to combo box*/
    private void loadCourseWorkTypes() {
        try {
            courseWorkTypeLoad = 0;
            ArrayList<CourseWorkDTO> allCourseWorksTypes = CourseWorkController.getAllCourseWorksTypes();
            cmbCourseWorkType.removeAllItems();
            for (CourseWorkDTO courseWorksType : allCourseWorksTypes) {
                cmbCourseWorkType.addItem(courseWorksType.getCourseWorkType());
            }
            courseWorkTypeLoad++;
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Customize Table*/
    private void customizeSubjectsTable() {
        tblCourseWork.setDefaultRenderer(Object.class, new CustomizeTable());
        tblCourseWork.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblCourseWork.setRowHeight(30);
        tblCourseWork.setShowGrid(true);
        tblCourseWork.setFont(new Font("", 0, 18));
        pneCourseWork.getViewport().setBackground(Color.WHITE);
    }
    private void calculateTotal(){
        int total=0;
        double average=0;
        int noOfRows=tblCourseWork.getRowCount();
        for(int i=0;i<tblCourseWork.getRowCount();i++){
            total =total+ Integer.parseInt(tblCourseWork.getValueAt(i, 3).toString());
        }
        average=total/noOfRows;
        txtaverage.setText(average+ "");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnaverage;
    private javax.swing.JButton btnmail;
    private javax.swing.JComboBox<String> cmbCourseWork;
    private javax.swing.JComboBox<String> cmbCourseWorkType;
    private javax.swing.JComboBox<String> cmbSubCode;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblSubjectName;
    private javax.swing.JScrollPane pneCourseWork;
    private javax.swing.JTable tblCourseWork;
    private javax.swing.JTextField txtMarks;
    private javax.swing.JTextField txtMarks1;
    private javax.swing.JTextField txtSemRegId;
    private javax.swing.JTextField txtaverage;
    private javax.swing.JLabel txtstudentname;
    // End of variables declaration//GEN-END:variables
}