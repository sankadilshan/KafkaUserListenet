package com.sankadilshan.userListener.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Address {
    private String address;
    private String city;
    private String state;
    private String postalcode;
    private String country;
}
