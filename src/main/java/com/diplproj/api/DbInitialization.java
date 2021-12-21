package com.diplproj.api;

import com.diplproj.api.model.*;
import com.diplproj.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class DbInitialization implements CommandLineRunner {

    private final CropYieldRepository cropYieldRepository;

    private final CultureRepository cultureRepository;

    private final LocationRepository locationRepository;

    private final MicroclimateNameRepository microclimateNameRepository;

    private final MicroclimateValueRepository microclimateValueRepository;

    @Autowired
    public DbInitialization(CropYieldRepository cropYieldRepository,
                            CultureRepository cultureRepository,
                            LocationRepository locationRepository,
                            MicroclimateNameRepository microclimateNameRepository,
                            MicroclimateValueRepository microclimateValueRepository) {
        this.cropYieldRepository = cropYieldRepository;
        this.cultureRepository = cultureRepository;
        this.locationRepository = locationRepository;
        this.microclimateNameRepository = microclimateNameRepository;
        this.microclimateValueRepository = microclimateValueRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Connection connection = connectToSqliteDb();
        String sql = "SELECT * FROM Report";

        /*try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // barley -> 1, chickpea -> 2, maize -> 3, oats -> 4, wheat -> 5
            Culture culture = new Culture();
            culture.setId(5);
            culture.setCultureName("Wheat");

            // zagreb -> 1, osijek -> 2, pula -> 3
            Location location = new Location();
            location.setId(1);
            location.setLocationName("Zagreb");

            while (resultSet.next()) {
                Date date = resultSet.getDate("Clock.Today");
                Double yield = resultSet.getDouble("Yield");
                Double radiation = resultSet.getDouble("Weather.Radn");
                Double maxTemp = resultSet.getDouble("Weather.MaxT");
                Double minTemp = resultSet.getDouble("Weather.MinT");
                Double rain = resultSet.getDouble("Weather.Rain");
                Double wind = resultSet.getDouble("Weather.Wind");

                CropYield cropYield = new CropYield();
                cropYield.setValue(yield);
                cropYield.setDate(date);
                cropYield.setYieldLocation(location);
                cropYield.setCulture(culture);
                this.cropYieldRepository.save(cropYield);

                // names

                MicroclimateName radiationName = new MicroclimateName();
                radiationName.setId(1);
                radiationName.setMicroclimateName("Radiation");

                MicroclimateName maxTempName = new MicroclimateName();
                maxTempName.setId(2);
                maxTempName.setMicroclimateName("Maximum temperature");

                MicroclimateName minTempName = new MicroclimateName();
                minTempName.setId(3);
                minTempName.setMicroclimateName("Minimum temperature");

                MicroclimateName rainName = new MicroclimateName();
                rainName.setId(4);
                rainName.setMicroclimateName("Rain");

                MicroclimateName windName = new MicroclimateName();
                windName.setId(5);
                windName.setMicroclimateName("Wind");

                // values

                MicroclimateValue radiationValue = new MicroclimateValue();
                radiationValue.setCulture(culture);
                radiationValue.setMicroclimateName(radiationName);
                radiationValue.setMicroclimateLocation(location);
                radiationValue.setMicroclimateValue(radiation);
                radiationValue.setDate(date);
                this.microclimateValueRepository.save(radiationValue);

                MicroclimateValue maxTempValue = new MicroclimateValue();
                maxTempValue.setCulture(culture);
                maxTempValue.setMicroclimateName(maxTempName);
                maxTempValue.setMicroclimateLocation(location);
                maxTempValue.setMicroclimateValue(maxTemp);
                maxTempValue.setDate(date);
                this.microclimateValueRepository.save(maxTempValue);

                MicroclimateValue minTempValue = new MicroclimateValue();
                minTempValue.setCulture(culture);
                minTempValue.setMicroclimateName(minTempName);
                minTempValue.setMicroclimateLocation(location);
                minTempValue.setMicroclimateValue(minTemp);
                minTempValue.setDate(date);
                this.microclimateValueRepository.save(minTempValue);

                MicroclimateValue rainValue = new MicroclimateValue();
                rainValue.setCulture(culture);
                rainValue.setMicroclimateName(rainName);
                rainValue.setMicroclimateLocation(location);
                rainValue.setMicroclimateValue(rain);
                rainValue.setDate(date);
                this.microclimateValueRepository.save(rainValue);

                MicroclimateValue windValue = new MicroclimateValue();
                windValue.setCulture(culture);
                windValue.setMicroclimateName(windName);
                windValue.setMicroclimateLocation(location);
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
            String url = "jdbc:sqlite:D:/diplomski_projekt/dataset/wheat_zagreb/wheat_zagreb.db";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
