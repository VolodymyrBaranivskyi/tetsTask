package com.baranivskyi.tetsTask.model.entities;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Response {
    private ArrayList<Comment> comments;

    private int total;

    private int skip;

    private int limit;
}
