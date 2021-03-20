import java.io.IOException;

public class Monom implements Comparable<Monom>{
    //enum state{unvisited, visited};
    private double coef;
    private int pow;

    public Monom(double coef, int pow) {
        this.coef = coef;
        this.pow = pow;
    }

    public Monom(){}

    public Monom(String monom) throws Exception {
            String[] parameters = monom.split("x\\^");
            if(parameters.length == 0)
                throw new Exception();
            coef = Double.parseDouble(parameters[0]);
            pow = Integer.parseInt(parameters[1]);

    }

    public static Monom div(Monom m1, Monom m2){
        Monom monom = new Monom();
        monom.setCoef(m1.getCoef()/m2.getCoef());
        monom.setPow(m1.getPow() - m2.getPow());
        return monom;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    @Override
    public int compareTo(Monom monom) {
        if(pow < monom.pow){
            return 1;
        }
        else if(pow == monom.pow)
                return 0;
        else
            return -1;
    }

    @Override
    public String toString() {
        return coef + "x^" + pow;
    }
}
