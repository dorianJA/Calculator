import java.util.TreeMap;
//конвертация арабских чисел в римские и обратно
public class Convert {


        private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        static {

            map.put(1000, "M");
            map.put(900, "CM");
            map.put(500, "D");
            map.put(400, "CD");
            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");

        }

        public final static String toRoman(int number) {
            int l =  map.floorKey(number);  // возвращает наибольший ключ, меньший или равный ключу , или ноль, если такого ключа нет
            if ( number == l ) {
                return map.get(number);
            }
            return map.get(l) + toRoman(number-l); // используем рекурсию, если полученного числа нету в мапе, прибавляем ближайшее значение к тому числу что пришло и ркурсивно проходимся еще раз по методу вычев из введенного числа - ближайшее
        }


    public static int letterToNumber(String input){
        if(input.equals("I") )
            return 1;
        if(input.equals("II") )
            return 2;
        if(input.equals("III") )
            return 3;
        else if(input.equals("IV"))
            return 4;
        else if(input.equals("V"))
            return 5;
        else if(input.equals("VI"))
            return 6;
        else if(input.equals("VII"))
            return 7;
        else if(input.equals("VIII"))
            return 8;
        else if(input.equals("IX"))
            return 9;
        else if(input.equals("X"))
            return 10;

        else return -1;
    }







}
