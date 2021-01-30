package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Publisher;
import com.github.arlan.library.models.ReleaseData;

import java.io.IOException;

public class ReleaseDataSerializer extends StdSerializer<ReleaseData> {
    public ReleaseDataSerializer() { super(ReleaseData.class); }

    @Override
    public void serialize(ReleaseData releaseData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",releaseData.getId());
        jsonGenerator.writeStringField("date_of_signing", releaseData.getDate_of_signing());
        jsonGenerator.writeStringField("paper_size", releaseData.getPaper_size());
        jsonGenerator.writeStringField("sheet_fraction", releaseData.getSheet_fraction());
        jsonGenerator.writeStringField("volume_edition", releaseData.getVolume_edition());
        jsonGenerator.writeStringField("order_number", releaseData.getOrder_number());
        jsonGenerator.writeEndObject();
    }
}
