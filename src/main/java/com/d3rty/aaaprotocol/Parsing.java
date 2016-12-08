package com.d3rty.aaaprotocol;

import org.apache.commons.cli.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Parsing {

    private static final Logger log = LogManager.getLogger(Parsing.class);

    private String[] args = null;
    private Options options = new Options();

    public Parsing(String[] args) {
        this.args = args;
        options.addOption("l", "login", true, "your login");
        options.addOption("p", "password", true, "your password");
        options.addOption("res", "resource", true, "requested resource (e.g. 'AB.CD.E')");
        options.addOption("role", "role", true, "your role on this resource (READ/WRITE/EXECUTE)");
        options.addOption("ds", "datestart", true, "date of start using [YYYY-MM-DD]");
        options.addOption("de", "dateend", true, "date of end using [YYYY-MM-DD]");
        options.addOption("vol", "volume", true, "volume");
        options.addOption("h", "help", false, "show help");
    }

    public ParsedData parse() {
        CommandLineParser parser = new DefaultParser();
        ParsedData cmdData = new ParsedData();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("l")) {
                cmdData.setLogin(cmd.getOptionValue("l"));
                System.out.println("Login: " + cmdData.getLogin());
                log.info("Login: " + cmdData.getLogin());
            }
            if (cmd.hasOption("p")) {
                cmdData.setPassword(cmd.getOptionValue("p"));
                System.out.println("Password: " + cmdData.getPassword());
                log.info("Password: " + cmdData.getPassword());
            }
            if (cmd.hasOption("res")) {
                cmdData.setResource(cmd.getOptionValue("res"));
                System.out.println("Resource: " + cmdData.getResource());
                log.info("Resource: " + cmdData.getResource());
            }
            if (cmd.hasOption("role")) {
                cmdData.setRole(cmd.getOptionValue("role"));
                System.out.println("Role: " + cmdData.getRole());
                log.info("Role: " + cmdData.getRole());
            }
            if (cmd.hasOption("ds")) {
                cmdData.setDateSt(cmd.getOptionValue("ds"));
                System.out.println("Date Start: " + cmdData.getDateSt());
                log.info("Date Start: " + cmdData.getDateSt());
            }
            if (cmd.hasOption("de")) {
                cmdData.setDateEnd(cmd.getOptionValue("de"));
                System.out.println("Date End: " + cmdData.getDateEnd());
                log.info("Date End: " + cmdData.getDateEnd());
            }
            if (cmd.hasOption("vol")) {
                cmdData.setVolume(cmd.getOptionValue("vol"));
                System.out.println("Volume: " + cmdData.getVolume());
                log.info("Volume: " + cmdData.getVolume());
            }
            if (cmd.hasOption("h") || cmdData.isEmpty()) {
                help();
            }
        } catch (ParseException e) {
            log.error("Failed to Parse command line properties", e);
            help();
        }
        return cmdData;
    }

    private void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Allowed options", options);
        System.exit(0);
    }
}