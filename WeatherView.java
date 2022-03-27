import java.awt.event.ActionListener;
import javax.swing.*;

public class WeatherView extends JFrame {
    private JTextField inputCity = new JTextField(20);
    private JButton submitButton = new JButton("Submit");
    private String description;
    private float maxTemp;
    private float minTemp;
    private float temp;

    WeatherView() {
        this.description = "Enter City name";
        this.maxTemp = 0.0f;
        this.minTemp = 0.0f;
        this.temp = 0.0f;
        JPanel weatherPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Weather App MVC");
        this.setSize(500, 400);
        weatherPanel.add(new JLabel(this.description + "  "));
        weatherPanel.add(this.inputCity);
        weatherPanel.add(this.submitButton);
        this.add(weatherPanel);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public String getInputCity() {
        return new String(inputCity.getText());
    }

    public void addWeatherEventListener(ActionListener weatherListener) {
        submitButton.addActionListener(weatherListener);
    }

    public void displayError(String ErrorMessage) {
        JOptionPane.showMessageDialog(this, ErrorMessage);
    }

    public void setDesc(String d) {
        this.description = d;
    }

    public void setTemp(float t) {
        this.temp = t;
    }

    public void setMinTemp(float t) {
        this.minTemp = t;
    }

    public void setMaxTemp(float t) {
        this.maxTemp = t;
    }

    public void setResult() {
        String res = this.getInputCity() + "<br>";
        res += "Current Temp. : " + this.KelvinToCelcius(this.temp) + " °C<br>";
        res += "Min Temp.     : " + this.KelvinToCelcius(this.minTemp) + " °C<br>";
        res += "Max Temp.     : " + this.KelvinToCelcius(this.maxTemp) + " °C<br>";
        res += this.description;
        res = "<html><br><p>" + res + "</p></html>";
        JOptionPane.showMessageDialog(this, res);
    }

    public void setError() {
        JOptionPane.showMessageDialog(this, this.description);
    }

    private float KelvinToCelcius(float k) {
        return k - 273.15f;
    }
}
