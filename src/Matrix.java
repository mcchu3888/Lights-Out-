/*
** Class Description: Contains mathematical functions for matricies that are used to solve lights out. All operations are done in mod 2
** Name: Michael Chu
** Period: 3
** Date: 5/29/20
** Version: 1
 */

public class Matrix extends OperatorsMod2
{
    private int[][]fullMatrix;
    private int[][]Amatrix;
    private int[][]bVector;
    private int rows;
    private int cols;
    
    //creates a new matrix for a given 2d array
    public Matrix(int[][]mat)
    {
        fullMatrix = mat;
        rows = mat.length;
        cols = mat[0].length - 1;
        Amatrix = new int[rows][cols];
        bVector = new int[rows][1];
        
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                Amatrix[i][j] = mat[i][j];
            
        for(int k = 0; k < rows; k++)
            bVector[k][0] = mat[k][cols];
            
    }
    
    //returns the number of columns in the adjacent matrix
    public int getCols()
    {
        return cols;
    }
    
    //returns the number of rows
    public int getRows()
    {
        return rows;
    }
    
    //returns the value of a given cell in the adjacent matrix
    public int get(int row, int col)
    {
        return Amatrix[row][col];
    }
    
    //returns the value of a given cell in the board vector(last column of the full matrix)
    public int getBVector(int row, int col)
    {
        return bVector[row][col];
    }
    
    //sets a given cell in the adjecent matrix to a given value
    public void set(int row, int col, int val)
    {
        Amatrix[row][col] = val;
    }
    
    //sets a given cell in the board vector to a given value
    public void setBVector(int row, int col, int val)
    {
        bVector[row][col] = val;
    }
    
    //returns the board vector
    public int[][]getBVector()
    {
        return bVector;
    }
    
    //returns the adjacent matrix
    public int [][]getAMatrix()
    {
      return Amatrix;  
    }
    
    //returns the full matrix
    public int[][]getFullMatrix()
    {
        return fullMatrix;
    }
    
    //swaps two given rows in the full matrix
    public void swapRows(int row1, int row2)
    {
        int[]temp = Amatrix[row1];
        Amatrix[row1] = Amatrix[row2];
        Amatrix[row2] = temp;
        
        int [] temp2 = bVector[row1];
        bVector[row1] = bVector[row2];
	bVector[row2] = temp2;
    }
    
    //multiplies all the values in a given row in the matrix by a given factor (mod 2)
    public void multiplyRow(int row, int factor)
    {
        for(int i = 0; i < cols; i++)
            set(row, i, multiply(get(row,i), factor));
        setBVector(row, 0, multiply(getBVector(row,0), factor));
    }
    
    //adds two given rows in the matrix and multiplies one of the rows by a given factor before adding if necesssary (mod 2)
    public void addRows(int row1, int row2, int factor)
    {
        for(int i = 0; i < cols; i++)
            set(row2, i, add(get(row2, i), multiply(get(row1, i),factor)));
        setBVector(row2, 0, add(getBVector(row2, 0), multiply(getBVector(row1 ,0), factor)));
    }
    
    //multiplies two matricies and returns the resulting matrix (mod 2)
    public Matrix multiplyMatrix(Matrix m)
    {
        if(cols + 1 == m.getRows())
        {
            int res[][] = new int[rows][m.getCols()];
            
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < m.getCols(); j++)
                {
                    int sum = 0;
                    for(int k = 0; k < cols + 1; k++)
                        sum = add(multiply(get(i,k), m.get(k,j)), sum);
                    res[i][j] = sum;
                }
                
            }
            Matrix mRes = new Matrix(res);
            return mRes;
        }
        else 
            throw new IllegalArgumentException("matrix size wrong bro.");
    }
    
    //completes the process of putting the matrix into reduced row echelon form 
    public void rref()
    {
        int numOfPivots = 0;
        
        for(int i = 0; i < cols; i++)
        {
            int pivotRow = numOfPivots;
            while(pivotRow < rows && equals(get(pivotRow,i), 0))
                pivotRow++;
            if(pivotRow == rows)
                continue;
            swapRows(numOfPivots, pivotRow);
            pivotRow = numOfPivots;
            numOfPivots++;
            
            try
            {
                 multiplyRow(pivotRow, reciprocal(get(pivotRow, i)));
            }
            catch(IllegalArgumentException e)
            {
                
            }
            
            for(int j = pivotRow + 1; j < rows; j++)
                addRows(pivotRow, j, negate(get(j,i)));
            
        }
        
        for(int k = rows - 1; k >= 0; k--)
        {
            int pivotCol = 0;
            while (pivotCol < cols && equals(get(k, pivotCol), 0))
                pivotCol++;
            if(pivotCol == cols)
                continue;
            for(int f = k - 1; f >= 0; f--)
                addRows(k, f, negate(get(f, pivotCol)));
            
        }
    }
}