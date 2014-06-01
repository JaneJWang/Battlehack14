package com.example.android.effectivenavigation.models;

public class Challenger
extends BaseModelObject {
    private String name_;
    public void setName ( final String value ) {
        name_ = value;
    }
    public String getName () {
        return name_;
    }
    public Challenger ( final String name ) {
        setName( name );
    }
}
