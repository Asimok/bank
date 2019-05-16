

import java.util.Scanner;

public class RunBankerClass {


    public static void main(String[] args) {

        boolean Choose = true;
        boolean Continue=true;
        String C;
        Scanner in = new Scanner(System.in);
        BankerClass TestBank = new BankerClass();

        TestBank.initSize();//初始化数组大小
        TestBank.setSystemVariableFirst();//设置各初始系统变量

        while (Continue == true) {

            System.out.println("您是否还要继续进行：y/n?");
            C = in.nextLine();
            if (C.endsWith("n")) {
                Continue = false;
            }
            else if(C.endsWith("y"))
            {
                TestBank.setSystemVariableSecond();
                while (Choose == true) {
                    TestBank.setRequest();
                    System.out.println("您是否还要进行请求：y/n?");
                    C = in.nextLine();
                    if (C.endsWith("n")) {
                        Choose = false;
                    }
                }
            }
        }

    }
}