package FactoryMethod;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
class ReadXML1
{
//�÷������ڴ�XML�����ļ�����ȡ������������������һ��ʵ������
	public static Object getObject()
	{
		try
		{
			//�����ĵ�����
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;							
			doc = builder.parse(new File("src/chapter03/factoryMethod/config1.xml")); 		
			//��ȡ�����������ı��ڵ�
			NodeList nl = doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName="chapter03.factoryMethod."+classNode.getNodeValue();
            //System.out.println("��������"+cName);
            //ͨ����������ʵ�����󲢽��䷵��
            Class<?> c=Class.forName(cName);
	  	    Object obj=c.newInstance();
            return obj;
         }   
         catch(Exception e)
         {
           		e.printStackTrace();
           		return null;
         }
	}
}
