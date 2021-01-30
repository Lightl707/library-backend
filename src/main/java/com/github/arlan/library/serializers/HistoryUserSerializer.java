package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.Edition;
import com.github.arlan.library.models.HistoryUser;

import java.io.IOException;

public class HistoryUserSerializer extends StdSerializer<HistoryUser> {
    public HistoryUserSerializer() { super(HistoryUser.class); }

    @Override
    public void serialize(HistoryUser historyUser, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",historyUser.getId());
        jsonGenerator.writeObjectField("user",historyUser.getUser());
        jsonGenerator.writeObjectField("book",historyUser.getBook());
        jsonGenerator.writeBooleanField("issue",historyUser.getIssue());
        jsonGenerator.writeStringField("deadline",historyUser.getDeadline());
        jsonGenerator.writeEndObject();
    }
}