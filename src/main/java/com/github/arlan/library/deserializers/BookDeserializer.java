package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Book;
import com.github.arlan.library.models.Company;

import java.io.IOException;
import java.sql.SQLException;

public class BookDeserializer extends StdDeserializer<Book> {

    public BookDeserializer() {
        super(Book.class);
    }

    @Override
    public Book deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        Book book = new Book();
        JsonNode node = parser.getCodec().readTree(parser);

        try {
            book.setAuthor(Service.searchAuthor(node.get("author").asText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            book.setOriginal_Title(Service.searchTS(node.get("original_title").asText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        book.setImg(node.get("img").asText());

        book.setDescription(node.get("description").asText());


        return book;
    }
}
