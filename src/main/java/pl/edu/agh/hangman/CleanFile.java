import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CleanFile {

    public static void main(String[] args) {

        String inputPath = "słowa.txt";
        String outputPath = "słowa_wyczyszczone.txt";

        try {
            // 1. Odczyt pliku
            String content = new String(
                    Files.readAllBytes(Paths.get(inputPath))
            ).toLowerCase();

            // 2. Czyszczenie — ZOSTAJĄ polskie litery
            String cleanedContent = content
                    .replaceAll("&nbsp;", " ")
                    // \p{L} = wszystkie litery Unicode (w tym polskie)
                    .replaceAll("[^\\p{L}\\s]", "")
                    .replaceAll("\\s+", " ")
                    .trim();

            // 3. Zapis do pliku
            Files.write(Paths.get(outputPath), cleanedContent.getBytes());

            System.out.println("Zachowano polskie znaki. Plik wyczyszczony.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
