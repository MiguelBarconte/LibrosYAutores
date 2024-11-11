package com.aluraCursos.librosyautores.models;

public enum Idiomas {
    ES("español","spanish","es"),
    EN("ingles","english","en"),
    FR("francés","french", "fr"),
    DE("aleman","german", "de"),
    IT("italiano","italian", "it"),
    PT("portugues","portuguese", "pt"),
    RU("ruso","russian", "ru"),
    ZH("chino","chinese", "zh"),
    JA("japones","japanese", "ja"),
    KO("coreano","korean", "ko"),
    AR("arabe","arabic", "ar"),
    HI("hindi","hindi", "hi"),
    NO("desconocido", "unknow", "no");
    private String idiomaEsp;
    private String idiomaEng;
    private String abreviatura;

    Idiomas(String idiomaEsp, String idiomaEng, String abreviatura) {
        this.idiomaEsp = idiomaEsp;
        this.idiomaEng = idiomaEng;
        this.abreviatura = abreviatura;
    }

    public String getIdiomaEsp() {
        return idiomaEsp;
    }

    public void setIdiomaEsp(String idiomaEsp) {
        this.idiomaEsp = idiomaEsp;
    }

    public String getIdiomaEng() {
        return idiomaEng;
    }

    public void setIdiomaEng(String idiomaEng) {
        this.idiomaEng = idiomaEng;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public static Idiomas fromStringLanguage(String text){
        for(Idiomas i : Idiomas.values()){
            if(i.idiomaEsp.equalsIgnoreCase(text)){
                return i;
            }
        }
        for(Idiomas i : Idiomas.values()){
            if(i.idiomaEng.equalsIgnoreCase(text)){
                return i;
            }
        }
        return NO;
    }

    public static Idiomas fromString(String text){
        for(Idiomas i : Idiomas.values()){
            if(i.abreviatura.equalsIgnoreCase(text)){
                return i;
            }
        }
        return NO;
    }

}
