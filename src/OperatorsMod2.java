/*
** Class Description: In lights out, all mathematical operations must be done in modulo 2. This class creates basic field operators for mod 2 to be used by other classes.
** Name: Michael Chu
** Period: 3
** Date: 5/29/20
** Version: 1
 */

public class OperatorsMod2 
{
    //addition in mod 2
    public int add(int x, int y)
    {
        return (x+y) % 2;
    }
    
    //multiiplication in mod 2
    public int multiply(int x, int y)
    {
        return (x * y) % 2;
    }
    
    //returns the negation of a given value 
    public int negate(int x)
    {
        return multiply(x, -1);
    }
    
    //returns the reciprocal of a given value
    public int reciprocal(int x) throws IllegalArgumentException
    {
        for (int i = 1; i >= 0; i--)
        {
            if((x*i) % 2 == 1)
                return i;
        }
        throw new IllegalArgumentException("Multiplicative inverse does not exist dum dum");
    }
    
    //subtraction in mod 2
    public int subtract(int x, int y)
    {
        return add(x, negate(y));
    }
    
    //division in mod 2
    public int divide(int x, int y)
    {
        return multiply(x, reciprocal(y));
    }
    
    //checks if two values are equal
    public boolean equals(int x, int y)
    {
        return x==y;
    }
}

