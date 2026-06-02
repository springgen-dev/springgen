package org.springgen.cli;


import org.springgen.cli.command.GenerateCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
		name = "springgen",
		mixinStandardHelpOptions = true,
		subcommands = {
				GenerateCommand.class
		}
)
public class SpringGenCliApplication implements Runnable {

	public static void main(String[] args) {
		int exitCode = new CommandLine(new SpringGenCliApplication()).execute(args);
		System.exit(exitCode);
	}

	@Override
	public void run() {
		CommandLine.usage(this, System.out);
	}
}