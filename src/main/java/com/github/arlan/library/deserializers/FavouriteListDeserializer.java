package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Edition;
import com.github.arlan.library.models.FavouriteList;

import java.io.IOException;
import java.sql.SQLException;

public class FavouriteListDeserializer extends StdDeserializer<FavouriteList> {

    public FavouriteListDeserializer() {
        super(FavouriteList.class);
    }

    @Override
    public FavouriteList deserialize (JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        FavouriteList favouriteList = new FavouriteList();
        JsonNode node = parser.getCodec().readTree(parser);
        favouriteList.setId(node.get("id").asInt());

        try {
            favouriteList.setBook(DatabaseConfiguration.bookDao.queryForId(node.get("book").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favouriteList;
    }
}

