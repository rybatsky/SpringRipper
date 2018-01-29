package quoters;

public class TerminatorQuoter implements Quoter {
    private String message;

    @Override
    public void sayQuote() {
        System.out.print(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
