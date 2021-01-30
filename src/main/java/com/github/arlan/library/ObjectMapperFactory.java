package com.github.arlan.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.arlan.library.deserializers.*;
import com.github.arlan.library.models.*;
import com.github.arlan.library.serializers.*;

public class ObjectMapperFactory {

    public static ObjectMapper createObjectMapper(Class<?> nameClass) {
        SimpleModule sm = new SimpleModule();
        ObjectMapper om = new ObjectMapper();
        if (User.class == nameClass) {
            sm.addSerializer(User.class, new com.github.arlan.library.serializers.UserSerializer());
            sm.addDeserializer(User.class, new com.github.arlan.library.deserializers.UserDeserializer());
        } else if (Address.class == nameClass) {
            sm.addSerializer(Address.class, new AddressSerializer());
            sm.addDeserializer(Address.class, new AddressDeserializer());
        } else if (Translatable_String.class == nameClass) {
            sm.addSerializer(Translatable_String.class, new TranslatableSerializer());
            sm.addDeserializer(Translatable_String.class, new TranslatableDeserializer());
        } else if (Author.class == nameClass) {
            sm.addSerializer(Author.class, new AuthorSerializer());
            sm.addDeserializer(Author.class, new AuthorDeserializer());
        } else if (Publisher.class == nameClass) {
            sm.addSerializer(Publisher.class, new PublisherSerializer());
            sm.addDeserializer(Publisher.class, new PublisherDeserializer());
        } else if (Company.class == nameClass) {
            sm.addSerializer(Company.class, new CompanySerializer());
            sm.addDeserializer(Company.class, new CompanyDeserializer());
        } else if (ReleaseData.class == nameClass) {
            sm.addSerializer(ReleaseData.class, new ReleaseDataSerializer());
            sm.addDeserializer(ReleaseData.class, new ReleaseDataDeserializer());
        } else if (OverReleaseData.class == nameClass) {
            sm.addSerializer(OverReleaseData.class, new OverReleaseDataSerializer());
            sm.addDeserializer(OverReleaseData.class, new OverReleaseDataDeserializer());
        } else if (Book.class == nameClass) {
            sm.addSerializer(Book.class, new BookSerializer());
            sm.addDeserializer(Book.class, new BookDeserializer());
        } else if (Edition.class == nameClass) {
            sm.addSerializer(Edition.class, new EditionSerializer());
            sm.addDeserializer(Edition.class, new EditionDeserializer());
        } else if (HistoryUser.class == nameClass) {
            sm.addSerializer(HistoryUser.class, new HistoryUserSerializer());
            sm.addDeserializer(HistoryUser.class, new HistoryUserDeserializer());
        } else if (FavouriteList.class == nameClass) {
            sm.addSerializer(FavouriteList.class, new FavouriteListSerializer());
            sm.addDeserializer(FavouriteList.class, new FavouriteListDeserializer());
        }
        return om.registerModule(sm);
    }

}
