package leetcode;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("9223372036854775808"));
	}
	
	public static int myAtoi(String s) {
        if(s == null || s.trim().length() ==0){
            return 0;
        }
        
        s = s.trim();
        char ch = s.charAt(0);
        if(!((ch == '+' || ch=='-') || (ch>='0' && ch<='9'))){
            return 0;
        }
        
        int index = 0;
        boolean isNegative = false;
        if(ch == '+' || ch=='-'){
            index++;
            if(ch == '-'){
                isNegative = true;
            }
        }
        long number = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if(!(c>='0' && c<='9')){
                break;
            }
            int val = c - '0';
            number = number*10 + val;
            index++;
        }
        
        if(isNegative){
            if(number > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }

        }
        if(number > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        return (int) number;
    }

}
