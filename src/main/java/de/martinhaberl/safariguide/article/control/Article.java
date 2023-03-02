package de.martinhaberl.safariguide.article.control;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class Article {

    private UUID uuid;
    private Instant createdAt;
    private Instant modifiedAt;
    private int version;
    private String headline;
    private String text;
    private UUID authorId;

    public Article() {
    }

    public Article(UUID uuid, Instant createdAt, Instant modifiedAt, int version, String headline, String text, UUID authorId) {

        this.uuid = uuid;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.version = version;
        this.headline = headline;
        this.text = text;
        this.authorId = authorId;
    }


}
