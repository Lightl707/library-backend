package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Author;
import com.github.arlan.library.models.Translatable_String;

import java.io.IOException;
import java.sql.SQLException;

public class AuthorDeserializer extends StdDeserializer<Author> {

    public AuthorDeserializer() {
        super(Author.class);
    }

    @Override
    public Author deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        Author author = new Author();
        JsonNode node = parser.getCodec().readTree(parser);

        author.setId(node.get("id").asInt());
        author.setNickname(node.get("nickname").asText());
        author.setYear_of_birthday(node.get("year_of_birthday").asText());
        try {
            author.setFname(DatabaseConfiguration.translateDao.queryForId(node.get("fname").asInt()));
            author.setLname(DatabaseConfiguration.translateDao.queryForId(node.get("lname").asInt()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }
}
