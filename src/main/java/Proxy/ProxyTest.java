package Proxy;
public class ProxyTest {
	public static void main(String[] args) {
		Proxy proxy = new Proxy();
        proxy.Request();
	}
}
//��������
interface Subject
{
    void Request();
}
//��ʵ����
class RealSubject implements Subject
{
    public void Request()
    {
    	System.out.println("������ʵ���ⷽ��...");
    }
}
//����
class Proxy implements Subject
{
    private RealSubject realSubject;
    public void Request()
    {
        if (realSubject == null)
        {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest()
    {
    	System.out.println("������ʵ����֮ǰ��Ԥ����");
    }
    public void postRequest()
    {
    	System.out.println("������ʵ����֮��ĺ�������");
    }
}
