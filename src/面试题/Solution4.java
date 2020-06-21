package 面试题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//7_This_is_a_test<br/>_hs_s_a_es
public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //预期输出的字符串
            String s1 = in.nextLine();
            //实际输出的字符串
            String s2 = in.nextLine();
            //存放实际字符的set
            Set<Character> set = new HashSet<>();
            //存放最终结果的set
            Set<Character> res = new HashSet<>();
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            for(int i = 0;i < ch2.length;i++){
                set.add(ch2[i]);
            }
            for(int j = 0;j < ch1.length;j++){
                if(!set.contains(ch1[j])){
                    if(!res.contains(ch1[j])){
                        res.add(ch1[j]);
                        System.out.print(ch1[j]);
                    }
                }
            }
            System.out.println();
            //注意：此处不要直接用foreach循环输出，因为res中的顺序与添加的顺序无关，在牛客网上可能会导致运行错误
        }
    }
}
