package org.example.domain.model;

public class CardPos {

    private int ri; //row index [1,..,nRows]
    private int ci; //column index [1,..,nCols]

    public CardPos() {};

    public CardPos(int ri, int ci) {
        this.ri=ri;   this.ci=ci;
    };

    public int getRi() {   return ri;    }
    public int getCi() {   return ci;    }

    /*
    public void setRi(int ri) {     this.ri = ri;    }
    public void setCi(int ci) {     this.ci = ci;    } */
    public void setRiCi(int ri,int ci) {   this.ri = ri;   this.ci = ci;    }

    @Override
    public String toString() {return getRi()+","+getCi();}

}
