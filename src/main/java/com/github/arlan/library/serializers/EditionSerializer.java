package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Book;
import com.github.arlan.library.models.Edition;

import java.io.IOException;

public class EditionSerializer extends StdSerializer<Edition> {
    public EditionSerializer() { super(Edition.class); }

    @Override
    public void serialize(Edition edition, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",edition.getId());
        jsonGenerator.writeStringField("ISBN",edition.getISBN());
        jsonGenerator.writeStringField("UDK",edition.getUDK());
        jsonGenerator.writeStringField("BBK",edition.getBBK());
        jsonGenerator.writeStringField("pages",edition.getPages());
        jsonGenerator.writeObjectField("publisher",edition.getPublisher());
        jsonGenerator.writeObjectField("book",edition.getBook());
        jsonGenerator.writeObjectField("release_data",edition.getRelease_data());
        jsonGenerator.writeObjectField("over_release_data",edition.getOver_release_data());
        jsonGenerator.writeObjectField("company",edition.getCompany());
        jsonGenerator.writeStringField("title",edition.getTitle());
        jsonGenerator.writeStringField("author_sign",edition.getAuthor_sign());
        jsonGenerator.writeStringField("size",edition.getSize());
        jsonGenerator.writeStringField("year",edition.getYear());

        jsonGenerator.writeEndObject();
    }
}
