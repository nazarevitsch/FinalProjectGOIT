package com.bida.finalproject.riaautos.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mailsending")
public class SearchForEmailNotification {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "link")
    private String link;

    public SearchForEmailNotification(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "SearchForEmailNotification{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
