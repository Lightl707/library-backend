package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Edition;
import com.github.arlan.library.models.OverReleaseData;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class EditionController {

    public static void addEdition(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Edition edition;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(Edition.class);
                edition = obMap.readValue(json, Edition.class);
                DatabaseConfiguration.editionDao.create(edition);
                ctx.status(201);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void getAllEdition(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Edition.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.editionDao.queryForAll()));
    }

    public static void getByIdEdition(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Edition.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (Edition adr : DatabaseConfiguration.editionDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }

    public static void patchEdition(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Edition edition;
                ObjectMapper obMap = Service.createObjectMapper(false, Edition.class);
                edition = obMap.readValue(json, Edition.class);
                DatabaseConfiguration.editionDao.update(edition);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void deleteEdition(Context ctx) throws SQLException {
//        if (Service.authentication(ctx)) {
//            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.editionDao.deleteById(id);
                ctx.status(204);
//            } else {
//                ctx.status(403);
//            }
//        }
//        else {
//            ctx.status(401);
//        }
    }
}
