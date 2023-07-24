package com.crud.tasks.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloTestSuite {
    @Test
    public void testJsonMapping() throws Exception {
        // Arrange
        String json = "{\"board\": 1, \"card\": 2}";
        ObjectMapper objectMapper = new ObjectMapper();

        // Act
        Trello trello = objectMapper.readValue(json, Trello.class);

        // Assert
        assertEquals(1, trello.getBoard());
        assertEquals(2, trello.getCard());
    }
}
