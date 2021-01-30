package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Author;
import com.github.arlan.library.models.Publisher;

import java.io.IOException;
import java.sql.SQLException;

public class PublisherDeserializer extends StdDeserializer<Publisher> {

public PublisherDeserializer() {
        super(Publisher.class);
        }

@Override
public Publisher deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        Publisher publisher = new Publisher();
        JsonNode node = parser.getCodec().readTree(parser);

        publisher.setId(node.get("id").asInt());
        publisher.setName(node.get("name").asText());
        try {
        publisher.setAddress(DatabaseConfiguration.addressDao.queryForId(node.get("address").asInt()));
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return publisher;
        }
        }
