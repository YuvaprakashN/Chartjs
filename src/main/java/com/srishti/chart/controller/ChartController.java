package com.srishti.chart.controller;

import com.srishti.chart.model.ChartData;
import com.srishti.chart.service.ChartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ChartController {

    private ChartService chartService;
    public ChartController(ChartService chartService){
        this.chartService=chartService;
    }

    @RequestMapping("index")
    public String index() throws IOException {
       // chartService.readChartData();
        return "index";
    }

    @RequestMapping("barChart")
    @ResponseBody
    public ChartData barChart() throws IOException {
        ChartData chartData = chartService.readChartData();
        System.out.println(chartData);
        return chartData;
    }
}
