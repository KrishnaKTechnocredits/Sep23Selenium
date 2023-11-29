package sayali;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment29_Paramter {

	@Parameters({ "browser", "env" }) // chrome, staging
	@Test
	public void m1(@Optional("edge") String browser, @Optional("stage") String environment) {
		System.out.println(browser + " : " + environment);
	}
}
