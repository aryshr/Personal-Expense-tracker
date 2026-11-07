import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class StorageTest {

    public static void main(String[] args) throws IOException {
        ExpenseStorage expenseStorage = new ExpenseStorage();
        // List<String> li = List.of("first record", "second record");

        // Expense expense1 = new Expense(
        // 1,
        // new BigDecimal("20.00"),
        // "Lunch",
        // "Food");

        // Expense expense2 = new Expense(
        // 2,
        // new BigDecimal("20.00"),
        // "Dinner",
        // "Food");

        // List<Expense> expenses = List.of(expense1, expense2);

        // // Saving expenses
        // try {
        // expenseStorage.saveExpenses(expenses);
        // } catch (Exception e) {
        // System.out.println("Error while saving Expenses " + e.getMessage());
        // }

        List<Expense> expenses1 = expenseStorage.loadExpenses();
        for (Expense exp : expenses1) {
            System.out.println(exp.toString());
        }

        // ****Saving plain lines just for testing - can be removed later*********
        // try {
        // expenseStorage.saveLines(li);
        // } catch (Exception e) {
        // System.out.println("Error while saving lines " + e.getMessage());
        // }

        // try {
        // List<String> loadedLies = expenseStorage.loadLines();

        // } catch (Exception e) {
        // System.out.println("Error while loading lines" + e.getMessage());
        // }
        // System.out.println(li);

        // List<String> li2 = List.of("replacement record");

        // try {
        // expenseStorage.saveLines(li2);
        // } catch (Exception e) {
        // System.out.println("Error while saving lines " + e.getMessage());
        // }

        // try {
        // List<String> loadedLies = expenseStorage.loadLines();

        // } catch (Exception e) {
        // System.out.println("Error while loading lines" + e.getMessage());
        // }

        // System.out.println(li2);

    }
}
