public class RestoreRoute {
    public static void main(String[] args) {
        Ticket[] ticketsList = new Ticket[5];
        ticketsList[0] = new Ticket("Спб", "Минск");
        ticketsList[1] = new Ticket("Киев", "Новосибирск");
        ticketsList[2] = new Ticket("Череповец", "Москва");
        ticketsList[3] = new Ticket("Минск", "Киев");
        ticketsList[4] = new Ticket("Москва", "Спб");

        int start = departure(ticketsList);
        Ticket[] way = route(ticketsList, start);

        for (int i = 0; i < way.length; i++)
            System.out.println(way[i].from + " " + way[i].to);

    }

    static int departure(Ticket[] ticketsList) {
        int departure = 0;
        for (int i = 0; i < ticketsList.length; i++) {
            for (int j = 0; j < ticketsList.length; j++) {
                if (ticketsList[i].from.equals(ticketsList[j].to))
                    break;
                else if (j == ticketsList.length - 1)
                    departure = i;
            }
        }
        return departure;
    }

    static int nextTicket(Ticket[] ticketsList, int previous) {
        for (int i = 0; i < ticketsList.length; i++) {
            if (ticketsList[previous].to.equals(ticketsList[i].from))
                return i;
        }
        return -1;
    }

    static Ticket[] route(Ticket[] ticketsList, int start) {
        Ticket[] route = new Ticket[ticketsList.length];
        route[0] = ticketsList[start];
        int i = 1;
        while (nextTicket(ticketsList, start) != -1) {
            route[i] = ticketsList[nextTicket(ticketsList, start)];
            i++;
            start = nextTicket(ticketsList, start);
        }
        return route;
    }
}


public class Ticket {
    String from;
    String to;

    Ticket() {
    }

    Ticket(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
