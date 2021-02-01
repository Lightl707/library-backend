package com.github.arlan.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.arlan.library.DatabaseConfiguration;
import com.github.arlan.library.deserializers.*;
import com.github.arlan.library.models.*;
import com.github.arlan.library.serializers.*;
import io.javalin.http.Context;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class Service {

    public static String encryption(String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(10));
        return hashed;
    }

    public static boolean authentication(Context ctx) throws SQLException {
        boolean check = false;
        String userName = ctx.basicAuthCredentials().getUsername();
        String userPas = ctx.basicAuthCredentials().getPassword();
        for (User us : DatabaseConfiguration.userDao.queryForAll()) {
            if (us.getLogin().equals(userName) && BCrypt.checkpw(userPas, us.getPassword())) {
                check = true;
                ctx.status(200);
            }
        }
        return check;
    }

    public static Role authorization(Context ctx) throws SQLException {
        if (searchUser(ctx).getRole() == Role.ADMIN) return Role.ADMIN;
        else return Role.USER;
}
    public static User searchUser(Context ctx) throws SQLException {
        String userName = ctx.basicAuthCredentials().getUsername();
        User user = null;
        for (User us : DatabaseConfiguration.userDao.queryForAll()) {
            if (us.getLogin().equals(userName)) {
                user = us;
            }
        }
        if (user != null)
            return user;
        else {
            ctx.status(404);
            throw new RuntimeException();
        }
    }

    public static User searchAuthor(Context ctx) throws SQLException {
        String userName = ctx.basicAuthCredentials().getUsername();
        User user = null;
        for (User us : DatabaseConfiguration.userDao.queryForAll()) {
            if (us.getLogin().equals(userName)) {
                user = us;
            }
        }
        if (user != null)
            return user;
        else {
            ctx.status(404);
            throw new RuntimeException();
        }
    }

    public static ObjectMapper createObjectMapper(boolean deserialORserial, Class<?> nameClass) {
        SimpleModule sm = new SimpleModule();
        ObjectMapper om = new ObjectMapper();
        if (deserialORserial)
            return forSerialize(om, sm, nameClass);
        else
            return forDeserialize(om, sm, nameClass);
    }

    public static ObjectMapper forSerialize(ObjectMapper om, SimpleModule sm, Class<?> nameClass) {
        if (User.class.equals(nameClass)) {
            sm.addSerializer(User.class, new com.github.arlan.library.serializers.UserSerializer());
        } else if (Address.class.equals(nameClass)) {
            sm.addSerializer(Address.class, new AddressSerializer());
        } else if (Translatable_String.class.equals(nameClass)) {
            sm.addSerializer(Translatable_String.class, new TranslatableSerializer());
        } else if (Author.class.equals(nameClass)) {
            sm.addSerializer(Author.class, new AuthorSerializer());
        } else if (Publisher.class.equals(nameClass)) {
            sm.addSerializer(Publisher.class, new PublisherSerializer());
        } else if (Company.class.equals(nameClass)) {
            sm.addSerializer(Company.class, new CompanySerializer());
        } else if (ReleaseData.class.equals(nameClass)) {
            sm.addSerializer(ReleaseData.class, new ReleaseDataSerializer());
        } else if (OverReleaseData.class.equals(nameClass)) {
            sm.addSerializer(OverReleaseData.class, new OverReleaseDataSerializer());
        } else if (Book.class.equals(nameClass)) {
            sm.addSerializer(Book.class, new BookSerializer());
        } else if (Edition.class.equals(nameClass)) {
            sm.addSerializer(Edition.class, new EditionSerializer());
        } else if (HistoryUser.class.equals(nameClass)) {
            sm.addSerializer(HistoryUser.class, new HistoryUserSerializer());
        } else if (FavouriteList.class.equals(nameClass)) {
            sm.addSerializer(FavouriteList.class, new FavouriteListSerializer());
        }
        return om.registerModule(sm);
    }

    public static ObjectMapper forDeserialize(ObjectMapper om, SimpleModule sm, Class<?> nameClass) {
        if (User.class.equals(nameClass)) {
            sm.addDeserializer(User.class, new com.github.arlan.library.deserializers.UserDeserializer());
        } else if (Address.class.equals(nameClass)) {
            sm.addDeserializer(Address.class, new AddressDeserializer());
        } else if (Translatable_String.class.equals(nameClass)) {
            sm.addDeserializer(Translatable_String.class, new TranslatableDeserializer());
        } else if (Author.class.equals(nameClass)) {
            sm.addDeserializer(Author.class, new AuthorDeserializer());
        } else if (Publisher.class.equals(nameClass)) {
            sm.addDeserializer(Publisher.class, new PublisherDeserializer());
        } else if (Company.class.equals(nameClass)) {
            sm.addDeserializer(Company.class, new CompanyDeserializer());
        } else if (ReleaseData.class.equals(nameClass)) {
            sm.addDeserializer(ReleaseData.class, new ReleaseDataDeserializer());
        } else if (OverReleaseData.class.equals(nameClass)) {
            sm.addDeserializer(OverReleaseData.class, new OverReleaseDataDeserializer());
        } else if (Book.class.equals(nameClass)) {
            sm.addDeserializer(Book.class, new BookDeserializer());
        } else if (Edition.class.equals(nameClass)) {
            sm.addDeserializer(Edition.class, new EditionDeserializer());
        } else if (HistoryUser.class.equals(nameClass)) {
            sm.addDeserializer(HistoryUser.class, new HistoryUserDeserializer());
        } else if (FavouriteList.class.equals(nameClass)) {
            sm.addDeserializer(FavouriteList.class, new FavouriteListDeserializer());
        }

        return om.registerModule(sm);

    }
    }