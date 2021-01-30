package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Address;
import com.github.arlan.library.models.Translatable_String;

import java.io.IOException;

public class TranslatableSerializer extends StdSerializer<Translatable_String> {
    public TranslatableSerializer() { super(Translatable_String.class); }

    @Override
    public void serialize(Translatable_String translatable_string, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",translatable_string.getId());
        jsonGenerator.writeStringField("text",translatable_string.getText());
        jsonGenerator.writeObjectField("parent",translatable_string.getParent());
        jsonGenerator.writeEndObject();
    }
}