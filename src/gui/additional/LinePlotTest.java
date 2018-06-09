package gui.additional;


import com.mxgraph.canvas.mxSvgCanvas;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LinePlotTest extends JFrame {

    public LinePlotTest(int[] arr) {
        setMinimumSize(new Dimension(600, 400));
        DataTable data = new DataTable(Integer.class, Integer.class);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "\t" + arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            data.add(i * 10, arr[i]);
        }
        XYPlot plot = new XYPlot(data);
        add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        plot.getPointRenderers(data).get(0).setShape(null);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
        setVisible(true);
    }


}
