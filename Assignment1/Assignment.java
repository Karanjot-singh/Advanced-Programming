package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {

	static Scanner sc = new Scanner(System.in);
	static ArrayList <HealthInstitute> instituteRecord = new ArrayList<HealthInstitute>();
	static ArrayList <Patient> patientRecord = new ArrayList<Patient>();
	
	public static void method1() {
		String inputName = sc.next();
		float inputTemp =sc.nextFloat();
		int inputOxygen = sc.nextInt();
		int inputNumberBeds = sc.nextInt();
		HealthInstitute institute = new HealthInstitute(inputName ,inputOxygen, inputNumberBeds, inputTemp);
		instituteRecord.add(institute);
		institute.display();
		method9(inputName);
		
	}
	
	
	public static void method9(String instituteName) {
		System.out.println("Patient Details:");
		for(Patient p : patientRecord) {
			String name = p.getHealthInstitute();
			if(name == instituteName) {
				System.out.println("Patient Name: "+p.getName()+"\n"+"Days to recover: "+p.getRecoverydays());
			}
		}
		
	}
    public static void main(String args[]){
    	int numberPatients = sc.nextInt();
    	for (int i =0; i<numberPatients; i++) {
    		String inputName = sc.next();
    		float inputTemp =sc.nextFloat();
    		int inputOxygen = sc.nextInt();
    		int inputbeds = sc.nextInt();
    		Patient p = new Patient(inputName,inputOxygen,inputbeds,inputTemp);
    		patientRecord.add(p);    		
    	}
    	int loopFlag=1;
    	while(loopFlag==1) {
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
      		    for(Patient p1 : patientRecord) {
      		    	System.out.println(p1.getId()+ " "+ p1.getName());
      		    }
      		    break;
    		  case 9:
      		    System.out.println("Sunday");
      		    break;
    		}
    	}
        
    }
}
 class HealthInstitute{

	String name;
	int oxygenCriteria, numberBeds;
	float temperatureCriteria;
	String status;
	
	public HealthInstitute(String name, int oxygenCriteria, int numberBeds, float temperatureCriteria) {
		this.name = name;
		this.oxygenCriteria = oxygenCriteria;
		this.numberBeds = numberBeds;
		this.temperatureCriteria = temperatureCriteria;
	}
	public void display() {
		System.out.println("Body temperature criteria <= " + this.temperatureCriteria+"\n"+
				"Oxygen level criteria >= " + this.oxygenCriteria + "\n"+
				"Number of available beds: " + this.numberBeds+ "\n"+
				"Admission Status: "+ this.status+ "\n");
		
	}

	public void setNumberBeds(int numberBeds) {
		this.numberBeds = numberBeds;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public int getOxygenCriteria() {
		return oxygenCriteria;
	}

	public int getNumberBeds() {
		return numberBeds;
	}

	public float getTemperatureCriteria() {
		return temperatureCriteria;
	}

	public String getStatus() {
		return status;
	}
}

 class Patient{
	private static int number=0;
	private String name;
	private int age, oxygenLevel;
	private float bodyTemperature;
	private int id,recoverydays;
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

	public void setRecoverydays(int recoverydays) {
		this.recoverydays = recoverydays;
	}
	//getters

	public int getRecoverydays() {
		return recoverydays;
	}
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
