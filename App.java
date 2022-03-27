public class App {
    public static void main(String[] args) {
        WeatherView wv = new WeatherView();
        WeatherModel wm = new WeatherModel();
        WeatherController wc = new WeatherController(wm, wv);
    }
}
