package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Role;
import com.github.arlan.library.models.User;

import java.io.IOException;

public class UserDeserializer extends StdDeserializer<User> {

    public UserDeserializer() {
        super(User.class);
    }

    @Override
    public User deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        User user = new User();
        JsonNode node = parser.getCodec().readTree(parser);

        user.setLogin(node.get("login").asText());
        user.setFname(node.get("fname").asText());
        user.setLname(node.get("lname").asText());
        user.setEmail(node.get("email").asText());
        user.setRole(Role.valueOf("USER"));
        String ps = node.get("password").asText();
        user.setPassword(Service.encryption(node.get("password").asText()));
        user.setYIN(node.get("YIN").asText());

        return user;
    }
}
