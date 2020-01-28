package maths;

public class Div implements MathOperation{
    public int execute(int numberOne, int numberTwo) {
        if(numberTwo==0){
            throw new ArithmeticException("На 0 делить нельзя!");
        }
        return numberOne / numberTwo;
    }
}
