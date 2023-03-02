package de.martinhaberl.safariguide.author.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@Getter
public class AuthorEntity {
    @CreationTimestamp
    Instant createdAt;
    @UpdateTimestamp
    Instant modifiedAt;
    @Version
    int version;
    @Column
    @NotBlank
    String name;
    @Column
    @Email
    String emailAddress;
    @Id
    private UUID id;

    public AuthorEntity() {
        this.id = UUID.randomUUID();
    }

    public AuthorEntity(String name, String emailAddress) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return version == that.version && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt) && Objects.equals(name, that.name) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, modifiedAt, version, name, emailAddress, id);
    }
}
