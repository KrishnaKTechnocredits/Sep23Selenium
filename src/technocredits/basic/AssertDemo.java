package technocredits.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {
	
	@Test
	public void m1() {
		System.out.println(1);
		String str = null;
		Assert.assertNull(str);
		str = str + "Hi";
		System.out.println(str);
		Assert.assertEquals(str, "HelloHi");
		str = str.replace("Hi", "Techno");
		Assert.assertEquals(str, "HelloTechno");
		Assert.assertTrue(str.equalsIgnoreCase("Hellotechno"));
		
		Assert.assertTrue(str.equals("HelloTechno"));
		
		str = str.replace("Techno", "");
		boolean conditionFLag = str.length()>7 && str.length()<3;
		Assert.assertFalse(conditionFLag);
		System.out.println(2);
	}
}
