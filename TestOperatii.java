import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOperatii {
    private static Polinom p1;
    private static Polinom p2;

    @Test
    public void testAdd() throws Exception {
        p1 = new Polinom("3x^2+1x^3+3x^1+1x^0");
        p2 = new Polinom("1x^2+2x^1+1x^0");
        assertEquals("1.0x^3+4.0x^2+5.0x^1+2.0x^0", Operatii.add(p1, p2).toString());
    }

    @Test
    public void testSub() throws Exception {
        p1 = new Polinom("3x^2+1x^3+3x^1+1x^0");
        p2 = new Polinom("1x^2+2x^1+1x^0");
        assertEquals("1.0x^3+2.0x^2+1.0x^1", Operatii.sub(p1, p2).toString());
    }

    @Test
    public void testMul() throws Exception {
        p1 = new Polinom("3x^2+1x^3+3x^1+1x^0");
        p2 = new Polinom("1x^2+2x^1+1x^0");
        assertEquals("1.0x^5+5.0x^4+10.0x^3+10.0x^2+5.0x^1+1.0x^0", Operatii.mul(p1, p2).toString());
    }

    @Test
    public void testDiv() throws Exception {
        p1 = new Polinom("3x^2+1x^3+3x^1+1x^0");
        p2 = new Polinom("1x^2+2x^1+1x^0");
        assertEquals("1.0x^1+1.0x^0", Operatii.div(p1, p2).getResult().toString());
    }

    @Test
    public void testInt() throws Exception {
        p1 = new Polinom("3x^2+1x^3+3x^1+1x^0");
        assertEquals("0.25x^4+1.0x^3+1.5x^2+1.0x^1", Operatii.integrate(p1).toString());
    }

    @Test
    public void testDer() throws Exception{
        p1 = new Polinom("3x^2+1x^3+3x^1+1x^0");
        assertEquals("3.0x^2+6.0x^1+3.0x^0", Operatii.derivate(p1).toString());
    }
}
