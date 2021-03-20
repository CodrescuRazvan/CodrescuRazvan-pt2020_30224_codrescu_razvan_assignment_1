import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operatii {
    public static Polinom add(Polinom pol1, Polinom pol2){
        ArrayList<Monom> monom = new ArrayList<Monom>();
        Polinom newPol = new Polinom();
        if(pol1.getMonomList() != null)
            monom.addAll(pol1.getMonomList());
        if(pol2.getMonomList() != null)
             monom.addAll(pol2.getMonomList());
        Collections.sort(monom);
        ArrayList<Monom> mn2 = new ArrayList<>();
        while(!monom.isEmpty()) {
            if (monom.size() > 1 && (monom.get(0).getPow() == monom.get(1).getPow())) {
                monom.get(0).setCoef(monom.get(0).getCoef() + monom.get(1).getCoef());
                mn2.add(monom.get(0));
                monom.remove(0);
                monom.remove(0);
            }
            else{
                mn2.add(monom.get(0));
                monom.remove(0);
            }
        }
        newPol.setMonomList(mn2);
        return newPol;
    }

    public static Polinom sub(Polinom pol1, Polinom pol2){
        int ok = 0;
        Collections.sort(pol1.getMonomList());
        Collections.sort(pol2.getMonomList());
        Iterator<Monom> m2 = pol2.getMonomList().iterator();
        while(m2.hasNext()){
            Monom i = m2.next();
            Iterator<Monom> m1 = pol1.getMonomList().iterator();
            while(m1.hasNext()){
                Monom j = m1.next();
                if(i.getPow() == j.getPow()){
                    ok = 1;
                    if(j.getCoef() - i.getCoef() == 0.0) {
                        m2.remove();
                        m1.remove();
                    }
                    else{
                        j.setCoef(j.getCoef() - i.getCoef());
                        m2.remove();
                    }
                }
            }
            if(ok == 0){
                i.setCoef(-i.getCoef());
                pol1.getMonomList().add(i);
                m2.remove();
            }

        }
        return pol1;
    }

    public static Polinom mul(Polinom pol1, Polinom pol2) throws Exception {
        ArrayList<Monom> monom = new ArrayList<Monom>();
        Polinom newPol = new Polinom();
        for (Monom m1 : pol1.getMonomList())
            for (Monom m2 : pol2.getMonomList()) {
                int pow = m1.getPow() + m2.getPow();
                double coef = m1.getCoef() * m2.getCoef();
                Monom mn = new Monom(coef + "x^" + pow);
                monom.add(mn);
            }
        Collections.sort(monom);
            ArrayList<Monom> mn2 = new ArrayList<>();
        while(!monom.isEmpty()) {
                while (monom.size() > 1 && (monom.get(0).getPow() == monom.get(1).getPow())) {
                    monom.get(1).setCoef(monom.get(0).getCoef() + monom.get(1).getCoef());
                    monom.remove(0);
                }
                while(monom.size() > 1 && (monom.get(0).getPow() != monom.get(1).getPow())){
                    mn2.add(monom.get(0));
                    monom.remove(0);
                }
                if(monom.size() == 1){
                    mn2.add(monom.get(0));
                    monom.remove(0);
                }
            }
        newPol.setMonomList(mn2);
        return newPol;
    }

    public static ResDiv div(Polinom pol1, Polinom pol2) throws Exception {
        ResDiv polNew = new ResDiv();
        Polinom res = new Polinom();
        Polinom rem = pol1;
        if(pol2.getMonomList().get(0).getCoef() == 0.0) {
            polNew = null;
        }
        else{
            if(pol2.getGradMax() == 0){
                rem = new Polinom();
                while(!pol1.getMonomList().isEmpty()){
                 pol1.getMonomList().get(0).setCoef(pol1.getMonomList().get(0).getCoef()/pol2.getMonomList().get(0).getCoef());
                 res.getMonomList().add(pol1.getMonomList().get(0));
                 pol1.getMonomList().remove(0);
                }
            }
            else{
                while(rem.getGradMax() >= pol2.getGradMax()){
                    Monom md = rem.getMonomList().get(0);
                    Monom mi = pol2.getMonomList().get(0);
                    Monom mc = Monom.div(md, mi);
                    Polinom div1 = new Polinom();
                    ArrayList<Monom> monom = new ArrayList<>();
                    monom.add(mc);
                    div1.setMonomList(monom);
                    res = add(res, div1);
                    Polinom aux = mul(pol2, div1);
                    rem = sub(rem, aux);
                    rem.setGradMax(rem.searchGradMax(rem));
                }
            }
            polNew.setResult(res);
            polNew.setRemainder(rem);
        }
        return polNew;
    }

    public static Polinom derivate(Polinom pol){
        Iterator<Monom> mon = pol.getMonomList().iterator();
        while(mon.hasNext()){
            Monom mn = mon.next();
            if(mn.getPow() > 0){
                mn.setCoef(mn.getCoef() * mn.getPow());
                mn.setPow(mn.getPow() - 1);
            }
            else {
                mon.remove();
            }
        }
        return pol;
    }

    public static Polinom integrate(Polinom pol){
        for(Monom mn : pol.getMonomList()){
            mn.setPow(mn.getPow() + 1);
            mn.setCoef(mn.getCoef() / mn.getPow());
        }
        return pol;
    }
}