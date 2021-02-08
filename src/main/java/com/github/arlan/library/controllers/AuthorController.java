package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Author;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class AuthorController {

    public static void addAuthor(Context ctx) throws IOException, SQLException {
//        if (Service.authentication(ctx)) {
//            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Author author;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(Author.class);
                author = obMap.readValue(json, Author.class);
                DatabaseConfiguration.authorDao.create(author);
                ctx.status(201);
//            }
//            else {
//                ctx.status(403);
//            }
//        }
//        else {
//            ctx.status(401);
//        }
    }
    public static void getAllAuthor(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Author.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.authorDao.queryForAll()));
    }
    public static void getByIdAuthor (Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Author.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (Author adr : DatabaseConfiguration.authorDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }
    public static void patchAuthor(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Author author;
                ObjectMapper obMap = Service.createObjectMapper(false, Author.class);
                author = obMap.readValue(json, Author.class);
                DatabaseConfiguration.authorDao.update(author);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
    public static void deleteAuthor(Context ctx) throws SQLException {
//        if (Service.authentication(ctx)) {
//            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.authorDao.deleteById(id);
                ctx.status(204);
            }
//            else {
//                ctx.status(403);
//            }
//        }
//        else {
//            ctx.status(401);
//        }
//    }
}
