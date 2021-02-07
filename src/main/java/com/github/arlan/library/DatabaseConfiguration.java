package com.github.arlan.library;

import com.github.arlan.library.models.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseConfiguration {

    public static ConnectionSource connectionSource;
    public static Dao<User, Integer> userDao;
    public static Dao<Book, Integer> bookDao;
    public static Dao<Address, Integer> addressDao;
    public static Dao<Author, Integer> authorDao;
    public static Dao<Company, Integer> companyDao;
    public static Dao<Edition, Integer> editionDao;
    public static Dao<FavouriteList, Integer> favouriteDao;
    public static Dao<HistoryUser, Integer> historyDao;
    public static Dao<OverReleaseData, Integer> overreleaseDao;
    public static Dao<Publisher, Integer> publisherDao;
    public static Dao<ReleaseData, Integer> releaseDao;
    public static Dao<Translatable_String, Integer> translateDao;



    static {
        try {
            connectionSource = new JdbcConnectionSource("jdbc:library.db");
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, ReleaseData.class);
            TableUtils.createTableIfNotExists(connectionSource, Publisher.class);
            TableUtils.createTableIfNotExists(connectionSource, OverReleaseData.class);
            TableUtils.createTableIfNotExists(connectionSource, HistoryUser.class);
            TableUtils.createTableIfNotExists(connectionSource, FavouriteList.class);
            TableUtils.createTableIfNotExists(connectionSource, Edition.class);
            TableUtils.createTableIfNotExists(connectionSource, Company.class);
            TableUtils.createTableIfNotExists(connectionSource, Book.class);
            TableUtils.createTableIfNotExists(connectionSource, Author_Book.class);
            TableUtils.createTableIfNotExists(connectionSource, Author.class);
            TableUtils.createTableIfNotExists(connectionSource, Address.class);
            TableUtils.createTableIfNotExists(connectionSource, Translatable_String.class);


            userDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, User.class);
            bookDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, Book.class);
            addressDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, Address.class);
            authorDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, Author.class);
            companyDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, Company.class);
            editionDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, Edition.class);
            favouriteDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, FavouriteList.class);
            historyDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, HistoryUser.class);
            overreleaseDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, OverReleaseData.class);
            releaseDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, ReleaseData.class);
            publisherDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, Publisher.class);
            translateDao = DaoManager.createDao(DatabaseConfiguration.connectionSource, Translatable_String.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
