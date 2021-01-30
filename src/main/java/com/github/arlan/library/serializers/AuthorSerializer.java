package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Address;
import com.github.arlan.library.models.Author;

import java.io.IOException;

public class AuthorSerializer extends StdSerializer<Author> {
    public AuthorSerializer() { super(Author.class); }

    @Override
    public void serialize(Author author, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",author.getId());
        jsonGenerator.writeObjectField("fname",author.getFname());
        jsonGenerator.writeObjectField("lname",author.getLname());
        jsonGenerator.writeStringField("nickname",author.getNickname());
        jsonGenerator.writeStringField("year_of_birthday",author.getYear_of_birthday());
        jsonGenerator.writeEndObject();
    }
}
