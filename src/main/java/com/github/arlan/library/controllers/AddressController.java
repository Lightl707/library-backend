package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Address;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class AddressController {

    public static void addAddress(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Address address;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(Address.class);
                address = obMap.readValue(json, Address.class);
                DatabaseConfiguration.addressDao.create(address);
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
    public static void getAllAddress(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Address.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.addressDao.queryForAll()));
    }
    public static void getByIdAddress (Context ctx) throws JsonProcessingException, SQLException {
            ObjectMapper om = Service.createObjectMapper(true, Address.class);
            int id = Integer.parseInt(ctx.pathParam("id"));
            for (Address adr : DatabaseConfiguration.addressDao.queryForAll()) {
                if (adr.getId() == id) {
                    ctx.result(om.writeValueAsString(adr));
                }
            }
    }
    public static void patchAddress(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Address address;
                ObjectMapper obMap = Service.createObjectMapper(false, Address.class);
                address = obMap.readValue(json, Address.class);
                DatabaseConfiguration.addressDao.update(address);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
    public static void deleteAddress(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.addressDao.deleteById(id);
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