package ru.yusdm.technics;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

public class DefaultNamingStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        if (Mode.POJO == mode) {
            return "Jpj" + super.getJavaClassName(definition, mode);
        }
        return "J" + super.getJavaClassName(definition, mode);
    }
}
