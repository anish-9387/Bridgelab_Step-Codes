import java.util.*;

public class TextFormatter{
    public static List<String> splitWords(String text){
        List<String> words=new ArrayList<>();
        int start=0;

        for(int i=0; i<text.length(); i++){
            if(text.charAt(i)==' '){
                if(start<i){
                    words.add(text.substring(start,i));
                }
                start=i+1;
            }
        }
        if(start<text.length()){
            words.add(text.substring(start));
        }
        return words;
    }

    public static List<String> justifyText(List<String> words, int width){
        List<String> lines=new ArrayList<>();
        StringBuilder line=new StringBuilder();
        List<String> currentLineWords=new ArrayList<>();
        int lineLength=0;

        for(String word : words){
            if(lineLength+word.length()+currentLineWords.size()<=width){
                currentLineWords.add(word);
                lineLength+=word.length();
            }
            else{
                int spaces=width-lineLength;
                int gaps=currentLineWords.size()-1;
                StringBuilder justified=new StringBuilder();

                if(gaps>0){
                    int evenSpace=spaces/gaps;
                    int extra=spaces%gaps;

                    for(int i=0; i<currentLineWords.size(); i++){
                        justified.append(currentLineWords.get(i));
                        if(i<gaps){
                            for(int s=0; s<evenSpace; s++)  justified.append(" ");
                            if(i<extra)  justified.append(" ");
                        }
                    }
                }
                else{
                    justified.append(currentLineWords.get(0));
                    while(justified.length()<width)  justified.append(" ");
                }
                lines.add(justified.toString());

                currentLineWords.clear();
                currentLineWords.add(word);
                lineLength=word.length();
            }
        }

        StringBuilder lastLine=new StringBuilder();
        for(int i=0; i<currentLineWords.size(); i++){
            lastLine.append(currentLineWords.get(i));
            if(i!=currentLineWords.size()-1)  lastLine.append(" ");
        }
        while(lastLine.length()<width)  lastLine.append(" ");
        lines.add(lastLine.toString());
        return lines;
    }

    public static List<String> centerAlign(List<String> words, int width){
        List<String> lines=new ArrayList<>();
        StringBuilder current=new StringBuilder();
        int length=0;

        for(String word : words){
            if(length+word.length()+(current.length()>0 ? 1 : 0)<=width){
                if(current.length()>0)  current.append(" ");
                current.append(word);
                length+=word.length();
            }
            else{
                int padding=(width-current.length())/2;
                StringBuilder line=new StringBuilder();

                for(int i=0; i<padding; i++)  line.append(" ");
                line.append(current);
                while(line.length()<width)  line.append(" ");
                lines.add(line.toString());

                current.setLength(0);
                current.append(word);
                length=word.length();
            }
        }

        int padding=(width-current.length())/2;
        StringBuilder lastLine=new StringBuilder();

        for(int i=0; i<padding; i++)  lastLine.append(" ");
        lastLine.append(current);
        while(lastLine.length()<width)  lastLine.append(" ");
        lines.add(lastLine.toString());

        return lines;
    }

    public static void comparePerformance(List<String> words, int width){
        long start, end;

        start=System.nanoTime();
        justifyText(words,width);
        end=System.nanoTime();
        long sbTime=end-start;

        start=System.nanoTime();
        List<String> lines=new ArrayList<>();
        String line="";
        int len=0;

        for(String word : words){
            if(len+word.length()+(line.isEmpty() ? 0 : 1)<=width){
                if(!line.isEmpty())  line+=" ";
                line+=word;
                len+=word.length();
            }
            else{
                lines.add(line);
                line=word;
                len=word.length();
            }
        }
        if(!line.isEmpty())  lines.add(line);
        end=System.nanoTime();
        long strTime=end-start;

        System.out.println("\n====== Performance Comparison ======");
        System.out.println("StringBuilder Justify Time   : "+sbTime+" ns");
        System.out.println("String Concatenation Time    : "+strTime+" ns");
    }

    public static void displayFormatted(List<String> lines){
        for(int i=0; i<lines.size(); i++){
            String line=lines.get(i);
            System.out.printf("%2d | %-50s | (%d chars)\n", i+1, line, line.length());
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter text to format:");
        String text=input.nextLine();

        System.out.print("Enter desired line width: ");
        int width =input.nextInt();
        input.close();

        List<String> words=splitWords(text);

        List<String> justified=justifyText(words,width);
        List<String> centered=centerAlign(words,width);

        System.out.println("\n====== Original Text ======");
        System.out.println(text);

        System.out.println("\n====== Left-Justified Text ======");
        displayFormatted(justified);

        System.out.println("\n====== Center-Aligned Text ======");
        displayFormatted(centered);

        comparePerformance(words, width);
    }
}
