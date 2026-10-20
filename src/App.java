import java.math.BigDecimal;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        // ArrayList<Expense> expenses = new ArrayList<>();
        HashMap<String, BigDecimal> totalAmountByCategory = new HashMap<>();

        int n = args.length;
        if (n == 0) {
            System.out.println("Error! Enter a command.");
            System.out.println("Available commands: add, list, delete, summary");
            return;
        }
        String commannd = args[0];

        switch (commannd) {
            case "add":
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
                            return;
                        }
                    } else if (args[i].equals("--amount")) {
                        if (i + 1 < n && !args[i + 1].startsWith("--")) {
                            try {
                                amount = new BigDecimal(args[i + 1]);
                                i++;
                            } catch (NumberFormatException e) {
                                System.out.println("Error! Invalid amount provided");
                                return;
                            }
                        } else {
                            System.out.println("Error! No amount provided");
                            return;
                        }
                    } else if (args[i].equals("--category")) {
                        if (i + 1 < n && !args[i + 1].startsWith("--")) {
                            category = args[i + 1];
                            i++;
                        } else {
                            System.out.println("Error! No category provided");
                            return;
                        }
                    } else {
                        System.out.println("Error! Invalid option " + args[i]);
                        return;
                    }
                }
                if (amount == null || description.isBlank() || category.isBlank()) {
                    System.out.println(
                            "Error! Invalid format sequence need amount, category, description values as well.");
                    return;
                } else if (amount.signum() <= 0) {
                    System.out.println("Error! Amount cannot be zero or negative.");
                    return;
                }

                // Expense expense = new Expense(amount, description, category);

                // System.out.println("Expense object created with ID: " + expense.getId() + " |
                // " + description + " | "
                // + amount + " | " + category);
                break;

            case "update":
                System.out.println("Update expense");
                break;
            case "delete":
                System.out.println("Delete expense");
                break;
            case "list":
                System.out.println("List expense");
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
