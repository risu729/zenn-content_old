public enum BitflagGetableImpl implements BitflagGetable {

  FLAG_A(0),
  FLAG_B(1),
  FLAG_C(2),
  FLAG_D(3);

  private final int offset;

  private BitflagGetableImpl(int offset) {
    this.offset = offset;
  }

  @Override
  public int getOffset() {
    return offset;
  }
}