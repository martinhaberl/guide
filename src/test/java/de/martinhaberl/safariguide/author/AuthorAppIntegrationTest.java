package de.martinhaberl.safariguide.author;

import de.martinhaberl.safariguide.author.entity.AuthorEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorAppIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    AuthorEntityRepository authorEntityRepository;

    @BeforeEach
    public void cleanDatabase() {
        authorEntityRepository.deleteAll();
    }


    @Test
    void postRequestToCreateAuthorShouldReturnStatusCreated() throws Exception {
        mockMvc.perform(post("/authors")
                        .content("{\"name\": \"Ron Weasley\", \"emailAddress\": \"iron.weasle@hogwards.edu\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }


    @Test
    void getRequestShouldReturnListOfAuthors() throws Exception {

        mockMvc.perform(post("/authors")
                        .content("{\"name\": \"Ron Weasley\", \"emailAddress\": \"iron.weasle@hogwards.edu\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/authors"))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$[0].id").isNotEmpty());
    }

}
