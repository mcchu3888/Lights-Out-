/*
** Class Description: holds the values and toggle rules of any lights out configuration and creates new, random lights out puzzles for any given size
** Name: Michael Chu
** Period: 3
** Date: 5/29/20
** Version: 1
 */


import java.util.ArrayList;
/**
 *
 * @author mcchu
 */
public class Board
{
    private Square[][] board;
    private int numOfRows;
    private int numOfCols;
    private int squareSize;
    
    //default to 3/3 random lights out 
    public Board()
    {
        board = new Square[3][3];
        numOfRows = 3;
        numOfCols = 3;
        squareSize = 400/3;
          
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                board[i][j] = new Square(i,j);
    }
    
    //creates a new, random lights out puzzle for a given board size. Ensures all puzzles are solvable
    public Board(int rows, int cols)
    {
        board = new Square[rows][cols];
        numOfRows = rows;
        numOfCols = cols;
        squareSize = 400/rows;
        
         for(int i = 0; i < board.length; i++)
                for(int j = 0; j < board[0].length; j++)
                    board[i][j] = new Square(i,j);
         
        if(rows == 5)
        {
            while(!isSolvable(board))
            {
                for(int i = 0; i < board.length; i++)
                    for(int j = 0; j < board[0].length; j++)
                       board[i][j] = new Square(i,j);
            }
            
            ArrayList<Square>allMoves = allPossibleMoves();
            for(int k = 0; k < (int)(Math.random()* (board.length * board[0].length+1)); k++)
            {
                Square s = allMoves.get((int)(Math.random()*allMoves.size()));
                int randCol = s.getCol();
                int randRow = s.getRow();
       
                move(randRow, randCol);
                allMoves.remove(s);
            }
        }
    }
    
    //checks if a random 5x5 lights out is solvable using orthogonal vecotors/dot product since not all 5x5 lights out configuations are solvable 
    public boolean isSolvable(Square[][] board)
    {
         int[]v1 = {0,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0};
         int[]v2 = {1,0,1,0,1,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,1,0,1,0,1};
         int dotpod1 = 0;
         int dotpod2 = 0;
         int idx = 0;
         
         for(int i = 0; i < board.length; i++)
         {
             for(int j = 0; j < board[0].length; j++)
             {
                 dotpod1 += v1[idx]*board[i][j].getColor();
                 dotpod2 += v2[idx]*board[i][j].getColor();
                 idx++;
             }
         }
         
         if(dotpod1 == 0 && dotpod2 == 0)
             return true;
         else
             return false;
    }
    
    //checks if the board is all white/terminal state
    public boolean isWinningMove()
    {
        int counter = 0;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j].getColor() == 0)
                    counter ++;
            }
        }
        if(counter == board.length*board[0].length)
            return true;
        else
            return false;
    }
    
    //makes changes to the puzzle if a square is selected based on the toggle rules of the puzzle
    public void move(int row, int col)
    {
        //check if user selected square is one of the four corners
        if(row == 0 && col == 0)
        {
            getSquare(row, col + 1).changeColor();
            getSquare(row + 1, col).changeColor();
        }
        else if(row == 0 && col == numOfCols - 1)
        {
            getSquare(row + 1, col).changeColor();
            getSquare(row, col - 1).changeColor();
        }
        else if(row == numOfRows - 1 && col == 0)
        {
            getSquare(row-1, col).changeColor();
            getSquare(row, col + 1).changeColor();
        }
        else if(row == numOfRows - 1 && col == numOfCols - 1)
        {
            getSquare(row-1, col).changeColor();
            getSquare(row, col - 1).changeColor();
        }
        
        //check if user selected square is on a side
        else if(row == 0)
        {
            getSquare(row,col-1).changeColor();
            getSquare(row,col+1).changeColor();
            getSquare(row+1, col).changeColor();
        }
        else if(row == numOfRows - 1)
        {
            getSquare(row,col-1).changeColor();
            getSquare(row,col+1).changeColor();
            getSquare(row-1, col).changeColor();
        }
        else if(col == 0)
        {
            getSquare(row-1,col).changeColor();
            getSquare(row+1,col).changeColor();
            getSquare(row, col+1).changeColor();
        }
        else if(col == numOfCols - 1)
        {
            getSquare(row-1,col).changeColor();
            getSquare(row+1,col).changeColor();
            getSquare(row, col-1).changeColor();
        }
        
        //base case
        else
        {
            getSquare(row-1,col).changeColor();
            getSquare(row+1,col).changeColor();
            getSquare(row, col-1).changeColor();
            getSquare(row, col+1).changeColor();
        }
        
        getSquare(row,col).changeColor();
    }
    
    //Holds all the possible moves of a given puzzle
    public ArrayList<Square> allPossibleMoves()
    {
        ArrayList<Square>res = new ArrayList<Square>();
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                res.add(new Square(i,j));
        
        return res;
    }
    
    //returns the square at a given location
    public Square getSquare(int row, int col)
    {
        return board[row][col];
    }
    
    //returns the number of rows in the current puzzle
    public int getNumOfRows()
    {
        return numOfRows;
    }
    
    //returns the number of columns in the current puzzle
    public int getNumOfCols()
    {
        return numOfCols;
    }
    
    //returns the necessary pixel size for the sqaures based on the board size 
    public int getSquareSize()
    {
        return squareSize;
    }
    
    //returns the puzzle at its current state
    public Square[][]getBoard()
    {
        return board;
    }
}
