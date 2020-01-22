package cool;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class LogSystem 
{
	public static enum LogLevel {
		INFO,
		WARNING,
		ERROR,
		COMPETECOMPETITION,
		CRITICAL,
		ALLOCATE,
		SYSTEM,
		FATAL,
		TERMINATED,
	}

	public static enum LogVersion {
		INTERNAL,
		ALPHA,
		BETA,
		TEAM,
		SERVICEPACK,
		DEBUG,
		RELEASE,
		STANDARD,
	}

	private static LogLevel MessageLevel = LogLevel.INFO;
	private static LogVersion VersionLevel = LogVersion.DEBUG;

	private String logging_file_name = ".\\LogSystem.db";
	private StringBuilder logging_string = new StringBuilder(1024 * 10);

	private FileOutputStream file_stream = null;

	public void Create2Log(String LogName) throws IOException {
		ValidParams.IsNull(LogName, "Create2Log(error)", true);

		logging_file_name = LogName;

		file_stream = new FileOutputStream(logging_file_name);
		if (null == file_stream) {
			System.out.println("Create Log FileHandler Error, Please Checking Your Acess...");
			file_stream.close();
		}
	}

	public String GetStreamBuffer() {
		return logging_string.toString();
	}

	public void Get2Console(String _data) {
		ValidParams.IsNull(_data, "Get2Console(error)", true);

		System.out.println("Time Now 		: " + new Date());
		System.out.println("Info Level 	: " 	+ MessageLevel);
		System.out.println("Ver  Level 	: " 	+ VersionLevel);
		System.out.println("Data Buffer  	: " + _data);
	}

	public void Get2Log(String data, LogLevel level, LogVersion version) {
		ValidParams.IsNull(data, "Get2Log(error)", true);

		logging_string.append("Time Now 	: " + new Date() + "\n")
				.append("Info Level 	: " + level + "\n")
				.append("Ver  Level 	: " + version + "\n")
				.append("Data Buffer  : " + data + "\n");
	}

	public void Write2Log() throws IOException {
		if (file_stream != null) {
			file_stream.write(logging_string.toString().getBytes());
			file_stream.flush();

			logging_string.setLength(0);
		}
	}

	public void Closing() throws IOException {
		if (file_stream != null) {
			file_stream.close();
		}

		logging_string.setLength(0);
	}

	public static final LogLevel SetReportingLevel(LogLevel _level) {
		return MessageLevel = _level;
	}

	public static final LogVersion SetReportingVersion(LogVersion _version) {
		return VersionLevel = _version;
	}

	public static final LogLevel GetReportingLevel() {
		return MessageLevel;
	}

	public static final LogVersion GetReportingVersion() {
		return VersionLevel;
	}
}
