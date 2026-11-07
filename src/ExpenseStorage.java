import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void saveExpenses(List<Expense> expenses) throws IOException {
        List<String> expenseList = new ArrayList<>();
        for (Expense expense : expenses) {
            String csvLine = expense.toCsvLine();
            expenseList.add(csvLine);
        }
        saveLines(expenseList);
    }

    private Expense fromCsvLine(String line) {
        String[] expenseInfo = line.split(",");
        int id = Integer.parseInt(expenseInfo[0]);
        LocalDate date = LocalDate.parse(expenseInfo[1]);
        String description = expenseInfo[2];
        BigDecimal amt = new BigDecimal(expenseInfo[3]);
        String category = expenseInfo[4];

        return new Expense(id, amt, description, category, date);
    }

    public List<Expense> loadExpenses() throws IOException {
        List<String> lines = loadLines();

        List<Expense> expenses = new ArrayList<>();

        for (String line : lines) {
            Expense expense = fromCsvLine(line);
            expenses.add(expense);
        }

        return expenses;

    }
}
