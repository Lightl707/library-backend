package com.github.arlan.library.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.Publisher;

import java.io.IOException;
import java.sql.SQLException;

public class CompanyDeserializer extends StdDeserializer<Company> {

    public CompanyDeserializer() {
        super(Company.class);
    }

    @Override
    public Company deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        Company company = new Company();
        JsonNode node = parser.getCodec().readTree(parser);

        company.setId(node.get("id").asInt());
        company.setName(node.get("name").asText());
        try {
            company.setAddress(DatabaseConfiguration.addressDao.queryForId(node.get("address").asInt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return company;
    }
}

