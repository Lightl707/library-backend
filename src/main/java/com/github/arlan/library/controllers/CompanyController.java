package com.github.arlan.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.ObjectMapperFactory;
import com.github.arlan.library.Service;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.Publisher;
import com.github.arlan.library.models.Role;
import io.javalin.http.Context;

import java.io.IOException;
import java.sql.SQLException;

public class CompanyController {

    public static void addCompany(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Company company;
                ObjectMapper obMap = ObjectMapperFactory.createObjectMapper(Company.class);
                company = obMap.readValue(json, Company.class);
                DatabaseConfiguration.companyDao.create(company);
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
    public static void getAllCompany(Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Company.class);
        ctx.result(om.writeValueAsString(DatabaseConfiguration.companyDao.queryForAll()));
    }
    public static void getByIdCompany (Context ctx) throws JsonProcessingException, SQLException {
        ObjectMapper om = Service.createObjectMapper(true, Company.class);
        int id = Integer.parseInt(ctx.pathParam("id"));
        for (Company adr : DatabaseConfiguration.companyDao.queryForAll()) {
            if (adr.getId() == id) {
                ctx.result(om.writeValueAsString(adr));
            }
        }
    }
    public static void patchCompany(Context ctx) throws IOException, SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                String json = ctx.body();
                Company company;
                ObjectMapper obMap = Service.createObjectMapper(false, Company.class);
                company = obMap.readValue(json, Company.class);
                DatabaseConfiguration.companyDao.update(company);
            }
            else {
                ctx.status(403);
            }
        }
        else {
            ctx.status(401);
        }
    }
    public static void deleteCompany(Context ctx) throws SQLException {
        if (Service.authentication(ctx)) {
            if (Service.authorization(ctx) == Role.ADMIN) {
                int id = Integer.parseInt(ctx.pathParam("id"));
                DatabaseConfiguration.companyDao.deleteById(id);
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

