package bbangscompany.bbangscompany.main.entity;

import org.springframework.lang.NonNull;

public class ContactUs {

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String subject;

    @NonNull
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
