interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Gui Email: " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Gui SMS: " + message);
    }
}

class Notification {
    private MessageService service;

    // Setter Injection
    public void setService(MessageService service) {
        this.service = service;
    }

    public void send(String msg) {
        if (service != null) {
            service.sendMessage(msg);
        }
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Notification note = new Notification();

        note.setService(new EmailService());
        note.send("Thong bao qua Email");

        note.setService(new SMSService());
        note.send("Thong bao qua SMS");
    }
}