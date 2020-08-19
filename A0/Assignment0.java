package A0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    static Patient list[] = new Patient[20];
    public static void main(String args[]){
        Date dateStart, dateEnd;
        Patient p1;

        dateStart = new Date(2020,4,1);
        dateEnd = new Date(2020,4,22);
        p1 = new Patient("Flora","A",dateStart,dateEnd,6);
        list[0]=p1;
        //month 0 WRONG HOMOGENISE DATE FORMAT
        System.out.println(p1.startDate.toString());

        dateStart = new Date(2020,4,1);
        dateEnd = new Date(2020,4,22);
        p1 = new Patient("Denys","B",dateStart,dateEnd,24);
        list[1]=p1;

        dateStart = new Date(2020,5,18);
        dateEnd = new Date(2020, 6,9);
        p1 = new Patient("Jim","C",dateStart,dateEnd,42);
        list[2]=p1;

        dateStart = new Date(2020,6,23);
        dateEnd = new Date(2020,7,15);
        p1 = new Patient("Hazel","D",dateStart,dateEnd,87);
        list[3]=p1;

        dateStart = new Date(2020,6,1);
        dateEnd = new Date(2020,6,23);
        p1 = new Patient("Caery","A",dateStart,dateEnd,72);
        list[4]=p1;

        dateStart = new Date(2020,6,14);
        dateEnd = new Date(2020,7,6);
        p1 = new Patient("David","B",dateStart,dateEnd,7);
        list[5]=p1;

        dateStart = new Date(2020,6,5);
        dateEnd = new Date(2020,6,27);
        p1 = new Patient("Kevim","D",dateStart,dateEnd,37);
        list[6]=p1;

        dateStart = new Date(2020,6,20);
        dateEnd = new Date(2020,7,12);
        p1 = new Patient("Tom","D",dateStart,dateEnd,67);
        list[7]=p1;

        dateStart = new Date(2020,7,4);
        dateEnd = new Date(2020,7,26);
        p1 = new Patient("Bob","A",dateStart,dateEnd,74);
        list[8]=p1;

        dateStart = new Date(2020,7,24);
        dateEnd = new Date(2020,8,15);
        p1 = new Patient("Rachel","C",dateStart,dateEnd,48);
        list[9]=p1;

        dateStart = new Date(2020,6,11);
        dateEnd = new Date(2020,7,2);
        p1 = new Patient("Thomas","C",dateStart,dateEnd,21);
        list[10]=p1;

        dateStart = new Date(2020,6,21);
        dateEnd = new Date(2020,7,13);
        p1 = new Patient("Mary","D",dateStart,dateEnd,17);
        list[11]=p1;

        dateStart = new Date(2020,8,7);
        dateEnd = new Date(2020,8,29);
        p1 = new Patient("Smith","A",dateStart,dateEnd,89);
        list[12]=p1;

        dateStart = new Date(2020,6,4);
        dateEnd = new Date(2020,6,26);
        p1 = new Patient("Pearson","B",dateStart,dateEnd,47);
        list[13]=p1;

        dateStart = new Date(2020,7,27);
        dateEnd = new Date(2020,8,18);
        p1 = new Patient("Anderson","B",dateStart,dateEnd,62);
        list[14]=p1;

        dateStart = new Date(2020,8,1);
        dateEnd = new Date(2020,8,23);
        p1 = new Patient("Johnson","D",dateStart,dateEnd,10);
        list[15]=p1;

        dateStart = new Date(2020,8,9);
        dateEnd = new Date(2020,8,31);
        p1 = new Patient("Robertz","A",dateStart,dateEnd,50);
        list[16]=p1;

        dateStart = new Date(2020,5,2);
        dateEnd = new Date(2020,5,24);
        p1 = new Patient("Julie","B",dateStart,dateEnd,86);
        list[17]=p1;

        dateStart = new Date(2020,6,7);
        dateEnd = new Date(2020,6,29);
        p1 = new Patient("Edith","D",dateStart,dateEnd,42);
        list[18]=p1;

        dateStart = new Date(2020,6,1);
        dateEnd = new Date(2020,6,23);
        p1 = new Patient("John","D",dateStart,dateEnd,95);
        list[19]=p1;

        SwingApp app = new SwingApp();
    }

}

    class SwingApp extends JFrame implements ItemListener {
        JLabel label, label2,label3,resultA,resultB,resultC,resultD;
        JFormattedTextField text1;
        JButton button1;
        JCheckBox boxA , boxB, boxC, boxD;

        SwingApp() {
            label = new JLabel("Assignment 0" );
            label2 = new JLabel();
            label2.setText("Enter the Date");
            label3 = new JLabel("Check the Towers");
            resultA = new JLabel("A:");
            resultB = new JLabel("B:");
            resultC = new JLabel("C:");
            resultD = new JLabel("D:");

            DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
            text1 = new JFormattedTextField(20);
            //BUTTON
            button1 = new JButton("Enter");
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

            boxA.addItemListener(this);
            boxB.addItemListener(this);
            boxC.addItemListener(this);
            boxD.addItemListener(this);

            //Add
//            add(label);
            add(label2);
            add(text1);
            add(button1);
            add(label3);
            add(boxA);
            add(boxB);
            add(boxC);
            add(boxD);
            add(resultA);
            add(resultB);
            add(resultC);
            add(resultD);

            setTitle("Karanjot Singh");
            FlowLayout f = new FlowLayout();
            setLayout(f);
            // IMPT
            setSize(380, 400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        @Override
        public void itemStateChanged(ItemEvent e) {

            if(e.getSource()==boxA){
                if (e.getStateChange()==1)
                    resultA.setText("geeksforgeeks  selected");
                else
                    resultA.setText("geeksforgeeks  not selected");
            }
            if(e.getSource()==boxB){
//                if (e.getStateChange() == 1)
//                    l.setText("geeksforgeeks  selected");
//                else
//                    l.setText("geeksforgeeks  not selected");
            }
            if(e.getSource()==boxC){
//                if (e.getStateChange() == 1)
//                    l.setText("geeksforgeeks  selected");
//                else
//                    l.setText("geeksforgeeks  not selected");
            }
            if(e.getSource()==boxD){
//                if (e.getStateChange() == 1)
//                    l.setText("geeksforgeeks  selected");
//                else
//                    l.setText("geeksforgeeks  not selected");
            }


        }
    }
