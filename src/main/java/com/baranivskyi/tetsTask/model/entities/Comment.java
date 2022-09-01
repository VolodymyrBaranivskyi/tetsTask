package com.baranivskyi.tetsTask.model.entities;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Comment {
    private long id;

    private String body;

    private long postId;

    private User user;
}
