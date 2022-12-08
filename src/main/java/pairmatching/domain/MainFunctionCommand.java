package pairmatching.domain;

import java.util.Arrays;

public enum MainFunctionCommand {
	PAIR_MATCH("1"),
	PAIR_INQUIRY("2"),
	PAIR_INIT("3"),
	QUIT("Q");

	private final String command;

	MainFunctionCommand(String command) {
		this.command = command;
	}

	public static void of(String input) {
		Arrays.stream(MainFunctionCommand.values()).filter(command -> command.getCommand().equals(input))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 커맨드를 입력해 주세요."));
	}

	public String getCommand() {
		return command;
	}
}
