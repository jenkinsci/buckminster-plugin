package hudson.plugins.buckminster.callables;

import hudson.Functions;
import hudson.remoting.Callable;

import java.io.IOException;

public class GetDirectorExecutable implements Callable<String, IOException>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -15952856176147985L;

	public String call() throws IOException {
		if(Functions.isWindows())
			return "director.bat";
		return "director";
	}
}
