package com.d3rty.aaa_app;

import org.apache.commons.cli.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Cli {

    private static final Logger log = Logger.getLogger(Cli.class.getName());
    private String[] args = null;
    private Options options = new Options();

    public Cli(String[] args) {
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

    public ParsedUserData parse() {
        CommandLineParser parser = new DefaultParser();
        ParsedUserData cmdData = new ParsedUserData();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("l")) {
                cmdData.setLogin(cmd.getOptionValue("l"));
                System.out.println("Login : " + cmdData.getLogin());
            }
            if (cmd.hasOption("p")) {
                cmdData.setPassword(cmd.getOptionValue("p"));
                System.out.println("Password : " + cmdData.getPassword());
            }
            if (cmd.hasOption("res")) {
                cmdData.setResource(cmd.getOptionValue("res"));
                System.out.println("Resource : " + cmdData.getResource());
            }
            if (cmd.hasOption("role")) {
                cmdData.setRole(cmd.getOptionValue("role"));
                System.out.println("Role : " + cmdData.getRole());
            }
            if (cmd.hasOption("ds")) {
                cmdData.setDateSt(cmd.getOptionValue("ds"));
                System.out.println("Date Start : " + cmdData.getDateSt());
            }
            if (cmd.hasOption("de")) {
                cmdData.setDateEnd(cmd.getOptionValue("de"));
                System.out.println("Date Start : " + cmdData.getDateEnd());
            }
            if (cmd.hasOption("vol")) {
                cmdData.setVolume(cmd.getOptionValue("vol"));
                System.out.println("Volume : " + cmdData.getVolume());
            }
            if (cmd.hasOption("h") || cmdData.isEmpty()) {
                help();
            }
        } catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to Parse command line properties", e);
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