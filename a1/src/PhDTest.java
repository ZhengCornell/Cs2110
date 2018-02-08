import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhDTest {
	/**test1 is used to test Group A*/
	@Test
	public void test1() {
		PhD p1 = new PhD("Zheng", 3, 2015);
		assertTrue(p1.name().length() >= 1);
		assertTrue(p1.month() >= 1);
		assertTrue(p1.month() <= 12 );
		assertEquals("Zheng", p1.name());
		assertEquals(3, p1.month());
		assertEquals(2015, p1.year());
		assertEquals(null, p1.advisor1());
		assertEquals(null, p1.advisor2());
		assertEquals(0, p1.numAdvisees());
	}
	/**test2 is used to test Group B*/
	@Test
	public void test2() {
		PhD p2 = new PhD("Ge", 5, 2005);
		PhD p3 = new PhD("La", 7, 2007);
		PhD p4 = new PhD("Go", 9, 2012);
		assertNotNull(p2);
		assertNull(p4.advisor1());
		p4.setAdvisor1(p2);
		assertNotNull(p3);
		assertNotNull(p4.advisor1());
		assertNull(p4.advisor2());
		assertNotSame(p4.advisor1(),p3);
		p4.setAdvisor2(p3);
		assertEquals("Ge", p4.advisor1().name());
		assertEquals(5, p4.advisor1().month());
		assertEquals(2005, p4.advisor1().year());
		assertEquals(null, p4.advisor1().advisor1());
		assertEquals(null, p4.advisor1().advisor2());
		assertEquals(1, p4.advisor1().numAdvisees());
		assertEquals(1, p4.advisor2().numAdvisees());
	}
	/**test3 is used to test Group C*/
	@Test
	public void test3() {
		PhD p5 = new PhD("Ko", 10, 2013);
		assertTrue(p5.name().length() >= 1);
		assertTrue(p5.month() >= 1);
		assertTrue(p5.month() <= 12 );
		assertNotNull(p5);
		PhD p6 = new PhD("Pu", 11, 2014, p5);
		PhD p7 = new PhD("Ma", 12, 2015, p5, p6);
		assertTrue(p7.name().length() >= 1);
		assertTrue(p7.month() >= 1);
		assertTrue(p7.month() <= 12 );
		assertNotNull(p5);
		assertNotNull(p6);
		assertNotSame(p5, p6);
		assertEquals("Ma", p7.name());
		assertEquals(12, p7.month());
		assertEquals(2015, p7.year());
		assertEquals(p5, p7.advisor1());
		assertEquals(p6, p7.advisor2());
		assertEquals(0, p7.numAdvisees());
		assertEquals(2, p5.numAdvisees());
		assertEquals(1, p6.numAdvisees());
	}
	/**test4 is used to test Group D*/
	@Test
	public void test4() {
		 PhD p5 = new PhD("Ko", 10, 2013);
		 PhD p6 = new PhD("Pu", 11, 2013, p5);
		 PhD p7 = new PhD("Ma", 12, 2015, p5, p6);
		 PhD p8 = new PhD("Wo", 7, 2016, p6, p5);
		 PhD p9 = new PhD("Ri", 7, 2016, p7, p5);
		 PhD p10 = new PhD("Roy", 1, 2016);
		 PhD feb77= new PhD("feb77", 2, 1977, p5);
         PhD jun77= new PhD("jun77", 8, 1977, p8);
         PhD p11= new PhD("jK", 8, 1978);
         assertNotNull(jun77);
         assertEquals(true, p6.gotAfter(p5));
         assertEquals(true, p7.gotAfter(p5));
         assertEquals(true, p8.gotAfter(p5));
         assertEquals(false, p10.gotAfter(p9));
         assertEquals(false, p10.gotAfter(p8));
         assertEquals(false, feb77.gotAfter(p9));
         assertEquals(false, feb77.gotAfter(p8));
         assertEquals(false, jun77.gotAfter(p9));
         assertEquals(false, jun77.gotAfter(p11));
         assertEquals(false, feb77.gotAfter(jun77));         
         assertEquals(true, p6.areSiblings(p7));//3
         assertEquals(true, p8.areSiblings(p7));//4
         assertEquals(true, p7.areSiblings(feb77));
         assertEquals(true, p8.areSiblings(p9));
         assertEquals(false, feb77.areSiblings(feb77));
 		 assertEquals(false, p10.areSiblings(p11));
 		 
	}
}
