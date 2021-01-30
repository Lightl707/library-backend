package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.HistoryUser;

import java.io.IOException;
import java.sql.SQLException;

public class HistoryUserDeserializer extends StdDeserializer<HistoryUser> {

    public HistoryUserDeserializer() {
        super(HistoryUser.class);
    }

    @Override
    public HistoryUser deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        HistoryUser historyUser = new HistoryUser();
        JsonNode node = parser.getCodec().readTree(parser);

        historyUser.setId(node.get("id").asInt());
        historyUser.setDeadline(node.get("deadline").asText());

        try {
            historyUser.setUser(DatabaseConfiguration.userDao.queryForId(node.get("user").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            historyUser.setBook(DatabaseConfiguration.bookDao.queryForId(node.get("book").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        historyUser.setIssue(node.get("issue").asBoolean());

        return historyUser;
    }
}

