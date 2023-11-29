package technocredits.robotClass;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {

	@Parameters({ "browser", "env" }) // chrome, qa
	@Test
	public void m1(@Optional("firefox") String browser, @Optional("stage") String environment) {
		System.out.println(browser + " : " + environment);
	}

}
