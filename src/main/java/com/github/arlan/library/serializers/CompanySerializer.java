package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.Publisher;

import java.io.IOException;

public class CompanySerializer extends StdSerializer<Company> {
    public CompanySerializer() { super(Company.class); }

    @Override
    public void serialize(Company company, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",company.getId());
        jsonGenerator.writeObjectField("address_id",company.getAddress());
        jsonGenerator.writeStringField("name",company.getName());
        jsonGenerator.writeEndObject();
    }
}
