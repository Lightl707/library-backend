package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Edition;
import com.github.arlan.library.models.FavouriteList;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class FavouriteListController {

    public static void addFavourite(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                FavouriteList favouriteList;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(FavouriteList.class);
                favouriteList = obMap.readValue(json, FavouriteList.class);
                DatabaseConfiguration.favouriteDao.create(favouriteList);
                ctx.status(201);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void getAllFavourite(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, FavouriteList.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.favouriteDao.queryForAll()));
    }

    public static void getByIdFavourite(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, FavouriteList.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (FavouriteList adr : DatabaseConfiguration.favouriteDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }

    public static void patchFavourite(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                FavouriteList favouriteList;
                ObjectMapper obMap = Service.createObjectMapper(false, FavouriteList.class);
                favouriteList = obMap.readValue(json, FavouriteList.class);
                DatabaseConfiguration.favouriteDao.update(favouriteList);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }

    public static void deleteFavourite(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.favouriteDao.deleteById(id);
                ctx.status(204);
            } else {
                ctx.status(403);
            }
        } else {
            ctx.status(401);
        }
    }
}
