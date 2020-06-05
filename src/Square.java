/*
** Class Description: holds the color, row, and column values for a given location/cell/square on the puzzle board
** Name: Michael Chu
** Period: 3
** Date: 5/29/20
** Version: 1
 */

public class Square
{
    private int color;
    private int row;
    private int col;
    
    //creates a new random square (white or black)
    public Square()
    {
        color = (int)(Math.random()*2);
        row = 0;
        col = 0;
    }

    //creates a new random square for a given cell in the puzzle(white or black) 
    public Square(int r, int c)
    {
        color = (int)(Math.random()*2);
        row = r;
        col = c;
    }
    
    //switches the color of the square
    public void changeColor()
    {
        if(color == 1)
            color = 0;
        else
            color = 1;
    }
    
    //returns the color of the square
    public int getColor()
    {
        return color;
    }
    
    //returns the x position relative to the board of the square
    public int getRow()
    {
        return row;
    }
 
    //returns the y position relative to the board of the square
    public int getCol()
    {
        return col;
    }
    
    //sets the color of the square to a given value
    public void setColor(int newColor)
    {
        color = newColor;
    }
}
