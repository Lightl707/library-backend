package com.github.arlan.library.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.arlan.library.models.User;

import java.io.IOException;

public class UserSerializer extends StdSerializer<User> {
    public UserSerializer() {
        super(User.class);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",user.getId());
        jsonGenerator.writeStringField("fname",user.getFname());
        jsonGenerator.writeStringField("lname", user.getLname());
        jsonGenerator.writeStringField("email", user.getEmail());
        jsonGenerator.writeStringField("login", user.getLogin());
        jsonGenerator.writeEndObject();
    }
}
