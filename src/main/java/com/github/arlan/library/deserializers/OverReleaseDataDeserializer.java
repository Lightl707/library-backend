package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.models.OverReleaseData;
import com.github.arlan.library.models.ReleaseData;

import java.io.IOException;

public class OverReleaseDataDeserializer extends StdDeserializer<OverReleaseData> {

    public OverReleaseDataDeserializer() {
        super(OverReleaseData.class);
    }

    @Override
    public OverReleaseData deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        OverReleaseData overReleaseData = new OverReleaseData();
        JsonNode node = parser.getCodec().readTree(parser);

        overReleaseData.setId(node.get("id").asInt());
        overReleaseData.setSeries_title(node.get("series_title").asText());
        overReleaseData.setSeries_issue_number(node.get("series_issue_number").asText());
        overReleaseData.setType_of_publication(node.get("type_of_publication").asText());
        overReleaseData.setTitle_publication(node.get("title_publication").asText());
        overReleaseData.setOriginators_name(node.get("originators_name").asText());

        return overReleaseData;
    }
}

