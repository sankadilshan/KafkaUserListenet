package com.sankadilshan.userListener.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String maidenName;
    private float age;
    private Object gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private float height;
    private float weight;
    private Hair hair;
    private Address address;





}
