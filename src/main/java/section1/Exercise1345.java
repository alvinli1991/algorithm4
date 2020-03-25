package section1;

import edu.princeton.cs.algs4.Stack;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Alvin Li
 * Date: 2020/3/25
 * Time: 09:13
 */
public class Exercise1345 {
    /**
     * 当pop的数量大于push的数量时，栈会下溢出
     *
     * @param input
     * @return
     */
    public static boolean isOverflow(String[] input){
        int pushCnt = 0;
        int popCnt = 0 ;
        for (String item:input){
            if(Objects.equals(item,"-")){
                popCnt++;
            }else{
                pushCnt++;
            }
            if(popCnt > pushCnt){
                return true;
            }
        }
        return pushCnt < popCnt;
    }

    /**
     * 算法是依据输出序列，来模拟正常的入栈出栈操作，以此来判断操作和输出是否匹配
     *
     * - 表示出栈 ，例如：
     * case1
     * 输入：0 1 2 3 4 - - - - - 5 6 7 8 9 - - - - -
     * 输出：4 3 2 1 0 9 8 7 6 5
     *
     * case2
     * 输入：0 1 2 3 4 - 5 6 7 8 9 - - - - -
     * 输出：4 9 8 7 6 5 3 2 1 0
     *
     * 1. 在扫描输出序列时候，第一个是4，意味着在此之前的已经入栈(3 2 1 0)，且它自己是pop
     * 2. 也就是说，输出序列的下一个有两种情况
     *    a、case1 与栈顶一致。也就是说接下来是接着pop
     *    b、case2 与栈顶不一致。也就是说接下来是继续push
     *       case2 输出序列接下来是 9，意味着在9之前的都入栈了  8 7 6 5 3 2 1 0
     * 3. 带输出序列值，不可能小于当前栈顶元素
     *
     * @param input
     * @return
     */
    public static boolean canPermutationGenerated(String[] input){
        Stack<Integer> stack = new Stack<>();
        int current = 0;

        List<Integer> intInput = Arrays.stream(input).map(NumberUtils::toInt).collect(Collectors.toList());

        //此处模拟的是正常的入栈操作
        for(Integer item : intInput){
            if(stack.isEmpty() || item > stack.peek()){
                /**
                 * 当栈为空或者输出序列值大于当前栈顶元素
                 * 则意味着该值之前的数据都是push，它自己是pop了
                 */
                while(current < item){
                    stack.push(current);
                    current ++;
                }
                current ++;
            }else if(item.equals(stack.peek())){
                /**
                 * 待输出序列和栈顶元素相同，符合正常出栈流程
                 */
                stack.pop();
            }else{
                /**
                 * 带输出序列小于栈顶元素，违反规则
                 */
                return false;
            }
        }
        return true;
    }
}
