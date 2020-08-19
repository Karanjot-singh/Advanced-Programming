package Swingh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSwing {
    public static void main(String args[]){
        SwingTest obj = new SwingTest();

    }
}

class SwingTest extends JFrame implements ActionListener{
    JLabel label,label2;
    JTextField text1,text2,text3;
    JButton button1, button2;
    JRadioButton rbtn1 , rbtn2;
    JCheckBox cbox1;

    SwingTest(){
        label= new JLabel("First number ");
        label2= new JLabel();
        label2.setText("Second number");

        text1 = new JTextField(20);
        text2 = new JTextField(20);
        text3 = new JTextField(20);

        button1 = new JButton("ADD");
        button2 = new JButton("MUL");

//        button1.addActionListener(this);
//        button2.addActionListener(this);

        rbtn1 = new JRadioButton("Yes");
        rbtn2 = new JRadioButton("NO");

        //to add single select constraint
        ButtonGroup buttonGroup= new ButtonGroup();
        buttonGroup.add(rbtn1);
        buttonGroup.add(rbtn2);

        rbtn1.addActionListener(this);
        rbtn2.addActionListener(this);

        cbox1 = new JCheckBox();
        cbox1.addActionListener();

        //Action listener anonymousclass
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                int a = Integer.parseInt(text1.getText());
//                int b = Integer.parseInt(text2.getText());
//
//                text3.setText((a+b) +"");
//
//
//            }
//        });

//        add(label);
//        add(text1);
//        add(label2);
//        add(text2);
//        add(button1);
//        add(button2);
//        add(text3);
        add(rbtn1);
        add(rbtn2);



        setTitle("demo");

        // change layout for stack
        //flow grid
//        Default layout is card layout
        FlowLayout f = new FlowLayout();
        setLayout(f);

        // IMPT for
        setSize(380,400);
        setVisible (true);
        //to stop the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

//        int a = Integer.parseInt(text1.getText());
//        int b = Integer.parseInt(text2.getText());
//        if(actionEvent.getSource()==button1)
//            text3.setText((a+b) +"");
//        if(actionEvent.getSource()==button2)
//            text3.setText((a*b) +"");

        if(rbtn1.isSelected()){
            JOptionPane.showMessageDialog(this,rbtn1.getText());
        }
        else{
            JOptionPane.showMessageDialog(this,rbtn2.getText());
        }
    }
}