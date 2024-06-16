package de.herhold.stroeerkata.model;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        GeoLocation geo
) {
}
