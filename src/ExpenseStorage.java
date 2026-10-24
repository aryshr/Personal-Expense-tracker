import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ExpenseStorage {
    private final Path path = Path.of("expenses.csv");

    public List<String> loadLines() throws IOException {
        if (!Files.exists(path)) {
            return List.of();
        }
        return Files.readAllLines(path);
    }

    public void saveLines(List<String> lines) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.write(path, lines);

    }
}
