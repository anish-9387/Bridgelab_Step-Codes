import java.util.Scanner;

public class TextBasedCalculator{
    public static boolean validateExpression(String expr){
        int balance=0;
        char prev=' ';

        for(int i=0; i<expr.length(); i++){
            char ch=expr.charAt(i);

            if(!(ch>='0' && ch<='9') && ch!='+' && ch!='-' && ch!='*' && ch!='/' && ch!='(' && ch!=')' && ch!=' '){
                return false;
            }

            if(ch=='(')  balance++;
            if(ch==')')  balance--;

            if((ch=='+' || ch=='-' || ch=='*' || ch=='/') && (prev=='+' || prev=='-' || prev=='*' || prev=='/')){
                return false;
            }

            if(balance<0)  return false;
            prev=ch;
        }
        return balance==0;
    }

    public static int evaluateExpression(String expr, StringBuilder steps){
        while(expr.contains("(")){
            int close=expr.indexOf(")");
            int open=expr.lastIndexOf("(",close);
            String inside=expr.substring(open + 1, close);
            int val=evaluateExpression(inside,steps);
            expr=expr.substring(0, open)+val+expr.substring(close+1);
            steps.append("Evaluate (").append(inside).append(") → ").append(val).append("\n");
        }

        int[] numbers=new int[100];
        char[] operators=new char[100];
        int nIndex=0, oIndex=0;

        for(int i=0; i<expr.length(); ){
            char ch=expr.charAt(i);
            if(ch==' '){
                i++;
                continue;
            }
            if(ch>='0' && ch<='9'){
                int j=i;

                while(j<expr.length() && expr.charAt(j)>='0' && expr.charAt(j)<='9') j++;
                numbers[nIndex++]=Integer.parseInt(expr.substring(i,j));
                i=j;
            }
            else{
                operators[oIndex++]=ch;
                i++;
            }
        }

        for(int i=0; i<oIndex; i++){
            if(operators[i]=='*' || operators[i]=='/'){
                int result=(operators[i]=='*') ? numbers[i]*numbers[i+1] : numbers[i]/numbers[i+1];
                steps.append(numbers[i]).append(" ").append(operators[i]).append(" ").append(numbers[i+1]).append(" = ").append(result).append("\n");

                numbers[i]=result;
                for(int j=i+1; j<nIndex-1; j++)  numbers[j]=numbers[j+1];
                for(int j=i; j<oIndex-1; j++)  operators[j]=operators[j+1];
                nIndex--;
                oIndex--;
                i--;
            }
        }

        int result=numbers[0];
        int k=1;
        for(int i=0; i<oIndex; i++){
            if(operators[i]=='+'){
                steps.append(result).append(" + ").append(numbers[k]).append(" = ");
                result+=numbers[k];
                steps.append(result).append("\n");
            }
            else if(operators[i]=='-'){
                steps.append(result).append(" - ").append(numbers[k]).append(" = ");
                result-=numbers[k];
                steps.append(result).append("\n");
            }
            k++;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Text-Based Calculator");
        System.out.println("=====================");
        System.out.print("Enter number of expressions: ");
        int n=input.nextInt();
        input.nextLine();

        for(int i=0; i<n; i++){
            System.out.print("\nEnter expression "+(i+1)+": ");
            String expr=input.nextLine();

            if(!validateExpression(expr)){
                System.out.println("Invalid expression format!");
                continue;
            }

            StringBuilder steps=new StringBuilder();
            steps.append("\nOriginal Expression: ").append(expr).append("\n");

            int result=evaluateExpression(expr,steps);
            steps.append("Final Result: ").append(result).append("\n");

            System.out.println("\nCalculation Steps:\n"+steps);
        }
        input.close();
    }
}
