package com.example.android.effectivenavigation.models;

import java.util.List;
import java.util.ArrayList;

public class Challenge
extends BaseModelObject
{
    private String title_;
    public void setTitle ( final String value ) {
        title_ = value;
    }
    public String getTitle () {
        return title_;
    }
    private String description_;
    public void setDescription ( final String value ) {
        description_ = value;
    }
    public String getDescription () {
        return description_;
    }
    private List <Challenger> challengers_ = new ArrayList <Challenger> ();
    public void setChallengers ( final List <Challenger> value )
    {
        challengers_ = value;
    }
    public List <Challenger> getChallengers () {
        return challengers_;
    }
    public Challenge ( final String title, final String description ) {
        setTitle( title );
        setDescription( description );
    }
    public Challenge ( final String title, final String description, final List <Challenger> challengers ) {
        this ( title, description );
        setChallengers ( challengers );
    }
}
