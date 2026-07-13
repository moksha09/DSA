package org.example.system_design.exercise.builder.emailBuilder;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private final String to;
    private final String subject;
    private final List<String> cc;
    private final List<String> bcc;
    private final String body;
    private final String priority;
    private final List<String> attachment;

    private Email(Builder builder){
        this.to = builder.to;
        this.subject = builder.subject;
        this.cc = List.copyOf(builder.cc);
        this.bcc = List.copyOf(builder.bcc);
        this.body = builder.body;
        this.priority = builder.priority;
        this.attachment = List.copyOf(builder.attachment);
    }

    @Override
    public String toString() {
        // TODO: Return formatted string showing all fields
        // Expected format: Email{to='...', subject='...', cc=[...], bcc=[...], body='...', priority='...', attachments=[...]}
        return "Email{to='"+to+"', "+ "subject=" + subject +", cc="+cc+", " + "body = " + body + ", " +"priority = " + priority + ", attachments="+ attachment + " }";
    }

    public static class Builder{
        private final String to;
        private final String subject;
        private List<String> cc = new ArrayList<>();
        private List<String> bcc = new ArrayList<>();
        private String body;
        private String priority = "normal";
        private List<String> attachment = new ArrayList<>();

        public Builder(String to, String subject){
            this.to = to;
            this.subject = subject;
        }

        public Builder cc(String cc){
            this.cc.add(cc);
            return this;
        }

        public Builder bcc(String bcc){
            this.bcc.add(bcc);
            return this;
        }

        public Builder body(String body){
            this.body = body;
            return this;
        }

        public Builder priority(String priority){
            this.priority = priority;
            return this;
        }

        public Builder attachment(String attachment){
            this.attachment.add(attachment);
            return this;
        }

        public Email build(){
            return new Email(this);
        }
    }

}
