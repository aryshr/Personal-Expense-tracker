import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {
    private int id;
    private BigDecimal amount;
    private String description;
    private String category;
    private LocalDate date;

    public Expense(int id, BigDecimal amount, String description, String category) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = LocalDate.now();
    }

    // Added this to provide custom date as per choice
    public Expense(int id, BigDecimal amount, String description, String category, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String toCsvLine() {
        return String.join(",",
                String.valueOf(id),
                getDate().toString(),
                getDescription(),
                getAmount().toPlainString(),
                getCategory());
    }

    public static String getHeader() {
        return "%-5s %-12s %-20s %-15s %s".formatted(
                "ID", "Date", "Description", "Category", "Amount");
    }

    @Override
    public String toString() {
        return "%-5d %-12s %-20s %-15s $%s".formatted(
                this.getId(),
                this.getDate(),
                this.getDescription(),
                this.getCategory(),
                this.getAmount());
    }
}
