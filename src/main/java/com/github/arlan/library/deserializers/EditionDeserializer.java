package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.Edition;

import java.io.IOException;
import java.sql.SQLException;

public class EditionDeserializer extends StdDeserializer<Edition> {

    public EditionDeserializer() {
        super(Edition.class);
    }

    @Override
    public Edition deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        Edition edition = new Edition();
        JsonNode node = parser.getCodec().readTree(parser);

        edition.setId(node.get("id").asInt());
        edition.setUDK(node.get("UDK").asText());
        edition.setISBN(node.get("ISBN").asText());
        edition.setBBK(node.get("BBK").asText());
        edition.setPages(node.get("pages").asText());
        edition.setTitle(node.get("title").asText());
        edition.setAuthor_sign(node.get("author_sign").asText());
        edition.setSize(node.get("size").asText());
        edition.setYear(node.get("year").asText());


        try {
            edition.setPublisher(DatabaseConfiguration.publisherDao.queryForId(node.get("publisher").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            edition.setBook(DatabaseConfiguration.bookDao.queryForId(node.get("book").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            edition.setRelease_data(DatabaseConfiguration.releaseDao.queryForId(node.get("release_data").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            edition.setOver_release_data(DatabaseConfiguration.overreleaseDao.queryForId(node.get("over_release_data").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            edition.setCompany(DatabaseConfiguration.companyDao.queryForId(node.get("company").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return edition;
    }
}
