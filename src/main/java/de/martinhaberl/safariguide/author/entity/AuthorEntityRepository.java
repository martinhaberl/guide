package de.martinhaberl.safariguide.author.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorEntityRepository extends JpaRepository<AuthorEntity, UUID> {
}