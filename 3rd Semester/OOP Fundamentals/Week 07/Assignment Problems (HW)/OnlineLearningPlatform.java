import java.time.LocalDate;

class Course{
    String title;
    String instructor;
    LocalDate enrollmentDate;

    Course(String title, String instructor, LocalDate enrollmentDate){
        this.title=title;
        this.instructor=instructor;
        this.enrollmentDate=enrollmentDate;
    }

    void displayProgress(){
        System.out.println("Course: "+title+" by "+instructor+", Enrolled on: "+enrollmentDate);
        System.out.println("Progress: N/A");
    }
}

class VideoCourse extends Course{
    int completionPercentage;
    int watchTime;

    VideoCourse(String title, String instructor, LocalDate enrollmentDate, int completionPercentage, int watchTime){
        super(title,instructor,enrollmentDate);
        this.completionPercentage=completionPercentage;
        this.watchTime=watchTime;
    }

    @Override
    void displayProgress(){
        System.out.println("Video Course: "+title+" by "+instructor);
        System.out.println("Completion: "+completionPercentage+"%, Watch time: "+watchTime+" mins");
        System.out.println("---------------------------------");
    }
}

class InteractiveCourse extends Course{
    int quizScore;
    int projectsCompleted;

    InteractiveCourse(String title, String instructor, LocalDate enrollmentDate, int quizScore, int projectsCompleted){
        super(title,instructor,enrollmentDate);
        this.quizScore=quizScore;
        this.projectsCompleted=projectsCompleted;
    }

    @Override
    void displayProgress(){
        System.out.println("Interactive Course: "+title+" by "+instructor);
        System.out.println("Quiz Score: "+quizScore+"%, Projects Completed: "+projectsCompleted);
        System.out.println("---------------------------------");
    }
}

class ReadingCourse extends Course{
    int pagesRead;
    int notesTaken;

    ReadingCourse(String title, String instructor, LocalDate enrollmentDate, int pagesRead, int notesTaken){
        super(title,instructor,enrollmentDate);
        this.pagesRead=pagesRead;
        this.notesTaken=notesTaken;
    }

    @Override
    void displayProgress(){
        System.out.println("Reading Course: "+title+" by "+instructor);
        System.out.println("Pages read: "+pagesRead+", Notes taken: "+notesTaken);
        System.out.println("---------------------------------");
    }
}

class CertificationCourse extends Course{
    int examAttempts;
    boolean certified;

    CertificationCourse(String title, String instructor, LocalDate enrollmentDate, int examAttempts, boolean certified){
        super(title,instructor,enrollmentDate);
        this.examAttempts=examAttempts;
        this.certified=certified;
    }

    @Override
    void displayProgress(){
        System.out.println("Certification Course: "+title+" by "+instructor);
        System.out.println("Exam Attempts: "+examAttempts+", Certified: "+(certified ? "Yes" : "No"));
        System.out.println("---------------------------------");
    }
}

public class OnlineLearningPlatform{
    public static void main(String[] args){
        Course[] courses={
            new VideoCourse("Java Basics","Alice",LocalDate.of(2025,9,1),75,120),
            new InteractiveCourse("Python Projects","Bob",LocalDate.of(2025,8,15),85,5),
            new ReadingCourse("Data Structures","Charlie",LocalDate.of(2025,7,20),150,12),
            new CertificationCourse("AWS Cloud","Diana",LocalDate.of(2025,6,10),2,true)
        };

        System.out.println("====== Learning Progress ======");
        for(Course c : courses){
            c.displayProgress();
        }
    }
}
