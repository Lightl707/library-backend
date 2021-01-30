package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Publisher;
import com.github.arlan.library.models.ReleaseData;

import java.io.IOException;
import java.sql.SQLException;

public class ReleaseDataDeserializer extends StdDeserializer<ReleaseData> {

    public ReleaseDataDeserializer() {
        super(ReleaseData.class);
    }

    @Override
    public ReleaseData deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        ReleaseData releaseData = new ReleaseData();
        JsonNode node = parser.getCodec().readTree(parser);

        releaseData.setId(node.get("id").asInt());
        releaseData.setDate_of_signing(node.get("date_of_signing").asText());
        releaseData.setPaper_size(node.get("paper_size").asText());
        releaseData.setSheet_fraction(node.get("sheet_fraction").asText());
        releaseData.setVolume_edition(node.get("volume_edition").asText());
        releaseData.setOrder_number(node.get("order_number").asText());

        return releaseData;
    }
}
