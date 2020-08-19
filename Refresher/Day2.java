//import java.util.Scanner;
package Refresher;

public class Day2 {

    public static void main(String args[]){
        Student arr[]=new Day2.Student[20];
        for(int i=0; i<5;i++)
        {
            arr[i]=new Day2.Student();
        }
        for(int i=0; i<5;i++)
        {
            arr[i+5]=new Day2.Student("k","c",2,33);
        }
        arr[2].display();


    }
    private static class Student{
        String name, branch;
        int age;
        static int latestroll=1;
        int roll;
        // default constructor
        Student(){
            this.name="Karan";
            this.branch="CSE";
            this.roll=11;
            this.age=18;
        }

        //parametrised constructor
        Student(String name, String branch , int roll, int age){
            this.name =name;
            this.branch=branch;
            this.age=age;
            this.roll=roll;
        }
        void display( ){
            System.out.println("Name "+this.name);
            System.out.println("Branch "+this.branch);
            System.out.println("age "+this.age);
            System.out.println("roll "+this.roll);
            System.out.println("Latest roll "+Student.latestroll);
        }

    }

}
