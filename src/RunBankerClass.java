

import java.util.Scanner;

public class RunBankerClass {


    public static void main(String[] args) {

        boolean Choose = true;
        boolean Continue=true;
        String C;
        Scanner in = new Scanner(System.in);
        BankerClass TestBank = new BankerClass();

        TestBank.initSize();//��ʼ�������С
        TestBank.setSystemVariableFirst();//���ø���ʼϵͳ����

        while (Continue == true) {

            System.out.println("���Ƿ�Ҫ�������У�y/n?");
            C = in.nextLine();
            if (C.endsWith("n")) {
                Continue = false;
            }
            else if(C.endsWith("y"))
            {
                TestBank.setSystemVariableSecond();
                while (Choose == true) {
                    TestBank.setRequest();
                    System.out.println("���Ƿ�Ҫ��������y/n?");
                    C = in.nextLine();
                    if (C.endsWith("n")) {
                        Choose = false;
                    }
                }
            }
        }

    }
}