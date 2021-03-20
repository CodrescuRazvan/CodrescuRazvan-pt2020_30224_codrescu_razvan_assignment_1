import java.util.*;

public class Polinom {
    private ArrayList<Monom> monomList;
    private int gradMax;
    public Polinom(){}

    public Polinom(String polynomial) throws Exception {
        monomList = new ArrayList<Monom>();
        String [] monoms = polynomial.split("\\+");
        for(String monom: monoms){
            Monom mn = new Monom(monom);
            monomList.add(mn);
        }
        Collections.sort(monomList);
        setGradMax(monomList.get(0).getPow());
    }

    @Override
    public String toString() {
        String x = new String();
        for(Monom mn : monomList)
                x = x + mn.toString() + "+" ;
        x = x.substring(0, x.length() - 1);
        return x;
    }

    public ArrayList<Monom> getMonomList() {
        return monomList;
    }

    public void setMonomList(ArrayList<Monom> monomList) {
        this.monomList = monomList;
    }

    public int getGradMax() {
        return gradMax;
    }

    public void setGradMax(int gradMax) {
        this.gradMax = gradMax;
    }

    public int searchGradMax(Polinom p) {
        Iterator<Monom> mn = p.getMonomList().iterator();
        while(mn.hasNext()) {
            Monom mn2 = mn.next();
            if (mn2.getCoef() == 0.0)
                mn.remove();
        }
        if(p.getMonomList().size() > 1) {
            Collections.sort(p.getMonomList());
            return p.getMonomList().get(0).getPow();
        }
        else if(p.getMonomList().size() == 1)
            return p.getMonomList().get(0).getPow();
        else return 0;
    }
}
