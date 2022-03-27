import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherController {
    private WeatherModel wm;
    private WeatherView wv;

    public WeatherController(WeatherModel wm, WeatherView wv) {
        this.wm = wm;
        this.wv = wv;

        this.wv.addWeatherEventListener(new weatherListener());
    }

    class weatherListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String inputCity = "London";
            try {
                inputCity = wv.getInputCity();
                wm.callWeatherAPI(inputCity);
                wv.setDesc(wm.getDescription());
                wv.setTemp(wm.getTemp());
                wv.setMaxTemp(wm.getMaxTemp());
                wv.setMinTemp(wm.getMinTemp());
                wv.setResult();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }
}
