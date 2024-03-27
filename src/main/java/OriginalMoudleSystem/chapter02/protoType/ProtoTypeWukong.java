package OriginalMoudleSystem.chapter02.protoType;
import java.awt.*;
import javax.swing.*;
class SunWukong extends JPanel implements Cloneable
{
	private static final long serialVersionUID = 5543049531872119328L;
	public SunWukong()
	{
        JLabel l1 = new JLabel(new ImageIcon("src/chapter02/protoType/Wukong.jpg"));
		this.add(l1);	
	}
	public Object clone()
	{
		SunWukong w=null;
		try{ w=(SunWukong)super.clone(); }
        catch(CloneNotSupportedException e) { System.out.println("�������ʧ��!"); }
		return w;
    }
}
public class ProtoTypeWukong 
{
	public static void main(String[] args) 
	{
		JFrame jf = new JFrame("ԭ��ģʽ����");
		jf.setLayout(new GridLayout(1,2));
		Container contentPane = jf.getContentPane();
		SunWukong obj1=new SunWukong();
		contentPane.add(obj1);	    
		SunWukong obj2=(SunWukong)obj1.clone();
		contentPane.add(obj2);	
		jf.pack();        
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	}
}
