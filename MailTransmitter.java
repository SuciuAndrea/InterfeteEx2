
import java.util.ArrayList;
import java.util.List;

public class MailTransmitter implements Transmitter {
    private List<Message> messages = new ArrayList<>();
    private int bufferSize;

    public MailTransmitter(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public void store(Message message) {
        messages.add(message);
        if (messages.size() >= bufferSize) {
            for (Message msg : messages) {
                notifyReceiver(msg.getReceiver());
            }
        }
    }

    @Override
    public void retrieve(Person receiver) {
        List<Message> toRemove = new ArrayList<>();
        for (Message message : messages) {
            if (message.getReceiver().equals(receiver)) {
                receiver.receiveMessage(message);
                toRemove.add(message);
            }
        }
        messages.removeAll(toRemove);
    }

    private void notifyReceiver(Person receiver) {
        receiver.notify(this);
    }
}

