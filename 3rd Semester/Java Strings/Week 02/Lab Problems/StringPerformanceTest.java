import java.util.Scanner;

class Result{
    String method;
    long timeTaken;
    int length;

    public Result(String method, long timeTaken, int length){
        this.method=method;
        this.timeTaken=timeTaken;
        this.length=length;
    }
}

public class StringPerformanceTest{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter number of iterations (e.g., 1000, 10000, 100000): ");
        int iterations=input.nextInt();

        Result stringResult=testStringConcatenation(iterations);
        Result builderResult=testStringBuilder(iterations);
        Result bufferResult=testStringBuffer(iterations);

        displayResults(stringResult,builderResult,bufferResult);
        input.close();
    }

    public static Result testStringConcatenation(int iterations){
        long start=System.currentTimeMillis();

        String text="";
        for(int i=0; i<iterations; i++){
            text=text+"X";
        }

        long end=System.currentTimeMillis();
        return new Result("String (+)", end-start, text.length());
    }

    public static Result testStringBuilder(int iterations){
        long start=System.currentTimeMillis();

        StringBuilder sb=new StringBuilder();
        for(int i=0; i<iterations; i++){
            sb.append("X");
        }

        long end=System.currentTimeMillis();
        return new Result("StringBuilder", end-start, sb.length());
    }

    public static Result testStringBuffer(int iterations){
        long start=System.currentTimeMillis();

        StringBuffer sb=new StringBuffer();
        for(int  i=0; i<iterations; i++){
            sb.append("X");
        }

        long end=System.currentTimeMillis();
        return new Result("StringBuffer", end-start, sb.length());
    }

    public static void displayResults(Result... results){
        System.out.println("\n====== PERFORMANCE COMPARISON ======");
        System.out.printf("%-15s %-20s %-20s %-20s\n", "Method", "Time (ms)", "Final Length", "Memory Efficiency");
        System.out.println("----------------------------------------------------------------------------");

        for(Result r : results){
            String efficiency=(r.method.equals("String (+)")) ? "Low (Immutable)" : (r.method.equals("StringBuilder")) ? "High (Not Thread-Safe)" : "Medium (Thread-Safe)";
            System.out.printf("%-15s %-20d %-20d %-20s\n", r.method, r.timeTaken, r.length, efficiency);
        }
    }
}
