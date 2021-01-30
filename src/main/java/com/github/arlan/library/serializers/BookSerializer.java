package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Book;
import com.github.arlan.library.models.Edition;
import com.j256.ormlite.dao.Dao;

import java.io.IOException;

public class BookSerializer extends StdSerializer<Book> {
    public BookSerializer() { super(Book.class); }

    @Override
    public void serialize(Book book, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",book.getId());
        jsonGenerator.writeObjectField("author",book.getAuthor());
        jsonGenerator.writeObjectField("original_title",book.getOriginal_Title());
        jsonGenerator.writeStringField("img",book.getImg());
        jsonGenerator.writeStringField("description",book.getDescription());


        jsonGenerator.writeEndObject();
    }
}
