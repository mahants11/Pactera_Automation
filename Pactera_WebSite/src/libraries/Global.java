package libraries;

/**
 * @Description This class has global data accessed by the test cases and all libraries
 */
public class Global   {

	// ******************************************************************************************
	// Global Constant values
	// ******************************************************************************************

	//to get project root
	public static final String PROJECT_ROOT = getProjectRoot();
	
	// Test Environment information
	public static String BaseURL 		= "http://www.pactera.com/"; 

	// Timeout values in seconds
	public static final int QUICK_TIMEOUT = 10;
	public static final int MAX_TIMEOUT   = 120;

	// Search String informations
	public static String SEARCH_STRING 	= "Test Automation";

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	// Getter methods
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	private static String getProjectRoot() {
		String projectRoot = Global.class.getClassLoader().getResource(".").getPath();
		projectRoot = projectRoot.replace("bin/", "");
		return projectRoot;
	}

}
