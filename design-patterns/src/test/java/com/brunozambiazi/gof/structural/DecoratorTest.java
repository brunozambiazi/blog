package com.brunozambiazi.gof.structural;

import com.brunozambiazi.gof.structural.decorator.BasicComputer;
import com.brunozambiazi.gof.structural.decorator.BusinessComputer;
import com.brunozambiazi.gof.structural.decorator.Computer;
import com.brunozambiazi.gof.structural.decorator.GameComputer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Allows for the dynamic wrapping of objects in order to modify their existing
 * responsibilities and behaviours.
 *
 * The <b>Component</b> defines the interface for objects that can have
 * responsibilties added dynamically, and the <b>ConcreteComponent</b> is simply
 * an implementation of this interface. The <b>Decorator</b> has a reference to
 * a <b>Component</b>, and also conforms to the Component interface. This is the
 * important thing to remember, as the Decorator is essentially wrapping the
 * Component. The <b>ConcreteDecorator</b> just adds responsibilities to the
 * original Component.
 *
 * @link https://dzone.com/articles/design-patterns-decorator
 */
public class DecoratorTest {

    @Test
    public void buyHomeComputer() {
        Computer computer = new BasicComputer();
        assertEquals("Basic computer memory RAM:", 1, computer.memory());
    }

    @Test
    public void buyBusinessComputer() {
        Computer computer = new BusinessComputer(new BasicComputer());
        assertEquals("Business computer memory RAM:", 2, computer.memory());
    }

    @Test
    public void buyGameComputer() {
        Computer computer = new GameComputer(new BasicComputer());
        assertEquals("Game computer memory RAM:", 3, computer.memory());
    }

    @Test
    public void buyTheMostPowerfulComputer() {
        Computer computer = new GameComputer(new BusinessComputer(new BasicComputer()));
        assertEquals("The most powerful computer memory RAM:", 4, computer.memory());
    }
}
