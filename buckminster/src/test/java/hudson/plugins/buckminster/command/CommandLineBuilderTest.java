package hudson.plugins.buckminster.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import hudson.FilePath;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CommandLineBuilderTest {

	@Test
	public void testCommandLineBuilder() {
		//TODO: implement test
	}

	@Test
	public void testBuildCommands() {
		//TODO: implement test
	}

	@Test
	public void testGetJavaExecutable() {
		//TODO: implement test
	}

	@Test
	public void testGetCommandFilePath() {
		//TODO: implement test
	}

	@Test
	public void testGetInstallation() {
		//TODO: implement test
	}

	@Test
	public void testGetCommands() {
		//TODO: implement test
	}

	@Test
	public void testGetLogLevel() {
		//TODO: implement test
	}

	@Test
	public void testGetAdditionalParams() {
		//TODO: implement test
	}

	@Test
	public void testWriteCommandFile() {
		FilePath mockPath = new FilePath(new File("target/test/command/test.txt"));
		String commands = "test ${property}test\n${ProPeRTY}property";
		CommandLineBuilder builder = new CommandLineBuilder(null, commands, null, null, null, null, null, null, null, null);
		Map<String, String> properties = new CaseInsensitiveMap();
		properties.put("property", "replacement");
		try {
			builder.writeCommandFile(mockPath, properties);
			assertEquals("test replacementtest\nreplacementproperty",mockPath.readToString());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testAddStarterParameters() {
		//TODO: implement test
	}

	@Test
	public void testGetDataPath() {
		//TODO: implement test
	}

	@Test
	public void testAddJVMProperties() {
		//TODO: implement test
	}

	@Test
	public void testGetTempDir() {
		//TODO: implement test
	}

	@Test
	public void testGetOutputDir() {
		//TODO: implement test
	}

	@Test
	public void testExpandProperties() {
		//TODO: implement test
	}

	@Test
	public void testFindEquinoxLauncher() {
		//TODO: implement test
	}

	@Test
	public void testCreateDirectorScriptBuckminsterInstallableFilePathNodeTaskListenerSetOfStringSetOfString() {
		//TODO: implement test
	}

	@Test
	public void testCreateDirectorScriptBuckminsterInstallableFilePathNodeTaskListenerSetOfStringSetOfStringSetOfString() {
		//TODO: implement test
	}
	


	@Test
	public void testToCSVCollectionOfString() {
		List<String> values = new ArrayList<String>();
		values.add("a");
		String result = CommandLineBuilder.toCSV(values);
		assertEquals("a", result);
		values.add("b");
		values.add("c");
		result = CommandLineBuilder.toCSV(values);
		assertEquals("a, b, c", result);
		result = CommandLineBuilder.toCSV(new ArrayList<String>());
		assertEquals("", result);
		
	}

	@Test
	public void testToCSVCollectionOfStringString() {
		List<String> values = new ArrayList<String>();
		values.add("a");
		String result = CommandLineBuilder.toCSV(values,":");
		assertEquals("a", result);
		values.add("b");
		values.add("c");
		result = CommandLineBuilder.toCSV(values,":");
		assertEquals("a:b:c", result);
		result = CommandLineBuilder.toCSV(new ArrayList<String>(),":");
		assertEquals("", result);
	}

	
	@Test
	public void testAddEquinoxLauncherProperties(){
		
		CommandLineBuilder builder = CommandLineBuilder.forInstallation(null).equinoxLauncherArgs("test\n${test}\n${test2}");
		List<String> expected = new ArrayList<String>(); 
		builder.addEquinoxLauncherProperties(expected, getDummyProperties());
		assertEquals(3, expected.size());
		assertEquals("test", expected.get(0));
		assertEquals("foobar", expected.get(1));
		assertEquals("${test2}", expected.get(2));
	}
	
	private Map<String, String>getDummyProperties(){
		Map<String, String> map = new CaseInsensitiveMap();
		map.put("test", "foobar");
		return map;
	}
}
