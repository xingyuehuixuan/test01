package Proxy;
import java.awt.*;
import javax.swing.*;
public class WySpecialtyProxy {
	public static void main(String[] args) {
		SgProxy proxy = new SgProxy();
		proxy.display();
	}
}
//�������⣺�ز�
interface Specialty
{
	void display();
}
//��ʵ���⣺��Դ�ز�
class WySpecialty extends JFrame implements Specialty
{
	private static final long serialVersionUID = 1L;
	public WySpecialty()
	{
		super("�عش�����Դ�ز�����");
		this.setLayout(new GridLayout(1,1));
		JLabel l1 = new JLabel(new ImageIcon("D:\\mavenproject\\test01\\src\\main\\java\\Proxy\\WuyuanSpecialty.jpg"));
		this.add(l1);	
        this.pack();        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	}
	public void display()
    {
		this.setVisible(true);
    }
}
//�����عش���
class SgProxy implements Specialty
{
	private WySpecialty realSubject = new WySpecialty();
    public void display()
    {
    	preRequest();
        realSubject.display();
        postRequest();
    }
    public void preRequest()
    {
  	    System.out.println("�عش�����Դ�ز���ʼ��");
    }
    public void postRequest()
    {
  	    System.out.println("�عش�����Դ�ز�������");
    }
}