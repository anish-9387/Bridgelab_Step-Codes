import java.util.Arrays;
import java.util.Comparator;

class Subject{
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor){
        this.subjectCode=subjectCode;
        this.subjectName=subjectName;
        this.credits=credits;
        this.instructor=instructor;
    }

    public String getSubjectCode(){ return subjectCode; }
    public String getSubjectName(){ return subjectName; }
    public int getCredits(){ return credits; }
    public String getInstructor(){ return instructor; }

    public void display(){
        System.out.println(subjectCode+": "+subjectName+" | Credits: "+credits+" | Instructor: "+instructor);
    }
}

class Student{
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks;
    private double gpa;

    private static int totalStudents=0;
    private static String schoolName="Default School";
    private static String[] gradingScale={"A:90-100", "B:80-89", "C:70-79", "D:60-69", "F:0-59"};
    private static double passPercentage=40.0;

    private static double gradePointA=4.0;
    private static double gradePointB=3.0;
    private static double gradePointC=2.0;
    private static double gradePointD=1.0;
    private static double gradePointF=0.0;

    public Student(String studentId, String studentName, String className, String[] subjects, double[][] marks){
        this.studentId=studentId;
        this.studentName=studentName;
        this.className=className;
        this.subjects=subjects;
        this.marks=marks;
        this.gpa=0.0;
        totalStudents++;
    }

    public static void setSchoolName(String name){ schoolName=name; }
    public static void setGradingScale(String[] scale){ gradingScale=scale; }
    public static void setPassPercentage(double p){ passPercentage=p; }
    public static int getTotalStudents(){ return totalStudents; }
    public static String getSchoolName(){ return schoolName; }
    public static String[] getGradingScale(){ return gradingScale; }
    public static double getPassPercentage(){ return passPercentage; }

    public void addMarks(int subjectIndex, double[] assessmentMarks){
        if(subjectIndex<0 || subjectIndex>=marks.length){
            System.out.println("Invalid subject index for "+studentName);
            return;
        }
        marks[subjectIndex]=Arrays.copyOf(assessmentMarks,assessmentMarks.length);
    }

    public double calculateSubjectAverage(int subjectIndex){
        double[] arr=marks[subjectIndex];
        if(arr==null || arr.length==0)  return 0.0;
        double sum=0.0;
        for(double m : arr)  sum+=m;
        return sum/arr.length;
    }

    public String getLetterGrade(double percentage){
        if(percentage>=90)  return "A";
        if(percentage>=80)  return "B";
        if(percentage>=70)  return "C";
        if(percentage>=60)  return "D";
        return "F";
    }

    private double letterToPoint(String letter){
        switch(letter){
            case "A":  return gradePointA;
            case "B":  return gradePointB;
            case "C":  return gradePointC;
            case "D":  return gradePointD;
            default:   return gradePointF;
        }
    }

    public double calculateGPA(Subject[] subjectObjects){
        double totalWeightedPoints=0.0;
        int totalCredits=0;
        for(int i=0; i<subjects.length; i++){
            double avg=calculateSubjectAverage(i);
            String letter=getLetterGrade(avg);
            double gp=letterToPoint(letter);
            int credits=subjectObjects[i].getCredits();
            totalWeightedPoints+=gp*credits;
            totalCredits+=credits;
        }
        this.gpa=(totalCredits==0) ? 0.0 : (totalWeightedPoints/totalCredits);
        return this.gpa;
    }

    public void generateReportCard(Subject[] subjectObjects){
        System.out.println("========================================");
        System.out.println("School: "+schoolName);
        System.out.println("Report Card for: "+studentName+" ("+studentId+") | Class: "+className);
        System.out.println("----------------------------------------");
        System.out.printf("%-10s %-20s %-8s %-8s %-6s\n", "SubCode", "Subject", "Credits", "Avg(%)", "Grade");
        for(int i=0; i<subjects.length; i++){
            double avg=calculateSubjectAverage(i);
            String grade=getLetterGrade(avg);
            Subject s=subjectObjects[i];
            System.out.printf("%-10s %-20s %-8d %-8.2f %-6s\n", s.getSubjectCode(), s.getSubjectName(), s.getCredits(), avg, grade);
        }
        double computedGPA=calculateGPA(subjectObjects);
        System.out.println("----------------------------------------");
        System.out.printf("GPA: %.2f\n", computedGPA);
        System.out.println("Pass Percentage Threshold: "+passPercentage+"%");
        System.out.println("Promotion Eligibility: "+(checkPromotionEligibility(subjectObjects) ? "Eligible" : "Not Eligible"));
        System.out.println("========================================\n");
    }

    public boolean checkPromotionEligibility(Subject[] subjectObjects){
        for(int i=0; i<subjects.length; i++){
            double avg=calculateSubjectAverage(i);
            if(avg<passPercentage)  return false;
        }
        return true;
    }

    public String getStudentId(){ return studentId; }
    public String getStudentName(){ return studentName; }
    public String getClassName(){ return className; }
    public double getGPA(){ return gpa; }

