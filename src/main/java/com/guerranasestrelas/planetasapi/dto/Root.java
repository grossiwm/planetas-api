package com.guerranasestrelas.planetasapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    public int count;
    public String next;
    public Object previous;
    public List<Result> results;
}
