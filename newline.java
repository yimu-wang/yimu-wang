public class newline
{
	public static void main (String[] args){
		for(int i=1;i<=100;i++){
			 System.out.println("main�߳����ڴ�ӡ��main "+i);
		}
        Xiancheng x=new Xiancheng();
		new Thread(x,"���߳�").start();
         
	}
}

class Xiancheng implements Runnable
{   	public void run(){		
				for(int i=1;i<=50;i++){
               Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"���ڴ�ӡ��new "+i);
				}
             
}       
}