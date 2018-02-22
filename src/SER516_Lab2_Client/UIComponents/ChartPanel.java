package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.Handlers;
import SER516_Lab2_Client.TimeChart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ChartPanel extends JPanel {

    private TimeChart chart;

    public ChartPanel(){

        initComponents();
    }

    private void initComponents(){

        setBorder(new LineBorder(Color.black));
        Handlers.setChartPanel(this);
    }

    public void initChart(int channelCount, int frequency){

        removeAll();
        chart = new TimeChart(channelCount,frequency);
        add(chart);
        revalidate();
        repaint();
    }
}