package com.diplproj.api.config;

import com.diplproj.api.model.*;
import com.diplproj.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class DbInitialization implements CommandLineRunner {

    @Autowired
    CropYieldRepository cropYieldRepository;
    @Autowired
    CultureRepository cultureRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    MicroclimateNameRepository microclimateNameRepository;
    @Autowired
    MicroclimateValueRepository microclimateValueRepository;

    @Override
    public void run(String... args) throws Exception {
        Connection connection = connectToSqliteDb();
        String sql = "SELECT * FROM Report";

       /* try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // barley -> 1, chickpea -> 2, maize -> 3, oats -> 4, wheat -> 5
            Culture culture = new Culture();
            culture.setId(1);
            culture.setCultureName("Barley");

            // zagreb -> 1, osijek -> 2, pula -> 3
            Location location = new Location();
            location.setId(2);
            location.setLocationName("Osijek");

            while (resultSet.next()) {
                Date date = resultSet.getDate("Clock.Today");
                Double yield = resultSet.getDouble("Yield");
                Double radiation = resultSet.getDouble("Weather.Radn");
                Double maxTemp = resultSet.getDouble("Weather.MaxT");
                Double minTemp = resultSet.getDouble("Weather.MinT");
                Double rain = resultSet.getDouble("Weather.Rain");
                Double wind = resultSet.getDouble("Weather.Wind");

                CropYield cropYield = new CropYield();
                cropYield.setIdLocation(location.getId());
                cropYield.setValue(yield);
                cropYield.setDate(date);
                this.cropYieldRepository.save(cropYield);

                // names

                MicroclimateName radiationName = new MicroclimateName();
                radiationName.setId(1);
                radiationName.setMicroclimateName("radiation");

                MicroclimateName maxTempName = new MicroclimateName();
                maxTempName.setId(2);
                maxTempName.setMicroclimateName("maxTemp");

                MicroclimateName minTempName = new MicroclimateName();
                minTempName.setId(3);
                minTempName.setMicroclimateName("minTemp");

                MicroclimateName rainName = new MicroclimateName();
                rainName.setId(4);
                rainName.setMicroclimateName("rain");

                MicroclimateName windName = new MicroclimateName();
                windName.setId(5);
                windName.setMicroclimateName("wind");

                // values

                MicroclimateValue radiationValue = new MicroclimateValue();
                radiationValue.setId(1);
                radiationValue.setIdCulture(culture.getId());
                radiationValue.setIdMicroclimate(radiationName.getId());
                radiationValue.setIdLocation(location.getId());
                radiationValue.setMicroclimateValue(radiation);
                radiationValue.setDate(date);
                this.microclimateValueRepository.save(radiationValue);

                MicroclimateValue maxTempValue = new MicroclimateValue();
                maxTempValue.setId(2);
                maxTempValue.setIdCulture(culture.getId());
                maxTempValue.setIdMicroclimate(maxTempName.getId());
                maxTempValue.setIdLocation(location.getId());
                maxTempValue.setMicroclimateValue(maxTemp);
                maxTempValue.setDate(date);
                this.microclimateValueRepository.save(maxTempValue);

                MicroclimateValue minTempValue = new MicroclimateValue();
                minTempValue.setId(3);
                minTempValue.setIdCulture(culture.getId());
                minTempValue.setIdMicroclimate(minTempName.getId());
                minTempValue.setIdLocation(location.getId());
                minTempValue.setMicroclimateValue(minTemp);
                minTempValue.setDate(date);
                this.microclimateValueRepository.save(minTempValue);

                MicroclimateValue rainValue = new MicroclimateValue();
                rainValue.setId(4);
                rainValue.setIdCulture(culture.getId());
                rainValue.setIdMicroclimate(rainName.getId());
                rainValue.setIdLocation(location.getId());
                rainValue.setMicroclimateValue(rain);
                rainValue.setDate(date);
                this.microclimateValueRepository.save(rainValue);

                MicroclimateValue windValue = new MicroclimateValue();
                windValue.setId(5);
                windValue.setIdCulture(culture.getId());
                windValue.setIdMicroclimate(windName.getId());
                windValue.setIdLocation(location.getId());
                windValue.setMicroclimateValue(wind);
                windValue.setDate(date);
                this.microclimateValueRepository.save(windValue);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }*/
    }

    private Connection connectToSqliteDb() {
        try {
            String url = "jdbc:sqlite:D:/diplomski_projekt/dataset/barley_osijek/barley_osijek.db";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
