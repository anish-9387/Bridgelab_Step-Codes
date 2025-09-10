import java.util.*;

class EmailDetails{
    String email;
    String username;
    String domain;
    String domainName;
    String extension;
    boolean isValid;

    EmailDetails(String email, boolean isValid, String username, String domain, String domainName, String extension){
        this.email=email;
        this.isValid=isValid;
        this.username=username;
        this.domain=domain;
        this.domainName=domainName;
        this.extension=extension;
    }
}

public class EmailAnalyzerNoMap{
    public static boolean validateEmail(String email){
        int atIndex=email.indexOf('@');
        int lastAtIndex=email.lastIndexOf('@');

        if(atIndex==-1 || atIndex!=lastAtIndex)  return false;

        int dotIndex=email.indexOf('.', atIndex);
        if(dotIndex==-1)  return false;

        if(atIndex==0 || atIndex==email.length()-1)  return false;

        String username=email.substring(0,atIndex);
        String domain=email.substring(atIndex+1);
        if(username.isEmpty() || domain.isEmpty())  return false;

        return true;
    }

    public static EmailDetails extractComponents(String email){
        if(!validateEmail(email)){
            return new EmailDetails(email,false,"-","-","-","-");
        }

        int atIndex=email.indexOf('@');
        int dotIndex=email.lastIndexOf('.');

        String username=email.substring(0,atIndex);
        String domain=email.substring(atIndex+1);
        String domainName=(dotIndex>atIndex) ? email.substring(atIndex+1, dotIndex) : domain;
        String extension=(dotIndex>atIndex) ? email.substring(dotIndex+1) : "";

        return new EmailDetails(email,true,username,domain,domainName,extension);
    }

    public static void analyzeStatistics(List<String> emails){
        int validCount=0, invalidCount=0, totalUsernameLength=0;

        List<String> domainNames=new ArrayList<>();
        List<Integer> domainCounts=new ArrayList<>();

        System.out.printf("%-30s %-15s %-20s %-15s %-10s %-10s\n",
                "Email", "Username", "Domain", "Domain Name", "Ext", "Valid?");

        System.out.println("-------------------------------------------------------------------------------------------");

        for(String email : emails){
            EmailDetails details=extractComponents(email);

            if(details.isValid){
                validCount++;
                totalUsernameLength+=details.username.length();

                if(!domainNames.contains(details.domainName)){
                    domainNames.add(details.domainName);
                    domainCounts.add(1);
                }
                else{
                    int idx=domainNames.indexOf(details.domainName);
                    domainCounts.set(idx, domainCounts.get(idx)+1);
                }

                System.out.printf("%-30s %-15s %-20s %-15s %-10s %-10s\n", details.email, details.username, details.domain, details.domainName, details.extension, "Valid");

            }
            else{
                invalidCount++;
                System.out.printf("%-30s %-15s %-20s %-15s %-10s %-10s\n", details.email, "-", "-", "-", "-", "Invalid");
            }
        }

        System.out.println("\n====== Email Analysis Summary ======");
        System.out.println("Total Valid Emails   : "+validCount);
        System.out.println("Total Invalid Emails : "+invalidCount);

        if(validCount>0){
            double avgLength=(double)totalUsernameLength/validCount;
            System.out.printf("Average Username Length: %.2f\n", avgLength);

            int maxCount=-1;
            String mostCommonDomain="";

            for(int i=0; i<domainNames.size(); i++){
                if(domainCounts.get(i)>maxCount){
                    maxCount=domainCounts.get(i);
                    mostCommonDomain=domainNames.get(i);
                }
            }
            System.out.println("Most Common Domain   : "+mostCommonDomain);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        List<String> emails=new ArrayList<>();

        System.out.print("Enter number of emails: ");
        int n=input.nextInt();
        input.nextLine();

        for(int i=0; i<n; i++){
            System.out.print("Enter email "+(i+1)+": ");
            emails.add(input.nextLine());
        }

        analyzeStatistics(emails);
        input.close();
    }
}
