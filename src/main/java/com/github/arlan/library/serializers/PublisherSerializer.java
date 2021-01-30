package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Author;
import com.github.arlan.library.models.Publisher;

import java.io.IOException;

public class PublisherSerializer extends StdSerializer<Publisher> {
    public PublisherSerializer() { super(Publisher.class); }

    @Override
    public void serialize(Publisher publisher, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",publisher.getId());
        jsonGenerator.writeObjectField("address_id",publisher.getAddress());
        jsonGenerator.writeStringField("name",publisher.getName());
        jsonGenerator.writeEndObject();
    }
}