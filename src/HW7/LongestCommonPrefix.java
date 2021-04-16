package HW7;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
       if(strs.length == 0){
           return "";
       }

       String commonPre = strs[0];

       for(String str: strs){
           while(str.indexOf(commonPre) != 0){
               commonPre = commonPre.substring(0, commonPre.length() -1);
           }
       }
       return commonPre;

    }
}
