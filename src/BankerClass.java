

import java.util.Arrays;
import java.util.Scanner;

public class BankerClass {
    int hang=0;
    int lie=0;
    int[] Available;
    int[][] Max = new int[3][3];
    int[][] Alloction = new int[3][3];
    int[][] Need = new int[3][3];
    int[][] Request = new int[3][3];
    int[] Work = new int[3];

    int num = 0;//���̱��
    Scanner in = new Scanner(System.in);

    public BankerClass() {

    }
    public void initSize()
    {
        //��ʼ�������С
        System.out.println("���������������");
        hang=in.nextInt();
        System.out.println("��������Դ����������");
        lie=in.nextInt();

        Max = new int[hang][lie];
        Alloction = new int[hang][lie];
        Need = new int[hang][lie];
        Request = new int[hang][lie];

        Work=new int[hang];
        Available=new int[lie];
        System.out.println("��ϵͳ�����ڼ��  "+hang+"  ����"+  lie+"  ����Դ�����İ�ȫ��");
    }


    public void setSystemVariableFirst(){//���ø���ʼϵͳ����
        setAvailable();//����ϵͳ���õ�������Դ����
        setMax();//���ø��������������

        printFirstSystemVariable();
    }
    public void setSystemVariableSecond(){
        //��������������ȷ ��������

        setAlloction(); //����AL ����
        printSecondSystemVariable();
        SecurityAlgorithm();
    }
    public void setAvailable() {//����ϵͳ���õ�������Դ����
        System.out.println("������ϵͳ���õ�  "+lie+" ����Դ���� Available��");
        for (int i = 0; i < lie; i++) {
            Available[i] = in.nextInt();
        }
        System.out.println("����һ���������̣���ʼϵͳ����������ԴΪ"+ Arrays.toString(Available)+"�����м��㷨��");
    }

    public void setMax() {
        //����Max����
        System.out.println("�����ø����̵�����������Max��");
        for (int i = 0; i < hang; i++) {
            System.out.println("���������P" + i + "�������Դ��������");
            for (int j = 0; j < lie; j++) {
                Max[i][j] = in.nextInt();
            }
        }
    }

