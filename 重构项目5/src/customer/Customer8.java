//ȥ����ʱ����totalAmount������getTotalCharge()��ѯ������ȡ��������totalAmount��ѭ���ڲ����ϱ��ӣ����԰�ѭ�����Ƶ���ѯ������
package customer;
import rental.*;
import java.util.Enumeration;
import java.util.Vector;
import price.*;
import move.*;
import rental.*;

public class Customer8 {
     private String _name;
     private Vector _rentals=new Vector();
     public Customer8(String name) {
    	 _name=name;
    	 
     }
     //������޵�ӰƬ
     public void addRental(Rental4 arg) {
    	 _rentals.addElement(arg);
    	 
     }
     public String getName() {
    	 return _name;
     }
     public String statement() {
    	 double totalAmount=0;
    	 int frequentRenterPoints=0;
    	 Enumeration rentals=_rentals.elements();
    	 String result="Rental Record for"+getName()+"\n";
    	 while(rentals.hasMoreElements()) {
    		
    		 Rental4 each=(Rental4)rentals.nextElement();	 
    		 result +="\t"+each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
    		
    		 
    	 }
    	 result += "Amount owed is" + String.valueOf(getTotalCharge())+"\n";
    	 result += "You earned"+ String.valueOf(getTotalFrequenterPoints())+ "frequent renter points";
    	 return result;
     }


      private double amountFor(Rental4 aRental) {
	
	    return aRental.getCharge();
    }
      private double getTotalCharge() {
    	  double result=0;
    	  Enumeration rentals=_rentals.elements();
    	  while(rentals.hasMoreElements()) {
    		  Rental4 each =(Rental4)rentals.nextElement();
    		  result+=each.getCharge();
    		  }
    	  return result;
    	  }
      private int getTotalFrequenterPoints() {
    	  int result=0;
    	  Enumeration rentals=_rentals.elements();
    	  while(rentals.hasMoreElements()) {
    		  Rental4 each =(Rental4)rentals.nextElement();
    		  result+=each.getFrequentRenterPoints();
    	  }
    	  return result;
      }
}
