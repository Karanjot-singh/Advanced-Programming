package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {

	static Scanner sc = new Scanner(System.in);
	static ArrayList <HealthInstitute> instituteRecord = new ArrayList<HealthInstitute>();
	static ArrayList <Patient> patientRecord = new ArrayList<Patient>();
	
	public static void method1() {
		System.out.println("Enter the name of the Institute:");
		String inputName = sc.next();
		System.out.println("Enter the body temperature criteria:");
		float inputTemp =sc.nextFloat();
		System.out.println("Enter the oxygen criteria:");
		int inputOxygen = sc.nextInt();
		System.out.println("Enter the number of beds:");
		int inputNumberBeds = sc.nextInt();
		HealthInstitute institute = new HealthInstitute(inputName ,inputOxygen, inputNumberBeds, inputTemp);
		if(inputNumberBeds>0)
			institute.setStatus("OPEN");			
		instituteRecord.add(institute);
		System.out.println("");
		System.out.println(institute.getName());
		institute.display();
		onboardPatients(institute);
		method9(inputName);
		
	}
	private static void onboardPatients(HealthInstitute i) {
		for(Patient p1 : patientRecord) {
//			System.out.println(p1.getHealthInstitute());
			if(p1.getHealthInstitute()=="NA")
			{	if(i.getStatus()=="OPEN" && p1.getOxygenLevel()>=i.getOxygenCriteria() )
					{	System.out.println("Enter the number of Recovery days for the patient ID "+ p1.getId()+" :");
						int inputDays = sc.nextInt();					
						p1.setRecoverydays(inputDays);
						p1.setHealthInstitute(i.getName());
						i.patients.add(p1);
						i.setNumberBeds(i.getNumberBeds()-1);
						if (i.getNumberBeds()==0)
							i.setStatus("CLOSED");						
					}
				
			}
		}
		for(Patient p1 : patientRecord) {
//			System.out.println(p1.getHealthInstitute());
			if(p1.getHealthInstitute()=="NA")
			{	
					if(i.getStatus()=="OPEN" && p1.getBodyTemperature()<=i.getTemperatureCriteria() )
					{	System.out.println("Enter the number of Recovery days for the patient: ");
						int inputDays = sc.nextInt();					
						p1.setRecoverydays(inputDays);
						p1.setHealthInstitute(i.getName());
						i.setNumberBeds(i.getNumberBeds()-1);
						if (i.getNumberBeds()==0)
							i.setStatus("CLOSED");						
					}
				
			}
		}
//		
	}
	public static void method2() {
		System.out.println("The data of the following patients was deleted: ");
		for (int i=0; i< patientRecord.size();i++){
			if(patientRecord.get(i).getHealthInstitute()=="NA")
			System.out.println(patientRecord.get(i).getName());
			patientRecord.remove(i);
		}
		
	}
	public static void method3() {
		System.out.println("The accounts of the following Institutes were deleted: ");
		for (int i=0; i< instituteRecord.size();i++){
			if(instituteRecord.get(i).getStatus()=="CLOSED")
			System.out.println(instituteRecord.get(i).getName());
			instituteRecord.remove(i);
		}
	}
	
	public static void method4() {
		System.out.println("The following patients are still in camp: ");
		for(Patient p1 : patientRecord) {
			if(p1.getHealthInstitute()=="NA")
			System.out.println(p1.getId()+ " "+ p1.getName());
		}
	}
	public static void method5() {
	System.out.println("The following Institutes are Open : ");
	for(HealthInstitute p1 : instituteRecord) {
		if(p1.getStatus()=="OPEN")
		System.out.println(p1.getName());
	}
	}
	
	public static void method6() {
		System.out.println("Enter the name of the Institute : ");
		String inputName = sc.next();
		for(HealthInstitute p1 : instituteRecord) {
			System.out.println(p1.getName());
			if(p1.getName().equals(inputName)) {
				System.out.println("Body temperature criteria <= " + p1.getTemperatureCriteria()+"\n"+
						"Oxygen level criteria >= " + p1.getOxygenCriteria() + "\n"+
						"Number of available beds: " + p1.getNumberBeds()+ "\n"+
						"Admission Status: "+ p1.getStatus()+ "\n");
						break;
			}
		}
	}
	
	public static void method7() {
		System.out.println("Enter the ID of the patient : ");
		int inputId = sc.nextInt();
		Patient p1 = patientRecord.get(inputId);
		p1.display();
		
	}
	
	public static void method8() {
		for(Patient p1 : patientRecord) {
			System.out.println(p1.getId()+ " "+ p1.getName());
		}
	}
	public static void method9(String instituteName) {
		System.out.println("Patient Details:");
		for(HealthInstitute p1 : instituteRecord) {
			if( p1.getName().equals(instituteName)) {
				for(Patient p : p1.patients)
				System.out.println("Patient Name: "+p.getName()+"\n"+"Days to recover: "+p.getRecoverydays());
			}
		}
		
	}
    public static void main(String args[]){
    	System.out.println("Enter the number of Patients: ");
    	int numberPatients = sc.nextInt();
    	for (int i =0; i<numberPatients; i++) {
//    		System.out.println("Enter the Patient Name, Body temperature, Oxygen levels, Age: ");
    		String inputName = sc.next();
//    		System.out.println("Enter the Body temperature: ");
    		float inputTemp =sc.nextFloat();
//    		System.out.println("Enter the Oxygen levels: ");
    		int inputOxygen = sc.nextInt();
//    		System.out.println("Enter the Age: ");
    		int inputAge = sc.nextInt();
    		Patient p = new Patient(inputName,inputAge,inputOxygen,inputTemp);
    		patientRecord.add(p);    		
    	}
    	int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("###### MAIN MENU ######");
    		System.out.println("Enter 0 to exit.");
    		System.out.println("Enter the query number: ");
    		int inputQuery = sc.nextInt();
    		switch (inputQuery) {
    		  case 0:
    			  loopFlag=0;
    			  break;    			
    		  case 1:
    			  method1();
    		    break;
    		  case 2:
    			  method2();
    		    break;
    		  case 3:
    			  method3();
    		    break;
    		  case 4:
    			  method4();
    		    break;
    		  case 5:
    			  method5();
    		    break;
    		  case 6:
    			  method6();
    		    break;
    		  case 7:
    			  method7();
    		    break;
    		  case 8:
      		    System.out.println("Displaying Patient details... "+"\n");
      		    method8();
      		    break;
    		  case 9:
    			  System.out.println("Enter the name of the Institute:");
    			  String inputName = sc.next();
    			  method9(inputName);
      		    break;
    		}
    	}
        
    }
	
}
 class HealthInstitute{
	private String name;
	private int oxygenCriteria, numberBeds;
	private float temperatureCriteria;
	private String status;
	ArrayList <Patient> patients = new ArrayList<Patient>();
	HealthInstitute(){}
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
	private String healthInstitute="NA";
	Patient(){
		
	}
	Patient(String name , int age, int oxygenLevel , float bodyTemperature){
		// id s start at 0
		this.id=Patient.number;
		Patient.number++;
		this.name=name;
		this.age=age;
		this.bodyTemperature=bodyTemperature;
		this.oxygenLevel=oxygenLevel;
	}
	public void display() {
		System.out.println("ID: " + this.getId()+"\n"+
				"Body Temperature: " + this.getBodyTemperature() + "\n"+
				"Oxygen Level: " + this.getOxygenLevel()+ "\n");
		if(this.getHealthInstitute()=="NA")
			System.out.println("Admission Status: Not Admitted" + "\n");
		else
			System.out.println("Admission Status: Admitted" + "\n" +"Institution Admitted to :"+ this.getHealthInstitute()+"\n");
		
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
