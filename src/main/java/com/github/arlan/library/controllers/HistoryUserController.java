package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Edition;
import com.github.arlan.library.models.HistoryUser;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class HistoryUserController {

    public static void addHistory(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                HistoryUser historyUser;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(HistoryUser.class);
                historyUser = obMap.readValue(json, HistoryUser.class);
                DatabaseConfiguration.historyDao.create(historyUser);
                ctx.status(201);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void getAllHistory(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, HistoryUser.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.historyDao.queryForAll()));
    }

    public static void getByIdHistory(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, HistoryUser.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (HistoryUser adr : DatabaseConfiguration.historyDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }

    public static void patchHistory(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                HistoryUser historyUser;
                ObjectMapper obMap = Service.createObjectMapper(false, HistoryUser.class);
                historyUser = obMap.readValue(json, HistoryUser.class);
                DatabaseConfiguration.historyDao.update(historyUser);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void deleteHistory(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.historyDao.deleteById(id);
                ctx.status(204);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }
}