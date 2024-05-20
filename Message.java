public class Message {
    private Person sender;
    private Person receiver;
    private String content;

    public Message(Person sender, Person receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Person getSender() {
        return sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }
}