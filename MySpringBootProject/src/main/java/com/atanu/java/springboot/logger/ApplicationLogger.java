package com.atanu.java.springboot.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ATANU
 * 
 */
public class ApplicationLogger {

	private Log log;

	private final String NULL_STRING = "null";
	private final String PATTERN = "[{]\\s{0,}[}]";

	@SuppressWarnings("rawtypes")
	public ApplicationLogger(Class clazz) {
		this.log = LogFactory.getLog(clazz);
	}

	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	public void trace(Object msg) {
		log.trace(msg);
	}

	public void debug(Object msg) {
		log.debug(msg);
	}

	public void info(Object msg) {
		log.info(msg);
	}

	public void warning(Object msg) {
		warn(msg);
	}

	public void warn(Object msg) {
		log.warn(msg);
	}

	public void error(Object msg) {
		log.error(msg);
	}

	public void fatal(Object msg) {
		log.fatal(msg);
	}

	public void trace(String msg, Throwable ex) {
		log.trace(msg, ex);
	}

	public void debug(String msg, Throwable ex) {
		log.debug(msg, ex);
	}

	public void info(String msg, Throwable ex) {
		log.info(msg, ex);
	}

	public void warn(String msg, Throwable ex) {
		log.warn(msg, ex);
	}

	public void error(String msg, Throwable ex) {
		log.error(msg, ex);
	}

	public void fatal(String msg, Throwable ex) {
		log.fatal(msg, ex);
	}

	public void trace(String msg, Object obj) {
		if (null != obj) {
			trace(msg.replaceAll(PATTERN, obj.toString()));
		} else {
			trace(msg.replaceAll(PATTERN, NULL_STRING));
		}
	}

	public void debug(String msg, Object obj) {
		if (null != obj) {
			debug(msg.replaceAll(PATTERN, obj.toString()));
		} else {
			debug(msg.replaceAll(PATTERN, NULL_STRING));
		}
	}

	public void info(String msg, Object obj) {
		if (null != obj) {
			info(msg.replaceAll(PATTERN, obj.toString()));
		} else {
			info(msg.replaceAll(PATTERN, NULL_STRING));
		}
	}

	public void warn(String msg, Object obj) {
		if (null != obj) {
			warn(msg.replaceAll(PATTERN, obj.toString()));
		} else {
			warn(msg.replaceAll(PATTERN, NULL_STRING));
		}
	}

	public void error(String msg, Object obj) {
		if (null != obj) {
			error(msg.replaceAll(PATTERN, obj.toString()));
		} else {
			error(msg.replaceAll(PATTERN, NULL_STRING));
		}
	}

	public void trace(String msg, Object obj1, Object obj2) {
		String obj1Str = NULL_STRING;
		String obj2Str = NULL_STRING;
		if (obj1 != null) {
			obj1Str = obj1.toString();
		}
		if (obj2 != null) {
			obj2Str = obj2.toString();
		}
		trace(msg.replaceFirst(PATTERN, obj1Str).replaceAll(PATTERN, obj2Str));
	}

	public void debug(String msg, Object obj1, Object obj2) {
		String obj1Str = NULL_STRING;
		String obj2Str = NULL_STRING;
		if (obj1 != null) {
			obj1Str = obj1.toString();
		}
		if (obj2 != null) {
			obj2Str = obj2.toString();
		}
		debug(msg.replaceFirst(PATTERN, obj1Str).replaceAll(PATTERN, obj2Str));
	}

	public void info(String msg, Object obj1, Object obj2) {
		String obj1Str = NULL_STRING;
		String obj2Str = NULL_STRING;
		if (obj1 != null) {
			obj1Str = obj1.toString();
		}
		if (obj2 != null) {
			obj2Str = obj2.toString();
		}
		info(msg.replaceFirst(PATTERN, obj1Str).replaceAll(PATTERN, obj2Str));
	}

	public void warn(String msg, Object obj1, Object obj2) {
		String obj1Str = NULL_STRING;
		String obj2Str = NULL_STRING;
		if (obj1 != null) {
			obj1Str = obj1.toString();
		}
		if (obj2 != null) {
			obj2Str = obj2.toString();
		}
		warn(msg.replaceFirst(PATTERN, obj1Str).replaceAll(PATTERN, obj2Str));
	}

	public void error(String msg, Object obj1, Object obj2) {
		String obj1Str = NULL_STRING;
		String obj2Str = NULL_STRING;
		if (obj1 != null) {
			obj1Str = obj1.toString();
		}
		if (obj2 != null) {
			obj2Str = obj2.toString();
		}
		error(msg.replaceFirst(PATTERN, obj1Str).replaceAll(PATTERN, obj2Str));
	}

	public void error(String msg, Object obj, Throwable ex) {
		if (null != obj) {
			error(msg.replaceAll(PATTERN, obj.toString()), ex);
		} else {
			error(msg.replaceAll(PATTERN, NULL_STRING), ex);
		}
	}

	public void fatal(String msg, Object obj, Throwable ex) {
		if (null != obj) {
			fatal(msg.replaceAll(PATTERN, obj.toString()), ex);
		} else {
			fatal(msg.replaceAll(PATTERN, NULL_STRING), ex);
		}
	}
}
