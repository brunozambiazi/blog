package com.brunozambiazi.gof.behavioral;

import com.brunozambiazi.gof.behavioral.visitor.HtmlReport;
import com.brunozambiazi.gof.behavioral.visitor.PdfReport;
import com.brunozambiazi.gof.behavioral.visitor.Report;
import com.brunozambiazi.gof.behavioral.visitor.ReportFormat;
import com.brunozambiazi.gof.behavioral.visitor.SalesReport;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Allows for one or more operation to be applied to a set of objects at
 * runtime, decoupling the operations from the object structure.
 *
 * The core of this pattern is the <b>Visitor</b> interface. This interface
 * defines a visit operation for each type of ConcreteElement in the object
 * structure. Meanwhile, the <b>ConcreteVisitor</b> implements the operations
 * defined in the Visitor interface. The concrete visitor will store local
 * state, typically as it traverses the set of elements. The element interface
 * simply defines an <b>accept</b> method to allow the visitor to run some
 * action over that element - the <b>ConcreteElement</b> will implement this
 * accept method.
 *
 * @link https://dzone.com/articles/design-patterns-visitor
 */
public class VisitorTest {

    @Test
    public void htmlFormat() {
        Report report = new SalesReport();
        ReportFormat format = new HtmlReport();
        String content = report.run(format);
        assertTrue("Content must be in HTML format", content.startsWith("<html>"));
    }

    @Test
    public void pdfFormat() {
        Report report = new SalesReport();
        ReportFormat format = new PdfReport();
        String content = report.run(format);
        assertTrue("Content must be in PDF format", content.contains("[PDF]"));
    }
}
