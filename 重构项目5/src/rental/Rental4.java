//���˼Ʒѷ����ͳ��ͻ��ּ��㵽Movie1��

package rental;
import move.*;

public class Rental4 {
	private Movie2 _movie;
	private int _daysRented;
	//����Ӱ����ÿ������������
	public Rental4(Movie2 movie,int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() {
		// TODO Auto-generated method stub
		return _daysRented;
	}
	public Movie2 getMovie() {
		return _movie;
	}
	//�ѼƷѷ�ʽ�Ž�Movie���У�Ȼ���޸�Rental��getCharge(),����ʹ������º�����
	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	public int getFrequentRenterPoints() {
		return  _movie.getFrequentRenterPoints(_daysRented);
		
}
}
