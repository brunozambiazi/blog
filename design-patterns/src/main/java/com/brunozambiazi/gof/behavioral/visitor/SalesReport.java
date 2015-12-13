package com.brunozambiazi.gof.behavioral.visitor;

/**
 * Concret Element implementation
 */
public class SalesReport implements Report {

    @Override
    public String run(ReportFormat format) {
        format.header("Sales Report");
        format.body("...");
        format.footer("---");
        return format.getContent();
    }

}
