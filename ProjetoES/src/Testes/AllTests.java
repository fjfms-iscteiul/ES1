package Testes;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import functional.MethodClass;
import functional.MyController;

@RunWith(JUnitPlatform.class)
@SelectClasses({MyControllerTest.class, MethodClassTest.class, MyControllerTestFX.class })
public class AllTests {

}
