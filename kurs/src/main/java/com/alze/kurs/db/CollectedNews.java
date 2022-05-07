package com.alze.kurs.db;

import javax.persistence.*;

//Класс-предствление Базы данных

@Table(name = "CollectedNews")
@Entity
public class CollectedNews {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "PO_URL")
    private String post_url;

    @Column(name = "PC_URL")
    private String pick_url;

    @Column(name="Title")
    private String title;

    @Lob
    @Column(name="Desc" )
    private String description;

    protected CollectedNews() {
    }

    public CollectedNews(Long id,String post_url,String pick_url,String title,String description) {
        this.id=id;
        this.post_url=post_url;
        this.pick_url=pick_url;
        this.title=title;
        this.description=description;
    }

    @Override
    public String toString() {
        return "CollectedNews{" + "id=" + id + ", post_url='" + post_url + '\'' + ", pick_url='" + pick_url + '\'' + ", title='" + title + '\'' + ", description='" + description + '\'' + '}';
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String description) {
        this.title = description;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}