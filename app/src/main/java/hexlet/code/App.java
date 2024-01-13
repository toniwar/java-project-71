package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)
public class App implements Runnable {
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private Boolean help = false;

    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    private Boolean version = false;


    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {

    }
}
