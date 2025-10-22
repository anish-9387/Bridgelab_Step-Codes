import java.util.*;

class Appointment{
    String patientName;
    String doctorName;
    String date;

    Appointment(String patientName, String doctorName, String date){
        this.patientName=patientName;
        this.doctorName=doctorName;
        this.date=date;
    }

    void display(){
        System.out.println("Appointment: "+patientName+" with Dr. "+doctorName+" on "+date);
    }
}

class Admin{
    public void manageAppointments(List<Appointment> appointments){
        System.out.println("Admin is managing appointments......");
        for(Appointment appt : appointments){
            appt.display();
        }
    }

    public void generateBills(String patientName, double amount){
        System.out.println("Admin generated bill for "+patientName+": Rs."+amount);
    }
}

class Doctor{
    public void updateRecords(String patientName, String notes){
        System.out.println("Doctor updated medical record for "+patientName+": "+notes);
    }

    public void viewAppointments(List<Appointment> appointments){
        System.out.println("Doctor is viewing appointments:");
        for(Appointment appt : appointments){
            if(appt.doctorName.equals("Kumar")){
                appt.display();
            }
        }
    }
}

class Patient{
    String name;

    Patient(String name){
        this.name=name;
    }

    public Appointment bookAppointment(String doctorName, String date){
        System.out.println(name+" booked an appointment with Dr. "+doctorName+" on "+date);
        return new Appointment(name,doctorName,date);
    }

    public void viewBill(double amount){
        System.out.println(name+" viewed bill amount: Rs."+amount);
    }
}

public class HospitalManagementDemo{
    public static void main(String[] args){
        Patient p1=new Patient("Anish");
        Appointment appt1=p1.bookAppointment("Kumar","2025-10-22");

        Doctor doc=new Doctor();
        doc.updateRecords("Anish","Follow-up after 1 week");
        doc.viewAppointments(Arrays.asList(appt1));

        Admin admin=new Admin();
        admin.manageAppointments(Arrays.asList(appt1));
        admin.generateBills("Anish",1500.00);

        p1.viewBill(1500.00);
    }
}
