package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.OverReleaseData;
import com.github.arlan.library.models.Publisher;
import com.github.arlan.library.models.ReleaseData;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class OverReleaseDataController {

    public static void addOverReleaseData(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                OverReleaseData overReleaseData;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(OverReleaseData.class);
                overReleaseData = obMap.readValue(json, OverReleaseData.class);
                DatabaseConfiguration.overreleaseDao.create(overReleaseData);
                ctx.status(201);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void getAllOverReleaseData(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, OverReleaseData.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.overreleaseDao.queryForAll()));
    }

    public static void getByIdOverReleaseData(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, OverReleaseData.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (OverReleaseData adr : DatabaseConfiguration.overreleaseDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }

    public static void patchOverReleaseData(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                OverReleaseData overReleaseData;
                ObjectMapper obMap = Service.createObjectMapper(false, OverReleaseData.class);
                overReleaseData = obMap.readValue(json, OverReleaseData.class);
                DatabaseConfiguration.overreleaseDao.update(overReleaseData);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void deleteOverReleaseData(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.overreleaseDao.deleteById(id);
                ctx.status(204);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }
}