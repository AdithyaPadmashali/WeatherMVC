import java.io.*;
import java.net.*;

public class WeatherModel {

    private float temp;
    private float minTemp;
    private float maxTemp;
    private String city;
    private String APIKEY;
    private URL openweather;
    private String response;
    private String description;

    WeatherModel() {
        this.temp = 0.0f;
        this.minTemp = 0.0f;
        this.maxTemp = 0.0f;
        this.description = "Enter the city name";
        // this.APIKEY = "d562ffb6eeba9537b10813b30795b078";
        this.city = "London";
        File apiFile = new File("./APIKEY.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(apiFile));
            this.APIKEY = br.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void callWeatherAPI(String inputCity) {
        try {
            this.response = "";
            this.city = inputCity;
            this.openweather = new URL(
                    "https://api.openweathermap.org/data/2.5/weather?q=" + this.city + "&appid=" + this.APIKEY);
            URLConnection ow = openweather.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(ow.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                this.response += inputLine;
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        if (this.response != null) {
            this.setTemp();
            this.setMinTemp();
            this.setMaxTemp();
            this.setDescription();
        }
    }

    private void setTemp() {
        int index = this.response.indexOf("temp") + 6;
        this.temp = Float.parseFloat(response.substring(index, index + 5));
    }

    private void setMinTemp() {
        int index = this.response.indexOf("temp_min") + 6 + 4;
        this.minTemp = Float.parseFloat(response.substring(index, index + 6));
    }

    private void setMaxTemp() {
        int index = this.response.indexOf("temp") + 6;
        this.maxTemp = Float.parseFloat(response.substring(index, index + 6));
    }

    private void setDescription() {
        int index = this.response.indexOf("description") + 14;
        int end = 0;
        while (this.response.charAt(index + end) != '\"') {
            end += 1;
        }
        this.description = response.substring(index, index + end);
    }

    public float getTemp() {
        return this.temp;
    }

    public float getMinTemp() {
        return this.minTemp;
    }

    public float getMaxTemp() {
        return this.maxTemp;
    }

    public String getDescription() {
        return this.description;
    }
}