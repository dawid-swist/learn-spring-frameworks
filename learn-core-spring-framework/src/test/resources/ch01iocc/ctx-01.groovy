import dev.n9mac.pharaoh.learncorespringframework.ch01iocc.Mbean1
import dev.n9mac.pharaoh.learncorespringframework.ch01iocc.Mbean2
import dev.n9mac.pharaoh.learncorespringframework.ch01iocc.Mbean3

beans {
    mbean2 Mbean2;
    mbean3(Mbean3);
    mbean1 Mbean1, mbean2, mbean3; //  build with constructor-args
    // OR mbean11(Mbean1, mbean2, mbean3)
}