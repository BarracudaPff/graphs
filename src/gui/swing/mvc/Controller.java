package gui.swing.mvc;

import gui.additional.LinePlotTest;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        JTable table = view.getTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row == 0) {
                    model.selectedCell = col;
                    view.getLabel().setText(table.getValueAt(row, col).toString());
                }
            }
        });

        view.getButton().addActionListener(ae -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                view.getFileLabel().setText(selectedFile.getName());
                model.setDataFile(selectedFile);
            }
        });

        view.getButtonData().addActionListener(ae -> {
            if (model.getDataFile() == null) {
                view.getFileLabel().setText("Error with file");
                return;
            }
            model.readFile(view.getBar());
        });

        view.getButtonGraph().addActionListener(ae -> {
            new LinePlotTest(model.graphControll.getData());
        });
    }
}
