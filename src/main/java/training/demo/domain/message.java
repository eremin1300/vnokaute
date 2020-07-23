package training.demo.domain;

import javax.persistence.*;

@Entity
public class message {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public message(String text, String tag, User author) {
        this.text = text;
        this.tag = tag;
        this.author = author;
    }
    public String getAuthorName() {
        return author !=null ? author.getUsername(): "none";
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
