package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.models.Address;

import java.io.IOException;

public class AddressDeserializer extends StdDeserializer<Address> {

    public AddressDeserializer() {
        super(Address.class);
    }

    @Override
    public Address deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        Address address = new Address();
        JsonNode node = parser.getCodec().readTree(parser);

        address.setId(node.get("id").asInt());
        address.setCity(node.get("city").asText());
        address.setCountry(node.get("country").asText());
        address.setText(node.get("text").asText());

        return address;
    }
}