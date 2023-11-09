package dev.n9mac.pharaoh.learncorespringframework.ch01iocc;

public class Mbean1 implements NamedMbean {
    private final Mbean2 mbean2;
    private final Mbean3 mbean3;

    public Mbean1(Mbean2 mbean2, Mbean3 mbean3) {
        this.mbean2 = mbean2;
        this.mbean3 = mbean3;
    }

    public String getNames() {
        return this.getCommonName(mbean2, mbean3);
    }
}
