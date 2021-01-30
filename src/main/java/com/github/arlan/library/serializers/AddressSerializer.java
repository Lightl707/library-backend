package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Address;

import java.io.IOException;

public class AddressSerializer extends StdSerializer<Address> {
    public AddressSerializer() { super(Address.class); }

    @Override
    public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",address.getId());
        jsonGenerator.writeStringField("country",address.getCountry());
        jsonGenerator.writeStringField("city",address.getCity());
        jsonGenerator.writeStringField("text",address.getText());
        jsonGenerator.writeEndObject();
    }
}