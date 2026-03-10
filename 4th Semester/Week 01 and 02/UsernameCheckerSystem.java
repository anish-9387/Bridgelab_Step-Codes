import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UsernameCheckerSystem{
    private Map<String, Integer> usernameDatabase;

    private Map<String, Integer> attemptFrequency;

    public UsernameCheckerSystem(){
        usernameDatabase=new ConcurrentHashMap<>();
        attemptFrequency=new ConcurrentHashMap<>();
    }

    public void registerUser(String username, int userId){
        usernameDatabase.put(username.toLowerCase(), userId);
    }

    public boolean checkAvailability(String username){
        username=username.toLowerCase();

        attemptFrequency.put(username,attemptFrequency.getOrDefault(username,0)+1);

        return !usernameDatabase.containsKey(username);
    }

    public List<String> suggestAlternatives(String username){
        List<String> suggestions=new ArrayList<>();

        if(checkAvailability(username)){
            suggestions.add(username);
            return suggestions;
        }

        for(int i=1; i<=5; i++){
            String suggestion=username+i;
            if(!usernameDatabase.containsKey(suggestion)){
                suggestions.add(suggestion);
            }
        }

        String dotVersion=username.replace("_", ".");
        if(!usernameDatabase.containsKey(dotVersion)){
            suggestions.add(dotVersion);
        }

        String underscoreVersion=username.replace(".", "_");
        if(!usernameDatabase.containsKey(underscoreVersion)){
            suggestions.add(underscoreVersion);
        }

        return suggestions;
    }

    public String getMostAttempted(){
        String mostAttempted=null;
        int max=0;

        for(Map.Entry<String, Integer> entry : attemptFrequency.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                mostAttempted=entry.getKey();
            }
        }

        return mostAttempted+" ("+max+" attempts)";
    }

    public static void main(String[] args){
        UsernameCheckerSystem system=new UsernameCheckerSystem();

        system.registerUser("john_doe", 1);
        system.registerUser("admin", 2);
        system.registerUser("alex", 3);

        System.out.println("Check john_doe: "+system.checkAvailability("john_doe"));

        System.out.println("Check jane_smith: "+system.checkAvailability("jane_smith"));

        System.out.println("Suggestions for john_doe: "+system.suggestAlternatives("john_doe"));

        for(int i=0; i<5; i++)
            system.checkAvailability("admin");

        System.out.println("Most Attempted: "+system.getMostAttempted());
    }
}