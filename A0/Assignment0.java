package A0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
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
class SwingApp extends JFrame implements ItemListener {
    JLabel label, label2,label3;
    JTextArea resultA,resultB,resultC,resultD;
    JFormattedTextField text1;
    JTextField text2;
    JCheckBox boxA , boxB, boxC, boxD;
    DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    SwingApp() {
        label = new JLabel("Assignment 0" );
        label2 = new JLabel();
        label2.setText("Enter the Date");
        label3 = new JLabel("Check the Towers");
        resultA = new JTextArea("A:");
        resultB = new JTextArea("B:");
        resultC = new JTextArea("C:");
        resultD = new JTextArea("D:");


        text1 = new JFormattedTextField(dateFormat);
        text2 = new JTextField(20);

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
        add(text2);
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
        setSize(600, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String strD = (text2.getText());
        Date enterDate = new Date();
        try {
            Date inputDate =df.parse(strD);
            System.out.println(inputDate);
            enterDate=inputDate;
        } catch (ParseException en) {
            en.printStackTrace();
            resultA.setText("Please Enter Valid Date!");
        }
        if(e.getSource()==boxA){
            if (e.getStateChange()==1)
                resultA.setText(Assignment0.getCases(enterDate,"A"));
            else
                resultA.setText("A:");
        }
        if(e.getSource()==boxB){
            if (e.getStateChange()==1)
                resultB.setText(Assignment0.getCases(enterDate,"B"));
            else
                resultB.setText("B:");
        }

        if(e.getSource()==boxC){
            if (e.getStateChange()==1)
                resultC.setText(Assignment0.getCases(enterDate,"C"));
            else
                resultC.setText("C:");
        }
        if(e.getSource()==boxD){
            if (e.getStateChange()==1)
                resultD.setText(Assignment0.getCases(enterDate,"D"));
            else
                resultD.setText("D:");
        }
    }
}
public class Assignment0 {
    static Patient list[] = new Patient[20];

    static String getCases(Date inputDate, String selectedTower){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        int activeCases=0, recoveredCases=0;
        String txt="";
        for(Patient p : list){
            if(p.tower==selectedTower){
                //active cases
                if((inputDate.compareTo(p.startDate)>=0) && (inputDate.compareTo(p.endDate)<=0) ){
                    activeCases++;
                    txt=txt+"Name: "+p.name+"\nAge: "+p.age+"\nTower: "+p.tower+"\nRecovery Date: "+f.format(p.endDate)+"\n";

                }
                if(inputDate.compareTo(p.endDate)>=0){
                    recoveredCases++;
                    txt=txt+"Name: "+p.name+"\nAge: "+p.age+"\nTower: "+p.tower+"\nRecovery Date: "+f.format(p.endDate)+"\n";

                }
            }
        }
        String newTxt ="Active Cases: "+(activeCases+"")+"\nRecovered Cases: "+(recoveredCases+"")+"\n"+txt;
        return newTxt;

    }
    public static void main(String args[]){
        Date dateStart, dateEnd;
        Patient p1;
        //The format follows 120 for year 2020 and month month-1
        dateStart = new Date(120,3,1);
        dateEnd = new Date(120,3,22);
        p1 = new Patient("Flora","A",dateStart,dateEnd,6);
        list[0]=p1;
        //month 0 WRONG HOMOGENISE DATE FORMAT
        System.out.println(p1.startDate.toString());

        dateStart = new Date(120,3,1);
        dateEnd = new Date(120,3,22);
        p1 = new Patient("Denys","B",dateStart,dateEnd,24);
        list[1]=p1;

        dateStart = new Date(120,4,18);
        dateEnd = new Date(120, 5,9);
        p1 = new Patient("Jim","C",dateStart,dateEnd,42);
        list[2]=p1;

        dateStart = new Date(120,5,23);
        dateEnd = new Date(120,6,15);
        p1 = new Patient("Hazel","D",dateStart,dateEnd,87);
        list[3]=p1;

        dateStart = new Date(120,5,1);
        dateEnd = new Date(120,5,23);
        p1 = new Patient("Caery","A",dateStart,dateEnd,72);
        list[4]=p1;

        dateStart = new Date(120,5,14);
        dateEnd = new Date(120,6,6);
        p1 = new Patient("David","B",dateStart,dateEnd,7);
        list[5]=p1;

        dateStart = new Date(120,5,5);
        dateEnd = new Date(120,5,27);
        p1 = new Patient("Kevim","D",dateStart,dateEnd,37);
        list[6]=p1;

        dateStart = new Date(120,5,20);
        dateEnd = new Date(120,6,12);
        p1 = new Patient("Tom","D",dateStart,dateEnd,67);
        list[7]=p1;

        dateStart = new Date(120,6,4);
        dateEnd = new Date(120,6,26);
        p1 = new Patient("Bob","A",dateStart,dateEnd,74);
        list[8]=p1;

        dateStart = new Date(120,6,24);
        dateEnd = new Date(120,7,15);
        p1 = new Patient("Rachel","C",dateStart,dateEnd,48);
        list[9]=p1;

        dateStart = new Date(120,5,11);
        dateEnd = new Date(120,6,2);
        p1 = new Patient("Thomas","C",dateStart,dateEnd,21);
        list[10]=p1;

        dateStart = new Date(120,5,21);
        dateEnd = new Date(120,6,13);
        p1 = new Patient("Mary","D",dateStart,dateEnd,17);
        list[11]=p1;

        dateStart = new Date(120,7,7);
        dateEnd = new Date(120,7,29);
        p1 = new Patient("Smith","A",dateStart,dateEnd,89);
        list[12]=p1;

        dateStart = new Date(120,5,4);
        dateEnd = new Date(120,5,26);
        p1 = new Patient("Pearson","B",dateStart,dateEnd,47);
        list[13]=p1;

        dateStart = new Date(120,6,27);
        dateEnd = new Date(120,7,18);
        p1 = new Patient("Anderson","B",dateStart,dateEnd,62);
        list[14]=p1;

        dateStart = new Date(120,7,1);
        dateEnd = new Date(120,7,23);
        p1 = new Patient("Johnson","D",dateStart,dateEnd,10);
        list[15]=p1;

        dateStart = new Date(120,7,9);
        dateEnd = new Date(120,7,31);
        p1 = new Patient("Robertz","A",dateStart,dateEnd,50);
        list[16]=p1;

        dateStart = new Date(120,4,2);
        dateEnd = new Date(120,4,24);
        p1 = new Patient("Julie","B",dateStart,dateEnd,86);
        list[17]=p1;

        dateStart = new Date(120,5,7);
        dateEnd = new Date(120,5,29);
        p1 = new Patient("Edith","D",dateStart,dateEnd,42);
        list[18]=p1;

        dateStart = new Date(120,5,1);
        dateEnd = new Date(120,5,23);
        p1 = new Patient("John","D",dateStart,dateEnd,95);
        list[19]=p1;

        SwingApp app = new SwingApp();
    }

}
