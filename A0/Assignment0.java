package A0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
class Patient {

    String name, tower;
    Date startDate, endDate;
    int age;

    Patient(String name, String tower,Date startDate, Date endDate, int age){
        this.name=name;
        this.tower=tower;
        this.startDate=startDate;
        this.endDate=endDate;
        this.age=age;
    }
}
public class Assignment0 {
    public static void main(String args[]){
        Date dateStart, dateEnd;
        Patient p1;

        dateStart = new Date(2020,4,1);
        dateEnd = new Date(2020,4,22);
        p1 = new Patient("Flora","A",dateStart,dateEnd,6);

        dateStart = new Date(2020,4,1);
        dateEnd = new Date(2020,4,22);
        p1 = new Patient("Denys","B",dateStart,dateEnd,24);

        dateStart = new Date(2020,5,18);
        dateEnd = new Date(2020, 6,9);
        p1 = new Patient("Jim","C",dateStart,dateEnd,42);

        dateStart = new Date(2020,6,23);
        dateEnd = new Date(2020,7,15);
        p1 = new Patient("Hazel","D",dateStart,dateEnd,87);

        dateStart = new Date(2020,6,1);
        dateEnd = new Date(2020,6,23);
        p1 = new Patient("Caery","A",dateStart,dateEnd,72);

        dateStart = new Date(2020,6,14);
        dateEnd = new Date(2020,7,6);
        p1 = new Patient("David","B",dateStart,dateEnd,7);

        dateStart = new Date(2020,6,5);
        dateEnd = new Date(2020,6,27);
        p1 = new Patient("Kevim","D",dateStart,dateEnd,37);

        dateStart = new Date(2020,6,20);
        dateEnd = new Date(2020,7,12);
        p1 = new Patient("Tom","D",dateStart,dateEnd,67);

        dateStart = new Date(2020,7,4);
        dateEnd = new Date(2020,7,26);
        p1 = new Patient("Bob","A",dateStart,dateEnd,74);

        dateStart = new Date(2020,7,24);
        dateEnd = new Date(2020,8,15);
        p1 = new Patient("Rachel","C",dateStart,dateEnd,48);

        dateStart = new Date(2020,6,11);
        dateEnd = new Date(2020,7,2);
        p1 = new Patient("Thomas","C",dateStart,dateEnd,21);

        dateStart = new Date(2020,6,21);
        dateEnd = new Date(2020,7,13);
        p1 = new Patient("Mary","D",dateStart,dateEnd,17);

        dateStart = new Date(2020,8,7);
        dateEnd = new Date(2020,8,29);
        p1 = new Patient("Smith","A",dateStart,dateEnd,89);

        dateStart = new Date(2020,6,4);
        dateEnd = new Date(2020,6,26);
        p1 = new Patient("Pearson","B",dateStart,dateEnd,47);

        dateStart = new Date(2020,7,27);
        dateEnd = new Date(2020,8,18);
        p1 = new Patient("Anderson","B",dateStart,dateEnd,62);

        dateStart = new Date(2020,8,1);
        dateEnd = new Date(2020,8,23);
        p1 = new Patient("Johnson","D",dateStart,dateEnd,10);

        dateStart = new Date(2020,8,9);
        dateEnd = new Date(2020,8,31);
        p1 = new Patient("Robertz","A",dateStart,dateEnd,50);

        dateStart = new Date(2020,5,2);
        dateEnd = new Date(2020,5,24);
        p1 = new Patient("Julie","B",dateStart,dateEnd,86);

        dateStart = new Date(2020,6,7);
        dateEnd = new Date(2020,6,29);
        p1 = new Patient("Edith","D",dateStart,dateEnd,42);

        dateStart = new Date(2020,6,1);
        dateEnd = new Date(2020,6,23);
        p1 = new Patient("John","D",dateStart,dateEnd,95);

        SwingApp app = new SwingApp();
    }

}

    class SwingApp extends JFrame{
        JLabel label, label2,label3;
        JTextField text1, text2, text3;
        JButton button1;
        JCheckBox boxA , boxB, boxC, boxD;

        SwingApp() {
            label = new JLabel("                         Assignment 0                      " );
            label2 = new JLabel();
            label2.setText("Enter the Date");
            label3 = new JLabel("Check the Towers");


            text1 = new JTextField(20);
            text2 = new JTextField(20);
            text3 = new JTextField(20);

            //BUTTON
            button1 = new JButton("Display");

    //        button1.addActionListener(this);

            //start
            button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                int a = Integer.parseInt(text1.getText());
//                int b = Integer.parseInt(text2.getText());
//                text3.setText((a+b) +"");


            }
        });
            //end

            //checkbox
            boxA = new JCheckBox("A");
            boxB = new JCheckBox("B");
            boxC = new JCheckBox("C");
            boxD = new JCheckBox("D");

            //Add
//            add(label);
            add(label2);
            add(text2);
            add(label3);
            add(boxA);
            add(boxB);
            add(boxC);
            add(boxD);
            add(button1);
            setTitle("Karanjot Singh");
            FlowLayout f = new FlowLayout();
            setLayout(f);
            // IMPT
            setSize(380, 400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }
