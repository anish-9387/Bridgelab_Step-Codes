import java.util.*;

public class CSVAnalyzer{
    public static String[][] parseCSV(String input){
        int rows=1;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='\n')  rows++;
        }

        String[][] data=new String[rows][];
        int row=0;
        StringBuilder field=new StringBuilder();
        List<String> currentRow=new ArrayList<>();

        boolean insideQuotes=false;

        for(int i=0; i<input.length(); i++){
            char c=input.charAt(i);

            if(c=='"'){
                insideQuotes=!insideQuotes;
            }
            else if(c==',' && !insideQuotes){
                currentRow.add(field.toString());
                field.setLength(0);
            }
            else if(c=='\n' && !insideQuotes){
                currentRow.add(field.toString());
                field.setLength(0);

                data[row]=currentRow.toArray(new String[0]);
                currentRow.clear();
                row++;
            }
            else{
                field.append(c);
            }
        }
        if(field.length()>0 || !currentRow.isEmpty()){
            currentRow.add(field.toString());
            data[row]=currentRow.toArray(new String[0]);
        }

        int cols=data[0].length;
        for(int i=0; i<data.length; i++){
            if(data[i]==null){
                data[i]=new String[cols];
                Arrays.fill(data[i],"MISSING");
                continue;
            }
            if(data[i].length<cols){
                String[] fixed=new String[cols];

                for(int j=0; j<cols; j++){
                    if(j<data[i].length)  fixed[j]=data[i][j];
                    else  fixed[j]="MISSING";
                }
                data[i]=fixed;
            }
        }
        return data;
    }

    public static String[][] cleanData(String[][] data){
        for(int i=1; i<data.length; i++){
            if(data[i]==null)  continue;

            for(int j=0; j<data[i].length; j++){
                if(data[i][j]==null){
                    data[i][j]="MISSING";
                }
                else{
                    data[i][j]=data[i][j].trim();
                    if(data[i][j].isEmpty())  data[i][j]="MISSING";
                }
            }
        }
        return data;
    }

    public static boolean isNumeric(String s){
        if(s==null || s.equals("MISSING"))  return false;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9')  return false;
        }
        return true;
    }

    public static void analyzeData(String[][] data){
        int cols=data[0].length;

        for(int j=0; j<cols; j++){
            boolean numericCol=true;
            Set<String> unique=new HashSet<>();
            int sum=0, count=0, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

            for(int i=1; i<data.length; i++){
                String val=data[i][j];

                if(isNumeric(val)){
                    int num=Integer.parseInt(val);
                    sum+=num;
                    count++;
                    if(num<min)  min=num;
                    if(num>max)  max=num;
                }
                else{
                    numericCol=false;
                    unique.add(val);
                }
            }

            System.out.println("\nColumn: "+data[0][j]);
            if(numericCol && count>0){
                System.out.println("  Min: "+min);
                System.out.println("  Max: "+max);
                System.out.println("  Avg: "+(sum/(double)count));
            }
            else{
                System.out.println("  Unique values: "+unique);
            }
        }
    }

    public static void displayTable(String[][] data){
        int cols=data[0].length;
        int[] colWidths=new int[cols];

        for(int j=0; j<cols; j++){
            int maxLen=0;

            for(int i=0; i<data.length; i++){
                if(data[i][j]!=null && data[i][j].length()>maxLen){
                    maxLen=data[i][j].length();
                }
            }
            colWidths[j]=maxLen+2;
        }

        for(int i=0; i<data.length; i++){
            StringBuilder row=new StringBuilder("| ");

            for(int j=0; j<cols; j++){
                String val=(data[i][j]==null) ? "" : data[i][j];
                row.append(String.format("%-"+colWidths[j]+"s", val)).append(" | ");
            }
            System.out.println(row);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter CSV-like data (end with an empty line):");
        StringBuilder sb=new StringBuilder();

        while(true){
            String line=input.nextLine();
            if(line.isEmpty())  break;
            sb.append(line).append("\n");
        }

        String[][] parsed=parseCSV(sb.toString());
        parsed=cleanData(parsed);

        System.out.println("\nFormatted Data Table:");
        displayTable(parsed);

        System.out.println("\nData Analysis:");
        analyzeData(parsed);

        System.out.println("\nSummary Report:");
        System.out.println("Total Records: "+(parsed.length-1));

        input.close();
    }
}
