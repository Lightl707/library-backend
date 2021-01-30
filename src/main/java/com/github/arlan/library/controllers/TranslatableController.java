package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Address;
import com.github.arlan.library.models.Role;
import com.github.arlan.library.models.Translatable_String;
import com.github.arlan.library.models.User;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class TranslatableController {

    public static void createTranslatable(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Translatable_String translatable_string;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(Translatable_String.class);
                translatable_string = obMap.readValue(json, Translatable_String.class);
                DatabaseConfiguration.translateDao.create(translatable_string);
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
    public static void getAllTranslatable(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Translatable_String.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.translateDao.queryForAll()));
    }
    public static void getByIdTranslatable(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Translatable_String.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (Translatable_String adr : DatabaseConfiguration.translateDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }
    public static void patchTranslatable(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Translatable_String translatable_string;
                ObjectMapper obMap = Service.createObjectMapper(false, Translatable_String.class);
                translatable_string = obMap.readValue(json, Translatable_String.class);
                DatabaseConfiguration.translateDao.update(translatable_string);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
    public static void deleteTranslatable(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.translateDao.deleteById(id);
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