    public double overallPercentage(){
        double sum=0.0;
        for(int i=0; i<subjects.length; i++)  sum+=calculateSubjectAverage(i);
        return  (subjects.length==0) ? 0.0 : (sum/subjects.length);
    }

    public static double calculateClassAverage(Student[] students, String className){
        double sum=0.0;
        int count=0;
        for(Student st : students){
            if(st==null)  continue;
            if(st.getClassName().equalsIgnoreCase(className)){
                sum+=st.overallPercentage();
                count++;
            }
        }
        return (count==0) ? 0.0 : (sum/count);
    }

    public static Student[] getTopPerformers(Student[] students, int count, Subject[][] subjectMatrix){
        for(int i=0; i<students.length; i++){
            if(students[i]==null)  continue;
            if(subjectMatrix!=null && subjectMatrix[i]!=null){
                students[i].calculateGPA(subjectMatrix[i]);
            }
        }
        Student[] nonNull=Arrays.stream(students).filter(s->s!=null).toArray(Student[]::new);
        Arrays.sort(nonNull, Comparator.comparingDouble(Student::getGPA).reversed());
        if(count>=nonNull.length)  return nonNull;
        return Arrays.copyOfRange(nonNull,0,count);
    }

    public static void generateSchoolReport(Student[] students, Subject[][] subjectMatrix){
        System.out.println("######## School Report: "+schoolName+" ########");
        System.out.println("Total Students: "+totalStudents);
        java.util.Set<String> classes=new java.util.HashSet<>();
        for(Student s : students)  if(s!=null)  classes.add(s.getClassName());
        for(String cls : classes){
            double avg=calculateClassAverage(students,cls);
            System.out.printf("Class %s Average Percentage: %.2f%%\n", cls, avg);
        }
        Student[] top=getTopPerformers(students,3,subjectMatrix);
        System.out.println("\nTop Performers:");
        for(Student t : top){
            System.out.printf("%s (%s) | Class: %s | GPA: %.2f | Overall%%: %.2f\n", t.getStudentName(), t.getStudentId(), t.getClassName(), t.getGPA(), t.overallPercentage());
        }
        System.out.println("############################################\n");
    }
}

public class GradeManagementSystem{
    public static void main(String[] args){
        Student.setSchoolName("Greenfield High School");
        Student.setPassPercentage(50.0);
        Student.setGradingScale(new String[] {"A:90-100","B:80-89","C:70-79","D:60-69","F:0-59"});

        Subject[] subjects = new Subject[4];
        subjects[0]=new Subject("ENG101","English",3,"Ms. Adams");
        subjects[1]=new Subject("MAT101","Mathematics",4,"Mr. Brown");
        subjects[2]=new Subject("SCI101","Science",3,"Dr. Clark");
        subjects[3]=new Subject("HIS101","History",2,"Ms. Davis");

        Student[] students=new Student[5];

        double[][] marks1={
                {88, 92, 85},   // English assessments
                {95, 90, 92},   // Math
                {78, 82, 80},   // Science
                {70, 72}        // History
        };
        students[0]=new Student("S001","Alice Johnson","10A",new String[]{"ENG101","MAT101","SCI101","HIS101"},marks1);

        double[][] marks2={
                {68, 72, 70},
                {58, 60, 55},
                {65, 60, 62},
                {75, 78}
        };
        students[1]=new Student("S002","Bob Smith","10A",new String[]{"ENG101","MAT101","SCI101","HIS101"},marks2);

        double[][] marks3={
                {90, 94, 92},
                {88, 85, 90},
                {92, 94, 90},
                {85, 88}
        };
        students[2]=new Student("S003","Carol Lee","10B",new String[]{"ENG101","MAT101","SCI101","HIS101"},marks3);

        double[][] marks4={
                {45, 50, 48},
                {55, 52, 50},
                {60, 62, 58},
                {40, 42}
        };
        students[3]=new Student("S004","David Kim","10B",new String[]{"ENG101","MAT101","SCI101","HIS101"},marks4);

        double[][] marks5={
                {82, 80, 85},
                {78, 75, 80},
                {72, 70, 75},
                {68, 65}
        };
        students[4]=new Student("S005","Eva Green","10A",new String[]{"ENG101","MAT101","SCI101","HIS101"},marks5);

        Subject[][] subjectMatrix=new Subject[students.length][];
        for(int i=0; i<students.length; i++)  subjectMatrix[i]=subjects;

        for(Student s : students){
            s.generateReportCard(subjects);
        }

        System.out.printf("Class 10A Average: %.2f%%\n", Student.calculateClassAverage(students, "10A"));
        System.out.printf("Class 10B Average: %.2f%%\n", Student.calculateClassAverage(students, "10B"));

        Student[] top2=Student.getTopPerformers(students,3,subjectMatrix);
        System.out.println("\nTop 3 Students by GPA:");
        for(Student t : top2){
            System.out.printf("%s (%s) - Class %s - GPA: %.2f - Overall%%: %.2f\n", t.getStudentName(), t.getStudentId(), t.getClassName(), t.getGPA(), t.overallPercentage());
        }

        Student.generateSchoolReport(students, subjectMatrix);
    }
}
