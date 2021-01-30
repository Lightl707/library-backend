package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.FavouriteList;
import com.github.arlan.library.models.HistoryUser;

import java.io.IOException;

public class FavouriteListSerializer extends StdSerializer<FavouriteList> {
    public FavouriteListSerializer() { super(FavouriteList.class); }

    @Override
    public void serialize(FavouriteList favouriteList, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",favouriteList.getId());
        jsonGenerator.writeObjectField("book",favouriteList.getBook());
        jsonGenerator.writeEndObject();
    }
}
