package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.OverReleaseData;

import java.io.IOException;

public class OverReleaseDataSerializer extends StdSerializer<OverReleaseData> {
    public OverReleaseDataSerializer() { super(OverReleaseData.class); }

    @Override
    public void serialize(OverReleaseData overReleaseData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",overReleaseData.getId());
        jsonGenerator.writeStringField("series_title", overReleaseData.getSeries_title());
        jsonGenerator.writeStringField("series_issue_number", overReleaseData.getSeries_issue_number());
        jsonGenerator.writeStringField("type_of_publication", overReleaseData.getType_of_publication());
        jsonGenerator.writeStringField("title_publication", overReleaseData.getTitle_publication());
        jsonGenerator.writeStringField("originators_name", overReleaseData.getOriginators_name());
        jsonGenerator.writeEndObject();
    }
}
