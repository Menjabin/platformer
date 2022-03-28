package com.example.controller;

import com.example.utility.Vector2D;

public interface Controllable {

    public void move(Vector2D movement);

    public void jump();

    public void update();
}
