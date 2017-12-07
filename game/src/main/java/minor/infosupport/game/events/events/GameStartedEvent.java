package minor.infosupport.game.events.events;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class GameStartedEvent extends RemoteApplicationEvent {

    private String message;

    // Must supply a default constructor and getters/setters for deserialization

    public GameStartedEvent() {
    }

    public GameStartedEvent(Object source, String originService, String message) {
        // source is the object that is publishing the event

        // originService is the unique context ID of the publisher

        super(source, originService);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public GameStartedEvent setMessage(String message) {
        this.message = message;
        return this;
    }

}
