public class Person {
    private String name;
    private Transmitter transmitter;

    public Person(String name) {
        this.name = name;
    }

    public void setTransmitter(Transmitter transmitter) {
        this.transmitter = transmitter;
    }

    public void send(Person receiver, String content) {
        Message message = new Message(this, receiver, content);
        transmitter.store(message);
    }

    public void receiveMessage(Message message) {
        System.out.println(this.name + " received a message from " + message.getSender().getName() + ": " + message.getContent());
    }

    public void notify(Transmitter transmitter) {
        transmitter.retrieve(this);
    }

    public String getName() {
        return name;
    }
}