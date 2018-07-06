package rcas.model;
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;

	public class Filereader {

		private static final String FILE = "C:\\Users\\wuerg\\Desktop\\TBZ\\!Module\\Modul 411\\data.txt";

		public static void main(String[] args) {

			BufferedReader br = null;
			FileReader fr = null;

			try {

				fr = new FileReader(FILE);
				br = new BufferedReader(fr);

				String sCurrentLine;

				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}

		}

	}

