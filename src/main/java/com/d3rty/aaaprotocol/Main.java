package com.d3rty.aaaprotocol;

import com.d3rty.aaaprotocol.dao.DbManager;
import com.d3rty.aaaprotocol.dao.DbUserSelecting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DbManager dataBase = new DbManager();
        DbUserSelecting dbUser = new DbUserSelecting();
        dataBase.migrate();
        dataBase.connect();
        ParsedData parsedData = new Parsing(args).parse();
        if (parsedData.isEmpty()) {
            log.info("Data is empty. Exit code: 0");
            System.exit(0);
        } else if (parsedData.isAccountingPossible()) {
            Aaa.tryAuthentication(parsedData, dbUser);
            Aaa.tryAuthorization(parsedData, dbUser);
            Aaa.tryAccounting(parsedData, dbUser);
        } else if (parsedData.isAuthorizationPossible()) {
            Aaa.tryAuthentication(parsedData, dbUser);
            Aaa.tryAuthorization(parsedData, dbUser);
        } else if (parsedData.isAuthenticationPossible()) {
            Aaa.tryAuthentication(parsedData, dbUser);
        } else {
            System.exit(0);
        }
        dataBase.disconnect();
    }

}