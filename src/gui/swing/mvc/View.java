package gui.swing.mvc;

import gui.additional.LinePlotTest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

public class View extends JFrame {

    private Button button;
    private Button buttonData;
    private Button buttonGraph;
    private Label label;
    private Label fileLabel;
    private Label labelTable;
    private JTable table;
    private JFileChooser fileChooser;
    private JProgressBar bar;

    private Model model;

    public View(Model model) {
        button = new Button("Select File");
        buttonData = new Button("Read file");
        buttonGraph = new Button("Draw Graph");
        label = new Label("Test Label");
        fileLabel = new Label("File not selected");
        labelTable = new Label("Table from file");
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
        table = new JTable(model.addTitleData(), model.getEmptyData()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bar = new JProgressBar();
        bar.setBounds(102, 40, 150, 16);
        bar.setStringPainted(true);
        bar.setVisible(false);

        setPreferredSize(new Dimension(1200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.model = model;
        buildView();
    }

    private void buildView() {
        JPanel panelLabels = new JPanel(new FlowLayout());
        panelLabels.add(fileLabel);
        panelLabels.add(label);
        panelLabels.setBorder(new EmptyBorder(10,10,10,10));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(button);
        panelButtons.add(buttonData);
        panelButtons.add(buttonGraph);
        panelButtons.setBorder(new EmptyBorder(10,10,10,10));

        JPanel panelMenu = new JPanel(new BorderLayout());
        panelMenu.add(bar);
        panelMenu.add(panelLabels, BorderLayout.NORTH);
        panelMenu.add(panelButtons);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(panelMenu, BorderLayout.WEST);

        JPanel panelTabel = new JPanel(new FlowLayout());
        panelTabel.add(labelTable);
        panelTabel.add(table);

        panel.add(panelTabel, BorderLayout.EAST);
        panel.setBorder(new EmptyBorder(10,10,10,10));
        setDefaultLookAndFeelDecorated(true);
        this.setContentPane(panel);
        this.pack();
        this.setTitle("Testing View");
    }

    public Button getButton() {
        return button;
    }

    public Label getLabel() {
        return label;
    }

    public JTable getTable() {
        return table;
    }

    public Model getModel() {
        return model;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public JProgressBar getBar() {
        return bar;
    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }

    public void setFileLabel(Label fileLabel) {
        this.fileLabel = fileLabel;
    }

    public Label getFileLabel() {
        return fileLabel;
    }

    public Button getButtonData() {
        return buttonData;
    }

    public Button getButtonGraph() {
        return buttonGraph;
    }
}
