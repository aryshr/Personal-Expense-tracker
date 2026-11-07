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

    public String toString() {
        return "ID: %s\n Amt: %s\n Description: %s\n Category: %s\n Date: %s".formatted(
                this.getId(),
                this.getAmount(),
                this.getDescription(),
                this.getCategory(),
                this.getDate());
    }
}
