package GUI;

import DataBase.AppointmentOperations;
import Model.Appointment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Roland on 01/03/2015.
 */
public class AppointmentGUI extends JFrame implements ActionListener {
    String[] list1 = {"med1 :", "med2        ", "med3        "};
    String[] list2 = {"cons1 :", "cons2       ", "cons3       "};
    JButton confirm;
    JButton cancel;
    private  Object selectedItem;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    JTextField field1;
    JTextField field2;
    JTextField field3;
    JTextField field4;
    JTextField field5;
    JTextField field6;
    JFrame f;

    JComboBox<String> combo1;
    JComboBox<String> combo2;

    public AppointmentGUI() {

        f = new JFrame();
        f.setTitle("Appointment");
        f.setLayout(new GridLayout(5,1, 1,1));

        f.setSize(600, 600);
        f.setResizable(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border loweredBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        JPanel clock= new JPanel(new FlowLayout(FlowLayout.LEFT));
        f.add(clock,BorderLayout.EAST);


        //Patient Phone label
        label5 = new JLabel("CLOCK");
        clock.add(label5);
        //GO Location label
        label6 = new JLabel("Appointment Number");
        clock.add(label6);
        //text field
        field3 = new JTextField(5);
        clock.add(field3);

        JPanel offTop= new JPanel(new FlowLayout(FlowLayout.CENTER));
        f.add(offTop,BorderLayout.NORTH);
        //Reason for Visit label
        label7 = new JLabel("Appointment");
        offTop.add(label7);
        label7.setFont(new Font("Arial",Font.BOLD, 38));



        JPanel middle=new JPanel();
        f.add(middle, BorderLayout.CENTER);
        middle.setLayout(new GridBagLayout());


        label2 = new JLabel("Reason for Visit");
        middle.add(label2, getConstraints(0, 2, 1, 1, GridBagConstraints.LINE_END));

        field2 = new JTextField(30);
        middle.add(field2, getConstraints(2, 2, 1, 1, GridBagConstraints.LINE_START));


        label3 = new JLabel("Medical Equipment Required");
        middle.add(label3, getConstraints(0, 3, 1, 1, GridBagConstraints.LINE_END));

        combo1 = new JComboBox<String>(list1);
        middle.add(combo1, getConstraints(2, 3, 1, 1, GridBagConstraints.LINE_START));
        combo1.addActionListener(this);


        label4 = new JLabel("Consultant Type Required");
        middle.add(label4, getConstraints(0, 5, 1, 1, GridBagConstraints.LINE_END));


        combo2 = new JComboBox<String>(list2);
        middle.add(combo2, getConstraints(2, 5, 1, 1, GridBagConstraints.LINE_START));
        combo2.addActionListener(this);

        JPanel dob = new JPanel();
        label5 = new JLabel("Patient Date Of Birth");
        dob.add(label5, getConstraints(2, 6, 1, 1, GridBagConstraints.LINE_START));


        f.add(dob, BorderLayout.CENTER);
        dob.setLayout(new GridBagLayout());
        label6 = new JLabel("Day:");
        dob.add(label6, getConstraints(0, 7, 1, 1, GridBagConstraints.LINE_END));
        label7 = new JLabel("Month:");
        dob.add(label7, getConstraints(2, 7, 1, 1, GridBagConstraints.LINE_END));
        label8 = new JLabel("Year:");
        dob.add(label8, getConstraints(4, 7, 1, 1, GridBagConstraints.LINE_END));


        field3 = new JTextField(5);
        dob.add(field3, getConstraints(1, 7, 1, 1, GridBagConstraints.LINE_START));
        field4 = new JTextField(5);
        dob.add(field4, getConstraints(3, 7, 1, 1, GridBagConstraints.LINE_START));
        field5 = new JTextField(5);
        dob.add(field5, getConstraints(5, 7, 1, 1, GridBagConstraints.LINE_START));


        JPanel bottom=new JPanel(new FlowLayout(FlowLayout.CENTER));
        f.add(bottom, BorderLayout.NORTH);
        // Confirm button
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        bottom.add(confirm);


        // Cancel button
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        bottom.add(cancel);

        f.setVisible(true);
    }

    public Object getCombo1Item() {
        return combo1;
    }

    public Object getElementAt(int i) {
        return list1[i];
    }

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = anchor;
        return c;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cancel)) {
            System.exit(0);

        } else if (e.getSource().equals(confirm)) {
                String medEquip;
                Appointment app =new Appointment(field2.getText(),1,1);




//            AppointmentOperations ao = new AppointmentOperations();
//            ao.addAppointment(new Appointment(Integer.valueOf(label5.getText()),label2.getText(),Integer.valueOf(label4.getText()),Integer.valueOf(label3.getText()),String.valueOf(dateFormat.format(date))));

        }
    }
}
