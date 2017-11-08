package minor.infosupport.game.models;

import java.util.Date;

public class GameEvent {

    private long timestamp;
    private String eventKey;
    private String eventMessage;

    public GameEvent(long timestamp, String eventKey, String eventMessage) {
        this.timestamp = timestamp;
        this.eventKey = eventKey;
        this.eventMessage = eventMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }
}
