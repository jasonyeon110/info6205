package FinalExam;

public class Problem1 {

    public static String getResult(char[][] body, int maxTime){

        for (int i = 0; i < body.length; i++) {
            for (int j = 0; j < body[i].length; j++) {
                char pointer = body[i][j];
                if(maxTime <= 0){
                    return "cannot infect";
                }
                if(pointer == 'O'){
                    transverBody(i,j,body);
                    maxTime --;
                }
            }
        }
        return "can infect";
    }

    private static void transverBody(int row, int col, char[][] body){
        if(col < 0 || row < 0 || col >= body[0].length || row >= body.length || body[row][col] == 'O'){
            return;
        }
        body[row][col] = 'X';
        transverBody(row, col + 1, body);
        transverBody(row, col -1, body);
        transverBody(row+1, col, body);
        transverBody(row-1, col, body);
    }

    public static void main(String[] args) {
        //time complexity: O(m X n); m = # of rows, n = # of col
        //space complexity: O(m X n);
        char[][] body = {
                {'O','O','X','O'},
                {'X','O','X','X'},
                {'X','O','O','O'}
        };

        System.out.println(getResult(body, 6));

    }
}
