package com.yunli.bigdata.dsep.foundation;

/**
 * @author : zhengyangyong
 */
public class Tuple<X, Y> {
  private X x;

  private Y y;

  public X getX() {
    return x;
  }

  public void setX(X x) {
    this.x = x;
  }

  public Y getY() {
    return y;
  }

  public void setY(Y y) {
    this.y = y;
  }

  public Tuple() {
  }

  public Tuple(X x, Y y) {
    this.x = x;
    this.y = y;
  }
}
