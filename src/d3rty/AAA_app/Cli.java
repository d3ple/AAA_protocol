package d3rty.AAA_app;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

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

    public void parse() {
        CommandLineParser parser = new BasicParser();

        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("l")) {
                String[] arguments = cmd.getOptionValues("l");
                System.out.println("Login : " + arguments[0]);
            }

            if (cmd.hasOption("h"))
                help();

            if (cmd.hasOption("p")) {
                String[] arguments = cmd.getOptionValues("p");
                System.out.println("Password : " + arguments[0]);
            }

            if (cmd.hasOption("res")) {
                String[] arguments = cmd.getOptionValues("res");
                System.out.println("Resurse : " + arguments[0]);

            }

            if (cmd.hasOption("role")) {
                String[] arguments = cmd.getOptionValues("role");
                System.out.println("Role : " + arguments[0]);

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




        }
        catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to parse comand line properties", e);
            help();
        }
    }

    private void help() {
        // This prints out some help
        HelpFormatter formater = new HelpFormatter();

        formater.printHelp("Main", options);
        System.exit(0);
    }
}