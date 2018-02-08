/** NetId: zg242.sz499 Time spent: 6 hours, 30 minutes.
An instance maintains info about the PhD of a person. */

//We checked the Javadoc output and it was OK
public class PhD {         
	private String phdName;//Name of PhD at least 1 character. 
	private int awardMonth;//Month PhD was awarded. In 1 to 12, with 1 meaning January, etc.
	private int awardYear;//Year PhD was awarded. Smaller than 2018.
	private PhD fad;//Object of PhD's first advisor, null if unknown.
	private PhD sad;//Object of PhD's second advisor, null if unknown.
	private int numAd;//Number of PhD;s advisees, equal or greater than zero.
	/**Constructor: an instance for a person with name n, PhD month m, PhD year y. Its
	advisors are unknown, and it has no advisees.
	Precondition: n has at least 1 char and m is in 1..12.*/
	public PhD(String n, int m, int y) {
		assert n.length() >= 1 && m >= 1 && m<= 12;
		this.phdName = n;
		this.awardMonth = m;
		this.awardYear = y;
	}
	/**Return the name of this person.*/
	public String name() {
		return phdName;
	}
	/**Return the month this person got their PhD.*/
	public int month() {
		return awardMonth;
	}
	/**Return the year this person got their PhD.*/
	public int year() {
		return awardYear;
	}
	/**Return the first advisor of this PhD (null if unknown).*/
	public PhD advisor1() {
		return fad;
	}
	/**Return the second advisor of this PhD (null if unknown or
	non-existent).*/
	public PhD advisor2() {
		return sad;
	}
	/**Return the number of PhD advisees of this person.*/
	public int numAdvisees() {
		return numAd;
	}
	/**Add p as the first advisor of this person.
	Precondition: the first advisor is unknown and p is not null.*/
	public void setAdvisor1(PhD p) {
		assert p != null && fad == null;
		this.fad = p;
		p.numAd = p.numAdvisees() + 1;
	}
	/**Add p as the second advisor of this person.
	Precondition: The first advisor (of this person) is known, the second advisor
	is unknown, p is not null, and p is different from the first advisor.*/
	public void setAdvisor2(PhD p) {
		assert p != null && sad == null && fad != null && p != fad;
		this.sad = p;
		p.numAd = p.numAd + 1;
	}
	/**Constructor: a PhD with name n, PhD month m, PhD year y, first advisor
	adv1, and no second advisor.
	Precondition: n has at least 1 char, m is in 1..12, and adv is not null.*/
	public PhD(String n, int m, int y, PhD adv1) {
		assert n.length() >= 1 && m >= 1 && m<= 12 && adv1 != null;
		this.phdName = n;
		this.awardMonth = m;
		this.awardYear = y;
		this.setAdvisor1(adv1);
	}
	/**Constructor: a PhD with name n, PhD month m, PhD year y, first advisor
	adv1, and second advisor adv2.
	Precondition: n has at least 1 char, m is in 1..12,
	adv1 and adv2 are not null, and adv1 and adv2 are different.*/
	public PhD(String n, int m, int y, PhD adv1, PhD adv2) {
		assert n.length() >= 1 && m >= 1 && m<= 12 && adv1 != null && adv2 != null && adv1 != adv2;
		this.phdName = n;
		this.awardMonth = m;
		this.awardYear = y;
		this.setAdvisor1(adv1);
		this.setAdvisor2(adv2);
	}
	/**Return value of "this PhD has at least one advisee",
	i.e. true if this PhD has at least one advisee and false
	otherwise"*/
	public boolean hasAdvisee() {
		return numAd >= 0;
	}
	/**Return value of "p is not null and this person got the PhD
	after p.”*/
	public boolean gotAfter(PhD p) {
		return p != null && (p.year() < awardYear || (p.year() == awardYear && p.month() < awardMonth)); 
	}
	/**Return value of "this person and p are intellectual
	siblings."
	Precondition: p is not null.*/
	public boolean areSiblings(PhD p) {
		assert p != null;
		PhD pa1 = p.advisor1();
		PhD pa2 = p.advisor2();
		return this != p && (fad != null && pa1 != null) && 
				(pa1 == fad || pa1 == sad || pa2 == fad || 
				(pa2 != null && pa2 == sad));
	}
}
