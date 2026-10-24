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

}
