package FactoryMethod;
import java.awt.*;
import javax.swing.*;
public class AnimalFarmTest {
	public static void main(String[] args) {
		try
        {
        	Animal a;
        	AnimalFarm af;
        	af=(AnimalFarm) ReadXML2.getObject();
        	a=af.newAnimal();
        	a.show();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}
}
//�����Ʒ��������
interface Animal {
	public void show();
}
//�����Ʒ������
class Horse implements Animal
{
	JScrollPane sp;
    JFrame jf = new JFrame("��������ģʽ����");
	public Horse() {
		Container contentPane = jf.getContentPane();
		JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("�����"));
		sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
		JLabel l1 = new JLabel(new ImageIcon("src/chapter03/factoryMethod/A_Horse.jpg"));
		p1.add(l1);		
		jf.pack();        
		jf.setVisible(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û�������ڹر�  
	}
	public void show()
	{
		jf.setVisible(true);
	}
}
//�����Ʒ��ţ��
class Cattle implements Animal
{
	JScrollPane sp;
    JFrame jf = new JFrame("��������ģʽ����");
	public Cattle() {
		Container contentPane = jf.getContentPane();
		JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("���ţ"));
		sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
		JLabel l1 = new JLabel(new ImageIcon("src/chapter03/factoryMethod/A_Cattle.jpg"));
		p1.add(l1);		
		jf.pack();        
		jf.setVisible(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û�������ڹر�  
	}
	public void show()
	{
		jf.setVisible(true);
	}
}
//���󹤳���������
interface AnimalFarm {
	public Animal newAnimal();
}
//���幤��������
class HorseFarm implements AnimalFarm
{
    public Animal newAnimal()
    {
    	System.out.println("���������");
    	return new Horse();
    }
}
//���幤������ţ��
class CattleFarm implements AnimalFarm
{
    public Animal newAnimal()
    {
    	System.out.println("��ţ������");
    	return new Cattle();
    }
}