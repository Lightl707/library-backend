package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Address;
import com.github.arlan.library.models.Translatable_String;

import java.io.IOException;
import java.sql.SQLException;

public class TranslatableDeserializer extends StdDeserializer<Translatable_String> {

    public TranslatableDeserializer() {
        super(Translatable_String.class);
    }

    @Override
    public Translatable_String deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        Translatable_String translatable_string = new Translatable_String();
        JsonNode node = parser.getCodec().readTree(parser);

        translatable_string.setId(node.get("id").asInt());
        translatable_string.setText(node.get("text").asText());
        try {
            translatable_string.setParent(DatabaseConfiguration.translateDao.queryForId(node.get("parent").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return translatable_string;
    }
}