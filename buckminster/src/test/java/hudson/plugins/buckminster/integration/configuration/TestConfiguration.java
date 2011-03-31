package hudson.plugins.buckminster.integration.configuration;

import hudson.model.FreeStyleProject;
import hudson.plugins.buckminster.BuckminsterInstallation;
import hudson.plugins.buckminster.EclipseBuckminsterBuilder;
import hudson.plugins.buckminster.integration.BuckminsterTestCase;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class TestConfiguration extends BuckminsterTestCase {
	
	@Test
	public void testConfigurationRoundTrip() throws ElementNotFoundException, SAXException, Exception{

		BuckminsterInstallation defaultBuckminster = configureDefaultBuckminster();
		FreeStyleProject p = createFreeStyleProject();
		EclipseBuckminsterBuilder before = new EclipseBuckminsterBuilder(
				defaultBuckminster.getName(),"commands","debug","params",null,
				"userTemp","userOutput","userCommand","userWorkspace","globalPropertiesFile","equinoxLauncherArgs");
		p.getBuildersList().add(before);

		submit(createWebClient().getPage(p,"configure").getFormByName("config"));
		EclipseBuckminsterBuilder after = p.getBuildersList().get(EclipseBuckminsterBuilder.class);
		assertNotNull(after);
		assertEquals(defaultBuckminster.getName(),after.getInstallation().getName());
		assertEquals(defaultBuckminster.getHome(),after.getInstallation().getHome());
		assertEquals("commands", after.getCommands());
		assertEquals("debug", after.getLogLevel());
		assertEquals("params", after.getParams());
		assertEquals("None",after.getTargetPlatform().getName());
		assertEquals("userTemp", after.getUserTemp());
		assertEquals("userOutput", after.getUserOutput());
		assertEquals("userCommand", after.getUserCommand());
		assertEquals("userWorkspace", after.getUserWorkspace());
		assertEquals("globalPropertiesFile", after.getGlobalPropertiesFile());
		assertEquals("equinoxLauncherArgs", after.getEquinoxLauncherArgs());

	}
	
}
