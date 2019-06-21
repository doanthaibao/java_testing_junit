package bao.doan.testing;


import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import junit.framework.TestCase;


@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticClass.class})
public class ExampleTest extends TestCase {
  @Before
  public void setup() {
    PowerMockito.mockStatic(StaticClass.class);
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testSum() {
    DependClass depend = Mockito.mock(DependClass.class);
    Mockito.when(depend.getInt()).thenReturn(11);
    int result = new Example().test();
    assertEquals(15, result);
  }

  @Test
  public void testStatic() {

    Mockito.when(StaticClass.getStatic()).thenReturn("aaa");
    String result = new Example().testStatic();
    assertEquals(result, "aaa Bao");
  }

  @Test
  public void testSpy() {
     Example example = new Example();
     Example spyExample = spy(example);
     Mockito.when(spyExample.abc()).thenReturn(11);
     assertEquals(spyExample.testSpy(), 16);
  }
}
