package com.brunozambiazi.gof.behavioral.visitor;

/**
 * Concrete Visitor implementation
 */
public class HtmlReport implements ReportFormat {

    private final StringBuilder data = new StringBuilder();

    @Override
    public void header(String content) {
        data.append("<title>");
        data.append(content);
        data.append("</title>");
    }

    @Override
    public void body(String content) {
        data.append("<body>");
        data.append(content);
        data.append("</body>");
    }

    @Override
    public void footer(String content) {
        data.append("<footer>");
        data.append(content);
        data.append("</footer>");
    }

    @Override
    public String getContent() {
        return String.format("<html>%s</html>", data.toString());
    }

}
