package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String path = "C:\\Dev\\ws-eclipse\\Pasta Arquivo Execício Files\\Products Sale.csv";
		new File("C:\\Dev\\ws-eclipse\\Pasta Arquivo Execício Files\\out\\test").mkdir();
		String pathOut = "C:\\Dev\\\\ws-eclipse\\Pasta Arquivo Execício Files\\out\\test\\Summari.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
				while (line != null) {

					String[] word = line.split(",");
					double totalValue = Double.parseDouble(word[1]) * Double.parseDouble(word[2]);
					bw.write(word[0] + "," + String.format("%.2f", totalValue));
					bw.newLine();
					line = br.readLine();
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
