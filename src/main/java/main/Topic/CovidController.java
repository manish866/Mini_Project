package main.Topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("")
public class CovidController {
    @Autowired
    private CovidController covidController;

    @RequestMapping("/covid/pincode")
    public String getApiResponce()
    {
        String response = null;
        CovidService covidService = new CovidService();
        try {
            response = covidService.getCovidResponse();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping("/pincode/{pincode}/{date}")
    public String getApiResponce(@PathVariable String pincode, @PathVariable String date)
    {
        String response = null;
        CovidService covidService = new CovidService();
        try {
            response = covidService.getCovidResponse(pincode, date);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

}
