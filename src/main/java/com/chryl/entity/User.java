package com.chryl.entity;

import lombok.Data;

/**
 * @author Chr.yl
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String status;

    private String roles;

    private String rememberMe;


}
