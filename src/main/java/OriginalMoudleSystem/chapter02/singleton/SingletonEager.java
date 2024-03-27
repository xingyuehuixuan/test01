package OriginalMoudleSystem.chapter02.singleton;
import java.awt.*;
import javax.swing.*;
public class SingletonEager {
	public static void main(String[] args) {
		JFrame jf = new JFrame("��������ģʽ����");
		jf.setLayout(new GridLayout(1,2));
		Container contentPane = jf.getContentPane();
        Bajie obj1 = Bajie.getInstance();
		contentPane.add(obj1);	 
        Bajie obj2 = Bajie.getInstance();  
		contentPane.add(obj2);
        if (obj1 == obj2) {
        	System.out.println("������ͬһ�ˣ�");
        }else {
            System.out.println("���ǲ���ͬһ�ˣ�");
        }	
		jf.pack();        
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}
}
class Bajie extends JPanel{
    private static Bajie instance=new Bajie();
    private Bajie(){  
        JLabel l1 = new JLabel(new ImageIcon("src/chapter02/singleton/Bajie.jpg"));
	    this.add(l1);	
    }
    public static Bajie getInstance(){ 
        return instance;
    } 
}
