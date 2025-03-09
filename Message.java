public class Message {

    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private long timestamp;
/*
    public Message(MessageType messageType, String content, String sender, String recipient, boolean isDelivered, long timestamp) {
        this.messageType = messageType;
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
        this.isDelivered = isDelivered;
        this.timestamp = timestamp;
    }*/

    public Message(MessageBuilder builder) {
        this.messageType =builder.messageType;
        this.content = builder.content;
        this.sender = builder.sender;
        this.recipient = builder.recipient;
        this.isDelivered = builder.isDelivered;
        this.timestamp = builder.timestamp;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // Static Builder class
    public static class MessageBuilder {
        private MessageType messageType;
        private String content;
        private String sender;
        private String recipient;
        private boolean isDelivered;
        private long timestamp;
        
        // Since first 4fields are mandatory and remaining are optional, we need to have a constructor that takes all the mandatory fields
        public MessageBuilder(MessageType messageType, String content, String sender, String recipient) {
            this.messageType = messageType;
            this.content = content;
            this.sender = sender;
            this.recipient = recipient;
        }

        public MessageBuilder isDelivered(boolean isDelivered) {
            this.isDelivered = isDelivered;
            return this;
        }

        public MessageBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        public Message build() {
            return new Message(this);
        }

        
    }
}
