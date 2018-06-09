package gui;

import gui.swing.mvc.Controller;
import gui.swing.mvc.Model;
import gui.swing.mvc.View;

public class MainGui {

    private View view;
    private Model model;
    private Controller controller;

    public MainGui() {
        this.model = new Model();
        this.view = new View(model);
        this.controller = new Controller(model, view);

        view.setVisible(true);
    }

    public static void main(String[] args) {
        MainGui gui = new MainGui();
    }
}
