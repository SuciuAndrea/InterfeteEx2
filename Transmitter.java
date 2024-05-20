public interface Transmitter {
    void store(Message message);
    void retrieve(Person receiver);
}