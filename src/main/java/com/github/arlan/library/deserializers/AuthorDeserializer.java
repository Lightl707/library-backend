package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.Service;
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

        author.setNickname(node.get("nickname").asText());
        author.setYear_of_birthday(node.get("year_of_birthday").asText());

        try {
            author.setFname(Service.searchTS(node.get("fname").asText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            author.setLname(Service.searchTS(node.get("lname").asText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return author;
    }
}
