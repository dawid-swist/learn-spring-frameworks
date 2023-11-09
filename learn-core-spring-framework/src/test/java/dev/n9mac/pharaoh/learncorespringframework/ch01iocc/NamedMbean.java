package dev.n9mac.pharaoh.learncorespringframework.ch01iocc;

import java.util.Arrays;
import java.util.stream.Collectors;

interface NamedMbean {
    default String getMbeanName() {
        return this.getClass().getSimpleName();
    }

    default String getCommonName(NamedMbean... namedMbeans) {
        return Arrays.stream(namedMbeans).map(NamedMbean::getMbeanName)
                .collect(Collectors.joining("-->"))
                + "-->" + this.getMbeanName();
    }
}
