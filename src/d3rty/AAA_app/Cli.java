package d3rty.AAA_app;


import org.apache.commons.cli.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cli {
    private static final Logger log = Logger.getLogger(Cli.class.getName());
    private String[] args = null;
    private Options options = new Options();

    public Cli(String[] args) {

        this.args = args;

        options.addOption("v", "var", true, "Here you can set parameter");
        options.addOption("l", "login", true, "your login");
        options.addOption("p", "password", true, "your password");
        options.addOption("res", "resource", true, "requested resource (e.g. 'AB.CD.E')");
        options.addOption("role", "role", true, "your role on this resource (READ/WRITE/EXECUTE)");
        options.addOption("ds", "datestart", true, "date of start using [YYYY-MM-DD]");
        options.addOption("de", "dateend", true, "date of end using [YYYY-MM-DD]");
        options.addOption("vol", "volume", true, "volume");
        options.addOption("h", "help", false, "show help");
    }

    public Parse parse() {
        CommandLineParser parser = new PosixParser();
        Parse Data = new Parse();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("l")) {
                Data.setU_login(cmd.getOptionValue("l"));
                System.out.println("Login : " + Data.getU_login());
            }


            if (cmd.hasOption("p")) {
                Data.setU_password(cmd.getOptionValue("p"));
                System.out.println("Password : " + Data.getU_password());
            }

            if (cmd.hasOption("res")) {
                Data.setU_resurse(cmd.getOptionValue("res"));
                System.out.println("Resurse : " + Data.getU_resurse());

            }

            if (cmd.hasOption("role")) {
                Data.setU_role(cmd.getOptionValue("role"));
                System.out.println("Role : " + Data.getU_role());

            }

            if (cmd.hasOption("ds")) {
                String[] arguments = cmd.getOptionValues("ds");
                System.out.println("Date Start : " + arguments[0]);

            }

            if (cmd.hasOption("de")) {
                String[] arguments = cmd.getOptionValues("de");
                System.out.println("Date End : " + arguments[0]);

            }

            if (cmd.hasOption("val")) {
                String[] arguments = cmd.getOptionValues("val");
                System.out.println("Values : " + arguments[0]);

            }

            if (cmd.hasOption("h") || Data.isEmpty())
                help();


        } catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to Parse comand line properties", e);
            help();
        }
        return Data;
    }

    private void help() {

        HelpFormatter formater = new HelpFormatter();

        formater.printHelp("Main", options);
        System.exit(0);
    }
}