package HW5;

public class ReorganizeString {
    public String reorganizeString(String S) {
        int alphabet = 26;
        int[] count = new int[alphabet];

        for(char c: S.toCharArray()){
            count[c - 'a']++;
        }

        int max = count[0];
        int maxIndex = 0;

        for (int i = 0; i < alphabet; i++) {
            if(count[i] > max){
                max = count[i];
                maxIndex = i;
            }
        }

        if(max - 1 > S.length() - max){
            return "";
        }

        StringBuilder[] contain = new StringBuilder[max];

        for (int i = 0; i < max; i++) {
            contain[i] = new StringBuilder();
            contain[i].append((char)(maxIndex + 'a'));
        }
        int index = 0;
        for (int i = 0; i < alphabet; i++) {
            if(i == maxIndex || count[i] == 0){
                continue;
            }
            char charac = (char)('a' + i);

            for (int j = 0; j < count[i]; j++){
                contain[index++].append(charac);
                index %= max;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: contain){
            result.append(sb);
        }
        return result.toString();
    }
}
