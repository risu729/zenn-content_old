public interface BitflagGetable {

  protected public int getOffset();

  public default int getBitflag() {
    int offset = getOffset();
    if (offset < 0) {
      throw new IllegalStateException("offset is negative");
    }
    return 1 << offset;
  }
}