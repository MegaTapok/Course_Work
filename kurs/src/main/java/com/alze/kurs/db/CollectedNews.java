package com.alze.kurs.db;

import javax.persistence.*;


@Table(name = "CollectedNews")
@Entity
public class CollectedNews {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "PO_URL")
    private String post_url;

    @Column(name = "PK_URL")
    private String pick_url;

    protected CollectedNews() {
    }

    public CollectedNews(Long id,String post_url,String pick_url) {
        this.id=id;
        this.post_url=post_url;
        this.pick_url=pick_url;
    }

    @Override
    public String toString() {
        return String.format("CollectedNews[id=%d, post_url='%s', pick_url='%s']", id, post_url, pick_url);
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

