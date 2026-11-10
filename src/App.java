import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ExpenseStorage expenseStorage = new ExpenseStorage();
        Methods methods = new Methods();
        List<Expense> expenses = null;

        try {
            expenses = expenseStorage.loadExpenses();
        } catch (IOException e) {
            System.out.println("Unable to loadexpenses from file" + e.getMessage());
            return;
        }

        // HashMap<String, BigDecimal> totalAmountByCategory = new HashMap<>();

        int n = args.length;
        if (n == 0) {
            System.out.println("Error! Enter a command.");
            System.out.println("Available commands: add, list, delete, summary");
            return;
        }
        String command = args[0];

        switch (command) {
            case "add":
                Expense expense = methods.add(args, expenses);
                if (expense == null) {
                    System.out.println("Not working");
                } else {
                    expenses.add(expense);
                    try {
                        expenseStorage.saveExpenses(expenses);
                        System.out.println("Expense saved successfully! (ID : " + expense.getId() + ")");
                    } catch (IOException e) {
                        System.out.println("Failed to save expense " + e.getMessage());
                    }
                }

                // System.out.println("Expense object created with ID: " + expense.getId() + " |
                // "
                // + expense.getDescription() + " | " + expense.getAmount() + " | "
                // + expense.getCategory());
                break;

            case "update":
                System.out.println("Update expense");
                break;

            case "delete":
                if (methods.deleteExpense(args, expenses)) {
                    try {
                        expenseStorage.saveExpenses(expenses);
                        System.out.println("Expense deleted successfully");
                    } catch (IOException e) {
                        System.out.println("Unable to save expenses from file" + e.getMessage());
                    }
                }
                break;

            case "list":
                methods.listExpenses(expenses);
                break;

            case "summary":
                System.out.println("Summary");
                break;

            default:
                System.out.println("Error! Invalid command.");
                break;
        }

        // BigDecimal total = new BigDecimal("0"); // can use BigDecimal.ZERO also
        // for (Expense expense : expenses) {
        // total = total.add(expense.getAmount());

        // totalAmountByCategory.put(expense.getCategory(), totalAmountByCategory
        // .getOrDefault(expense.getCategory(), BigDecimal.ZERO)
        // .add(expense.getAmount()));
        // }

        // for (Map.Entry<String, BigDecimal> entry : totalAmountByCategory.entrySet())
        // {
        // String category = entry.getKey();
        // BigDecimal amount = entry.getValue();
        // System.out.println(category + " : " + amount);
        // }
        // System.out.println("Total expense :" + total);
    }

}
