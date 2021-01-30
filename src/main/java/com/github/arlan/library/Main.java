package com.github.arlan.library;


import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.controllers.*;
import com.github.arlan.library.models.Company;
import com.github.arlan.library.models.FavouriteList;
import com.github.arlan.library.models.Translatable_String;
import com.github.arlan.library.models.User;
import io.javalin.Javalin;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<User>();
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.enableDevLogging();
            javalinConfig.enableCorsForAllOrigins();
            javalinConfig.defaultContentType = "application/json";
        }).start(17071);

        app.get("/search", ctx -> Service.searchUser(ctx));
        app.get("/auth/", ctx -> Service.authentication(ctx));
        app.post("/user/", ctx -> UserController.createUser(ctx));
        app.get("/user/", ctx -> UserController.getAll(ctx));
        app.get("/user/:id", ctx -> UserController.getById(ctx));
        app.delete("/user/:id", context -> UserController.delete(context));
        app.patch("/user/", context -> UserController.patch(context));

        app.post("/address/", context -> AddressController.addAddress(context));
        app.get("/address/", context -> AddressController.getAllAddress(context));
        app.get("/address/:id", context -> AddressController.getByIdAddress(context));
        app.delete("/address/:id", context -> AddressController.deleteAddress(context));
        app.patch("/address/", context -> AddressController.patchAddress(context));

        app.post("/translatable/", context -> TranslatableController.createTranslatable(context));
        app.get("/translatable/", context -> TranslatableController.getAllTranslatable(context));
        app.get("/translatable/:id", context -> TranslatableController.getByIdTranslatable(context));
        app.delete("/translatable/:id", context -> TranslatableController.deleteTranslatable(context));
        app.patch("/translatable/", context -> TranslatableController.patchTranslatable(context));

        app.post("/author/", context -> AuthorController.addAuthor(context));
        app.get("/author/", context -> AuthorController.getAllAuthor(context));
        app.get("/author/:id", context -> AuthorController.getByIdAuthor(context));
        app.delete("/author/:id", context -> AuthorController.deleteAuthor(context));
        app.patch("/author/", context -> AuthorController.patchAuthor(context));

        app.post("/publisher/", context -> PublisherController.addPublisher(context));
        app.get("/publisher/", context -> PublisherController.getAllPublisher(context));
        app.get("/publisher/:id", context -> PublisherController.getByIdPublisher(context));
        app.delete("/publisher/:id", context -> PublisherController.deletePublisher(context));
        app.patch("/publisher/", context -> PublisherController.patchPublisher(context));

        app.post("/company/", context -> CompanyController.addCompany(context));
        app.get("/company/", context -> CompanyController.getAllCompany(context));
        app.get("/company/:id", context -> CompanyController.getByIdCompany(context));
        app.delete("/company/:id", context -> CompanyController.deleteCompany(context));
        app.patch("/company/", context -> CompanyController.patchCompany(context));

        app.post("/release_data/", context -> ReleaseDataController.addReleaseData(context));
        app.get("/release_data/", context -> ReleaseDataController.getAllReleaseData(context));
        app.get("/release_data/:id", context -> ReleaseDataController.getByIdReleaseData(context));
        app.delete("/release_data/:id", context -> ReleaseDataController.deleteReleaseData(context));
        app.patch("/release_data/", context -> ReleaseDataController.patchReleaseData(context));

        app.post("/over_release_data/", context -> OverReleaseDataController.addOverReleaseData(context));
        app.get("/over_release_data/", context -> OverReleaseDataController.getAllOverReleaseData(context));
        app.get("/over_release_data/:id", context -> OverReleaseDataController.getByIdOverReleaseData(context));
        app.delete("/over_release_data/:id", context -> OverReleaseDataController.deleteOverReleaseData(context));
        app.patch("/over_release_data/", context -> OverReleaseDataController.patchOverReleaseData( context));

        app.post("/book/", context -> BookController.addBook(context));
        app.get("/book/", context -> BookController.getAllBook(context));
        app.get("/book/:id", context -> BookController.getByIdBook(context));
        app.delete("/book/:id", context -> BookController.deleteBook(context));
        app.patch("/book/", context -> BookController.patchBook( context));

        app.post("/edition/", context -> EditionController.addEdition(context));
        app.get("/edition/", context -> EditionController.getAllEdition(context));
        app.get("/edition/:id", context -> EditionController.getByIdEdition(context));
        app.delete("/edition/:id", context -> EditionController.deleteEdition(context));
        app.patch("/edition/", context -> EditionController.patchEdition( context));

        app.post("/historyUser/", context -> HistoryUserController.addHistory(context));
        app.get("/historyUser/", context -> HistoryUserController.getAllHistory(context));
        app.get("/historyUser/:id", context -> HistoryUserController.getByIdHistory(context));
        app.delete("/historyUser/:id", context -> HistoryUserController.deleteHistory(context));
        app.patch("/historyUser/", context -> HistoryUserController.patchHistory( context));

        app.post("/favourite/", context -> FavouriteListController.addFavourite(context));
        app.get("/favourite/", context -> FavouriteListController.getAllFavourite(context));
        app.get("/favourite/:id", context -> FavouriteListController.getByIdFavourite(context));
        app.delete("/favourite/:id", context -> FavouriteListController.deleteFavourite(context));
        app.patch("/favourite/", context -> FavouriteListController.patchFavourite( context));
    }
}
