package com.baranivskyi.tetsTask.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private long id;

    @JsonProperty("username")
    private String userName;

    private Date updatedAt;
}
