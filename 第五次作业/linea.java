public class linea
{
	public static void main (String[] args){
        Thread x1=new Xiancheng("�߳�һ");
        Thread x2=new Xiancheng("�̶߳�");
		x1.start();
		x2.start();  
	}
}

class Xiancheng extends Thread
{   
	public Xiancheng(String name){
			super(name);
		}
	public void run(){
		
				Thread th=Thread.currentThread();
				String th_name=th.getName();
                System.out.println("����̵߳������ǣ�"+th_name);
				
}       
}