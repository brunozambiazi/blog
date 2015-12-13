package com.brunozambiazi.gof.behavioral.visitor;

/**
 * Element interface
 */
public interface Report {

    String run(ReportFormat format);
}
