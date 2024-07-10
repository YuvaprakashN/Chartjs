package com.srishti.chart.model;

import com.srishti.chart.service.ChartService;

import java.util.List;

public class ChartData {
    private List<Integer> labels;
    private List<Integer> values;

    public ChartData(){

    }

    public List<Integer> getLabels() {
        return labels;
    }

    public void setLabels(List<Integer> labels) {
        this.labels = labels;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "labels=" + labels +
                ", values=" + values +
                '}';
    }
}
