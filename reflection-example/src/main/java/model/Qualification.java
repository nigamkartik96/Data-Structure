package model;

public class Qualification {
    private String kahanPadha;

    private String kyuPadha;

    @Override
    public String toString() {
        return "Qualification{" +
                "kahanPadha='" + kahanPadha + '\'' +
                ", kyuPadha='" + kyuPadha + '\'' +
                '}';
    }

    public String getKyuPadha() {
        return kyuPadha;
    }

    public void setKyuPadha(String kyuPadha) {
        this.kyuPadha = kyuPadha;
    }

    public Qualification(String kahanPadha, String kyuPadha) {
        this.kahanPadha = kahanPadha;
        this.kyuPadha = kyuPadha;
    }

    public Qualification() {
    }

    public String getKahanPadha() {
        return kahanPadha;
    }

    public void setKahanPadha(String kahanPadha) {
        this.kahanPadha = kahanPadha;
    }

    public Qualification(String kahanPadha) {
        this.kahanPadha = kahanPadha;
    }
}
