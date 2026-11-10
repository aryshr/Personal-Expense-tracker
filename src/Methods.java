import java.math.BigDecimal;
import java.util.List;

public class Methods {

    public Expense add(String[] args, List<Expense> expenses) {
        int n = args.length;
        int id = expenses.isEmpty() ? 1 : expenses.get(expenses.size() - 1).getId() + 1;
        BigDecimal amount = null;
        String description = "";
        String category = "";
        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("--description")) {
                if (i + 1 < n && !args[i + 1].startsWith("--")) {
                    description = args[i + 1];
                    i++;
                } else {
                    System.out.println("Error! No description provided");
                    return null;
                }
            } else if (args[i].equals("--amount")) {
                if (i + 1 < n && !args[i + 1].startsWith("--")) {
                    try {
                        amount = new BigDecimal(args[i + 1]);
                        i++;
                    } catch (NumberFormatException e) {
                        System.out.println("Error! Invalid amount provided");
                        return null;
                    }
                } else {
                    System.out.println("Error! No amount provided");
                    return null;
                }
            } else if (args[i].equals("--category")) {
                if (i + 1 < n && !args[i + 1].startsWith("--")) {
                    category = args[i + 1];
                    i++;
                } else {
                    System.out.println("Error! No category provided");
                    return null;
                }
            } else {
                System.out.println("Error! Invalid option " + args[i]);
                return null;
            }
        }
        if (amount == null || description.isBlank() || category.isBlank()) {
            System.out.println(
                    "Error! Invalid format sequence need amount, category, description values as well.");
            return null;
        } else if (amount.signum() <= 0) {
            System.out.println("Error! Amount cannot be zero or negative.");
            return null;
        }

        return new Expense(id, amount, description, category);

    }
}
