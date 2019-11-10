import java.util.Random;
class Input implements Runnable{
	private Storage st;
	private int num;
	Input(Storage st){
		this.st=st;
	}
	public void run(){
		while(true){
			Random r=new Random();

			if(r.nextInt(1000)>500){
				try{
					Thread.sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			num=r.nextInt(1000);
			st.put(num);
		}
	}

}

