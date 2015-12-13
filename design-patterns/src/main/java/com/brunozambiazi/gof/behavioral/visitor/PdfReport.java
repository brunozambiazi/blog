package com.brunozambiazi.gof.behavioral.visitor;

/**
 * Concrete Visitor implementation
 */
public class PdfReport implements ReportFormat {

    private final StringBuilder data = new StringBuilder();

    @Override
    public void header(String content) {
        data.append(content);
    }

    @Override
    public void body(String content) {
        data.append(content);
    }

    @Override
    public void footer(String content) {
        data.append(content);
    }

    @Override
    public String getContent() {
        return String.format("[PDF]%s[/PDF]", data.toString());
    }

}
