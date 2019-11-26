package other;

import user.User;
import utility.XMLUtility;
import factory.*;
import java.text.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.*;

public class TelcomUser {
private String phoneNumber;
private String callTo;
private TreeSet callToNumbersSet;
private ArrayList communicationRecords;

User ZUser;

public TelcomUser(String phoneNumber) {
	this.phoneNumber=phoneNumber;
	this.communicationRecords=new ArrayList();
	this.callToNumbersSet = new TreeSet();
	Factory factory=(Factory)XMLUtility.getBean();
	ZUser=factory.produceRecord();
	
	}
public void generateCommunicateRecords() {
	int recordNum=new Random().nextInt(10);
	for(int i=0;i<=recordNum;i++) {
		this.callTo = getcallToPhoneNumber();
		this.callToNumbersSet.add(this.callTo);
		long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
		long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
		//long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
		//long timeEnd=timeStart+60000+new Random().nextInt(60000);
		this.communicationRecords.add(this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo+";");
	}
}
private String getcallToPhoneNumber() {
	return "1380372000"+String.valueOf(new Random().nextInt(10));
}
private String accountFee(long timeStart,long timeEnd) {
	
	double feePerMinute=ZUser.getfeePerMinute();
	
	int minutes = Math.round((timeEnd-timeStart)/60000);
	double feeTotal=feePerMinute * minutes;
	return String.format("%.4f",feeTotal);
}
public void printCallToNumber() {
	System.out.println("--------���춼����Щ���������---------");
	for(Object callTo:this.callToNumbersSet) {
		System.out.println((String)callTo);
	}
}

public void printDetails() {
	
	int arrayListSize=this.communicationRecords.size(); 

	for(int i=0;i<arrayListSize-1;i++) {

		String [] recordField = ((String)this.communicationRecords .get(i)).split(",");

		System.out.println("���У�"+recordField[0]);

		System.out.println("���У�"+recordField[3]);

		Date timeStart = new Date(Long.parseLong(recordField[1]));
		Date timeEnd = new Date(Long.parseLong(recordField[2]));			
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
		
		//SimpleDateFormat			
		System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
		System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
		
		System.out.println("�Ʒѣ�"+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"Ԫ");

	}

		
	}
	
}
