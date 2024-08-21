package com.grepp.controller;

public class MyControllerMapping {
    private MainController mainController = new MainController();
    private BoardController boardController = new BoardController();
    private MemberController memberController = new MemberController();


    public MyController getController(String command){
        if (command.startsWith("/member")) return memberController;
        if (command.startsWith("/board")) return boardController;
        return mainController;
    }
}
