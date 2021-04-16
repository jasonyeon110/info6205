package HW7;

public class ReverseWord {
    public String reverseWords(String s) {

        String[] strArr = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = strArr.length-1; i>=0; i--){
            if (strArr[i].trim().length() > 0)
                sb.append(strArr[i]+" ");
        }

        return sb.toString().trim();
    }
}
