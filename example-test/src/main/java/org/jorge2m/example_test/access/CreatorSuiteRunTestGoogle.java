package org.jorge2m.example_test.access;

import java.util.Arrays;

import org.jorge2m.example_test.access.datatmaker.Suites;
import org.jorge2m.example_test.test.suite.SmokeTestSuite;

import org.jorge2m.testmaker.domain.CreatorSuiteRun;
import org.jorge2m.testmaker.domain.InputParamsBasic;
import org.jorge2m.testmaker.domain.SuiteMaker;

public class CreatorSuiteRunTestGoogle extends CreatorSuiteRun {

	private final String ChromeDriverVersionDefault = "80.0.3987.106";
	private final String GeckoDriverVersionDefault = "0.26.0";
	
	private CreatorSuiteRunTestGoogle() throws Exception {
		super();
	}
	private CreatorSuiteRunTestGoogle(InputParamsBasic inputParams) throws Exception {
		super(inputParams);
	}
	public static CreatorSuiteRunTestGoogle getNew() throws Exception {
		return new CreatorSuiteRunTestGoogle();
	}
	public static CreatorSuiteRunTestGoogle getNew(InputParamsBasic inputParams) throws Exception {
		return new CreatorSuiteRunTestGoogle(inputParams);
	}
	
	@Override
	public SuiteMaker getSuiteMaker() throws Exception {
		setWebDriverVersion();
		try {
			switch ((Suites)inputParams.getSuite()) {
			case SmokeTest:
				return (new SmokeTestSuite(inputParams));
			case OtherSuite:  
			default:
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("Suite Name not valid. Posible values: " + Arrays.asList(Suites.values()));
		}

		return null;
	}
	
	private void setWebDriverVersion() {
		if (inputParams.getChromeDriverVersion()==null) {
			inputParams.setChromeDriverVersion(ChromeDriverVersionDefault);
		}
		if (inputParams.getGeckoDriverVersion()==null) {
			inputParams.setGeckoDriverVersion(GeckoDriverVersionDefault);
		}
	}
}