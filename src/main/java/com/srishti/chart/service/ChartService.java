package com.srishti.chart.service;

import com.srishti.chart.model.ChartData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class ChartService {



    public  ChartData readChartData() throws IOException {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "application.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        // Read Excel File
        FileInputStream file = new FileInputStream(new File(appProps.getProperty("READ_EXCEL_FILE_PATH")));
        Workbook workbook = new XSSFWorkbook(file);


        Sheet sheet = workbook.getSheetAt(0);

        List<Integer> label=new ArrayList<>();
        List<Integer> value=new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            if(row.getRowNum()==0){
                continue;
            }

            for (Cell cell : row) {
                if(cell.getColumnIndex()==0)
                    label.add((int)cell.getNumericCellValue());
                if(cell.getColumnIndex()==1)
                    value.add((int)cell.getNumericCellValue());

            }
            i++;
        }

        ChartData chartData=new ChartData();
        chartData.setLabels(label);
        chartData.setValues(value);
return chartData;

    }

}
