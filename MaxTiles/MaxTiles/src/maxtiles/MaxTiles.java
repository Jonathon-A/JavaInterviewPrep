package maxtiles;

public class MaxTiles {

    public static void main(String[] args) {

        Tile[][] board = {
            {new Tile(1), new Tile(1), new Tile(2), new Tile(3)},
            {new Tile(1), new Tile(2), new Tile(3), new Tile(2)},
            {new Tile(3), new Tile(2), new Tile(2), new Tile(2)}
        };
        int count = 0;
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                    sum = 0;
                    ConnectedTypes(board,  i,  j);
                    if(sum > count){
                    count = sum;
                    }
            }

        }
        System.out.println(count);
    }
    private static int sum = 0;
    
    private static void ConnectedTypes(Tile[][] board, int i, int j){
    
       sum+= 1;
       board[i][j].did = true;
       if(board[Math.min(i + 1, board.length - 1)][j].type == board[i][j].type && !board[Math.min(i + 1, board.length - 1)][j].did){
           ConnectedTypes(board, Math.min(i + 1,board.length - 1),j);
       }
       
       
       if(board[Math.max(i - 1, 0)][j].type == board[i][j].type && !board[Math.max(i - 1, 0)][j].did){
           ConnectedTypes(board, Math.min(i - 1,0),j);
       }
       
       
       if(board[i][Math.min(j + 1, board[0].length - 1)].type == board[i][j].type && !board[i][Math.min(j + 1, board[0].length - 1)].did){
           ConnectedTypes(board, i, Math.min(j + 1, board[0].length - 1));
       }
       
       
       if(board[i][Math.max(j - 1, 0)].type == board[i][j].type && !board[i][Math.max(j - 1,0)].did){
           ConnectedTypes(board, i, Math.max(j + 1, 0));
       }
       
        
        
   
    }
}
