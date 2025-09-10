import java.util.*;

class FileInfo{
    String originalName, baseName, extension, category, suggestedName, subCategory;
    boolean valid;

    FileInfo(String originalName){
        this.originalName=originalName;
    }
}

public class FileOrganizer{
    static Scanner input=new Scanner(System.in);
    static List<FileInfo> files=new ArrayList<>();
    static Map<String, Integer> categoryCount=new HashMap<>();
    static Set<String> usedNames=new HashSet<>();

    public static void main(String[] args){
        System.out.println("Enter file names with extensions (end with empty line):");
        while(true){
            String name=input.nextLine().trim();
            if(name.isEmpty())  break;
            files.add(new FileInfo(name));
        }

        for(FileInfo f : files){
            extractComponents(f);
        }

        for(FileInfo f : files){
            categorizeFile(f);
        }

        for(FileInfo f : files){
            contentAnalysis(f);
        }

        for(FileInfo f : files){
            generateNewName(f);
        }

        displayReport();
        generateBatchRename();
    }

    static void extractComponents(FileInfo file){
        String name=file.originalName;
        int dot=name.lastIndexOf('.');

        if(dot==-1 || dot==0 || dot==name.length()-1){
            file.valid=false;
            file.baseName=name;
            file.extension="";
            return;
        }

        file.baseName=name.substring(0,dot);
        file.extension=name.substring(dot).toLowerCase();

        file.valid=true;
        for(int i=0; i<file.baseName.length(); i++){
            char c=file.baseName.charAt(i);
            if(!Character.isLetterOrDigit(c) && c!='_' && c!='-'){
                file.valid=false;
                break;
            }
        }
    }

    static void categorizeFile(FileInfo file){
        String ext=file.extension;
        if(ext.equals(".txt") || ext.equals(".doc"))  file.category="Document";
        else if(ext.equals(".jpg") || ext.equals(".png"))  file.category="Image";
        else if(ext.equals(".mp3"))  file.category="Audio";
        else if(ext.equals(".mp4"))  file.category="Video";
        else if(ext.equals(".java") || ext.equals(".py"))  file.category="Code";
        else  file.category="Unknown";

        categoryCount.put(file.category, categoryCount.getOrDefault(file.category,0)+1);
    }

    static void contentAnalysis(FileInfo file){
        if(!file.category.equals("Document") && !file.category.equals("Code")) return;

        String text=file.baseName.toLowerCase();

        if(file.category.equals("Document")){
            if(text.contains("resume"))  file.subCategory="Resume";
            else if(text.contains("report"))  file.subCategory="Report";
            else  file.subCategory="GeneralDoc";
        }
        else if(file.category.equals("Code")){
            if(text.contains("test"))  file.subCategory="TestCode";
            else  file.subCategory="SourceCode";
        }

        for(int i=0; i<text.length(); i++){
            if(text.charAt(i)<32 || text.charAt(i)>126){
                file.valid=false;
                break;
            }
        }
    }

    static void generateNewName(FileInfo file){
        StringBuilder sb=new StringBuilder();

        sb.append(file.category);
        if(file.subCategory!=null)  sb.append("_").append(file.subCategory);

        sb.append("_").append(java.time.LocalDate.now());

        String candidate=sb.toString();
        int counter=1;
        while(usedNames.contains(candidate)){
            candidate=sb.toString()+"_"+counter;
            counter++;
        }
        usedNames.add(candidate);

        file.suggestedName=candidate+file.extension;
    }

    static void displayReport(){
        System.out.println("\n====== File Organization Report ======");
        System.out.printf("%-20s %-12s %-25s %-10s\n", "Original", "Category", "Suggested Name", "Valid?");

        for(FileInfo f : files){
            System.out.printf("%-20s %-12s %-25s %-10s\n", f.originalName, f.category, f.suggestedName, f.valid ? "Yes" : "No");
        }

        System.out.println("\nCategory Counts:");
        for(Map.Entry<String, Integer> e : categoryCount.entrySet()){
            System.out.println(" - "+e.getKey()+": "+e.getValue());
        }
    }

    static void generateBatchRename(){
        System.out.println("\n====== Batch Rename Commands ======");
        for(FileInfo f : files){
            if(f.valid && !f.category.equals("Unknown")){
                System.out.println("rename \""+f.originalName+"\" -> \""+f.suggestedName+"\"");
            }
            else{
                System.out.println("SKIP (invalid/unknown): "+f.originalName);
            }
        }
    }
}
