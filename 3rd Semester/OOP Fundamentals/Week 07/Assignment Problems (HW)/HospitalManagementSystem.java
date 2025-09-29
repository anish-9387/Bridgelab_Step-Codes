class MedicalStaff{
    String name;
    String staffId;

    MedicalStaff(String name, String staffId){
        this.name=name;
        this.staffId=staffId;
    }

    void scheduleShift(String shift){
        System.out.println(name+" (ID: "+staffId+") scheduled for "+shift+" shift");
    }

    void accessIDCard(){
        System.out.println(name+" accessed hospital ID card");
    }

    void processPayroll(){
        System.out.println("Payroll processed for "+name+" (ID: "+staffId+")");
    }
}

class Doctor extends MedicalStaff{
    Doctor(String name, String staffId){
        super(name,staffId);
    }

    void diagnosePatient(String patient){
        System.out.println(name+" diagnosed patient: "+patient);
    }

    void prescribeMedicine(String patient, String medicine){
        System.out.println(name+" prescribed "+medicine+" to "+patient);
    }

    void performSurgery(String patient){
        System.out.println(name+" performed surgery on "+patient);
    }
}

class Nurse extends MedicalStaff{
    Nurse(String name, String staffId){
        super(name,staffId);
    }

    void administerMedicine(String patient){
        System.out.println(name+" administered medicine to "+patient);
    }

    void monitorPatient(String patient){
        System.out.println(name+" is monitoring patient: "+patient);
    }

    void assistProcedure(String procedure){
        System.out.println(name+" is assisting in procedure: "+procedure);
    }
}

class Technician extends MedicalStaff{
    Technician(String name, String staffId){
        super(name,staffId);
    }

    void operateEquipment(String equipment){
        System.out.println(name+" is operating equipment: "+equipment);
    }

    void runTest(String test){
        System.out.println(name+" ran test: "+test);
    }

    void maintainInstrument(String instrument){
        System.out.println(name+" maintained instrument: "+instrument);
    }
}

class Administrator extends MedicalStaff{
    Administrator(String name, String staffId){
        super(name,staffId);
    }

    void scheduleAppointment(String patient){
        System.out.println(name+" scheduled appointment for "+patient);
    }

    void manageRecords(String record){
        System.out.println(name+" managed record: "+record);
    }
}

public class HospitalManagementSystem{
    public static void main(String[] args){
        MedicalStaff[] staff={
            new Doctor("Dr. Alice","D101"),
            new Nurse("Nurse Bob","N202"),
            new Technician("Tech Charlie","T303"),
            new Administrator("Admin Diana","A404")
        };

        System.out.println("====== Hospital Staff Operations ======");
        for(MedicalStaff ms : staff){
            ms.scheduleShift("Morning");
            ms.accessIDCard();
            ms.processPayroll();
            System.out.println();
        }

        System.out.println("====== Specialized Operations ======");
        ((Doctor)staff[0]).diagnosePatient("Patient X");
        ((Doctor)staff[0]).prescribeMedicine("Patient X", "Paracetamol");
        ((Nurse)staff[1]).administerMedicine("Patient X");
        ((Technician)staff[2]).runTest("Blood Test");
        ((Administrator)staff[3]).scheduleAppointment("Patient Y");
    }
}
