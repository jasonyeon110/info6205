package HW8;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int result = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            result ++;

            while (size-- > 0){
                String current = queue.poll();
                if(current.equals(endWord)){
                    return result;
                }
                char[] letters = current.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    char temp = letters[i];
                    for(char j='a'; j<='z'; j++){
                        letters[i] = j;
                        String newWord = new String(letters);

                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    letters[i] = temp;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LinkedList<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println("queue " + wordList);

        System.out.println(ladderLength("hit", "cog", wordList));

    }
}
