package a0;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	private int hr;
	private int min;
	
	public Time() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH: mm");
		this.hr = Integer.parseInt(df.format(d).substring(0, 2));
		this.min = Integer.parseInt(df.format(d).substring(4,6));
	}
	public Time(int a, int b) {
		this.hr = a;
		this.min = b;
	}
	
	public void setHour(int hour) {
		this.hr = hour;
	}
	public void setMin(int minute) {
		this.min = minute;
	}
	public int getHour() {
		return hr;
	}
	public int getMin() {
		return min;
	}
	public String toString() {
		return cons(hr) + ": " + cons(min);
		
	}
	private String cons(int n) {
		if(n < 0 || n > 9) {
			return "" + n;
		} else {
			return "0" + n;
		}
	}
}
