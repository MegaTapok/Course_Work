package com.alze.kurs.db;

import javax.persistence.*;

@Entity
@Table(name = "COLLECTEDNEWS")
public class CollectedNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "PO_URL")
    private String post_url;

    @Column(name = "PK_URL")
    private String pick_url;

    public CollectedNews() {
    }

    public CollectedNews(String pourl,String pickurl) {
        this.post_url=pourl;
        this.pick_url=pickurl;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPost_url() {
        return post_url;
    }
    public void setPost_url(String post_url) {
        this.post_url = post_url;
    }
    public String getPick_url() {
        return pick_url;
    }
    public void setPick_url(String pick_url) {
        this.pick_url = pick_url;
    }
}

