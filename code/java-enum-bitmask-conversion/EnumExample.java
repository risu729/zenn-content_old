import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.stream.Collectors;

public enum EnumExample {

  FLAG_A(0),
  FLAG_B(1),
  FLAG_C(2),
  FLAG_D(3);

  public static EnumSet<EnumExample> getEnumSet(int bitmask) {
    // 全てのEnum定数を取得
    return Arrays.stream(values())
        // ビットフラグと引数のビットマスクのAND演算で0にならないかどうかで含まれているか判定
        .filter(e -> (e.getBitflag() & bitmask) != 0)
        // EnumSetに変換する
        .collect(Collectors.toCollection(() -> EnumSet.noneOf(EnumExample.class)));
  }

  public static int getBitmask(Collection<EnumExample> set) {
    return set.stream()
        .mapToInt(EnumExample::getBitflag)
        // それぞれのビットにOR演算を行う (e.g. (0b100, 0b10) -> 0b100 | 0b10 (= 0b110))
        .reduce(0, (i, j) -> i | j);
  }

  private final int bitflag;

  private EnumExample(int offset) {
    // ビットフラグ(2進数で(offset+1)桁目が1で他が0の整数)に変換
    this.bitflag = 1 << offset; // <=> this.bitflag = (int) Math.pow(2, offset);
  }

  public int getBitflag() {
    return bitflag;
  }
}