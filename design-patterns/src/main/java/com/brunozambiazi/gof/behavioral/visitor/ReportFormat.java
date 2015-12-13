package com.brunozambiazi.gof.behavioral.visitor;

/**
 * Visitor interface
 */
public interface ReportFormat {

    void header(String content);

    void body(String content);

    void footer(String content);

    String getContent();
}
