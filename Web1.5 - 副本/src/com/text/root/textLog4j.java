package com.text.root;

import org.apache.log4j.Logger;

public class textLog4j {
    private static Logger log = Logger.getLogger(textLog4j.class);
	public static void main(String[] args) {
          log.debug("hello world debug");
          log.info("hello world info");
          log.warn("hello world warn");
          log.error("hello worlderror");
	}

}
