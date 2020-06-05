/*
** Class Description: AI class, finds a solution to any given lights out configuation and boardsize
** Name: Michael Chu
** Period: 3
** Date: 5/29/20
** Version: 1
 */

public class AI
{   
    private int[][]solution;
    private Board board;
    private int[]boardVector;
    private int numOfMoves;
    
    //contrusts the 
    public AI(Board b)
    {
        board = b;
        
        int idx = 0;
        boardVector = new int[board.getBoard().length*board.getBoard()[0].length];
        
        for(int i = 0; i < board.getBoard().length; i++)
        {
            for(int j = 0; j < board.getBoard()[0].length; j++)
            {
                boardVector[idx] = (board.getSquare(i,j).getColor());
                idx++;
            }
        }
        
        solution = findSolution();
        
        numOfMoves = 0;
        for(int k = 0; k < solution.length; k++)
            numOfMoves++;
    }
    
    //calculates and returns the solution to the game in terms of 1's and 0's. A 1 indicates one of the squares the user needs to click to solve the puzzle
    public int[][]findSolution()
    {
          int len = board.getBoard().length;
          int [][]solution = new int[len][len];
          int[][]augMat = getAdjMatrix(len, len);
          Matrix solver = new Matrix(augMat);
          solver.rref();
          int[][]sol = solver.getBVector();
          int idx = 0;
          
          for(int i = 0; i < len; i++)
          {
              for(int j = 0; j < len; j++)
              {
                  solution[i][j] = Math.abs(sol[idx][0]);
                  idx++;
              }
          }
          
          return solution;
    }
    
    //returns the adjacent matrix for a given board size. The adjacent matrix is representation of the toggle rules of the puzzle and is required to solve the puzzle using linear algebra
    public int[][]getAdjMatrix(int rows, int cols)
    {
        int[][]adjMatrix = new int[rows*cols][rows*cols+1];
        int rowIdx = 0;
        
        for(int k = 0; k < rows; k++)
        {
            for(int x = 0; x < cols; x++)
            {
                Board board = new Board(rows, cols);
                for(int i = 0; i < board.getBoard().length; i++)
                    for(int j = 0; j < board.getBoard()[0].length; j++)
                        board.getSquare(i,j).setColor(0);
                board.move(k,x);
                Square[][]sboard = board.getBoard();
                int[]row = new int[rows*cols + 1];
                int idx = 0;
                
                for(int i = 0; i < sboard.length; i++)
                {
                    for(int j = 0; j < sboard[0].length; j++)
                    {
                        row[idx] = sboard[i][j].getColor();
                        idx++;
                    }
                }
                adjMatrix[rowIdx] = row;
                rowIdx++;
            }
        }
        
        for(int i = 0; i < rows*cols; i++)
            adjMatrix[i][cols*rows] = boardVector[i];  
        
        return adjMatrix;
    }        
            
            
    //returns the calucated solution
    public int[][]getSolution()
    {
        return solution;
    }
    
    //sets a given value to a specific square in the solution
    public void set(int row, int col, int val)
    {
        solution[row][col] = val;
    }
    
    //returns the value of a given square in the solution
    public int get(int row, int col)
    {
        return solution[row][col];
    }
}
