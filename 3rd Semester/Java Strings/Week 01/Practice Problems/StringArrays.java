public class StringArrays{
    public static String findLongestName(String[] names){
        String longest="";
        int length=0;

        for(int i=0; i<names.length; i++){
            int count=0;
            for(int j=0; j<names[i].length(); j++){
                count++;
            }

            if(count>=length){
                longest=names[i];
                length=count;
            }
        }
        return longest;
    }

    public static int countNamesStartingWith(String[] names, char letter){
        int count=0;

        for(int i=0; i<names.length; i++){
            if((names[i].toUpperCase().charAt(0))==letter){
                count++;
            }
        }
        return count;
    }
    
    public static String[] formatNames(String[] names){
        String[] formatNames=new String[names.length];

        for(int i=0; i<names.length; i++){
            String[] name=names[i].split(" ");
            formatNames[i]=name[1]+" "+name[0];
        }
        return formatNames;
    }

    public static void main(String[] args){
        String[] students={"John Smith","Alice Johnson","Bob Brown","Carol Davis","David Wilson"};

        System.out.println("Longest name in students is: "+findLongestName(students));
        System.out.println("Number of students whose name starts with the letter 'A': "+countNamesStartingWith(students,'A'));

        System.out.println("Formatted names array:");
        String[] formattedNames=formatNames(students);
        for(int i=0; i<formattedNames.length; i++){
            System.out.println(formattedNames[i]);
        }
    }
}