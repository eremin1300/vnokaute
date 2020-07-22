package training.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class message {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;

    public message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
