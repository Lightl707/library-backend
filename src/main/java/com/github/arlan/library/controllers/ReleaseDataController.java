package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Publisher;
import com.github.arlan.library.models.ReleaseData;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class ReleaseDataController {

    public static void addReleaseData(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                ReleaseData releaseData;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(ReleaseData.class);
                releaseData = obMap.readValue(json, ReleaseData.class);
                DatabaseConfiguration.releaseDao.create(releaseData);
                ctx.status(201);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void getAllReleaseData(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, ReleaseData.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.releaseDao.queryForAll()));
    }

    public static void getByIdReleaseData(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, ReleaseData.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (ReleaseData adr : DatabaseConfiguration.releaseDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }

    public static void patchReleaseData(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                ReleaseData releaseData;
                ObjectMapper obMap = Service.createObjectMapper(false, ReleaseData.class);
                releaseData = obMap.readValue(json, ReleaseData.class);
                DatabaseConfiguration.releaseDao.update(releaseData);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void deleteReleaseData(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.releaseDao.deleteById(id);
                ctx.status(204);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }
}
