import java.util.Scanner;//��ʾ��java.util�µ�Scanner�ർ��
public class Input {

    //��дһ��main����
    public static void main(String[] args) {
        //��ʾ�����û�������
        //����
        //Scanner�� ��ʾ ���ı�ɨ��������java.util��
        //1. ����/���� Scanner�����ڵİ�
        //2. ����Scanner����
        //   myScanner ���� Scanner��Ķ���
        Scanner myScanner = new Scanner(System.in);
        //3. �����û�������
        System.out.println("����������");
        //������ִ�е� netx����ʱ,��ȴ��û�����,
        String name = myScanner.next(); //�����û�����
        System.out.println("����������");
        int age = myScanner.nextInt(); //�����û�����
        System.out.println("������нˮ");
        double sal = myScanner.nextDouble(); //�����û�����
        System.out.println("�˵���Ϣ����:");
        System.out.println("����=" + name + "����=" 
            + age + "нˮ=" + sal);


    }
}