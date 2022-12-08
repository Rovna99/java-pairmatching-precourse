package pairmatching.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewReader {
	private final String fileName;
	private final List<String> crewNames;

	public CrewReader(String fileName) {
		this.fileName = fileName;
		this.crewNames = new ArrayList<>();
	}

	public List<String> readCrewNames() {
		try {
			File file = new File("src/main/resources/" + fileName);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				crewNames.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("크루원 이름이 들어있는 파일이 존재하지 않습니다.");
		}
		return crewNames;
	}
}
