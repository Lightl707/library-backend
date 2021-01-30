package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Book;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class BookController {
    public static void addBook(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Book book;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(Book.class);
                book = obMap.readValue(json, Book.class);
                DatabaseConfiguration.bookDao.create(book);
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
    public static void getAllBook(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Book.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.bookDao.queryForAll()));
    }
    public static void getByIdBook(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Book.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (Book adr : DatabaseConfiguration.bookDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }
    public static void patchBook(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Book book;
                ObjectMapper obMap = Service.createObjectMapper(false, Book.class);
                book = obMap.readValue(json, Book.class);
                DatabaseConfiguration.bookDao.update(book);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
    public static void deleteBook(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.bookDao.deleteById(id);
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

