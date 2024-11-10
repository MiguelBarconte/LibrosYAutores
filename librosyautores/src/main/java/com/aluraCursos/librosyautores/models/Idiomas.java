package com.aluraCursos.librosyautores.models;

import javax.swing.*;

public enum Idiomas {
    EN("inglés", "english"),

    ES("español", "spanish"),

    FR("francés", "french"),

    DE("alemán", "german"),

    IT("italiano", "italian"),

    PT("portugués", "portuguese"),

    NL("holandés", "dutch"),

    RU("ruso", "russian"),

    ZH("chino", "chinese"),

    JA("japonés", "japanese"),

    KO("coreano", "korean"),

    AR("árabe", "arabic"),

    EL("griego", "greek"),

    HE("hebreo", "hebrew"),

    TR("turco", "turkish"),

    SV("sueco", "swedish");
    private String languageEs;
    private String languageEn;

    Idiomas(String languageEs, String languageEn) {
        this.languageEs = languageEs;
        this.languageEn = languageEn;
    }
}
