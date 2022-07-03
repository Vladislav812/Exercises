import java.util.Objects;

public final class Ticket {
    String from;
    String to;

    Ticket() {
    }

    Ticket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(from, ticket.from) && Objects.equals(to, ticket.to);
    }

    public int hashCode() {
        return Objects.hash(from, to);
    }
}
