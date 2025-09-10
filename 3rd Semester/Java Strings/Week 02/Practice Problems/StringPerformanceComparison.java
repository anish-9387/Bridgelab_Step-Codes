public class StringPerformanceComparison{
    public static void main(String[] args){
        System.out.println("====== PERFORMANCE COMPARISON ======");

        long startTime=System.nanoTime();
        String result1=concatenateWithString(10000);
        long endTime=System.nanoTime();
        System.out.println("String concatenation time: "+(endTime-startTime)+" ns");

        startTime=System.nanoTime();
        String result2=concatenateWithStringBuilder(10000);
        endTime=System.nanoTime();
        System.out.println("StringBuilder concatenation time: "+(endTime-startTime)+" ns");

        startTime=System.nanoTime();
        String result3=concatenateWithStringBuffer(10000);
        endTime=System.nanoTime();
        System.out.println("StringBuffer concatenation time: "+(endTime-startTime)+" ns");

        System.out.println("\n====== STRINGBUILDER METHODS DEMO ======");
        demonstrateStringBuilderMethods();

        System.out.println("\n====== THREAD SAFETY DEMO ======");
        demonstrateThreadSafety();

        System.out.println("\n====== STRING COMPARISON METHODS ======");
        compareStringComparisonMethods();

        System.out.println("\n====== MEMORY EFFICIENCY DEMO ======");
        demonstrateMemoryEfficiency();
    }

    public static String concatenateWithString(int iterations){
        String result="";
        for(int i=0; i<iterations; i++){
            result+="Java"+i+" ";
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations){
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<iterations; i++){
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations){
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<iterations; i++){
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods(){
        StringBuilder sb=new StringBuilder("Hello World");
        System.out.println("Original: "+sb);

        sb.append(" Java");
        System.out.println("After append: "+sb);

        sb.insert(6, "Beautiful ");
        System.out.println("After insert: "+sb);

        sb.delete(6, 16);
        System.out.println("After delete: "+sb);

        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: "+sb);

        sb.reverse();
        System.out.println("After reverse: "+sb);

        sb.reverse().replace(0, 5, "Hi");
        System.out.println("After replace: "+sb);

        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt: "+sb);

        System.out.println("Capacity: "+sb.capacity());
        sb.ensureCapacity(50);
        System.out.println("After ensureCapacity(50): "+sb.capacity());
        sb.trimToSize();
        System.out.println("After trimToSize: "+sb.capacity());
    }

    public static void demonstrateThreadSafety(){
        StringBuffer safeBuffer=new StringBuffer("Start");
        StringBuilder unsafeBuilder=new StringBuilder("Start");

        Runnable taskBuffer=() -> {
            for(int i=0; i<1000; i++){
                safeBuffer.append("X");
            }
        };
        Runnable taskBuilder=() -> {
            for(int i=0; i<1000; i++){
                unsafeBuilder.append("X");
            }
        };

        Thread t1=new Thread(taskBuffer);
        Thread t2=new Thread(taskBuffer);
        t1.start(); t2.start();

        Thread t3=new Thread(taskBuilder);
        Thread t4=new Thread(taskBuilder);
        t3.start(); t4.start();

        try{
            t1.join(); t2.join(); t3.join(); t4.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("StringBuffer length (thread-safe): "+safeBuffer.length());
        System.out.println("StringBuilder length (not thread-safe): "+unsafeBuilder.length());
    }

    public static void compareStringComparisonMethods(){
        String str1="Hello";
        String str2="Hello";
        String str3=new String("Hello");

        System.out.println("== operator (str1 == str2): "+(str1 == str2)); 
        System.out.println("== operator (str1 == str3): "+(str1 == str3)); 
        System.out.println("equals() (str1.equals(str3)): "+str1.equals(str3));
        System.out.println("equalsIgnoreCase() (\"hello\"): "+str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo(\"Hello\"): "+str1.compareTo("Hello")); 
        System.out.println("compareTo(\"World\"): "+str1.compareTo("World")); 
        System.out.println("compareToIgnoreCase(\"hello\"): "+str1.compareToIgnoreCase("hello"));
    }

    public static void demonstrateMemoryEfficiency(){
        String str1="Java";
        String str2="Java";
        String str3=new String("Java");

        System.out.println("String Pool test: (str1 == str2): "+(str1 == str2));
        System.out.println("String Pool test: (str1 == str3): "+(str1 == str3));

        StringBuilder sb=new StringBuilder();
        System.out.println("Initial capacity: "+sb.capacity());
        sb.append("This is a test string to check capacity growth...");
        System.out.println("After appending text, capacity: "+sb.capacity());
    }
}
