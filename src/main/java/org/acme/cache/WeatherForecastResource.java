package org.acme.cache;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Vector;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/weather")
public class WeatherForecastResource {

    Vector v = new Vector();

    @Inject
    WeatherForecastService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WeatherForecast getForecast(@QueryParam String city, @QueryParam long daysInFuture) {
        long executionStart = System.currentTimeMillis();
        List<String> dailyForecasts = Arrays.asList(
                service.getDailyForecast(LocalDate.now().plusDays(daysInFuture), city),
                service.getDailyForecast(LocalDate.now().plusDays(daysInFuture + 1L), city),
                service.getDailyForecast(LocalDate.now().plusDays(daysInFuture + 2L), city));
        long executionEnd = System.currentTimeMillis();
        byte b[] = new byte[5048576];
        v.add(b);
        Runtime rt = Runtime.getRuntime();
        System.out.println( "free memory: " + rt.freeMemory() );
        return new WeatherForecast(dailyForecasts, executionEnd - executionStart,rt.freeMemory());
    }
}
