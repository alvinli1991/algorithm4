package section1;

import edu.princeton.cs.algs4.Stack;

import java.util.Objects;

/**
 * @Author: Alvin Li
 * Date: 2020/3/24
 * Time: 14:48
 */
public class Exercise139 {
    public static String recover(String input){
        Stack<String> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        String[] items = input.split("\\s");

        for (String item:items){
            if(Objects.equals(item,"")){

            }else if(Objects.equals(item,"+")
            || Objects.equals(item,"-")
            || Objects.equals(item,"*")
            || Objects.equals(item,"/")){
                operators.push(item);
            }else if(Objects.equals(item,")")){
                String opd2 = operands.pop();
                String opd1 = operands.pop();
                String op = operators.pop();
                String sub = "(" + " "+ opd1 +" "+op+" "+ opd2 + " )";
                operands.push(sub);
            }else {
                operands.push(item);
            }
        }
        return operands.pop();
    }
}
