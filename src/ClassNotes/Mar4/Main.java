package ClassNotes.Mar4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//      generateBinarySeq(3);
//      generateMarySeq(3,3);
//      combinations("ABC", 3);
//      generateAllSubsets("ABC");
        int[] arr = {10,10,5,1,25,5,5,5,5};
        generateAllSeqSumEqualtoK(arr, 25);

    }



        private static void generateBinarySeq(int n){
            if(n <= 0 ){
                return;
            }
            int[] result = new int[n];
            int current = 0;
            generateBinarySeq(result, current);
        }

        private static void generateBinarySeq(int[] result, int current){
            if(current == result.length){
                System.out.println(Arrays.toString(result));
                return;
            }

            for (int i = 0; i < 2; i++) {
                result[current] = i;
                generateBinarySeq(result, current + 1);
            }
        }

        //m = number of integers
        //n = size of the array
        public static void generateMarySeq(int n, int m){
            if (n <= 0 || m <= 0) {
                return;
            }
            int[] result = new int[n];
            int current = 0;
            generateMarySeq(result, current, m);
        }

        private static void generateMarySeq(int[] result, int current, int m){
            if(current == result.length){
                System.out.println(Arrays.toString(result));
                return;
            }

            for (int i = 0; i < m; i++) {
                result[current] = i;
                generateMarySeq(result, current+1, m);
            }
        }

        public static void combinations(String str, int size){
        if(size <= 0 || str.isEmpty()){
            return;
        }

        char[] result = new char[size];
        int current = 0;
        combinations(result, current, str);
    }

    private static void combinations(char[] result, int current, String str){
        if(current == result.length){
            System.out.println(new String(result));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            result[current] = str.charAt(i);
            combinations(result, current + 1, str);

        }
    }
//
//    public static void printCombination(int[] result, String str){
//        char[] arr = str.toCharArray();
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(arr[result[i]] + ",");
//        }
//        System.out.println();
//    }

    public static void generateAllSubsets(String str){
        if(str.isEmpty()){
            return;
        }

        int[] result = new int[str.length()];
        int current = 0;
        generateAllSubsets(result, current, str);
    }

    public static void generateAllSubsets(int[] result, int current, String str){
        if(current == result.length){
            printSubsets(result, str);
            return;
        }
        for (int i = 0; i < 2; i++) {
            result[current] = i;
            generateAllSubsets(result, current + 1, str);
        }
    }

    private static void printSubsets(int[] result, String str){
        char[] arr = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < result.length; i++) {
            if(result[i] == 1){
                sb.append(arr[i] + ", ");
            }
        }
        if(sb.length() > 1 ){
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        //drop the last
        sb.append("}");
        System.out.println(sb.toString());
    }

    public static void generateAllSeqSumEqualtoK(int[] arr, int k){
        if(k <= 0 || arr.length == 0){
            return;
        }

        int[] result = new int[arr.length];
        int current = 0;
        generateAllSeqSumEqualtoK(result, current, arr, k);
    }

    private static void generateAllSeqSumEqualtoK(int[] result, int current, int[] arr, int k){
        if(current == result.length){
            printSumEqualToK(result, arr, k);
            return;
        }

        for (int i = 0; i < 2; i++) {
            result[current] = i;
            generateAllSeqSumEqualtoK(result, current + 1, arr, k);
        }
    }

    private static void printSumEqualToK(int[] result, int[] arr, int k){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            if(result[i] == 1){
                sum += arr[i];
                sb.append(arr[i] + ", ");
            }
        }
        if(sb.length() > 1){
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        if(sum == k){
            System.out.println(sb.toString());
        }
    }

    public static void permutations(String str){
        if(str.isEmpty()){
            return;
        }
        int[] result = new int[str.length()];
        int current = 0;
    }

//    public static void premutations(int[] result, int current, String str){
//        if(current == result.length){
//            //print
//            return;
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//            if(is)
//            result[current] = i;
//        }
//    }
//
//    private static boolean isValidPermutation(int[] result, int current, int num){
//        for (int i = 0; i < current; i++) {
//
//        }
//    }

}
