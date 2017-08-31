package com.choice.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4JSocketAppenderTest {
	public static void main(String[] args) throws Exception {
		// 发送日志记录时间
		long runTime = 1000 * 60 * 1;
		DOMConfigurator.configure(Log4JSocketAppenderTest.class.getResource("log4j.xml"));
		Logger remoteLogger = LogManager.getLogger("taizhou");
		long i = 0;
		String sendInfo = "the send info is ";
		long old = System.currentTimeMillis();
		while (true) {
			System.out.println("send info begin:  " + sendInfo + i);
			remoteLogger.info(sendInfo + i);
			i++;
			// 每3秒记录一次日志
			Thread.sleep(1000 * 3);
			long now = System.currentTimeMillis();
			if ((now - old) > runTime) {
				break;
			}
		}
	}
}
