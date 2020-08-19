package Swingh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TEstSwing2 {
    public static void main(String args[]){
        SwingTest1 obj = new SwingTest1();
    }
}
class SwingTest1 extends JFrame
{
    SwingTest1()
    {
        JButton jButton=new JButton("OK");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingTest();
                dispose();
            }
        });

        add(jButton);
        FlowLayout flowLayout=new FlowLayout();
        setLayout(flowLayout);
        setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
