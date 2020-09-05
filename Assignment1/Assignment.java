package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int numberPatients = sc.nextInt();
    	ArrayList <Patient> record = new ArrayList<Patient>();
//    	Patient[] record = new Patient[numberPatients];
    	for (int i =0; i<numberPatients; i++) {
    		String inputName = sc.next();
    		float inputTemp =sc.nextFloat();
    		int inputOxygen = sc.nextInt();
    		int inputAge = sc.nextInt();
    		Patient p = new Patient(inputName,inputAge,inputOxygen,inputTemp);
    		record.add(p);    		
    	}
    	int loopFlag=1;
    	while(loopFlag) {
    		int inputQuery = sc.nextInt();
    		switch (inputQuery) {
    		  case 0:
    			  loopFlag=0;
    			  break;    			
    		  case 1:
    		    System.out.println("Monday");
    		    break;
    		  case 2:
    		    System.out.println("Tuesday");
    		    break;
    		  case 3:
    		    System.out.println("Wednesday");
    		    break;
    		  case 4:
    		    System.out.println("Thursday");
    		    break;
    		  case 5:
    		    System.out.println("Friday");
    		    break;
    		  case 6:
    		    System.out.println("Saturday");
    		    break;
    		  case 7:
    		    System.out.println("Sunday");
    		    break;
    		  case 8:
      		    System.out.println("Sunday");
      		    break;
    		  case 9:
      		    System.out.println("Sunday");
      		    break;
    		}
    	}
        
    }
}

 class Patient{
	private static int number=0;
	private String name;
	private int age, oxygenLevel;
	private float bodyTemperature;
	private int id;
	private String healthInstitute=null;
	
	Patient(String name , int age, int oxygenLevel , float bodyTemperature){
		// id s start at 0
		this.id=Patient.number;
		Patient.number++;
		this.name=name;
		this.age=age;
		this.bodyTemperature=bodyTemperature;
		this.oxygenLevel=oxygenLevel;
	}
	//setters
	public void setHealthInstitute(String healthInstitute) {
		this.healthInstitute = healthInstitute;
	}
	//getters
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getOxygenLevel() {
		return oxygenLevel;
	}
	public float getBodyTemperature() {
		return bodyTemperature;
	}
	public int getId() {
		return id;
	}
	public String getHealthInstitute() {
		return healthInstitute;
	}
	
}
