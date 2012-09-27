package github.Lucycraft.LucycraftModule.Kit.Includes;

	import java.util.logging.Logger;

public class LCLogger {

	private static Logger log;
	private static String prefix;
	
	public static void initialize(Logger newLog) {
		
		LCLogger.log = newLog;
		prefix = "[LCModuleKit] ";
		
	}
	
	public static void info(String message) {
		log.info(prefix + message);
	}
	
	public static void error(String message) {
        log.severe(prefix + message);
    }
	
    public static void warning(String message) {
        log.warning(prefix + message);
    }

    public static void config(String message) {
        log.config(prefix + message);
    }
}
