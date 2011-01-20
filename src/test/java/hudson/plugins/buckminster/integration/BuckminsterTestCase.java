package hudson.plugins.buckminster.integration;

import hudson.plugins.buckminster.BuckminsterInstallation;

import java.io.File;

import org.jvnet.hudson.test.HudsonTestCase;

public abstract class BuckminsterTestCase extends HudsonTestCase {

	
	private void configureBuckminsterHome(){
		
		if(System.getProperty("buckminster.home")==null)
		{
			String buckminsterHome =  "work/tools/Buckminster_3.6/buckminster";
			File file = new File(buckminsterHome);
			if(file.exists())
				System.setProperty("buckminster.home", file.getAbsolutePath());
		}

	}
	
    protected BuckminsterInstallation configureDefaultBuckminster() throws Exception {
    	
    	configureBuckminsterHome();
    	String buckminsterHome = System.getProperty("buckminster.home");
    	if(buckminsterHome==null)
    		buckminsterHome = "NONE";
    	BuckminsterInstallation installation = new BuckminsterInstallation("installationName", buckminsterHome, "3.6", null, null);
    	
    	hudson.getDescriptorByType(BuckminsterInstallation.DescriptorImpl.class).setInstallations(installation);
    	return installation;
    }

	
}
