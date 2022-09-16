package com.api.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportGenerator {
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;

    public static void setUp() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        extent.attachReporter(spark);
    }

    public static void reportLog(String reportTitle, String reportContent) {
        ExtentTest test = extent.createTest(reportTitle);
        test.log(Status.PASS, reportContent);
    }

    public static void reportGenerate() {
        extent.flush();
    }
}