    public void setAlloction() {
        //�����ѷ������Alloction
        System.out.println("������������̷������Alloction��");
        for (int i = 0; i < hang; i++) {
            System.out.println("���������P" + i + "�ķ�����Դ����");
            for (int j = 0; j < lie; j++) {
                Alloction[i][j] = in.nextInt();
            }
        }

        System.out.println("��������");
        System.out.println("Available=Available-Alloction");
        System.out.println("Need=Max-Alloction");
        for (int i = 0; i < lie; i++) {
            //���㵱ǰAvailable����
            for (int j = 0; j < hang; j++) {

                Available[i] = Available[i] - Alloction[j][i];
            }
        }
        for (int i = 0; i < hang; i++) {
            //����Need����
            for (int j = 0; j < lie; j++) {
                Need[i][j] = Max[i][j] - Alloction[i][j];
            }
        }
    }
    public void printFirstSystemVariable(){
        //���� MAX���� Allocation ���� ֮�����ȷ��
        System.out.println("���������Ƿ���ȷ��");
        System.out.println("����  "+"   Max   "+"   Alloction ");
        for(int i=0;i<hang;i++){
            System.out.print("P"+i+"    ");
            for(int j=0;j<lie;j++){
                System.out.print(Max[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public void printSecondSystemVariable(){
        //����� Need Avaiable ����֮���ٴ����
        System.out.println("��ʱ��Դ���������£�");
        System.out.println("����  "+"   Max   "+"   Alloction "+"    Need  "+"     Available ");
        for(int i=0;i<hang;i++){
            System.out.print("P"+i+"  ");
            for(int j=0;j<lie;j++){
               System.out.print(Max[i][j]+"  "); 
            }
            System.out.print("|  ");
            for(int j=0;j<lie;j++){
               System.out.print(Alloction[i][j]+"  "); 
            }
            System.out.print("|  ");
            for(int j=0;j<lie;j++){
               System.out.print(Need[i][j]+"  "); 
            }
            System.out.print("|  ");
            if(i==0){
                for(int j=0;j<lie;j++){
                    System.out.print(Available[j]+"  ");
                }
            }
            System.out.println();
        }
    }

    public void setRequest() {//����������Դ��Request


        System.out.println("������������Դ�Ľ��̱�ţ�");
        System.out.println();
        System.out.println("��ǰ�н��̣�");
        for(int i=0;i<hang;i++)
        {
            System.out.println("P  "+i);
        }
        num= in.nextInt();//����ȫ�ֱ������̱��num
        System.out.println("�������������Դ��������");
        for (int j = 0; j < lie; j++) {
            Request[num][j] = in.nextInt();
        }
        System.out.println("������P" + num + "�Ը���Դ����Request��(" + Request[num][0] + "," + Request[num][1] + "," + Request[num][2] + ").");

        BankerAlgorithm();
    }

    public void BankerAlgorithm() {//���м��㷨
        boolean T=true;

        if (Request[num][0] <= Need[num][0] && Request[num][1] <= Need[num][1] && Request[num][2] <= Need[num][2]) {//�ж�Request�Ƿ�С��Need
            if (Request[num][0] <= Available[0] && Request[num][1] <= Available[1] && Request[num][2] <= Available[2]) {//�ж�Request�Ƿ�С��Alloction
                for (int i = 0; i < lie; i++) {
                    Available[i] -= Request[num][i];
                    Alloction[num][i] += Request[num][i];
                    Need[num][i] -= Request[num][i];
                }

            } else {
                System.out.println("��ǰû���㹻����Դ�ɷ��䣬����P" + num + "��ȴ���");
               T=false;
            }
        } else {
            System.out.println("����P" + num + "�����Ѿ��������������Need.");
            T=false;
        }

       if(T==true){
           printSecondSystemVariable();
        System.out.println("���ڽ��밲ȫ�㷨��");
        SecurityAlgorithm();
       }
    }


    public void SecurityAlgorithm() {//��ȫ�㷨
        boolean[] Finish = {false, false, false,false,false};//��ʼ��Finish
        int count = 0;//��ɽ�����
        int circle=0;//ѭ��Ȧ��
        int[] S=new int[5];//��ȫ����
        for (int i = 0; i < 3; i++) {//���ù�������
            Work[i] = Available[i];
        }
        boolean flag = true;
        while (count < 5) {
            if(flag){
                System.out.println("����  "+"   Work  "+"   Alloction "+"    Need  "+"     Work+Alloction ");
                flag = false;
            }
            for (int i = 0; i < 5; i++) {

                if (Finish[i]==false&&Need[i][0]<=Work[0]&&Need[i][1]<=Work[1]&&Need[i][2]<=Work[2]) {//�ж�����
                    System.out.print("P"+i+"  ");
                    for (int k = 0; k < 5; k++){
                        System.out.print(Work[k]+"  ");
                    }
                    System.out.print("|  ");
                    for (int j = 0; j<3;j++){
                        Work[j]+=Alloction[i][j];
                    }
                    Finish[i]=true;//����ǰ����������ʱ
                    S[count]=i;//���õ�ǰ�����ź�

                    count++;//�����������1
                    for(int j=0;j<3;j++){
                        System.out.print(Alloction[i][j]+"  ");
                    }
                    System.out.print("|  ");
                    for(int j=0;j<3;j++){
                        System.out.print(Need[i][j]+"  ");
                    }
                    System.out.print("|  ");
                    for(int j=0;j<3;j++){
                        System.out.print(Work[j]+"  ");
                    }
                    System.out.println();
                }

            }
            circle++;//ѭ��Ȧ����1

            if(count==5){//�ж��Ƿ��������н�����Ҫ
                System.out.print("��ʱ����һ����ȫ���У�");
                for (int i = 0; i<5;i++){//�����ȫ����
                    System.out.print("P"+S[i]+" ");
                }
                System.out.println("�ʵ�ǰ�ɷ��䣡");
                break;//����ѭ��
            }
            if(count<circle){//�ж���ɽ������Ƿ�С��ѭ��Ȧ��
                count=5;
                System.out.println("��ǰϵͳ���ڲ���ȫ״̬���ʲ����ڰ�ȫ���С�");
                break;//����ѭ��
            }
        }
    }


}
