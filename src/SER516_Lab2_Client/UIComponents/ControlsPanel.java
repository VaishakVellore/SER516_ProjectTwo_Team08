package SER516_Lab2_Client.UIComponents;

import SER516_Lab2_Client.*;

import javax.swing.*;
import java.awt.*;

 /**
 * To initialize the control values in the center panel
 */

public class ControlsPanel extends JPanel{

    private final String DEFAULT_CHANNEL = "1";
     private final String DEFAULT_FREQUENCY = "1";

    private TextPane highestValue;
    private TextPane lowestValue;
    private TextPane averageValue;
    private TextPane frequency;
    private JComboBox<String> channels;

    public ControlsPanel(){
        setLayout(new GridLayout(0,2,10,10));

        TextPane highestValLabel = new TextPane("Highest\r\nValue:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane lowestValLabel = new TextPane("Lowest\r\nValue:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane averageValLabel = new TextPane("Average\r\nValue:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane channelValLabel = new TextPane("Channels:", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);
        TextPane frequencyValLabel = new TextPane("Frequency (HZ):", Consts.DEFAULT_FONT, Consts.LIGHTBLUE,true, false);

        highestValue = new TextPane("", Consts.DEFAULT_FONT, Consts.PINK,true, false);
        lowestValue = new TextPane("", Consts.DEFAULT_FONT, Consts.PINK,true, false);
        averageValue = new TextPane("", Consts.DEFAULT_FONT, Consts.PINK,true, false);
        channels = new ComboBox(Consts.CHANNELS, Consts.DEFAULT_FONT, Consts.PINK, true, false);
        frequency = new TextPane(DEFAULT_FREQUENCY, Consts.DEFAULT_FONT, Consts.PINK,true, true);

        add(highestValLabel);
        add(highestValue);
        add(lowestValLabel);
        add(lowestValue);
        add(averageValLabel);
        add(averageValue);
        add(channelValLabel);
        add(channels);
        add(frequencyValLabel);
        add(frequency);

        Handlers.getInstance().setContolPanel(this);
    }


    private JComboBox<String> createChannelsComboBox(){
        JComboBox<String> noOfChannels = new JComboBox<>();
        noOfChannels.setFont(Consts.DEFAULT_FONT);
        noOfChannels.setModel(new DefaultComboBoxModel<>(Consts.CHANNELS));
        noOfChannels.setBackground(Consts.PINK);
        noOfChannels.setBorder(BorderFactory.createLineBorder(Color.black));
        return noOfChannels;
    }

    public void setEnabled(boolean b){

        channels.setEnabled(b);
        frequency.setEnabled(b);
    }

    public String getChannels(){

        String channelCount = channels.getSelectedItem().toString();
        return "".equals(channelCount)? DEFAULT_CHANNEL : channelCount;
    }

    public String getFrequency(){

        String freq = frequency.getText();
        return "".equals(freq)? DEFAULT_FREQUENCY : freq;
    }

    public void setHighestValue(String value){
        highestValue.setText(value);
    }

    public void setLowestValue(String value){
        lowestValue.setText(value);
    }

    public void setAverageValue(String value){
        averageValue.setText(value);
    }

    private class ComboBox extends JComboBox<String>{

        private Color background;

        public ComboBox(String[] model, Font font, Color background, boolean hasBorder, boolean isEditable){
            setModel(new DefaultComboBoxModel<>(model));
            if(font != null)
                setFont(font);
            else
                setFont(null);
            this.background = background;
            setBackground(background);
            setEditable(isEditable);
            if(hasBorder) setBorder(BorderFactory.createLineBorder(Color.black));
        }

        @Override
        public void setEnabled(boolean b){

            super.setEnabled(b);
            if(b){
                setBackground(background);
            }else{
                background = getBackground();
                setBackground(Color.LIGHT_GRAY);
            }
        }
    }
}
