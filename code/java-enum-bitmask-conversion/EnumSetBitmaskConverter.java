import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

public class EnumSetBitmaskConverter {

  public static <E extends Enum<E>> int enumSetToBitmask(EnumSet<E> enumSet) {
    return enumSet.stream()
        // Enum定数の序数(宣言順)に変換
        .mapToInt(Enum::ordinal)
        // ビットフラグ(2進数で(i+1)桁目が1で他が0の整数)に変換 (e.g. 2 -> 1<<2 (= 0b100 = 4))
        .map(i -> 1 << i)
        // それぞれのビットにOR演算を行う (e.g. (0b100, 0b10) -> 0b100 | 0b10 (= 0b110))
        .reduce(0, (i, j) -> i | j);
  }

  public static <E extends Enum<E>> EnumSet<E> bitmaskToEnumSet(Class<E> elementType, int bitmask) {
    // elementTypeで指定されたEnum定数を全て取得
    return Arrays.stream(elementType.getEnumConstants())
        // 上と同様にEnum定数をビットフラグに変換し、引数のビットマスクとのAND演算で0にならないかどうかで含まれているか判定
        .filter(e -> (1 << e.ordinal() & bitmask) != 0)
        // EnumSetに変換する
        .collect(Collectors.toCollection(() -> EnumSet.noneOf(elementType)));
  }

  private EnumSetBitmaskConverter() {
    throw new AssertionError();
  }
}