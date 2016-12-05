package com.d3rty.aaaprotocol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger log = LogManager.getLogger(Aaa.class);

    public static void main(String[] args) {
        DbManager.migrate();
        DbManager.connect();
        DbManager conn = new DbManager();
        ParsedData parsedData = new Parsing(args).parse();
        if (parsedData.isEmpty()) {
            log.info("Data is empty. Exit code: 0");
            System.exit(0);
        } else if (parsedData.isAccountingPossible()) {
            Aaa.tryAuthentication(conn, parsedData);
            Aaa.tryAuthorization(parsedData);
            Aaa.tryAccounting(parsedData);
        } else if (parsedData.isAuthorizationPossible()) {
            Aaa.tryAuthentication(conn, parsedData);
            Aaa.tryAuthorization(parsedData);
        } else if (parsedData.isAuthenticationPossible()) {
            Aaa.tryAuthentication(conn, parsedData);
        } else {
            System.exit(0);
        }
        DbManager.disconnect();
    }

}