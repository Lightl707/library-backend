package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Address;
import com.github.arlan.library.models.Author;
import com.github.arlan.library.models.Publisher;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.io.PipedInputStream;
import java.sql.SQLException;

public class PublisherController {

    public static void addPublisher(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Publisher publisher;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(Publisher.class);
                publisher = obMap.readValue(json, Publisher.class);
                DatabaseConfiguration.publisherDao.create(publisher);
                ctx.status(201);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
    public static void getAllPublisher(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Publisher.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.publisherDao.queryForAll()));
    }
    public static void getByIdPublisher (Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Publisher.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (Publisher adr : DatabaseConfiguration.publisherDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }
    public static void patchPublisher(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Publisher publisher;
                ObjectMapper obMap = Service.createObjectMapper(false, Publisher.class);
                publisher = obMap.readValue(json, Publisher.class);
                DatabaseConfiguration.publisherDao.update(publisher);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
    public static void deletePublisher(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.publisherDao.deleteById(id);
                ctx.status(204);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
}

