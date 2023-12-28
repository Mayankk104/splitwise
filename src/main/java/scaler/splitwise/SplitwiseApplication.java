package scaler.splitwise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import scaler.splitwise.commands.Command;
import scaler.splitwise.commands.CommandExecutor;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner {
	private final Scanner scanner = new Scanner(System.in);
	private final CommandExecutor commandExecutor;

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	SplitwiseApplication(CommandExecutor commandExecutor, List<Command> commands) {
		this.commandExecutor = commandExecutor;
		commandExecutor.addCommands(commands);
	}

	@Override
	public void run (String... args) {
		String input = "";
		while (!input.equals("exit")) {
			System.out.println("Enter input: ");
			input = scanner.nextLine();
			System.out.println("---------------------------------------------");
			commandExecutor.execute(input);
		}
	}
}