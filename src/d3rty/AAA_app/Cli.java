package d3rty.AAA_app;

/**
 * Created by Danil on 01.10.2016.
 */

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
        options.addOption("login", "login", true, "your login");
        options.addOption("pass", "password", true, "your password");
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

            if (cmd.hasOption("h"))
                help();

            if (cmd.hasOption("v")) {
                log.log(Level.INFO, "Using cli argument -v=" + cmd.getOptionValue("v"));
                // Whatever you want to do with the setting goes here
            }
            if (cmd.hasOption("login")) {
                System.out.println(cmd.getOptionValue("login"));
            }

            if (cmd.hasOption("pass")) {
            }

            if (cmd.hasOption("res")) {
            }

            if (cmd.hasOption("role")) {
            }

            if (cmd.hasOption("ds")) {
            }

            if (cmd.hasOption("de")) {
            }

            if (cmd.hasOption("val")) {
            }

        } catch (ParseException e) {
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