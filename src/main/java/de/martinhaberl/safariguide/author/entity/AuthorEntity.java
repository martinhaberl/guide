package de.martinhaberl.safariguide.author.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity @EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class AuthorEntity {
    @CreatedDate
    Instant createdAt;
    @LastModifiedDate
    Instant modifiedAt;
    @Version
    int version;
    @Column
    @NotBlank String name;
    @Column
    @Email String email;
    @Id
    private UUID id;

    public AuthorEntity() {
        this.id = UUID.randomUUID();
    }

    public AuthorEntity(UUID id, Instant createdAt, Instant modifiedAt, int version, String name, String email) {
        this.id = UUID.randomUUID();
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.version = version;
        this.name = name;
        this.email = email;
    }
}
