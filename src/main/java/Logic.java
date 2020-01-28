import maths.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logic {
    private  MathOperation currentOperation;

    public void start(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numbersAndOperation = "";
        int resultNumber;

        while (true) {  //не много не понял, нужно ли было позволять пользователю вводить до тех пор пока не допустит ошибку, или один раз вводить (оставил вариант с повторением ввода
            try {
                System.out.println("Input:");
                numbersAndOperation = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Check.isCorrectStringForArab(numbersAndOperation)) { //проверяем введенную строку через регулярное выражение
                numbersAndOperation = numbersAndOperation.replaceAll(" ", ""); //убираем пробелы
                String[] num1Andnum2 = numbersAndOperation.split("[-+/*]"); //делем строку и получаем два введеных числа
                int numb1 = Integer.parseInt(num1Andnum2[0]);
                int numb2 = Integer.parseInt(num1Andnum2[1]);
                currentOperation = getMathOperation(numbersAndOperation); //узнаем знак операции
                System.out.println("Output:");
                resultNumber = result(currentOperation, numb1, numb2);//выполняем указанное действие
                System.out.println(resultNumber);
            } else if (Check.isCorrectStringForRoman(numbersAndOperation)) {
                numbersAndOperation = numbersAndOperation.replaceAll(" ", "");
                String[] num1Andnum2 = numbersAndOperation.split("[-+/*]");
                currentOperation = getMathOperation(numbersAndOperation);
                resultNumber = result(currentOperation, Convert.letterToNumber(num1Andnum2[0]), Convert.letterToNumber(num1Andnum2[1]));
                System.out.println("Output:");
                if(Check.isNegativeNumberForRoman(resultNumber)){ //не знаю наверное это не так нужно делать, здесь проверяем число на то является отрицательным или нет
                    System.out.println("-"+Convert.toRoman(Math.abs(resultNumber)));// убираем знак с арабского числа,конвертируем и ставим '-' перед числом в римской системе
                } else {
                    System.out.println(Convert.toRoman(resultNumber));
                }
            } else {
                throw new RuntimeException();

            }
        }

    }

    public int result(MathOperation operation, int numberOne, int numberTwo){
       return operation.execute(numberOne,numberTwo);
    }



    public MathOperation getMathOperation(String inputOp){
        if (inputOp.contains("-")) {
            return   new Sub();
        } else if (inputOp.contains("+")) {
           return   new Add();
        } else if (inputOp.contains("*")) {
            return new Mult();
        } else if (inputOp.contains("/")) {
            return new Div();
        }
        return null;
    }



}
