package a0;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class TestTime {

	public static void main(String[] args) {
//		Date d = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("HH: mm");
//		System.out.println(df.format(d));
		Time t1 = new Time();
		System.out.println(t1);
		t1.setHour(5);
		t1.setMin(3);
		System.out.println(t1);
//		assertEquals(2, t1.getHour());
		String name = "wef";
		assert name!= null && name.length() >= 1;

	}

}
