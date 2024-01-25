package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)
public class App implements Callable {

    @Parameters(index = "0", paramLabel = "filePath1", description = "path to first file")
    private String filePath1 = null;

    @Parameters(index = "1", paramLabel = "filePath2", description = "path to second file")
    private String filePath2 = null;
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private Boolean help = false;

    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    private Boolean version = false;

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format = "format";

    public static void main(String[] args) {

        new CommandLine(new App()).execute(args);
    }

    @Override
    public Object call() {
        String result = "";
        if (filePath1 != null && filePath2 != null) {
            try {
                result = Differ.generate(filePath1, filePath2);
            } catch (Exception e) {
                result = e.getMessage();
            }
            System.out.println(result);
        } else {
            System.out.println("Ups!");
        }
        return result;
    }

}
